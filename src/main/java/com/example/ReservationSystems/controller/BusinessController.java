package com.example.ReservationSystems.controller;

import com.example.ReservationSystems.model.Business;
import com.example.ReservationSystems.service.BusinnesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinnesService businnesService;

    @GetMapping
    public List<Business> getBusiness(){
        return businnesService.getBusiness();
    }
}
