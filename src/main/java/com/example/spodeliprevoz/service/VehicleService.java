package com.example.spodeliprevoz.service;

import com.example.spodeliprevoz.model.Vehicle;
import com.example.spodeliprevoz.model.enumerations.VehicleType;

public interface VehicleService {
    Vehicle addNewVehicle(String plateNumber, String makeAndModel, VehicleType vehicleType, String color, int seats, Long ownerId);
}
