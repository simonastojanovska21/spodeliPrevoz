package com.example.spodeliprevoz.model;

import com.example.spodeliprevoz.model.enumerations.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long DriverId;

    @OneToOne
    private User user;

    private String drivingLicenceLocation;

    private String carLicenceLocation;

    public  Driver(User user, String drivingLicenceLocation, String carLicenceLocation)
    {
        this.user=user;
        this.drivingLicenceLocation=drivingLicenceLocation;
        this.carLicenceLocation=carLicenceLocation;
    }
}
