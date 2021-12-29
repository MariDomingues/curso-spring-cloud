package com.curso.microservico.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LojaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

	@Bean
	//dá a inteligência de gerenciar o nome da aplicação na eureka
	@LoadBalanced
	public RestTemplate getRestTemplate() {

		return new RestTemplate();
	}
}
