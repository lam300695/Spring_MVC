package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
class CustomerController {

    @GetMapping("/home")
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView("/home");
        return modelAndView;
    }

}