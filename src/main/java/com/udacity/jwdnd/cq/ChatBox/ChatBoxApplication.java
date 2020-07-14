package com.udacity.jwdnd.cq.ChatBox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.udacity.jwdnd.cq.ChatBox.service.MessageService;

@SpringBootApplication
public class ChatBoxApplication {

	@Bean(name = "message")
	public String getMessage() {
		System.out.println("Hello");
		return "Hello, Spring!";
	}

	@Bean(name = "upperCaseMessage")
	public String upperCaseMessage(MessageService service) {
		System.out.println("upperCaseMessage");
		return service.upperCase();

	}

	@Bean(name = "lowerCaseMessage")
	public String lowerCaseMessage(MessageService service) {
		System.out.println("lowerCaseMessage");
		return service.lowerCase();
	}

	public static void main(String[] args) {
		SpringApplication.run(ChatBoxApplication.class, args);
	}

}
