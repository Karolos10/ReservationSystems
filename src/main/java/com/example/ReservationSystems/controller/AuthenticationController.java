package com.example.ReservationSystems.controller;

import com.example.ReservationSystems.configurations.JwtUtils;
import com.example.ReservationSystems.model.JwtRequest;
import com.example.ReservationSystems.model.JwtResponse;
import com.example.ReservationSystems.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{

            authenticar(jwtRequest.getUsername(), jwtRequest.getPassword());

        }catch (Exception exception) {
            exception.printStackTrace();
            throw new Exception("User not found");
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticar(String username, String password)throws Exception{
        try{

            authenticationManager.authenticate((new UsernamePasswordAuthenticationToken(username, password)));

        }catch (DisabledException disabledException){

            throw new Exception("User disabled" + disabledException.getMessage());

        }catch (BadCredentialsException badCredentialsException){

            throw new Exception("Invalid credentials" + badCredentialsException.getMessage());

        }
    }
}
