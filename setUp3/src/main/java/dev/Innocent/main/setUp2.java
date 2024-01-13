package dev.Innocent.main;

import dev.Innocent.beans.Vehicle;
import dev.Innocent.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class setUp2 {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle veh = context.getBean("vehicle1",Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh.getName());

    }
}
