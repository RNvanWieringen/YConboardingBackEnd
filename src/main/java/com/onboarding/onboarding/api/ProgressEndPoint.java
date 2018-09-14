package com.onboarding.onboarding.api;

import com.onboarding.onboarding.model.Progress;
import com.onboarding.onboarding.persistence.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("progress")
@Component
public class ProgressEndPoint {

    @Autowired
    private ProgressService progressService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listGroep(){
        Iterable <Progress> progress = progressService.findAll();
        return Response.ok(progress).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postProgress(Progress progress){
        Progress result = progressService.save(progress);
        return Response.accepted(result.getId()).build();
    }

}