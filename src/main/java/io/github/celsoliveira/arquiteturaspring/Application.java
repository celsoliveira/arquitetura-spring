package io.github.celsoliveira.arquiteturaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		//Alternativa para carregar a aplicação
		/*
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);

		builder.profiles("producao", "homologação");
		builder.properties("spring.datasource.url=jdbc://");

		builder.run(args);

		ConfigurableApplicationContext applicationContext = builder.context();
		var produtoRepository = applicationContext.getBean("produtoRepository");
		*/
	}

}
