package com.example.spodeliprevoz.model;

import com.example.spodeliprevoz.model.enumerations.TripStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripID;

    private String startStreet;

    private String endStreet;

    private Double price;

    private LocalDateTime startTime;

    @Enumerated(EnumType.STRING)
    private TripStatus tripStatus;

    @ManyToOne
    private Driver creatorOfTrip;

    @ManyToMany
    private List<Passenger> passengerList;

    public Trip(String startStreet, String endStreet, Double price, LocalDateTime startTime,TripStatus tripStatus, Driver creatorOfTrip)
    {
        this.startStreet=startStreet;
        this.endStreet=endStreet;
        this.price=price;
        this.startTime=startTime;
        this.tripStatus=tripStatus;
        this.creatorOfTrip=creatorOfTrip;
    }
}
