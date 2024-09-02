package com.example.ReservationSystems.dto;

public class UserDTO {

    private Integer userId;

    private String names;

    private String lastName;

    private String username;

    private String email;

    private String phone;

    public UserDTO(String email, Integer userId, String names, String lastName, String username, String phone) {
        this.email = email;
        this.userId = userId;
        this.names = names;
        this.lastName = lastName;
        this.username = username;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
