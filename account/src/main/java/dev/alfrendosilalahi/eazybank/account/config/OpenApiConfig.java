package dev.alfrendosilalahi.eazybank.account.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Account Microservice REST API Documentation",
                description = "Eazy Bank Account Microservice REST API Documentation",
                version = "v1.0.0",
                contact = @Contact(
                        name = "Alfrendo Silalahi",
                        email = "alfrendosilalahi@email.com",
                        url = "https://github.com/alfrendo-silalahi"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Eazy Bank Account Microservice Documentation",
                url = "https://github.com/alfrendo-silalahi"
        )
)
public class OpenApiConfig {

}
