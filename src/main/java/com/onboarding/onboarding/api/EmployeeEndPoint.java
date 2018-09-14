package com.onboarding.onboarding.api;

import com.onboarding.onboarding.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


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
        Employee result = employeeService.save(employee);
        return Response.accepted(result.getEmail()).build();
    }



}
