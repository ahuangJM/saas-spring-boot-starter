package com.github.ahuangjm.spring.boot.react.starter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {
    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("index");
    }
}
