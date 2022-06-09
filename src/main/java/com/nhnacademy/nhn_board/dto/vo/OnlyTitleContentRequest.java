package com.nhnacademy.nhn_board.dto.vo;

import com.nhnacademy.nhn_board.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnlyTitleContentRequest {

    User user;

    String title;

    String content;
}