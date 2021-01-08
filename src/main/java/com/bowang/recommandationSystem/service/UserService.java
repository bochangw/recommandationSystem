package com.bowang.recommandationSystem.service;

import com.bowang.recommandationSystem.Repository.UserRepository;
import com.bowang.recommandationSystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByID(Long userID) {
        return userRepository.findById(userID).get();
    }

    public User getAUser() {
        List<User> users = userRepository.findAll();
        int index = (int) Math.floor(Math.random() * users.size());
        return users.get(index);
    }

    public List<User> saveAUser(String firstname, String lastname, String password) {
        userRepository.save(new User(firstname, lastname, password));
        return userRepository.findAll();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> deleteAllUsers() {
        userRepository.deleteAll();
        return userRepository.findAll();
    }
}
