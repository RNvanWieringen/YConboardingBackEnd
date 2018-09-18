package com.onboarding.onboarding.api;

import com.onboarding.onboarding.model.Employee;
import com.onboarding.onboarding.model.Manager;
import com.onboarding.onboarding.model.YCProgram;
import com.onboarding.onboarding.persistence.EmployeeService;
import com.onboarding.onboarding.persistence.ManagerService;
import com.onboarding.onboarding.persistence.YCProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Controller
public class ManagerEndPoint {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private YCProgramService programService;

    @GetMapping("listbyprogram/{id}")
    public @ResponseBody ResponseEntity<Iterable<Employee>> listByProgram(@PathVariable(value="id") String id) {
        System.out.println("We are here now" + "   " + id);
        YCProgram program = programService.findById(new Long(id));
        System.out.println(program);
        Iterable<Employee> employees = employeeService.findByProgram(program);
        return new ResponseEntity<Iterable<Employee>>(employees, HttpStatus.OK);
    }

    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public  Response postManager(Manager manager){
        Manager result = employeeService.save(manager);
        return Response.accepted(result.getEmail()).build();
    }*/
}
