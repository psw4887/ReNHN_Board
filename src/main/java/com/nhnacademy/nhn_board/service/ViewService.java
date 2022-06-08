package com.nhnacademy.nhn_board.service;

import com.nhnacademy.nhn_board.repository.ViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViewService {

    private final ViewRepository vRepository;
}
