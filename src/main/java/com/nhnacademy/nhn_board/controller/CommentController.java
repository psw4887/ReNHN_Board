package com.nhnacademy.nhn_board.controller;

import com.nhnacademy.nhn_board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService service;
}
