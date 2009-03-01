package net.blitzstein.al.messenger.dao;

import java.util.List;
import net.blitzstein.al.messenger.domain.Message;

public interface MessageDao {

    Integer save(Message message);

    Message findByPk(Integer integer);

    void delete(Integer integer);
}
