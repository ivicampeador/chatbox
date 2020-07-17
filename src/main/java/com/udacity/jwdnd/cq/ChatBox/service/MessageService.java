package com.udacity.jwdnd.cq.ChatBox.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.udacity.jwdnd.cq.ChatBox.dto.ChatMessage;
import com.udacity.jwdnd.cq.ChatBox.model.ChatForm;

@Service
public class MessageService {

	private List<ChatMessage> theChat;

	public void addMessage(ChatForm form) {
		switch (form.getMessageType()) {
		case "Shout":
			theChat.add(upperCase(form));
			break;
		case "Whisper":
			theChat.add(lowerCase(form));
			break;
		default:
			theChat.add(normalCase(form));
		}
	}

	public List<ChatMessage> getMessages() {
		return new ArrayList<ChatMessage>(this.theChat);
	}

	public ChatMessage upperCase(ChatForm form) {
		return new ChatMessage(form.getUserName(), form.getMessageText().toUpperCase());
	}

	public ChatMessage lowerCase(ChatForm form) {
		return new ChatMessage(form.getUserName(), form.getMessageText().toLowerCase());
	}

	public ChatMessage normalCase(ChatForm form) {
		return new ChatMessage(form.getUserName(), form.getMessageText());
	}

	@PostConstruct
	public void postConstructor() {
		theChat = new ArrayList<ChatMessage>();
	}
}
