package net.blitzstein.al.messenger.dao;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/messenger-servlet.xml"})
public class MessageDaoImplUnitTest {
	MessageDao messageDao;
	
	@Test
	public void hello() {
		assertTrue(true);
	}
	
	@Before
	public void setup() {

	}

}
