package edu.utfpr.gerenciador;

import edu.utfpr.gerenciador.config.CorsConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CorsConfiguration.class)
public class GerenciadorRepublicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorRepublicaApplication.class, args);
	}

}
