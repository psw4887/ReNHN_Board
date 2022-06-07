package com.nhnacademy.nhn_board.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

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
public class View {

    @EmbeddedId
    private ViewPK viewPK;

    @MapsId("postNo")
    @ManyToOne
    @JoinColumn(name = "post_no")
    private Post post;

    @MapsId("userNo")
    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    @Embeddable
    public static class ViewPK implements Serializable {
        @Column(name = "post_no")
        Integer postNo;

        @Column(name = "user_no", insertable = false, updatable = false)
        Integer userNo;
    }
}
