package com.nhnacademy.nhn_board.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_no")
    private Integer commentNo;

    @MapsId
    @ManyToOne
    @JoinColumn(name = "post_no", referencedColumnName = "post_no")
    private Post post;

    @Column(name = "user_no", insertable = false, updatable = false)
    private Integer userNo;

    @MapsId
    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    @Column(name = "comment_content")
    private String content;

}
