package com.nhnacademy.nhn_board.service;

import com.nhnacademy.nhn_board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository cRepository;
}
