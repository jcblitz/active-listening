package net.blitzstein.al.messenger.dao;

import java.sql.Timestamp;
import java.util.Date;

import net.blitzstein.al.messenger.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void delete(Integer userId) {
		hibernateTemplate.delete(findByPk(userId));

	}

	public User findByPk(Integer userId) {
		return (User) hibernateTemplate.get(User.class, userId);
	}

	public Integer save(User user) {
		user.setUpdatedAt(new Timestamp(new Date().getTime()));
		if (user.getInsertedAt() == null) {
			user.setInsertedAt(new Timestamp(new Date().getTime()));
		}
		return (Integer) hibernateTemplate.save(user);
	}

}
