package com.sd.Controllers;

import com.sd.Models.Medicine;
import com.sd.Models.MedicineCompany;
import com.sd.Models.UserDoc;
import com.sd.Repositories.MedicineCompanyRepository;
import com.sd.Repositories.MedicineRepository;
import com.sd.Repositories.UserDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Muntasir on 4/30/2017.
 */
@Controller
public class PrescriptionController {

    @Autowired
    private MedicineCompanyRepository medicineCompanyRepository;
    @Autowired
    private MedicineRepository medicineRepository;

    @RequestMapping ("/prescription")
    public String showEditMedicine(HttpSession session) {
        String username = "";
        if (session.getAttribute("username") != null) {
            username = session.getAttribute("username").toString();
        }
        if (username.equals("")) {
            return "redirect:/login";
        }
        return "prescription";
    }
    @PostMapping("/prescription")
    public String loginCheck(HttpSession session) { //, @RequestParam("symptoms") List<String> symptoms, Model model) {


        return "success";
    }

}
