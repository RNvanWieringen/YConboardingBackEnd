package com.onboarding.onboarding.api;

import com.onboarding.onboarding.model.Employee;
import com.onboarding.onboarding.model.Fillout;
import com.onboarding.onboarding.persistence.EmployeeService;
import com.onboarding.onboarding.persistence.FilloutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@Controller
public class FilloutEndPoint {
    @Autowired
    private FilloutService filloutService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/postfillout")
    @Produces(MediaType.TEXT_PLAIN)
    public @ResponseBody Response postFillout(
            @RequestParam("file") MultipartFile file,
            @RequestParam(value="id") String id,
            Fillout fillout){
        try {
            System.out.println("We are here m8" + id);
            //byte[] file = new byte[5];
            Employee employee = employeeService.findById(Long.parseLong(id));
            fillout.setFormData(file.getBytes());
            fillout.setEmployee(employee);
            System.out.println("Got a new fillout: " + fillout.getId());
            filloutService.save(fillout);
           return Response.status(201).build();
        }catch(Exception e){e.printStackTrace();}
        return Response.status(500).build();
    }

    @GetMapping("fillout/{id}")
    public ResponseEntity<InputStreamResource> downloadFillout(@PathVariable(value="id") String id){
        Employee employee = employeeService.findById(Long.parseLong(id));
        Fillout fillout = filloutService.findFilloutByEmployee(employee);

        FileOutputStream out = null;
        try {
            File f = new File(employee.getFirstName() + "_" + employee.getLastName() + ".zip");
            out = new FileOutputStream(f);
            out.write(fillout.getFormData());
            InputStreamResource resource = new InputStreamResource(new FileInputStream(f));
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment;filename=" + f.getName())
                    .contentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM).contentLength(f.length())
                    .body(resource);
        }catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            }catch(Exception e){}
        }

        return null;
    }
}



//
//}