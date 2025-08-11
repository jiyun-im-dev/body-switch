package com.centreal.bodyswitch.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("body switch api")
                .version("v1.0.0")
                .description("body switch api"); // API에 대한 설명

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}