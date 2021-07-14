package com.example.spodeliprevoz.model;

import com.example.spodeliprevoz.model.enumerations.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    private String plateNumber;

    private String makeAndModel;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private String color;

    private int maxSeats;

    @OneToOne
    private Driver owner;
}
