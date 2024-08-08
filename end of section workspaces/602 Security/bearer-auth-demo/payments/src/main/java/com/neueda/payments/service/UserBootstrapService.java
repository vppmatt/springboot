package com.neueda.payments.service;

import com.neueda.payments.enums.UserRole;
import com.neueda.payments.model.User;
import com.neueda.payments.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBootstrapService {

    private UserService userService;

    private UserRepository userRepository;

    public UserBootstrapService(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void setupUsers() {
        if (userRepository.count() == 0) {
            User user1 = new User();
            user1.setName("user1");
            user1.setPassword("password");
            user1.setRole(UserRole.USER);
            userService.save(user1);
            User user2 = new User();
            user2.setName("user2");
            user2.setPassword("password");
            user2.setRole(UserRole.ADMIN);
            userService.save(user2);
        }
    }
}
