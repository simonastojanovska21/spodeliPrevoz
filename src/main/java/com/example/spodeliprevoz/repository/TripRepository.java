package com.example.spodeliprevoz.repository;

import com.example.spodeliprevoz.model.Driver;
import com.example.spodeliprevoz.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {
    List<Trip> findAllByEndStreet(String endStreet);
    List<Trip> findAllByCreatorOfTrip(Driver driver);
}
