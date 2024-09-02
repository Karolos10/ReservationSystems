package com.example.ReservationSystems.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    private Integer rolId;

    private String nameRol;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rol")
    @JsonIgnore
    private Set<UserRol> userRols = new HashSet<>();

    public Rol() {
    }

    public Rol(Integer rolId, String nameRol, Set<UserRol> userRols) {
        this.rolId = rolId;
        this.nameRol = nameRol;
        this.userRols = userRols;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }

    public Set<UserRol> getUserRols() {
        return userRols;
    }

    public void setUserRols(Set<UserRol> userRols) {
        this.userRols = userRols;
    }
}
