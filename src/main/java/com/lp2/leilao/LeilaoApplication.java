package com.lp2.leilao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Leilão", version = "1.0", description = "API Para Leilão de produtos"))
public class LeilaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeilaoApplication.class, args);
	}

}
