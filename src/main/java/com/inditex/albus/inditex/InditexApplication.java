package com.inditex.albus.inditex;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Proyecto Inditex",
				version = "1.0.0",
				description = "Este proyecto es para mostrar mis capacidades " +
						"con lo que se ha pedido del proyecto de Inditex"
		)
)
public class InditexApplication {

	public static void main(String[] args) {
		SpringApplication.run(InditexApplication.class, args);
	}

}
