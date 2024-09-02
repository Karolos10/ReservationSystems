package com.example.ReservationSystems.service;

import com.example.ReservationSystems.model.Business;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BusinnesService {

    List<Business> getBusiness();
}
