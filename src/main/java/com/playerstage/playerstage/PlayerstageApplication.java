package com.playerstage.playerstage;

import com.sun.nio.sctp.SctpSocketOption;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
@MapperScan("com.playerstage.playerstage.mappers")
public class PlayerstageApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayerstageApplication.class, args);
	}

		
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		// Do any additional configuration here
		return builder.build();

	}

}