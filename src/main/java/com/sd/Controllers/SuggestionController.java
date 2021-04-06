package com.sd.Controllers;

import com.sd.Models.*;
import com.sd.Repositories.MedicineCompanyRepository;
import com.sd.Repositories.MedicineRepository;
import com.sd.Repositories.PrescriptionMedicineRepository;
import com.sd.Repositories.UserDocRepository;
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
public class SuggestionController {

    @Autowired
    private PrescriptionMedicineRepository prescriptionMedicineRepository;

    public static List<String> medicinesStatic = new ArrayList<>();
    public static List<String> testsStatic = new ArrayList<>();
    public static List<String> advicesStatic = new ArrayList<>();

    @Autowired
    private MedicineCompanyRepository medicineCompanyRepository;
    @Autowired
    private MedicineRepository medicineRepository;

    @RequestMapping ("/suggestion")
    public String showEditMedicine(HttpSession session) {
        String username = "";
        if (session.getAttribute("username") != null) {
            username = session.getAttribute("username").toString();
        }
        if (username.equals("")) {
            return "redirect:/login";
        }
        return "suggestion";
    }
    @PostMapping("/suggestion")
    public String loginCheck(HttpSession session, @RequestParam(name = "medicines", defaultValue = "") List<String> medicines,
                             @RequestParam(name = "tests", defaultValue = "") List<String> tests,
                             @RequestParam(name = "advices", defaultValue = "") List<String> advices, Model model) {

//        if(medicines.isEmpty()){
//            List<String> symptomList = medicineRepository.allSymptoms();
//            Collections.sort(symptomList);
//            model.addAttribute("symptomList",symptomList);
//            return "symptom";
//        }
        medicinesStatic.clear();
        testsStatic.clear();
        advicesStatic.clear();
        medicinesStatic.addAll(medicines);
        testsStatic.addAll(tests);
        advicesStatic.addAll(advices);

        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DATE);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        String date =String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);

        String preMed="";
        for(String i : medicines){
            if(preMed==""){
                preMed=i;
                continue;
            }
            preMed=preMed+","+i;
        }

        PrescriptionMedicine prescriptionMedicine = new PrescriptionMedicine(PatientController.patientId,preMed,date);

        prescriptionMedicineRepository.save(prescriptionMedicine);

        model.addAttribute("medicines", medicines);
//        model.addAttribute("tests",tests);
//        model.addAttribute("advices",advices);


        return "dosage";
    }

}
