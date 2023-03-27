package com.example.springmongocrud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {
  @SuppressWarnings("checkstyle:JavadocVariable")
 @Value("${openapi.url}")
 private String url;


@Bean
  public OpenAPI myOpenAPI() {
    Contact contact = new Contact();
    License mitLicense = new License().name("").url("");
    Info info = new Info()
        .title("Book Management API")
        .version("1.0")
        .contact(contact)
        .description("This API exposes endpoints to manage books." +
                "created by sathish gollapaly").termsOfService("")
        .license(mitLicense);
    return new OpenAPI().info(info);
 }
}