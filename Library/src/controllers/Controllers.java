package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controllers {
    @GetMapping("/library")
    public String home() {
        return "home";
    }

    @PostMapping("/find")
    public String submit(@RequestParam String word, Model model) {
        String arr[] = {"dog","cat","baby","book"};
        String arr2[] = {"con cho", "con meo","em be","sach"};
        for (int i = 0; i <arr.length;i++){
            if (arr[i].equals(word)){
                 String resual =(arr2[i]);
                 model.addAttribute("resual1",resual);
            }
        }
        return "submit";
    }
}
