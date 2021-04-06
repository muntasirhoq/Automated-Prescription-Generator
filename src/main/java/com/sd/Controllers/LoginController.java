package com.sd.Controllers;

import com.sd.Models.UserDoc;
import com.sd.Repositories.UserDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserDocRepository userDocRepository;

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginCheck(HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password) {
        List<UserDoc> users =  userDocRepository.findByUsernameAndPassword(username,password);

       // System.out.println(username+" "+password);

//        if(users.isEmpty()) {
//            return "login";
//        }

        session.setAttribute("username", username);
        return "home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "/login";
    }

}
