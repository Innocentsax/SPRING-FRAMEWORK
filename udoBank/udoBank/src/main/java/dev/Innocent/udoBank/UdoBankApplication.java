package dev.Innocent.udoBank;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Innocent Udo's Bank",
				description = "Backend Rest APIs for UdoBank",
				version = "v1.0",
				contact = @Contact(
						name = "Innocent Udo",
						email = "innocentcharlesudo@gmail.com",
						url = "https://github.com/Innocentsax"
				),
				license = @License(
						name = "MIT license",
						url = "https://github.com/Innocentsax"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Backend Rest APIs for UdoBank",
				url = "https://github.com/Innocentsax"
		)
)
public class UdoBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(UdoBankApplication.class, args);
	}
}
