package ru.xerces.katacourse.SpringBoot_312.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.xerces.katacourse.SpringBoot_312.entity.User;

import java.util.List;


@Repository
public class UserDaoService implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(int id, User user) {
        User tempUser = em.find(User.class, id);
        tempUser.setNickname(user.getNickname());
        tempUser.setCountry(user.getCountry());
        tempUser.setEmail(user.getEmail());
        em.merge(tempUser);
    }

    @Override
    public void deleteUser(int id) {
        em.remove(em.find(User.class, id));
    }
}
