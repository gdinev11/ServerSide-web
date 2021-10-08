package edu.neiu.finalprojsswd.controllers;

import edu.neiu.finalprojsswd.models.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/car")
public class CarController {

    @GetMapping
    public String addCar(Model model){
        model.addAttribute("car", new Car());
        return "add-car";
    }
}
