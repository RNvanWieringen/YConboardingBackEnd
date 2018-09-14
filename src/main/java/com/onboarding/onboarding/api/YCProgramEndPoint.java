package com.onboarding.onboarding.api;

import com.onboarding.onboarding.model.YCProgram;
import com.onboarding.onboarding.persistence.YCProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ycprogram")
@Component
public class YCProgramEndPoint {

    @Autowired
    private YCProgramService ycProgramService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listGroep(){
        Iterable <YCProgram> programs = ycProgramService.findAll();
        return Response.ok(programs).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postYCProgram (YCProgram ycprogram){
        YCProgram result = ycProgramService.save(ycprogram);
        return Response.accepted(result.getId()).build();
    }

}
