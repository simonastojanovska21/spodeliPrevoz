package com.example.spodeliprevoz.model;

import com.example.spodeliprevoz.model.enumerations.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "app_user")
public class User {
    @Id
    private String username;

    private String password;

    private String fullName;

    private String telephoneNumber;

    private String image;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public String getUsername() {
        return username;
    }
}
