package com.example.ReservationSystems.service;

import com.example.ReservationSystems.model.User;

public interface UserService {

    public User saveUser(User user) throws Exception;

    public User getUser(String username) throws Exception;

    public void deleteUser(Integer userId);


}
