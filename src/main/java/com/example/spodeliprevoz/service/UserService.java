package com.example.spodeliprevoz.service;
import com.example.spodeliprevoz.model.enumerations.Role;
import com.example.spodeliprevoz.model.User;

public interface UserService {
    User register(String username, String password, String repeatedPassword, String name,  String telephone, String image);
    User findByUsername(String username);
    User editUserInformation(String username, String name, String telephone, String image);
    User changeRole(String username, Role newRole);
}
