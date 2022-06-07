package com.nhnacademy.nhn_board.service;

import com.nhnacademy.nhn_board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository pRepository;
}
