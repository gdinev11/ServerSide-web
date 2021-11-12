package edu.neiu.finalprojsswd.controllers;

import edu.neiu.finalprojsswd.data.CarRepository;
import edu.neiu.finalprojsswd.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;

@Controller
@RequestMapping("/car")
public class CarController {

    private CarRepository carRepo;

    @Autowired
    public CarController(CarRepository carRepo) {
        this.carRepo = carRepo;
    }

    @GetMapping
    public String addCar(Model model){
        model.addAttribute("car", new Car());
        return "add-car";
    }

    @PostMapping
    public String handleCarForm(@Valid @ModelAttribute("car") Car car, Errors errors) {
        if (errors.hasErrors())
            return "add-car";
        this.carRepo.save(car);
        return "redirect:/view";
    }
}
