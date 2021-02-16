package com.server.reactSpringServer.dao;//package com.server.reactSpringServer.dao;
//
//import com.server.reactSpringServer.models.User;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Repository
//@Transactional
//public class UserDAO {
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    public void addUser(User user){
//        entityManager.persist(user);
//    }
//
//    public List<User> getUsers(){
//        return entityManager.createQuery("select u from User u",User.class).getResultList();
//
//    }
//}

import com.server.reactSpringServer.models.User;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.JpaRepository;

@EnableJdbcRepositories
public interface UserDAO extends JpaRepository<User,Integer> {

   User findUserByName(String name);
}
