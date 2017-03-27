package org.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;






@SpringBootApplication
public class SchoolManagementProjectApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SchoolManagementProjectApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SchoolManagementProjectApplication.class, args);
    }

}
/*



@SpringBootApplication
public class SchoolManagementProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementProjectApplication.class, args);
	}
}
*/