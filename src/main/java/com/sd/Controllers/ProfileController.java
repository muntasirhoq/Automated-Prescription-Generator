package com.sd.Controllers;


import com.sd.Models.Profile;
import com.sd.Repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @RequestMapping ("/profile")
    public String showEditMedicine(HttpSession session) {
        String username = "";
        if (session.getAttribute("username") != null) {
            username = session.getAttribute("username").toString();
        }
        if (username.equals("")) {
            return "redirect:/login";
        }
        return "profile";
    }

    @PostMapping("/profile")
    public String greeting(HttpSession session, @RequestParam("name") String name, @RequestParam("designation") String designation,
             @RequestParam("address") String address, @RequestParam("phoneNumber") String phoneNumber,@RequestParam("email") String email) {

        profileRepository.deleteOld(1);

        Profile profile = new Profile(1,name,phoneNumber,address,designation,email);
        profileRepository.save(profile);

        return "profile";
    }

}