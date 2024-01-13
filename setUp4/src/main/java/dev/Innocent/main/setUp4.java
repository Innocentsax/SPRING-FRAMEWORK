package dev.Innocent.main;

import dev.Innocent.beans.Vehicle;
import dev.Innocent.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class setUp4 {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("Primary Vehicle name from Spring Context is: " + vehicle.getName());

    }
}
