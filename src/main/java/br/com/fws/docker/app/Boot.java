package br.com.fws.docker.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Boot {

	public static void main(String[] args) {
		SpringApplication.run(Boot.class, args);
	}


	@Value("${spring.datasource.url}")
	private String connectionURL;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@PostConstruct
	public void postConstruct(){
		System.out.println("\n\n\n\n\n\n************* DOCKER-APP *************");
		System.out.println(connectionURL);
		System.out.println(username);
		System.out.println(password);
		System.out.println("\n\n\n\n\n\n************* DOCKER-APP *************");
	}
}
