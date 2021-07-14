package com.example.spodeliprevoz.service;

import com.example.spodeliprevoz.model.Passenger;
import com.example.spodeliprevoz.model.User;

public interface PassengerService {
    Passenger addNewPassenger(String username);
    void addPassengerToTrip(Long passengerId, Long tripId);
}
