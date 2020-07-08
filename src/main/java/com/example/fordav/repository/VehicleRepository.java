package com.example.fordav.repository;

import com.example.fordav.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findVehicleByIsAvailableTrue();
}
