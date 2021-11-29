package edu.neiu.finalprojsswd.controllers;

import edu.neiu.finalprojsswd.data.CarRepository;
import edu.neiu.finalprojsswd.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/view/{id}")
    public String ShowCar(@PathVariable Long id, Model model){
        Car car = this.carRepo.findById(id).get();
        model.addAttribute("car", car);
        return "view-car";
    }

    @PostMapping
    public String handleCarForm(@Valid @ModelAttribute("car") Car car, Errors errors) {
        if (errors.hasErrors())
            return "add-car";

        try{
            this.carRepo.save(car);
        } catch (DataIntegrityViolationException e) {
            errors.rejectValue("email", "invalidEmail", "Email not available. Please enter another email address");
            return "add-car";
        }

        return "redirect:/view";
    }

    @PostMapping("/edit/{id}")
    public String handleEditCarForm(@PathVariable Long id, @Valid @ModelAttribute("car") Car car, Errors errors) {
        if (errors.hasErrors())
            return "view-car";

        try{
            Car originalCar = this.carRepo.findById(id).get();
            updateOriginalCar(originalCar, car);
            this.carRepo.save(originalCar);
        } catch (DataIntegrityViolationException e) {
            errors.rejectValue("email", "invalidEmail", "Email not available. Please enter another email address");
            return "view-car";
        }

        return "redirect:/view";
    }

    private void updateOriginalCar(Car original, Car update) {
        original.setMake(update.getMake());
        original.setMode(update.getMode());
        original.setYear(update.getYear());
        original.setEmail(update.getEmail());
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        this.carRepo.deleteById(id);
        return "redirect:/view";
    }
}
