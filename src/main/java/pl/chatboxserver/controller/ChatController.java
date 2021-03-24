package pl.chatboxserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.chatboxserver.dao.MessageDao;
import pl.chatboxserver.dao.MessageRepository;
import pl.chatboxserver.dao.UserDao;
import pl.chatboxserver.model.Message;
import pl.chatboxserver.model.User;

@RestController
public class ChatController {

    MessageDao messageDao;
    UserDao userDao;

    @Autowired
    public ChatController(@Qualifier("mysql") MessageDao messageDao, UserDao userDao){
        this.messageDao = messageDao;
        this.userDao = userDao;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message sendChatMessage(Message message){
        messageDao.insertMessage(message);
        return message;
    }

    @PostMapping("/user/{name}")
    public @ResponseStatus int userExists(@PathVariable("name") String name){
        if (userDao.userExistsByName(name)) {
            return 202;
        }

        userDao.insertUser(new User(name));
        return 200;
    }
}
