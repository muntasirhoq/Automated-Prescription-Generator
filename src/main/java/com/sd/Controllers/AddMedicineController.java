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
public class AddMedicineController {

    @Autowired
    private MedicineCompanyRepository medicineCompanyRepository;
    @Autowired
    private MedicineRepository medicineRepository;

    @RequestMapping ("/addMedicine")
    public String showEditMedicine(HttpSession session) {
        String username = "";
        if (session.getAttribute("username") != null) {
            username = session.getAttribute("username").toString();
        }
        if (username.equals("")) {
            return "redirect:/login";
        }
        return "addMedicine";
    }
    @PostMapping("/addMedicine")
    public String loginCheck(HttpSession session, @RequestParam("medicineName") String medicineName, @RequestParam("companyName") String companyName, @RequestParam("symptoms") String symptoms) {

        String[] s=symptoms.split(",");

        for(String str:s)
        {
            Medicine medi = new Medicine (medicineName.toLowerCase(), str.toLowerCase());
            medicineRepository.save(medi);
        }

//        Medicine medi=new Medicine(medicineName.toLowerCase(),symptoms.toLowerCase());
//        medicineRepository.save(medi);
        MedicineCompany medicineCompany=new MedicineCompany(medicineName.toLowerCase(),companyName.toLowerCase());
        medicineCompanyRepository.save(medicineCompany);

        return "success";
    }

}
