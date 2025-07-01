package com.ecomarket.configuracion;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API del Proyecto Semestral 007D")
                        .version("1.0")
                        .description("Documentación de la API para el proyecto semestral")
                        .license(new License().name("Apache 2.0").url("https://github.com/angelssy/GitHub-semestral-007D.git")));
    }
}
