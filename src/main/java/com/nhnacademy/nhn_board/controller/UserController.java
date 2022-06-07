package com.nhnacademy.nhn_board.controller;

import com.nhnacademy.nhn_board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
}
