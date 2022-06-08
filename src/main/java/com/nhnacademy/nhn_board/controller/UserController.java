package com.nhnacademy.nhn_board.controller;

import com.nhnacademy.nhn_board.entity.User;
import com.nhnacademy.nhn_board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/{id}")

public class UserController {

    private final UserService service;


    @GetMapping
    public User getUser(@PathVariable("id") String id) {

        return service.findUserById(id);
    }
}
