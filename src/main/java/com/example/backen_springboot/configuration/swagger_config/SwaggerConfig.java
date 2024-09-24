package com.example.backen_springboot.configuration.swagger_config;

import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
    @Value("${open.api.title}")
    private String title;

    @Value("${open.api.version}")
    private String version;

    @Bean
    public OpenAPI customerOpenAPI(){
        return new OpenAPI()
                .openapi("3.0.0")
                .info(new Info()
                        .title(title)
                        .version(version)
                        .description("This is a sample API")
                        .license(new License().name("Apache 2.0").url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                )
                .servers(List.of(new Server().url("http://localhost:8080").description("this is the localhost server")))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("bearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")));
    }

    @Bean
    public GroupedOpenApi adminGroup(){
        return  GroupedOpenApi.builder()
                .group("admin")
                .pathsToMatch("/api/v1/**")
                .build();
    }

    @Bean
    public GroupedOpenApi userGroup() {
        return GroupedOpenApi.builder()
                            .group("user")
                            .pathsToMatch("/api/v2/**")
                            .build();
    }
}
