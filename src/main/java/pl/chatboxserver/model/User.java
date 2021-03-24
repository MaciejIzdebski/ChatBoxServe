package pl.chatboxserver.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    String userName;


    public User(){}

    public User(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
