package com.example.ReservationSystems.service.impl;

import com.example.ReservationSystems.model.User;
import com.example.ReservationSystems.model.UserRol;
import com.example.ReservationSystems.repository.RolRepository;
import com.example.ReservationSystems.repository.UserRepository;
import com.example.ReservationSystems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
