package com.nhnacademy.nhn_board.dto.vo;

import com.nhnacademy.nhn_board.entity.User;
import lombok.Data;

@Data
public class PostRegisterRequest {
    private User user;

    private String title;

    private String content;
}
