package net.blitzstein.al.messenger.dao;

import java.sql.Timestamp;
import java.util.Date;

import java.util.List;
import net.blitzstein.al.messenger.domain.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDaoImpl implements MessageDao {
	
	@Autowired	
	private HibernateTemplate hibernateTemplate;

	public Integer save(Message message) {
		message.setUpdatedAt(new Timestamp(new Date().getTime()));
		if (message.getInsertedAt() == null) {
			message.setInsertedAt(new Timestamp(new Date().getTime()));
		}
		return (Integer) hibernateTemplate.save(message);
	}

	public Message findByPk(Integer integer) {
		return (Message) hibernateTemplate.get(Message.class, integer);
	}

	public void delete(Integer integer) {
		hibernateTemplate.delete(findByPk(integer));
	}

    public List<Message> findDashboardMessagesForUser() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
	
}
