package com.github.ahuangjm.spring.boot.react.starter.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class IndexController {
    @GetMapping
    public ModelAndView homepage() {
        log.info("Getting homepage");
        return new ModelAndView("index");
    }
}
