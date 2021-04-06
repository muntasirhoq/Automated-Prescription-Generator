package com.sd.Controllers;

import com.sd.Models.Medicine;
import com.sd.Models.MedicineCompany;
import com.sd.Models.Patient;
import com.sd.Models.UserDoc;
import com.sd.Repositories.MedicineCompanyRepository;
import com.sd.Repositories.MedicineRepository;
import com.sd.Repositories.PatientRepository;
import com.sd.Repositories.UserDocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

/**
 * Created by Muntasir on 4/30/2017.
 */
@Controller
public class PatientController {
    public static long patientId = -1;
    public static String height1,weight1,bloodPressure1;

    @Autowired
    private MedicineRepository medicineRepository;
    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping ("/patient")
    public String showEditMedicine(HttpSession session) {
        String username = "";
        if (session.getAttribute("username") != null) {
            username = session.getAttribute("username").toString();
        }
        if (username.equals("")) {
            return "redirect:/login";
        }
        return "patient";
    }
    @PostMapping("/patient")
    public String loginCheck(HttpSession session,@RequestParam(name = "serialNo",defaultValue = "-1") String serialNo, @RequestParam("patientName") String patientName, @RequestParam("age") String age,
                             @RequestParam(name="gender", defaultValue="Male") String gender, @RequestParam("phoneNumber") String phoneNumber,
                             @RequestParam("height") String height, @RequestParam("weight") String weight, @RequestParam("bloodPressure") String bloodPressure,Model model) {

        //System.out.println(patientName+"\t"+gender);


        if(!serialNo.equals("-1")){
            System.out.println(serialNo);
            List<Patient> p = patientRepository.findById(Long.parseLong(serialNo));
            if(p.isEmpty()){
                model.addAttribute("error","Invalid serial number.");
                return "patient";
            }
            else
            {
                height1 = height;
                weight1 = weight;
                bloodPressure1 = bloodPressure;
                patientId= Long.parseLong(serialNo);
            }
        }

        else{
            Patient patient = new Patient(patientName, phoneNumber, age, gender);
            patientRepository.save(patient);

            height1 = height;
            weight1 = weight;
            bloodPressure1 = bloodPressure;

            patientId = patient.getId();
        }

        List<String> symptomList = medicineRepository.allSymptoms();
        Collections.sort(symptomList);
        model.addAttribute("symptomList", symptomList);

        return "symptom";
    }

}
