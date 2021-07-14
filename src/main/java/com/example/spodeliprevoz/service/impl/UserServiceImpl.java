package com.example.spodeliprevoz.service.impl;

import com.example.spodeliprevoz.model.User;
import com.example.spodeliprevoz.model.enumerations.Role;
import com.example.spodeliprevoz.model.exceptions.InvalidUsernameException;
import com.example.spodeliprevoz.repository.UserRepository;
import com.example.spodeliprevoz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(String username, String password, String repeatedPassword, String name, String telephone, String image)
    {
        String encryptedPassword=this.passwordEncoder.encode(password);
        User user=new User(username,encryptedPassword,name,telephone,image,Role.ROLE_PASSENGER);
        return this.userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username).orElseThrow(InvalidUsernameException::new);
    }


    @Override
    public User editUserInformation(String username, String name, String telephone, String image) {
        User user=this.userRepository.findByUsername(username).orElseThrow(InvalidUsernameException::new);
        user.setFullName(name);
        user.setTelephoneNumber(telephone);
        user.setImage(image);
        return this.userRepository.save(user);
    }

    @Override
    public User changeRole(String username, Role newRole) {
        User user=this.userRepository.findByUsername(username).orElseThrow(InvalidUsernameException::new);
        user.setRole(newRole);
        return this.userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=this.userRepository.findByUsername(username).orElseThrow(InvalidUsernameException::new);
        UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),
                Stream.of(new SimpleGrantedAuthority(user.getRole().toString())).collect(Collectors.toList()));
        return userDetails;
    }
}
