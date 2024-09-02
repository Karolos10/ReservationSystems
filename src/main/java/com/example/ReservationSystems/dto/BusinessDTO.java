package com.example.ReservationSystems.dto;

public class BusinessDTO {

    private Integer businessId;

    private String name;

    private String description;

    private Double price;

    public BusinessDTO(Integer businessId, String name, String description, Double price) {
        this.businessId = businessId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
