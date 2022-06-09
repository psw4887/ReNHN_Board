package com.nhnacademy.nhn_board.controller;

import com.nhnacademy.nhn_board.dto.OnlyTitleContentDTO;
import com.nhnacademy.nhn_board.dto.complete.ContentDTO;
import com.nhnacademy.nhn_board.dto.complete.PostListDTO;
import com.nhnacademy.nhn_board.dto.vo.OnlyTitleContentRequest;
import com.nhnacademy.nhn_board.dto.vo.PostRegisterRequest;
import com.nhnacademy.nhn_board.entity.Post;
import com.nhnacademy.nhn_board.service.PostService;
import com.nhnacademy.nhn_board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{postNo}")
    Post getPost(@PathVariable("postNo") Integer postNo) {

        return pService.postGet(postNo);
    }

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    void registerPost(@RequestBody PostRegisterRequest post,
                        HttpServletRequest req) {

        pService.postRegister(post.getUser(), post.getTitle(), post.getContent(), req);
    }

    @GetMapping("/modify/{postNo}")
    OnlyTitleContentRequest readyModifyPost(@PathVariable("postNo") int postNo) {

        return new OnlyTitleContentRequest(pService.getOnlyTitleContent(postNo).getUser(),
            pService.getOnlyTitleContent(postNo).getTitle(),
            pService.getOnlyTitleContent(postNo).getContent());
    }

    @PostMapping("/modify")
    String modifyPost(@RequestParam("title") String title,
                      @RequestParam("content") String content,
                      @RequestParam("postNo") Integer postNo) {

        pService.postModify(title, content, postNo);

        return "redirect:/board/content?postNo=" + postNo;
    }

    @PostMapping("/delete/{postNo}")
    void deletePost(@PathVariable("postNo") Integer postNo) {

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
