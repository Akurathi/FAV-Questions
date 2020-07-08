package com.example.fordav;


import com.example.fordav.controller.VehicleController;
import com.example.fordav.entity.Vehicle;
import com.example.fordav.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class VehicleControllerTest {

    @Autowired
    private VehicleController vehicleController;

    @MockBean
    private VehicleRepository vehicleRepository;

    @Test
    public void saveTest() {
        Vehicle newVehicle = new Vehicle(1L,"ford", true);
        when(vehicleRepository.save(any())).thenReturn(newVehicle);
        Assertions.assertEquals(vehicleController.save(newVehicle),newVehicle.getId());
    }

    @Test
    public void getAllByAvailabilityTest(){
        Vehicle v1 = new Vehicle(1L,"vehicle1",true);
        Vehicle v2 = new Vehicle(2L,"vehicle2",true);
        Vehicle v3 = new Vehicle(3L,"vehicle3",false);
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(v1);
        vehicles.add(v2);
        vehicles.add(v3);
        List<Vehicle> filteredVehicles = vehicles.stream().filter(v->v.getIsAvailable()).collect(Collectors.toList());

        when(vehicleRepository.findVehicleByIsAvailableTrue()).thenReturn(filteredVehicles);
        Assertions.assertEquals(vehicleController.getAllByAvailablity(),filteredVehicles);

    }


}