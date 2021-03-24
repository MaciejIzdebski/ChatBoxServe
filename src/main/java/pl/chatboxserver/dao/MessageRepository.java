package pl.chatboxserver.dao;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.stereotype.Repository;
import pl.chatboxserver.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Repository("mysql")
public class MessageRepository implements MessageDao{


    EntityManagerFactory emf;

    public MessageRepository(){
        emf = Persistence.createEntityManagerFactory("MessageDatabaseJPA");

    }

    @Override
    public List<Message> getAllMessages() {
        return null;
    }

    @Override
    public boolean insertMessage(Message message) {
        EntityManager entityManager = emf.createEntityManager();
//        message.setId(null);
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(message);
            entityManager.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Error");
            return false;
        }

        return true;
    }
}
