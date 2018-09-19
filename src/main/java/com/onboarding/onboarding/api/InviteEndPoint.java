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

import com.onboarding.onboarding.model.Employee;
import com.onboarding.onboarding.model.Invite;
import com.onboarding.onboarding.model.Team;
import com.onboarding.onboarding.model.YCProgram;
import com.onboarding.onboarding.persistence.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("invite")
@Component
public class InviteEndPoint {

    @Autowired
    private EmployeeService employeeService;

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
        employee.setYcProgram(invite.getProgram());
        employee.setLoonheffing(false);
        employee.setHouseNumber(-1);
        Employee result = employeeService.save(employee);
        return Response.accepted(result.getId()).build();
    }
}