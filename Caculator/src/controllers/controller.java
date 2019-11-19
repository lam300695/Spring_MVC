package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controller {

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam("num1") String num1,@RequestParam("num2") String num2,@RequestParam("operater") String operater, Model model){
        float firstNumber = Float.parseFloat(num1);
        float secondNumber = Float.parseFloat(num2);
        float resual;

        switch (operater){
            case "+":
                resual = firstNumber + secondNumber;
                model.addAttribute("resual",resual);
                break;
            case "-":
                resual = firstNumber - secondNumber;
                model.addAttribute("resual",resual);
                break;
            case "*":
                resual = firstNumber * secondNumber;
                model.addAttribute("resual",resual);
                break;
            case "/":
                resual = firstNumber / secondNumber;
                model.addAttribute("resual",resual);
                break;
            default:
                model.addAttribute(operater + "sai");
        }
        return "submit";
    }
}
