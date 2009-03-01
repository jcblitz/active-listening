package net.blitzstein.al.messenger.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import net.blitzstein.al.messenger.domain.Message;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/messenger-servlet.xml" })
public class MessageDaoImplIntegrationTest {

	@Autowired
	MessageDao messageDao;

	Message messageFixture;

	@Test
	public void testSave() {
		Integer returnedId = messageDao.save(messageFixture);
		//assertNotNull("MessageId was null", returnedId);
		//assertTrue("Message did not have an id", messageFixture.getId() != null);
	}
	
	@Test
	public void testFind() {
		Message message = messageDao.findByPk(new Integer(1));
		//assertNotNull("Could not find message", message);
		//assertTrue("Message did not have an id", message.getId() != null);
	}
	
	@Test
	public void testDelete() {
		//Message message = messageDao.findByPk(new Integer(1));
		//assertNotNull("Could not find fixture", message);
		//messageDao.delete(new Integer(1));
		//message = messageDao.findByPk(new Integer(1));
		//assertNull("Message was not deleted", message);
	}

	@Before
	public void setup() {
		messageFixture = new Message();
		messageFixture.setContent("Going to lunch @ BurgerKing");
	}

}
