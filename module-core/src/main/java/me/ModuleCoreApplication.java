package me;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Profile;

@Profile("h2")
@SpringBootApplication
public class ModuleCoreApplication {
    public static final String APPLICATION_LOCATIONS = "spring.config.location="
                                                       + "classpath:application.yml";
    public static void main(String[] args) {
        new SpringApplicationBuilder(ModuleCoreApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }

}
