package com.onboarding.onboarding.api;

import com.onboarding.onboarding.model.Manager;
import com.onboarding.onboarding.persistence.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("manager")
@Component
public class ManagerEndPoint {

    @Autowired
    private ManagerService managerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listGroep() {
        Iterable<Manager> manager = managerService.findAll();
        return Response.ok(manager).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public  Response postManager(Manager manager){
        Manager result = managerService.save(manager);
        return Response.accepted(result.getEmail()).build();
    }
}
