package com.nhnacademy.nhn_board.controller;

import com.nhnacademy.nhn_board.service.ViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ViewController {

    private final ViewService service;
}
