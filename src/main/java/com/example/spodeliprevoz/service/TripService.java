package com.example.spodeliprevoz.service;

import com.example.spodeliprevoz.model.Driver;
import com.example.spodeliprevoz.model.Trip;

import java.time.LocalDateTime;
import java.util.List;

public interface TripService {
    Trip createNewTrip(String startStreet, String endStreet, Double price, LocalDateTime startTime, Long driverId);
    List<Trip> findTripsByEndStreet(List<String> endStreet);
    void startTrip(Long tripId);
    void endTrip(Long tripId);
    void cancelTrip(Long tripId);
    List<Trip> getListOfTripsForUser(String username);
    Trip getActiveTripForUser(String username);
}
