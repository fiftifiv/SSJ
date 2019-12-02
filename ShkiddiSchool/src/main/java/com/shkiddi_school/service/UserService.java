package com.shkiddi_school.service;

import com.shkiddi_school.domain.Role;
import com.shkiddi_school.domain.User;
import com.shkiddi_school.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private TestService testService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public boolean addUser(User user) {
        User userFromDB = userRepo.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setActive(false);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);

        if (!StringUtils.isEmpty(user.getEmail())) {

            String message = String.format(
                    "Hello, %s \n" +
                            "Welcome to Shkiddi.Java.School.\n" +
                            "Please, visit next link: http://localhost:8080/activate/%s", user.getUsername(), user.getActivationCode()
            );

            mailSender.send(user.getEmail(), "Activetion code", message);
        }
        return true;
    }

    public boolean activateUser(String code) {
        User user = userRepo.findByActivationCode(code);
        user.setPassword2(user.getPassword());
        if (user == null || user.isActive()) {
            return false;
        }

        user.setActive(true);
        userRepo.save(user);
        return true;
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public int userProgresTest(User user) {
        return (100 * user.getProgres().size()) / testService.findAll().size();
    }
}
