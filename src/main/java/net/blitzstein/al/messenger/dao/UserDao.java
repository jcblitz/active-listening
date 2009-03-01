package net.blitzstein.al.messenger.dao;

import net.blitzstein.al.messenger.domain.User;

public interface UserDao {
	Integer save(User message);
	User findByPk(Integer integer);
	void delete(Integer integer);
}
