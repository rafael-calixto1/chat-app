package com.dsenvolvendosistemas.chat_app;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatAppApplication {
	public static void main(String[] args) {
		// .env
		Dotenv dotenv = Dotenv.load();
		System.setProperty("SERVER_PORT", dotenv.get("SERVER_PORT"));
		System.setProperty("URL_DATABASE", dotenv.get("URL_DATABASE"));
		System.setProperty("USERNAME_DB", dotenv.get("USERNAME_DB"));
		System.setProperty("PASS_DB", dotenv.get("PASS_DB"));
		System.setProperty("HIBERNATE_DDL_AUTO", dotenv.get("HIBERNATE_DDL_AUTO"));
		System.setProperty("SHOW_SQL", dotenv.get("SHOW_SQL"));

		// start app
		SpringApplication.run(ChatAppApplication.class, args);
	}
}