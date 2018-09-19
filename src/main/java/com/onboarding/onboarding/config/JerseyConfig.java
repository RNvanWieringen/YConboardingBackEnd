package com.onboarding.onboarding.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import com.onboarding.onboarding.api.*;


@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(EmployeeEndPoint.class);
        //register(ManagerEndPoint.class);
        register(FilloutEndPoint.class);
        register(FormEndPoint.class);
        register(YCProgramEndPoint.class);
        register(InviteEndPoint.class);
        register(TeamEndPoint.class);
        register(ProgressEndPoint.class);

    }

}
