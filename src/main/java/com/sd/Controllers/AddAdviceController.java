package com.sd.Controllers;

import com.sd.Models.Advice;
import com.sd.Models.Medicine;
import com.sd.Models.MedicineCompany;
import com.sd.Repositories.AdviceRepository;
import com.sd.Repositories.MedicineCompanyRepository;
import com.sd.Repositories.MedicineRepository;
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
public class AddAdviceController {
    @Autowired
    private AdviceRepository adviceRepository;

    @RequestMapping("/addAdvice")
    public String showEditAdvice(HttpSession session) {
        String username = "";
        if (session.getAttribute("username") != null) {
            username = session.getAttribute("username").toString();
        }
        if (username.equals("")) {
            return "redirect:/login";
        }
        return "addAdvice";
    }
    @PostMapping("/addAdvice")
    public String loginCheck(HttpSession session, @RequestParam("adviceName") String adviceName, @RequestParam("symptoms") String symptoms) {

        String[] s=symptoms.split(",");
        Advice advi=new Advice(adviceName,symptoms);
        adviceRepository.save(advi);

        return "success";
    }
}
