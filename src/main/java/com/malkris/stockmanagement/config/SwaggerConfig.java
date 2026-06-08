package com.malkris.stockmanagement.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI stockManagementOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Malkris Stock Management API")
                                .description("Enterprise Inventory & Stock Management Backend")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .name("Malkris Technologies")
                                                .email("support@malkris.com")
                                )
                                .license(
                                        new License()
                                                .name("Apache 2.0")
                                )
                )
                .externalDocs(
                        new ExternalDocumentation()
                                .description("API Documentation")
                );
    }
}