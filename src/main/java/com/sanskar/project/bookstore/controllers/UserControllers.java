package com.sanskar.project.bookstore.controllers;

import com.sanskar.project.bookstore.dto.UserDTO;
import com.sanskar.project.bookstore.services.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserControllers {
    private final UserService userService;

    public UserControllers(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String saveUser(@RequestBody UserDTO userDTO){
        userDTO.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        UserDTO userDTO1 = userService.saveUser(userDTO);
        return STR."User registered successfully!\n\{userDTO1.toString()}";
    }
}
