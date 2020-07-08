package com.example.fordav.controller;

import com.example.fordav.entity.Vehicle;
import com.example.fordav.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping(value = "/save", produces = "application/json")
    public Long save(@RequestBody Vehicle vehicle){
        return vehicleService.save(vehicle);

    }


    @GetMapping(value = "/available", produces = "application/json")
    public List<Vehicle> getAllByAvailablity(){
        return vehicleService.getAllVehiclesByIsAvailable();
    }
}