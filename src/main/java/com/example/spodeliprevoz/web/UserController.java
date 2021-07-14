package com.example.spodeliprevoz.web;

import com.example.spodeliprevoz.model.enumerations.VehicleType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/profile")
    public String getProfilePage(Model model)
    {
        model.addAttribute("bodyContent","profile");
        return "master-template";
    }

    @GetMapping("/personalInfo")
    public String getPersonalInfoPage(Model model)
    {
        model.addAttribute("bodyContent","personalInfo");
        return "master-template";
    }

    @GetMapping("/editPersonalInfo")
    public String editPersonalInfoPage(Model model)
    {
        model.addAttribute("bodyContent","editPersonalInfo");
        return "master-template";
    }

    @GetMapping("/vehicleData")
    public String getVehicleDataPage(Model model)
    {
        model.addAttribute("bodyContent","vehicleData");
        return "master-template";
    }

    @GetMapping("/registerDriver")
    public String getRegisterDriverPage(Model model)
    {
        model.addAttribute("types", VehicleType.values());
        model.addAttribute("bodyContent","registerDriver");
        return "master-template";
    }


}
