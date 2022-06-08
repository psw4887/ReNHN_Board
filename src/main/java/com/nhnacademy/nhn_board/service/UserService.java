package com.nhnacademy.nhn_board.service;

import com.nhnacademy.nhn_board.entity.User;
import com.nhnacademy.nhn_board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository uRepository;

    public User findUserById(String id) {
        return uRepository.findByUserId(id).orElse(null);
    }
}
