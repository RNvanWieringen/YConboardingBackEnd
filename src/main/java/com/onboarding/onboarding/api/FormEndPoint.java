package com.onboarding.onboarding.api;

import com.onboarding.onboarding.model.Form;
import com.onboarding.onboarding.persistence.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("form")
@Component
public class FormEndPoint {

    @Autowired
    private FormService formService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listGroep() {
        Iterable<Form> form = formService.findAll();
        return Response.ok(form).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postForm(Form form){
        Form result = formService.save(form);
        return Response.accepted(result.getId()).build();
    }
}