package net.blitzstein.al.messenger.web;

import java.util.List;
import net.blitzstein.al.messenger.domain.Message;
import net.blitzstein.al.messenger.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@RequestMapping(value = "/message/save.htm", method = RequestMethod.POST)
	public void postMessage(@ModelAttribute("message") Message message) {
		messageService.postMessage(message);
	}
	
	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public void home(Model model) {
		List messages = messageService.getSubscriptionMessages();
        model.addAttribute("messages", messages);
	}
}
