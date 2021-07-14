package com.example.spodeliprevoz.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TripsController {


    @GetMapping("/createTrip")
    public String getCreateTripPage(Model model)
    {
        model.addAttribute("bodyContent","createTrip");
        return "master-template";
    }

    @GetMapping("/successfullyCreatedTrip")
    public String getSuccessfullyCreatedTrip(Model model)
    {
        model.addAttribute("bodyContent","successfullyCreatedTrip");
        return "master-template";
    }

    @GetMapping("/searchTrip")
    public String getSearchTripPage(Model model)
    {
        model.addAttribute("bodyContent", "searchTrip");
        return "master-template";
    }

    @GetMapping("/requestForTrip")
    public String getRequestForTripPage(Model model)
    {
        model.addAttribute("bodyContent","requestForTrip");
        return "master-template";
    }

    @GetMapping("/searchResults")
    public String getSearchResultsPage(Model model)
    {
        model.addAttribute("bodyContent","searchResults");
        return "master-template";
    }

    @GetMapping("/myTrips")
    public String getMyTripsPage(Model model)
    {
        model.addAttribute("bodyContent","myTrips");
        return "master-template";
    }

    @GetMapping("/duringTrip")
    public String getDuringTripPage(Model model)
    {
        model.addAttribute("bodyContent","duringTrip");
        return "master-template";
    }

    @GetMapping("/tripSummary")
    public String getTripSummaryPage(Model model)
    {
        model.addAttribute("bodyContent","tripSummary");
        return "master-template";
    }
}
