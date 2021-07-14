package com.example.spodeliprevoz.repository;


import com.example.spodeliprevoz.model.Driver;
import com.example.spodeliprevoz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
    Driver findByUser(User user);
}
