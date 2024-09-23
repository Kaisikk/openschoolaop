package com.kaisik.openscheoolaop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Конфиг для сваггера
 */
@OpenAPIDefinition(
        info = @Info(
                title = "OpenSchool",
                description = "Проект для открытых школ", version = "1.0.0",
                contact = @Contact(
                        name = "Kaisik"
                )
        )
)
public class OpenApiConfig {
}
