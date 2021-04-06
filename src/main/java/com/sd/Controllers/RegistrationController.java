package com.sd.Controllers;

import com.sd.Models.UserDoc;
import com.sd.Repositories.UserDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserDocRepository userDocRepository;

    @RequestMapping("/registration")
    public String studentRegistration() {
        return "registration";
    }

    @PostMapping("/register")
    public String greetingSubmit(@ModelAttribute UserDoc user) {
        userDocRepository.save(user);
        return "redirect:/home";
    }

}
