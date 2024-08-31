package com.example.ReservationSystems.model;

import jakarta.persistence.*;

@Entity
@Table(name = "userRoles")
public class UserRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userRoleId;

    @ManyToOne()
    private User users;

    @ManyToOne
    private Rol rol;

    public UserRol() {
    }

    public UserRol(Integer userRoleId, User users, Rol rol) {
        this.userRoleId = userRoleId;
        this.users = users;
        this.rol = rol;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
