package com.example.ReservationSystems.service.impl;

import com.example.ReservationSystems.model.Business;
import com.example.ReservationSystems.repository.BusinessRepository;
import com.example.ReservationSystems.service.BusinnesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImImpl implements BusinnesService {

    @Autowired
    private BusinessRepository businessRepository;
    @Override
    public List<Business> getBusiness() {
        return businessRepository.findAll();
    }
}
