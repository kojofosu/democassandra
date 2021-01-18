package com.example.democassandra.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerFoxConfig {
    @Bean
    public Docket api(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select() //the select() method returns an instance of ApiSelectorBuilder, which provides a way to control the endpoints exposed by Swagger.
                .apis(RequestHandlerSelectors.any())// configuring predicates for selecting RequestHandlers with the help of RequestHandlerSelectors and PathSelectors. Using any() for both will make documentation for our entire API available through Swagger.
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
                .apiInfo(apiInfo());
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Cassandra Demo",
                "This is a demo spring project with cassandra database",
                "v1.0.0",
                "www.google.com",
                new Contact(
                        "Kojofosu",
                        "www.google.com",
                        "kojofosube@gmail.com"
                ),
                "KOJOFOSU END USER LICENSE AGREEMENT",
                "www.google.com",
                Collections.emptyList()
        );
    }
}
