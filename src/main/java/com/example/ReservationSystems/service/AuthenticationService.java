package com.example.ReservationSystems.service;

import com.example.ReservationSystems.dto.LoginUserDto;
import com.example.ReservationSystems.dto.RegisterUserDto;
import com.example.ReservationSystems.model.CustomUserDetails;
import com.example.ReservationSystems.model.User;
import com.example.ReservationSystems.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signup(RegisterUserDto input) throws Exception {
        Optional<User> result = userRepository.findByUsername(input.getUsername());

        if (result.isEmpty()) {
            User user = new User();
            user.setNames(input.getNames());
            user.setLastName(input.getLastName());
            user.setUsername(input.getUsername());
            user.setEmail(input.getEmail());
            user.setPassword(passwordEncoder.encode(input.getPassword()));
            user.setPhone(input.getPhone());

            return userRepository.save(user);
        } else {
            throw new Exception("The user name is already registered");
        }

    }

    public CustomUserDetails authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        return userRepository.findByUsername(input.getUsername())
                .map(CustomUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
