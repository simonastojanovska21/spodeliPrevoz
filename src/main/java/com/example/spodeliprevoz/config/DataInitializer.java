package com.example.spodeliprevoz.config;

import com.example.spodeliprevoz.model.enumerations.Role;
import com.example.spodeliprevoz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class DataInitializer {

//    private final UserService userService;
//
//    public DataInitializer(UserService userService)
//    {
//        this.userService=userService;
//    }
//
//    @PostConstruct
//    public void initData() {
//        initializeUsers();
//    }
//
//    private void initializeUsers()
//    {
//        this.userService.register("passenger1@test.com","P@ssword1","P@ssword1",
//                "Name1","Surname1","070542784","img/profile.com");
//        this.userService.register("admin@test.com","P@ssword1","P@ssword1",
//                "Name2","Surname2","075368265","img/profile.com");
//        this.userService.changeRole("admin@test.com", Role.ADMIN);
//        this.userService.register("driver@test.com","P@ssword1","P@ssword1",
//                "Name3","Surname3","078532458","img/profile.com");
//        this.userService.changeRole("driver@test.com",Role.DRIVER);
//    }
}
