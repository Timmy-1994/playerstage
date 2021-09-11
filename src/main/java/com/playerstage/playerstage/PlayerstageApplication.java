package com.playerstage.playerstage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class PlayerstageApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerstageApplication.class, args);
	}

}
