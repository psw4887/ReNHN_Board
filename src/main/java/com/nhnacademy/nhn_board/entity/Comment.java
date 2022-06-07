package com.nhnacademy.nhn_board.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_no")
    private Integer commentNo;

    @Column(name = "post_no")
    private Integer postNo;

    @MapsId
    @ManyToOne
    @JoinColumn(name = "post_no")
    private Post post;

    @Column(name = "user_no")
    private Integer userNo;

    @MapsId
    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    @Column(name = "comment_content")
    private String content;

}
