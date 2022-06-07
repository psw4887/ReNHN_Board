package com.nhnacademy.nhn_board.service;

import com.nhnacademy.nhn_board.dto.ViewPostDTO;
import com.nhnacademy.nhn_board.dto.complete.PostListDTO;
import com.nhnacademy.nhn_board.entity.Post;
import com.nhnacademy.nhn_board.entity.User;
import com.nhnacademy.nhn_board.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository pRepository;
    private final UserRepository uRepository;
    private final ViewRepository vRepository;
    private final CommentRepository cRepository;
    private final LikeRepository lRepository;

    public List<PostListDTO> getPageablePostList(Pageable pageable, HttpServletRequest req) {
        User user = new User();
        boolean isGuest = true;

        if(Objects.nonNull(req.getSession(false))) {
            user = uRepository.findByUserId((String) req.getSession(false).getAttribute("id")).orElse(null);
            isGuest = false;
        }
            List<ViewPostDTO> viewPostDTOS = pRepository.getPageableList(pageable).getContent();
            List<PostListDTO> postListDTOS = new ArrayList<>();

            for (ViewPostDTO viewPostDTO : viewPostDTOS) {
                Post post = pRepository.findById(viewPostDTO.getPostNo()).orElse(null);
                User writer = uRepository.findById(viewPostDTO.getUserNo()).orElse(null);
                postListDTOS.add(new PostListDTO(
                        isLike(user, post, isGuest),
                        viewPostDTO.getPostNo(),
                        viewPostDTO.getTitle(),
                        writer.getUserId(),
                        viewPostDTO.getWriteDate(),
                        cRepository.countAllByPost(post),
                        vRepository.countAllByPost(post)));
            }
            return postListDTOS;
    }

    private boolean isLike(User user, Post post, boolean isGuest) {
        if (isGuest) {
            return false;
        }
        return lRepository.existsByUserAndPost(user, post);
    }
}
