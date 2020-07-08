package com.example.fordav;


import com.example.fordav.controller.RideController;
import com.example.fordav.entity.Ride;
import com.example.fordav.entity.User;
import com.example.fordav.entity.Vehicle;
import com.example.fordav.repository.UserRepository;
import com.example.fordav.repository.RideRepository;
import com.example.fordav.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class RideControllerTest {

    @Autowired
    private RideController rideController;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private VehicleRepository vehicleRepository;

    @MockBean
    private RideRepository rideRepository;

    @Test
    public void makeARideTest() {
        User u = new User(1L,"Sri Harsha Akurathi");
        Vehicle v = new Vehicle(1L,"Ford Fusion",true);
        Ride r = new Ride(1L,u.getId(),v.getId());

        when(userRepository.findById(any())).thenReturn(java.util.Optional.of(u));
        when(vehicleRepository.findById(any())).thenReturn(java.util.Optional.of(v));
        when(rideRepository.save(any())).thenReturn(r);

        Assertions.assertEquals(rideController.makeARide(r),r.getId());
    }
}