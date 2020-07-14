package com.udacity.jwdnd.cq.ChatBox.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.udacity.jwdnd.cq.ChatBox.dto.ChatMessage;

@Service
public class MessageService {

	private List<ChatMessage> theChat;

	private String message;

	public MessageService() {
	}

	public MessageService(String message) {
		this.message = message;
	}

	public void addMessage(ChatMessage message, String type) {
		switch(type) {
		case "Shout" : theChat.add(upperCase(message));
		break;
		case "Whisper": theChat.add(lowerCase(message))
		break;
		default: theChat.add(message);
		
		}
	}

	public String upperCase() {
		System.out.println("UpperCase: " + this.message);
		return message.toUpperCase();
	}

	public String lowerCase() {
		System.out.println("LowerCase: " + this.message);
		return message.toLowerCase();
	}

	@PostConstruct
	public void postConstructor() {
		System.out.println("Service bean constructed");
	}
}
