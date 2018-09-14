package com.onboarding.onboarding.api;

import com.onboarding.onboarding.model.Employee;
import com.onboarding.onboarding.model.Fillout;
import com.onboarding.onboarding.model.Form;
import com.onboarding.onboarding.persistence.EmployeeService;
import com.onboarding.onboarding.persistence.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

@Path("fillout")
@Component
public class FilloutEndPoint {

    @Autowired
    private FormService formService;

    @Autowired
    private EmployeeService employeeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listGroep(){
        try {
        }catch(Exception e){}
        return null;
    }

    //    @GET
    //    @Produces(MediaType.APPLICATION_JSON)
    //    public Response listGroep(){
    //        Iterable <Employee> employee = employeeService.findAll();
    //        return Response.ok(employee).build();
    //    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public  Response postFillout(Fillout fillout){
        try {
            Iterable<Form> forms = formService.findAll();
            Form form = forms.iterator().next();

            File file = new File("config.cfg");
            System.out.println(file.getAbsolutePath());
            PrintStream out = new PrintStream(file);
            out.write(form.getFormConfigPDF());
            out.close();
            FillConfiguration configuration = FillConfiguration.loadConfiguration(file);
            //FillConfiguration configuration = FillConfiguration.loadConfiguration(new File("D:\\Formulier telefoon.cfg"));

            File formFile = new File(" form.pdf" );
            out = new PrintStream(formFile);
            out.write(form.getFormData());
            out.close();
            //File formFile = new File("D:\\Geen titel 1.pdf");

            Iterable<Employee> employees = employeeService.findAll();
            Employee emp = employees.iterator().next();

            convertConfiguration(configuration, emp);

            //TODO fix me
            File filled = new File(formFile.getAbsolutePath() + "filled.pdf");
            PDFFiller.fillPDF(formFile.getAbsolutePath(), filled.getAbsolutePath(), configuration);

        }catch(Exception e){e.printStackTrace();}
        return null;
    }

    private void convertConfiguration(FillConfiguration config, Employee employee) {
        Map<String, String> data = employee.getHashMapData();
        List<List<FillConfiguration.ConfigEntry>> configurations = config.getConfigurations();

        for(List<FillConfiguration.ConfigEntry> configlist : configurations) {
            for(FillConfiguration.ConfigEntry entry : configlist) {
                entry.setValue(data.get(entry.getValue()));
            }
        }
    }
}
