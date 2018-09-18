package com.onboarding.onboarding.api;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.onboarding.onboarding.model.*;
import com.onboarding.onboarding.persistence.EmployeeService;
import com.onboarding.onboarding.persistence.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("invite")
@Component
public class InviteEndPoint {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProgressService progressService;



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listGroep() {
        Iterable<Employee> employee = employeeService.findAll();
        return Response.ok(employee).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postInvite(Invite invite) {
        Employee employee = new Employee();
        Progress progress = new Progress();
        progress.setStage(0);
        employee.setYcProgram(invite.getProgram());
        employee.setLoonheffing(false);
        employee.setHouseNumber(-1);
        Employee result = employeeService.save(employee);
        progress = progressService.save(progress);
        progress.setStage(1);
        result.setProgress(progress);
        result = employeeService.save(employee);
        progressService.save(progress);
        String url = "http://localhost:80/employee_page.html?id=" + result.getId();

//        String url = "http://localhost:63342/OnboardingAppFrontEnd/demo/employee_page.html?id=" + result.getId();
        return Response.accepted(url).build();
    }
}