package com.example.spodeliprevoz.service.impl;

import com.example.spodeliprevoz.model.Driver;
import com.example.spodeliprevoz.model.User;
import com.example.spodeliprevoz.model.Vehicle;
import com.example.spodeliprevoz.model.enumerations.Role;
import com.example.spodeliprevoz.model.enumerations.VehicleType;
import com.example.spodeliprevoz.model.exceptions.InvalidUsernameException;
import com.example.spodeliprevoz.repository.DriverRepository;
import com.example.spodeliprevoz.repository.UserRepository;
import com.example.spodeliprevoz.repository.VehicleRepository;
import com.example.spodeliprevoz.service.DriverService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;

    @Override
    public List<Driver> findAllDrivers() {
        return this.driverRepository.findAll();
    }

    @Transactional
    @Override
    public void registerDriver(String username, String drivingLicenceLocation, String carLicenceLocation, String plateNumber, VehicleType vehicleType, String makeAndModel, String color, int maxSeats) {
        Driver driver=this.addNewDriver(username,drivingLicenceLocation,carLicenceLocation);
        Vehicle vehicle=new Vehicle(plateNumber,makeAndModel,vehicleType,color,maxSeats,driver);
        this.vehicleRepository.save(vehicle);
    }

    @Override
    public Driver addNewDriver(String username,String drivingLicenceLocation,String carLicenceLocation) {
        User user=this.userRepository.findByUsername(username).orElseThrow(InvalidUsernameException::new);
        user.setRole(Role.ROLE_DRIVER);
        Driver driver=new Driver(user,drivingLicenceLocation,carLicenceLocation);
        return this.driverRepository.save(driver);
    }
}
