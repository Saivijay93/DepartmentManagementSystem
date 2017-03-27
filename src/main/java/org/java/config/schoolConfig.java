package org.java.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration 
@ApplicationPath("/school")
public class schoolConfig extends ResourceConfig {
    public schoolConfig() {
    	 register(org.java.controller.StudentController.class);
         register(org.java.controller.StaffController.class);        
         register(org.java.controller.AdminstudentController.class);
         register(org.java.controller.AdminstaffController.class);
         register(org.java.controller.TimetableController.class);
         register(org.java.controller.NotificationsController.class);
         register(org.java.controller.ResultsController.class);
         register(org.java.controller.SyllabusController.class);

    }
}

/*
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        register(org.glassfish.jersey.server.filter.UriConnegFilter.class);
        register(org.glassfish.jersey.server.validation.ValidationFeature.class);
        register(org.glassfish.jersey.server.spring.SpringorgponentProvider.class);
        register(org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpContainerProvider.class);
        property(ServerProperties.METAINF_SERVICES_LOOKUP_DISABLE, true);
    }
}*/
