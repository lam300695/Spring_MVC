package com.codegym.controller;


import com.codegym.service.CustomerSevice;
import com.codegym.service.CustomerSeviceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    private CustomerSevice customerSevice = new CustomerSeviceImp();

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("customers",customerSevice.FindAll());
        return "index";
    }
}
