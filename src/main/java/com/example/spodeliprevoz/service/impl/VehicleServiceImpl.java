package com.example.spodeliprevoz.service.impl;

import com.example.spodeliprevoz.model.Driver;
import com.example.spodeliprevoz.model.User;
import com.example.spodeliprevoz.model.Vehicle;
import com.example.spodeliprevoz.model.enumerations.VehicleType;
import com.example.spodeliprevoz.model.exceptions.InvalidUsernameException;
import com.example.spodeliprevoz.repository.DriverRepository;
import com.example.spodeliprevoz.repository.UserRepository;
import com.example.spodeliprevoz.repository.VehicleRepository;
import com.example.spodeliprevoz.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;
    private final DriverRepository driverRepository;


    @Override
    public Vehicle addNewVehicle(String plateNumber, String makeAndModel, VehicleType vehicleType, String color, int seats, Long ownerId) {
        Driver owner=this.driverRepository.findById(ownerId).get();
        Vehicle vehicle=new Vehicle(plateNumber,makeAndModel,vehicleType,color,seats,owner);
        return this.vehicleRepository.save(vehicle);
    }

}
