package com.nhnacademy.nhn_board.service;

import com.nhnacademy.nhn_board.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository lRepository;
}
