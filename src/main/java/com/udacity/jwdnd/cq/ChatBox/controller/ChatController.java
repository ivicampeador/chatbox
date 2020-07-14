package com.udacity.jwdnd.cq.ChatBox.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.udacity.jwdnd.cq.ChatBox.service.MessageService;

@Controller
public class ChatController {
	public String getHomePage() {
		return "chat";
	}

	public String postShoutMessage(MessageService service) {
		System.out.println("lowerCaseMessage");
		return service;
	}
}
