package com.udacity.jwdnd.cq.ChatBox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.udacity.jwdnd.cq.ChatBox.model.ChatForm;
import com.udacity.jwdnd.cq.ChatBox.service.MessageService;

@Controller
public class ChatController {

	private MessageService messageService;

	public ChatController(MessageService messageService) {
		this.messageService = messageService;
	}

	@GetMapping("/chat")
	public String getHomePage(@ModelAttribute("ChatForm") ChatForm form, Model model) {
		model.addAttribute("messages", messageService.getMessages());
		return "chat";
	}

	@PostMapping("/chat")
	public String addMessage(MessageService service, @ModelAttribute("ChatForm") ChatForm form, Model model) {
		messageService.addMessage(form);
		model.addAttribute("messages", messageService.getMessages());
		return "chat";
	}
	
	@ModelAttribute("allMessageTypes")
	public String[] getMessageTypes() {
		System.out.println("injected");
		return new String[] {"Say","Whisper","Shout"};
	}
}
