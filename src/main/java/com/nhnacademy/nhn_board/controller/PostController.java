package com.nhnacademy.nhn_board.controller;

import com.nhnacademy.nhn_board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService service;
}
