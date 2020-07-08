package com.example.fordav.service;

import com.example.fordav.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    Long save(Vehicle vehicle);
    List<Vehicle> getAllVehiclesByIsAvailable();
}
