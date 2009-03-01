package net.blitzstein.al.messenger.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import net.blitzstein.al.messenger.domain.Message;
import net.blitzstein.al.messenger.domain.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/messenger-servlet.xml" })
public class UserDaoImplIntegrationTest {

	Message messageFixture;

	@Autowired
	UserDao userDao;

	@Test
	public void testFind() {
		User user = userDao.findByPk(1);

		assertNotNull("Could not find user", user);
		assertTrue("Message did not have an id", user.getId() != null);

		assertEquals("Number of messages is incorrect", 4, user.getMessages()
				.size());
	}

	@Before
	public void setup() {
		messageFixture = new Message();
		messageFixture.setContent("Going to lunch @ BurgerKing");

	}

}
