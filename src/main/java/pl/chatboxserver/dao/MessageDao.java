package pl.chatboxserver.dao;

import pl.chatboxserver.model.Message;

import java.util.List;

public interface MessageDao {
    List<Message> getAllMessages();

    boolean insertMessage(Message message);
}
