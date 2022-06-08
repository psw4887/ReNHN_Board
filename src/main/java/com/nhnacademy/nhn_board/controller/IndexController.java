package com.nhnacademy.nhn_board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @RequestMapping(value = {"/index", "/"})
    public String goHome(HttpServletRequest req,
                         Model model) {

        return "index";
    }

}
