package com.example.spodeliprevoz.service;

import com.example.spodeliprevoz.model.Driver;
import com.example.spodeliprevoz.model.User;
import com.example.spodeliprevoz.model.enumerations.VehicleType;

import java.util.List;

public interface DriverService {
    List<Driver> findAllDrivers();
    void registerDriver(String username, String drivingLicenceLocation, String carLicenceLocation, String plateNumber, VehicleType vehicleType, String makeAndModel, String color, int maxSeats);
    Driver addNewDriver(String username,String drivingLicenceLocation,String carLicenceLocation);
}
