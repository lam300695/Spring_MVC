package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class contronller {

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam String tuongot, String tuongca, String tuongoi, String tuongcam, Model model){
        model.addAttribute("tungot",tuongot);
        model.addAttribute("tuongca",tuongca);
        model.addAttribute("tuongoi",tuongoi);
        model.addAttribute("tuongcam",tuongcam);
        return "submit";
    }
}
