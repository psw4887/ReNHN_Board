package com.nhnacademy.nhn_board.controller;

import com.nhnacademy.nhn_board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService service;

    @PostMapping("/register/{postNo}")
    public String commentRegister(@PathVariable("postNo")Integer postNo,
                                  @RequestParam("comment")String comment,
                                  HttpServletRequest req) {
        if (Objects.isNull(req.getSession(false))) {
            return "redirect:/board/content?postNo=" + postNo;
        }

        service.registerComment(postNo, comment, req);

        return "redirect:/board/content?postNo=" + postNo;
    }
}
