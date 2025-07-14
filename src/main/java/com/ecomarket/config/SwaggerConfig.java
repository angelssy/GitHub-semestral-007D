package com.ecomarket.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI ecomarketOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("EcoMarket API")
                        .description("API para la gestión de productos ecológicos en ecomarket")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("EcoMarket Team")
                                .url("https://ecomarket.com")
                                .email("info@ecomarket.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }

}
