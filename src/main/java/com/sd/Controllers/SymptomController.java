package com.sd.Controllers;

import com.sd.Models.Medicine;
import com.sd.Models.MedicineCompany;
import com.sd.Models.UserDoc;
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
public class SymptomController {

    @Autowired
    private MedicineCompanyRepository medicineCompanyRepository;
    @Autowired
    private AdviceRepository adviceRepository;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private MedicineRepository medicineRepository;

    @RequestMapping ("/symptom")
    public String showEditMedicine(HttpSession session) {
        String username = "";
        if (session.getAttribute("username") != null) {
            username = session.getAttribute("username").toString();
        }
        if (username.equals("")) {
            return "redirect:/login";
        }
        return "symptom";
    }
    @PostMapping("/symptom")
    public String loginCheck(HttpSession session, @RequestParam(name = "symptoms", defaultValue = "") List<String> symptoms, Model model) {

        if(symptoms.isEmpty()){
            List<String> symptomList = medicineRepository.allSymptoms();
            Collections.sort(symptomList);
            model.addAttribute("symptomList",symptomList);
            return "symptom";
        }

        List<String> medicineBySymptom = new ArrayList<>();
        List<String> testBySymptom = new ArrayList<>();
        List<String> adviceBySymptom = new ArrayList<>();
        for(String sym : symptoms){
            //System.out.println(sym);
            List<String> m = medicineRepository.findMedicineBySymptom(sym);
            List<String> t = testRepository.findTestBySymptom(sym);
            List<String> a = adviceRepository.findAdviceBySymptom(sym);
            medicineBySymptom.addAll(m);
            testBySymptom.addAll(t);
            adviceBySymptom.addAll(a);
        }

        Set<String> set = new HashSet<>();
        set.addAll(medicineBySymptom);
        medicineBySymptom.clear();
        medicineBySymptom.addAll(set);
        set.clear();
        set.addAll(testBySymptom);
        testBySymptom.clear();
        testBySymptom.addAll(set);
        set.clear();
        set.addAll(adviceBySymptom);
        adviceBySymptom.clear();
        adviceBySymptom.addAll(set);

        Collections.sort(medicineBySymptom);
        Collections.sort(testBySymptom);
        Collections.sort(adviceBySymptom);

        ListIterator<String> iterator = medicineBySymptom.listIterator();
        while (iterator.hasNext())
        {
            iterator.set( iterator.next().toUpperCase());
        }

        ListIterator<String> iterator1 = testBySymptom.listIterator();
        while (iterator1.hasNext())
        {
            iterator1.set( iterator1.next().toUpperCase());
        }

        ListIterator<String> iterator2 = adviceBySymptom.listIterator();
        while (iterator2.hasNext())
        {
            iterator2.set( iterator2.next().toUpperCase());
        }


        model.addAttribute("medicineList",medicineBySymptom);
        model.addAttribute("testList",testBySymptom);
        model.addAttribute("adviceList", adviceBySymptom);

        return "suggestion";
    }

}
