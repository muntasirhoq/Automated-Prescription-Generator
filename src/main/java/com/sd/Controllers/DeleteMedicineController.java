package com.sd.Controllers;

import com.sd.Models.Medicine;
import com.sd.Models.MedicineCompany;
import com.sd.Models.UserDoc;
import com.sd.Repositories.MedicineCompanyRepository;
import com.sd.Repositories.MedicineRepository;
import com.sd.Repositories.UserDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Muntasir on 4/30/2017.
 */
@Controller
public class DeleteMedicineController {

    @Autowired
    private MedicineCompanyRepository medicineCompanyRepository;
    @Autowired
    private MedicineRepository medicineRepository;

    @RequestMapping ("/deleteMedicine")
    public String showEditMedicine(HttpSession session) {
        String username = "";
        if (session.getAttribute("username") != null) {
            username = session.getAttribute("username").toString();
        }
        if (username.equals("")) {
            return "redirect:/login";
        }
        return "deleteMedicine";
    }
    @PostMapping("/deleteMedicine")
    public String deleteMedicineCheck(HttpSession session, @RequestParam("medicineName") String medicineName) {

        medicineRepository.deleteByMedicineName(medicineName.toLowerCase());
        medicineCompanyRepository.deleteByMedicineName(medicineName.toLowerCase());

        return "success";
    }

}
