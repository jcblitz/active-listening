package net.blitzstein.al.messenger.service;

import java.util.List;
import net.blitzstein.al.messenger.domain.Message;

public interface MessageService {

    public List<Message> getSubscriptionMessages();
	public Message postMessage(Message message);

}
