package com.onboarding.onboarding.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.onboarding.onboarding.model.Employee;
import com.onboarding.onboarding.persistence.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("employee")
@Component
public class EmployeeEndPoint {

    @Autowired
    private EmployeeService employeeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listGroep(){
        Iterable <Employee> employee = employeeService.findAll();
        return Response.ok(employee).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postEmployee(Employee employee){

        Employee withProgress = employeeService.findById(employee.getId());
        employee.setProgress(withProgress.getProgress());
        Employee result = employeeService.save(employee);
        return Response.accepted(result.getId()).build();
    }

}