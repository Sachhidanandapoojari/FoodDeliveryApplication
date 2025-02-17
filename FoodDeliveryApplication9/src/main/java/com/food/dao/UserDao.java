package com.food.dao;

import java.util.List;

import com.food.model.User;

public interface UserDao {
   void addUser(User user);
   User getUser(int userId);
   void updateUser(User user);
   void deleteUser(int userId);
   
   List<User> getAllUsers();
}
