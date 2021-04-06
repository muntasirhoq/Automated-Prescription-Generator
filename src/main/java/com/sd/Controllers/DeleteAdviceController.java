package com.sd.Controllers;

import com.sd.Repositories.AdviceRepository;
import com.sd.Repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Sifat on 02-May-17.
 */
@Controller
public class DeleteAdviceController {
    @Autowired
    private AdviceRepository adviceRepository;

    @RequestMapping("/deleteAdvice")
    public String showEditAdvice(HttpSession session) {
        String username = "";
        if (session.getAttribute("username") != null) {
            username = session.getAttribute("username").toString();
        }
        if (username.equals("")) {
            return "redirect:/login";
        }
        return "deleteAdvice";
    }
    @PostMapping("/deleteAdvice")
    public String deleteAdviceCheck(HttpSession session, @RequestParam("adviceName") String adviceName) {

        adviceRepository.deleteByAdviceName(adviceName.toLowerCase());

        return "success";
    }
}
