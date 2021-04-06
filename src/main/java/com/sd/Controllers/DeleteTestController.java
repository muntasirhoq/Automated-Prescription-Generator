package com.sd.Controllers;

import com.sd.Models.Test;
import com.sd.Repositories.MedicineCompanyRepository;
import com.sd.Repositories.MedicineRepository;
import com.sd.Repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Sifat on 01-May-17.
 */

@Controller
public class DeleteTestController {

    @Autowired
    private TestRepository testRepository;

    @RequestMapping("/deleteTest")
    public String showEditTest(HttpSession session) {
        String username = "";
        if (session.getAttribute("username") != null) {
            username = session.getAttribute("username").toString();
        }
        if (username.equals("")) {
            return "redirect:/login";
        }
        return "deleteTest";
    }
    @PostMapping("/deleteTest")
    public String deleteTestCheck(HttpSession session, @RequestParam("testName") String testName) {

        testRepository.deleteByTestName(testName.toLowerCase());

        return "success";
    }
}
