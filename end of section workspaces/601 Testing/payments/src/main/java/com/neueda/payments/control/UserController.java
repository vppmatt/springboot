package com.neueda.payments.control;

import com.neueda.payments.dto.UserDTO;
import com.neueda.payments.model.User;
import com.neueda.payments.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id) {
        return new UserDTO(userService.getById(id));
    }

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAll().stream().map(UserDTO::new).toList();
    }

    @PostMapping
    public UserDTO saveUser(User user) {
        return new UserDTO(userService.save(user));
    }
}
