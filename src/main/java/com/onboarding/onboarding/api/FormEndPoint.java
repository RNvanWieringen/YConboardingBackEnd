package com.onboarding.onboarding.api;


import com.onboarding.onboarding.model.Employee;
import com.onboarding.onboarding.model.Form;
import com.onboarding.onboarding.persistence.EmployeeService;
import com.onboarding.onboarding.persistence.FormService;
import config.FillConfiguration;
import merge.PDFFiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.core.HttpHeaders;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Controller
public class FormEndPoint {

    @Autowired
    private FormService formService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/forms.zip/{id}")
    public ResponseEntity<InputStreamResource> downloadFillout(@PathVariable(value="id") String id){
        try {
            System.out.println("THE FOUND ID IS: " + id + "   ");
            Employee emp = employeeService.findById(Long.parseLong(id));


            for(Object ent : emp.getHashMapData().entrySet()) {
                Map.Entry entry = (Map.Entry) ent;
                System.out.println(entry.getKey() + "  " + entry.getValue());
            }

            List<File> prefilled = fillForms(emp);

            File zip = zippify(prefilled, emp);

            InputStreamResource resource = new InputStreamResource(new FileInputStream(zip));

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment;filename=" + zip.getName())
                    .contentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM).contentLength(zip.length())
                    .body(resource);
        }catch(Exception e){e.printStackTrace();}
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    private File zippify(List<File> files, Employee emp) throws FileNotFoundException, IOException {
        File zip = new File(emp.getId() + ".zip");
        FileOutputStream fos = new FileOutputStream(zip);
        ZipOutputStream zos = new ZipOutputStream(fos);
        for(File file : files) {
            FileInputStream fis = new FileInputStream(file);
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zos.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zos.write(bytes, 0, length);
            }

            zos.closeEntry();
            fis.close();
        }

        zos.close();
        fos.close();
        return zip;
    }

    private List<File> fillForms(Employee emp) throws Exception {
        Iterator<Form> forms = formService.findAll().iterator();
        List<File> filledForms = new ArrayList<>();
        while(forms.hasNext()) {
            Form form = forms.next();
            File file = new File("config.cfg");
            System.out.println(file.getAbsolutePath());
            PrintStream out = new PrintStream(file);
            out.write(form.getFormConfigPDF());
            out.close();
            FillConfiguration configuration = FillConfiguration.loadConfiguration(file);
            //FillConfiguration configuration = FillConfiguration.loadConfiguration(new File("D:\\Formulier telefoon.cfg"));

            File formFile = new File(form.getName() + ".pdf");
            out = new PrintStream(formFile);
            out.write(form.getFormData());
            out.close();
            //File formFile = new File("D:\\Geen titel 1.pdf");

            convertConfiguration(configuration, emp);

            //TODO fix me
            File filled = new File(formFile.getAbsolutePath() + "filled.pdf");
            PDFFiller.fillPDF(formFile.getAbsolutePath(), filled.getAbsolutePath(), configuration);
            filledForms.add(filled);
        }

        return filledForms;
    }

    private void convertConfiguration(FillConfiguration config, Employee employee) {
        Map<String, String> data = employee.getHashMapData();
        List<List<FillConfiguration.ConfigEntry>> configurations = config.getConfigurations();

        for(List<FillConfiguration.ConfigEntry> configlist : configurations) {
            for(FillConfiguration.ConfigEntry entry : configlist) {
                System.out.println(data.get(entry.getValue()) + "    " + entry.getValue());
                entry.setValue(data.get(entry.getValue()));
            }
        }
    }

   /* @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postForm(Form form){
        Form result = formService.save(form);
        return Response.accepted(result.getId()).build();
    }*/
}

