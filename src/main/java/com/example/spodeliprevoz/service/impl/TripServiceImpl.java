package com.example.spodeliprevoz.service.impl;

import com.example.spodeliprevoz.model.Driver;
import com.example.spodeliprevoz.model.Trip;
import com.example.spodeliprevoz.model.User;
import com.example.spodeliprevoz.model.enumerations.TripStatus;
import com.example.spodeliprevoz.model.exceptions.InvalidUsernameException;
import com.example.spodeliprevoz.repository.DriverRepository;
import com.example.spodeliprevoz.repository.TripRepository;
import com.example.spodeliprevoz.repository.UserRepository;
import com.example.spodeliprevoz.service.TripService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final UserRepository userRepository;
    private final DriverRepository driverRepository;

    @Override
    public Trip createNewTrip(String startStreet, String endStreet, Double price, LocalDateTime startTime, Long driverId) {
        Driver driver=this.driverRepository.findById(driverId).get();
        Trip trip=new Trip(startStreet,endStreet,price,startTime, TripStatus.CREATED,driver);
        return this.tripRepository.save(trip);
    }

    @Override
    public List<Trip> findTripsByEndStreet(List<String> endStreet) {
        return null;
    }

    @Override
    public void startTrip(Long tripId) {
        Trip trip=this.tripRepository.findById(tripId).get();
        trip.setTripStatus(TripStatus.ACTIVE);
        this.tripRepository.save(trip);
    }

    @Override
    public void endTrip(Long tripId) {
        Trip trip=this.tripRepository.findById(tripId).get();
        trip.setTripStatus(TripStatus.FINISHED);
        this.tripRepository.save(trip);
    }

    @Override
    public void cancelTrip(Long tripId) {
        Trip trip=this.tripRepository.findById(tripId).get();
        trip.setTripStatus(TripStatus.CANCELED);
        this.tripRepository.save(trip);
    }

    @Override
    public List<Trip> getListOfTripsForUser(String username) {
        User user=this.userRepository.findByUsername(username).orElseThrow(InvalidUsernameException::new);
        Driver driver=this.driverRepository.findByUser(user);
        return this.tripRepository.findAllByCreatorOfTrip(driver);
    }

    @Override
    public Trip getActiveTripForUser(String username) {
        User user=this.userRepository.findByUsername(username).orElseThrow(InvalidUsernameException::new);
        Driver driver=this.driverRepository.findByUser(user);
        return this.tripRepository.findAllByCreatorOfTrip(driver)
                .stream()
                .filter(each->each.getTripStatus().equals(TripStatus.ACTIVE))
                .findFirst()
                .get();
    }
}
