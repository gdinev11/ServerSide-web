package edu.neiu.finalprojsswd.controllers;

import edu.neiu.finalprojsswd.models.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("car", new Car("Subaru", "Crosstrek", 2016));
        return "index-page";
    }
}
