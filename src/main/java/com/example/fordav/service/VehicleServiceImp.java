package com.example.fordav.service;

import com.example.fordav.entity.Vehicle;
import com.example.fordav.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImp implements VehicleService{

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Long save(Vehicle vehicle) {
        return vehicleRepository.save(vehicle).getId();
    }

    @Override
    public List<Vehicle> getAllVehiclesByIsAvailable() {
        return vehicleRepository.findVehicleByIsAvailableTrue();
    }
}
