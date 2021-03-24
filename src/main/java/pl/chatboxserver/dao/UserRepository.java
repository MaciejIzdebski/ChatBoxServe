package pl.chatboxserver.dao;

import org.springframework.stereotype.Repository;
import pl.chatboxserver.model.Message;
import pl.chatboxserver.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Repository
public class UserRepository implements UserDao{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("UserEMF");

    @Override
    public boolean userExistsByName(String id) {
        EntityManager entityManager = emf.createEntityManager();

        User user = entityManager.find(User.class,new User(id));

        return user != null;
    }

    @Override
    public boolean insertUser(User user) {
        EntityManager entityManager = emf.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(user);
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
