package com.onboarding.onboarding.api;

import com.onboarding.onboarding.model.Team;
import com.onboarding.onboarding.persistence.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("team")
@Component
public class TeamEndPoint {

    @Autowired
    private TeamService teamService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listGroep(){
        Iterable <Team> team = teamService.findAll();
        return Response.ok(team).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postTeam(Team team){
        Team result = teamService.save(team);
        return Response.accepted(result.getId()).build();
    }

}