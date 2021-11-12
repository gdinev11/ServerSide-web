package edu.neiu.finalprojsswd.controllers;

import edu.neiu.finalprojsswd.data.CarRepository;
import edu.neiu.finalprojsswd.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewCarsController {

    private CarRepository carRepo;

    @Autowired
    public ViewCarsController(CarRepository carRepo){
        this.carRepo = carRepo;
    }

    @GetMapping
    public String showCarInfo(Model model) {
        List<Car> cars = (List<Car>) this.carRepo.findAll();

        model.addAttribute("cars", cars);
        return "display-cars";
    }
}
