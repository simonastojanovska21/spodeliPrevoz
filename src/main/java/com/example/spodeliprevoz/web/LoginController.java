package com.example.spodeliprevoz.web;

import com.example.spodeliprevoz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/login")
    public String getLogin(Model model)
    {
        model.addAttribute("bodyContent","login");
        return "master-template";
    }
    @GetMapping("/register")
    public String getRegister(Model model)
    {
        model.addAttribute("bodyContent","register");
        return "master-template";
    }
    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String fullName,
                               @RequestParam String telephoneNumber)
    {
        this.userService.register(username,password,password,fullName,telephoneNumber,"img/profile.com");
        return "redirect:/login";
    }
}
