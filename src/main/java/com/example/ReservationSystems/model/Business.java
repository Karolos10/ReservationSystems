package com.example.ReservationSystems.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "business")
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer businessId;

    private String name;

    private String description;

    private Double price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "business")
    private List<Reservation> reservations;

    public Business() {
    }

    public Business(Double price, Integer businessId, String name, String description, List<Reservation>  reservations) {
        this.price = price;
        this.businessId = businessId;
        this.name = name;
        this.description = description;
        this.reservations = reservations;
    }

    public List<Reservation>  getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation>  reservations) {
        this.reservations = reservations;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }


}
