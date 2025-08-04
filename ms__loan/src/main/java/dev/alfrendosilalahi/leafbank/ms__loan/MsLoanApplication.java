package dev.alfrendosilalahi.leafbank.ms__loan;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Loan microservice REST API Documentation",
                description = "LeafBank Loan microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Alfrendo Stenley Silalahi",
                        email = "alfrendos72@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "LeafBank Loan microservice REST API Documentation"
        )
)
public class MsLoanApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsLoanApplication.class, args);
    }

}
