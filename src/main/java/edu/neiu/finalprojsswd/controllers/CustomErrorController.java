package edu.neiu.finalprojsswd.controllers;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/error")
public class CustomErrorController implements ErrorController {
    @GetMapping
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String message = "Something went wrong! We're working on it...";
        if(status != null){
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value()){
                message = "Sorry! We could not find that page!";
            }
            else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                message = "Sorry! you are not allowed to access that page!";
            }
        }
        model.addAttribute("message", message);
        return "error";
    }


    public String getErrorPath() {
        return null;
    }
}
