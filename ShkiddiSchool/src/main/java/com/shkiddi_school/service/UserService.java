package com.shkiddi_school.service;

import com.shkiddi_school.domain.Message;
import com.shkiddi_school.domain.Role;
import com.shkiddi_school.domain.User;
import com.shkiddi_school.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean addUser(User user) {
        User userFromDB = userRepo.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        userRepo.save(user);

        String message = String.format(
                "Hello, %s \n" +
                        "Welcome to Shkiddi.Java.School.\n" +
                        "Please, visit next link: http://localhost8080/activate/%s", user.getUsername(), user.getActivationCode()
        );

        if (!StringUtils.isEmpty(user.getEmail())) {

        }
        return true;
    }

    public boolean activateUser(String code) {
        User user = userRepo.findByActivationCode(code);

        if(user == null){
            return false;
        }

        user.setActivationCode(null);
        userRepo.save(user);
        return true;
    }

    public void save(User user){
        userRepo.save(user);
    }
}
