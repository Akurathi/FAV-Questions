package com.example.fordav.controller;

import com.example.fordav.entity.Ride;
import com.example.fordav.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ride")
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping(value = "/", produces = "application/json", consumes="application/json")
        public Long makeARide(@RequestBody Ride ride) {
            return rideService.saveRide(ride);
    }
}
