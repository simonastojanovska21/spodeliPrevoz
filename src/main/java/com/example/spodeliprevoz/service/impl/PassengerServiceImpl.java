package com.example.spodeliprevoz.service.impl;

import com.example.spodeliprevoz.model.Passenger;
import com.example.spodeliprevoz.model.Trip;
import com.example.spodeliprevoz.model.User;
import com.example.spodeliprevoz.model.enumerations.Role;
import com.example.spodeliprevoz.model.exceptions.InvalidUsernameException;
import com.example.spodeliprevoz.repository.PassengerRepository;
import com.example.spodeliprevoz.repository.TripRepository;
import com.example.spodeliprevoz.repository.UserRepository;
import com.example.spodeliprevoz.service.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final TripRepository tripRepository;
    private final UserRepository userRepository;

    @Override
    public Passenger addNewPassenger(String username) {
        User user=this.userRepository.findByUsername(username).orElseThrow(InvalidUsernameException::new);
        user.setRole(Role.ROLE_PASSENGER);
        Passenger passenger=new Passenger(user);
        this.userRepository.save(user);
        return this.passengerRepository.save(passenger);
    }

    @Override
    public void addPassengerToTrip(Long passengerId, Long tripId) {
        Passenger passenger=this.passengerRepository.findById(passengerId).get();
        Trip trip=this.tripRepository.findById(tripId).get();
        List<Passenger> passengerList=trip.getPassengerList();
        passengerList.add(passenger);
        this.tripRepository.save(trip);
    }
}
