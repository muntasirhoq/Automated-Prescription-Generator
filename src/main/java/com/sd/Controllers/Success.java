package com.sd.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class Success {

    @PostMapping("/success")
    public String successful(HttpSession session) {
        //     model.addAttribute("name", name);
        String email="";
        if(session.getAttribute("username")!=null) {
            email = session.getAttribute("username").toString();
        }
        if(email.equals("")){ return "redirect:/login"; }

        return "home";
    }

}