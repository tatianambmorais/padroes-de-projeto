package com.lojaauto.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI backendflixOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Loja Auto API")
                        .description("API para gerenciamento loja de automóveis")
                        .version("v1.0"));
    }
}

