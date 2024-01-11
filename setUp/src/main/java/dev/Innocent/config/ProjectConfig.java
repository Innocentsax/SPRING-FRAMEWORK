package dev.Innocent.config;

import dev.Innocent.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
Spring @Configuration annotation is part of the spring core framework.
Spring Configuration annotation indicates that the class has @Bean definition
methods. So Spring container can process the class and generate Spring Beans
to be used in the application.
* */

@Configuration
public class ProjectConfig {
    @Bean
    Vehicle vehicle(){
        var veh = new Vehicle();
        veh.setName("Audi 8");
        return veh;
    }

}
