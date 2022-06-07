package com.nhnacademy.nhn_board.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_no")
    private Integer postNo;

    @Column(name = "user_no", insertable = false, updatable = false)
    private Integer userNo;

    @MapsId
    @OneToOne
    @JoinColumn
    private User user;

    @Column(name = "post_title")
    private String title;

    @Column(name = "post_content")
    private String content;

    @Column(name = "post_write_datetime")
    private LocalDateTime writeDateTime;

    @Column(name = "post_modify_dateTime")
    private LocalDateTime modifyDateTime;

    @Column(name = "post_check_hide")
    private Boolean checkHide;
}
