package com.sd.Controllers;

import com.sd.Models.*;
import com.sd.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Muntasir on 4/30/2017.
 */
@Controller
public class DosageController {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ProfileRepository profileRepository;

    @RequestMapping ("/dosage")
    public String showEditMedicine(HttpSession session) {
        String username = "";
        if (session.getAttribute("username") != null) {
            username = session.getAttribute("username").toString();
        }
        if (username.equals("")) {
            return "redirect:/login";
        }
        return "dosage";
    }
    @PostMapping("/dosage")
    public String loginCheck(HttpSession session, @RequestParam(name = "dose", defaultValue = "") List<String> dose, Model model) {

        List<MedicineAndDose> medicineAndDose = new ArrayList<>();

        for(int i=0; i<dose.size(); i++){
            MedicineAndDose m = new MedicineAndDose(SuggestionController.medicinesStatic.get(i), dose.get(i));
            medicineAndDose.add(m);
        }


        SuggestionController.medicinesStatic.clear();
        model.addAttribute("medicineAndDose", medicineAndDose);

        model.addAttribute("tests", SuggestionController.testsStatic);
        model.addAttribute("advices", SuggestionController.advicesStatic);
        model.addAttribute("height",PatientController.height1);
        model.addAttribute("weight",PatientController.weight1);
        model.addAttribute("bloodPressure",PatientController.bloodPressure1);

//        SuggestionController.testsStatic.clear();
//        SuggestionController.advicesStatic.clear();

        List<Profile> profiles = profileRepository.findById(1);

        model.addAttribute("doctorName",profiles.get(0).getName());
        model.addAttribute("designation", profiles.get(0).getDesignation());
        model.addAttribute("address",profiles.get(0).getAddress());
        model.addAttribute("phoneNumber",profiles.get(0).getPhoneNumber());

        List<Patient> p = patientRepository.findById(PatientController.patientId);
        model.addAttribute("patient",p.get(0));

        return "prescription";
    }

}
