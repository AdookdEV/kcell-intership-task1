package com.example.kcelltask1.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Currency Conversion API",
                description = "The API allows getting exchange rates for single or multiple currencies.", version = "1.0.0",
                contact = @Contact(
                        name = "Adilet Koishybek",
                        email = "addik.koishibek03@gmail.com"
                )
        )
)
public class OpenApiConfig {
}
