package pl.chatboxserver.dao;

import pl.chatboxserver.model.User;

public interface UserDao {
    boolean userExistsByName(String id);
    boolean insertUser(User user);
}
