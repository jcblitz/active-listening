package net.blitzstein.al.messenger.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.blitzstein.al.messenger.dao.MessageDao;
import net.blitzstein.al.messenger.dao.UserDao;
import net.blitzstein.al.messenger.domain.Message;

import net.blitzstein.al.messenger.domain.User;
import net.blitzstein.al.messenger.util.TimeBasedMessageComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private UserDao userDao;

    public Message postMessage(Message message) {
        Integer savedId = messageDao.save(message);

        return messageDao.findByPk(savedId);
    }

    public List<Message> getSubscriptionMessages() {
        List<Message> messages = new ArrayList();
        User user = userDao.findByPk(1);

        for (User subscription : user.getSubscriptions()) {
            messages.addAll(subscription.getMessages());
        }

        Collections.sort(messages, new TimeBasedMessageComparator());

        return messages;
    }
}
