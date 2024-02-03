package br.com.alelvis.sistemAlevis;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.alelvis.sistemAlevis.vew.TelaLogin;

@SpringBootApplication
public class SistemAlevisApplication {
	public static void main(String[] args) {
		// SpringApplication.run(SistemAlevisApplication.class, args);
		ApplicationContext context = new SpringApplicationBuilder(SistemAlevisApplication.class).headless(false)
				.run(args);
		TelaLogin frame = context.getBean(TelaLogin.class);
		frame.setVisible(true);
	}
}