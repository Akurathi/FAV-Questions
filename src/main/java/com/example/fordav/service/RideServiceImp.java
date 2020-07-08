package com.example.fordav.service;

import com.example.fordav.entity.Ride;
import com.example.fordav.entity.User;
import com.example.fordav.entity.Vehicle;
import com.example.fordav.repository.RideRepository;
import com.example.fordav.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RideServiceImp<UserRepository> implements RideService{

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private com.example.fordav.repository.UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Long saveRide(Ride ride) {
        Optional<User> user = userRepository.findById(ride.getUserId());
        if(user.isPresent()){
            Optional<Vehicle> vehicle = vehicleRepository.findById(ride.getVehicleId());
            if (vehicle.isPresent() && vehicle.get().getIsAvailable()){
                return rideRepository.save(ride).getId();
            }
        }
        return null;
    }
}
