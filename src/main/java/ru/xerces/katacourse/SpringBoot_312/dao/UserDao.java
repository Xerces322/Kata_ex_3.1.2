package ru.xerces.katacourse.SpringBoot_312.dao;


import ru.xerces.katacourse.SpringBoot_312.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void addUser(User user);
    public void updateUser(int id, User user);
    public void deleteUser(int id);
}
