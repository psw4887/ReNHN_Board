package com.nhnacademy.nhn_board.controller;

import com.nhnacademy.nhn_board.dto.OnlyTitleContentDTO;
import com.nhnacademy.nhn_board.dto.complete.ContentDTO;
import com.nhnacademy.nhn_board.dto.complete.PostListDTO;
import com.nhnacademy.nhn_board.entity.User;
import com.nhnacademy.nhn_board.service.PostService;
import com.nhnacademy.nhn_board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class PostController {

    private final PostService pService;
    private final UserService uService;

    @GetMapping("/view/{page}")
    List<PostListDTO> getBoards(@PathVariable("page") Integer page,
                                HttpServletRequest req) {

        PageRequest pageRequest = PageRequest.of(page, 20);

        return pService.getPageablePostList(pageRequest, req);
    }

    @GetMapping("/content/{postNo}")
    ContentDTO viewContent(@PathVariable("postNo") int postNo,
                       HttpServletRequest req) {

        if(Objects.nonNull(req.getSession(false))) {
            pService.insertView(postNo, req);
        }

        return pService.getContentByPostNo(postNo);
    }

    @GetMapping("/register")
    String readyRegisterPost(HttpServletRequest req) {

        if (Objects.isNull(req.getSession(false))) {
            return "redirect:/board/view?page=0";
        }
        return "boardRegisterForm";
    }

    @PostMapping("/register")
    String registerPost(@RequestParam("writeTitle") String title,
                        @RequestParam("writeContent") String content,
                        HttpServletRequest req) {

        pService.postRegister(title, content, req);

        return "redirect:/board/view?page=0";
    }

    @GetMapping("/modify/{postNo}")
    String readyModifyPost(HttpServletRequest req,
                           @PathVariable("postNo") int postNo,
                           Model model) {

        OnlyTitleContentDTO dto = pService.getOnlyTitleContent(postNo);

        if (Objects.isNull(req.getSession(false)) ||
                (!((String)(req.getSession(false).getAttribute("id"))).equals(dto.getUser().getUserId()))) {
            return "redirect:/board/content?postNo=" + postNo;
        }

        model.addAttribute("postNo", postNo);
        model.addAttribute("title", dto.getTitle());
        model.addAttribute("content", dto.getContent());

        return "boardModifyForm";
    }

    @PostMapping("/modify")
    String modifyPost(@RequestParam("title") String title,
                      @RequestParam("content") String content,
                      @RequestParam("postNo") Integer postNo) {

        pService.postModify(title, content, postNo);

        return "redirect:/board/content?postNo=" + postNo;
    }

    @PostMapping("/delete/{postNo}")
    void deletePost(HttpServletRequest req,
                      @PathVariable("postNo") Integer postNo) {

        pService.postDelete(postNo);
    }

    @PostMapping("/search/{title}/{page}")
    List<PostListDTO> searchPost(@PathVariable("title") String title,
                      @PathVariable("page") Integer page,
                      HttpServletRequest req) {

        PageRequest pageRequest = PageRequest.of(page, 20);

        return pService.getPageableSearchPostList(pageRequest, title, req);

    }

    @GetMapping("/recover/{page}")
    List<PostListDTO> readyRecoverPost(@PathVariable("page") Integer page) {

        PageRequest pageRequest = PageRequest.of(page, 20);

        return pService.getPageableRecoverPostList(pageRequest);
    }

    @PostMapping("/recover/{postNo}")
    void recoverPost(@PathVariable("postNo") Integer postNo) {

        pService.postRecover(postNo);
    }
}
