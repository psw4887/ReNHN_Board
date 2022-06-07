package com.nhnacademy.nhn_board.controller;

import com.nhnacademy.nhn_board.dto.complete.PostListDTO;
import com.nhnacademy.nhn_board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class PostController {

    private final PostService service;

    @GetMapping("/view")
    String goBoard(@RequestParam("page") Integer page,
                   Model model,
                   HttpServletRequest req) {

        PageRequest pageRequest = PageRequest.of(page, 5);
        List<PostListDTO> list = service.getPageablePostList(pageRequest, req);
        model.addAttribute("isEnd", 0);

        if(list.size() < 5) {
            model.addAttribute("isEnd", 1);
        }
        model.addAttribute("page", page);
        model.addAttribute("lists", list);

        return "viewBoard";
    }
}
