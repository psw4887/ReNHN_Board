package com.nhnacademy.nhn_board.controller;

import com.nhnacademy.nhn_board.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class LikeController {

    private final LikeService service;
}
