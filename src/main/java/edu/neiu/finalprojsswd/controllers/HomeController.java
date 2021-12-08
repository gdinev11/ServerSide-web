package edu.neiu.finalprojsswd.controllers;

import edu.neiu.finalprojsswd.data.UserRepository;
import edu.neiu.finalprojsswd.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("/")
public class HomeController {

    private UserRepository userRepo;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public HomeController(UserRepository userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
    }

    @GetMapping
    public String getHomePage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user",user);
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegistrationPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String handleRegisterForm(@Valid @ModelAttribute("user") User user, Errors errors) {
        if (errors.hasErrors())
            return "register";

        try{
            String password = user.getPassword();
            user.setEnabled(true);
            user.setPassword(passwordEncoder.encode(password));
            user.setRoles((Set.of(User.Role.ROLE_USER)));
            this.userRepo.save(user);
        } catch (DataIntegrityViolationException e) {
            errors.rejectValue("email", "invalidEmail", "Email not available. Please enter another email address");
            return "register";
        }

        return "redirect:/";
    }
}
