package com.example.spodeliprevoz.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getHomePage(Model model)
    {
        model.addAttribute("bodyContent","home");
        return "master-template";
    }

    @GetMapping("/help")
    public String getHelpPage(Model model)
    {
        model.addAttribute("bodyContent","help");
        return "master-template";
    }
    @GetMapping("/accessDenied")
    public String getAccessDeniedPage(Model model)
    {
        model.addAttribute("bodyContent","accessDenied");
        return "master-template";
    }
}
