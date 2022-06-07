package com.nhnacademy.nhn_board.dto;

import java.time.LocalDateTime;

public interface ViewPostDTO {

    Integer getPostNo();

    Integer getUserNo();

    String getTitle();

    LocalDateTime getWriteDate();
}
