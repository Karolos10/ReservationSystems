package com.example.ReservationSystems.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ReservationDTO {

    private Integer reservationId;

    private LocalDateTime creationDate;

    private LocalDateTime modificationDate;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalTime startTime;

    private String details;

    private boolean canceled;

    private UserDTO user;

    private BusinessDTO business;

    public ReservationDTO(String details, Integer reservationId, LocalDateTime creationDate, LocalDateTime modificationDate, LocalDate startDate, LocalDate endDate, LocalTime startTime, boolean canceled, UserDTO user, BusinessDTO business) {
        this.details = details;
        this.reservationId = reservationId;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.canceled = canceled;
        this.user = user;
        this.business = business;
    }

    public BusinessDTO getBusiness() {
        return business;
    }

    public void setBusiness(BusinessDTO business) {
        this.business = business;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }
}
