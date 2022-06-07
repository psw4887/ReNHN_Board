package com.nhnacademy.nhn_board.repository;

import com.nhnacademy.nhn_board.entity.Like;
import com.nhnacademy.nhn_board.entity.Post;
import com.nhnacademy.nhn_board.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {

    Boolean existsByUserAndPost(User user, Post post);
}
