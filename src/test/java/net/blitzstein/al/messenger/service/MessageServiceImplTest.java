/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.blitzstein.al.messenger.service;

import java.util.List;
import org.junit.Test;
import net.blitzstein.al.messenger.domain.Message;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 *
 * @author jared
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/messenger-servlet.xml" })
public class MessageServiceImplTest {

    @Autowired
	MessageService messageService;

    @Test
    public void testSubscriptions() {
        List<Message> messages = messageService.getSubscriptionMessages();
        assertNotNull(messages);
        assertEquals("Incorrect expected messages", 2, messages.size());
    }

}
