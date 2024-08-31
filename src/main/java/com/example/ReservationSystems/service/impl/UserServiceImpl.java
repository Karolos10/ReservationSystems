package com.example.ReservationSystems.service.impl;

import com.example.ReservationSystems.model.User;
import com.example.ReservationSystems.repository.UserRepository;
import com.example.ReservationSystems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User saveUser(User user) throws Exception {
        User userLocal = userRepository.findByUsername(user.getUsername());
        if (userLocal != null) {
            throw new Exception("The email is already registered");
        } else {
            userLocal = userRepository.save(user);
        }

        return userLocal;
    }

    @Override
    public User getUser(String username) throws Exception {
        User userLocal = userRepository.findByUsername(username);
        if (userLocal != null) {
            return userLocal;
        } else {
            throw new Exception("The user not exists");
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
