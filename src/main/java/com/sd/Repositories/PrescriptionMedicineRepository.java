package com.sd.Repositories;

import com.sd.Models.Medicine;
import com.sd.Models.Patient;
import com.sd.Models.PrescriptionMedicine;
import com.sd.Models.UserDoc;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PrescriptionMedicineRepository extends CrudRepository<PrescriptionMedicine, Long> {

    List<PrescriptionMedicine> findById(long id);
//
//    @Modifying
//    @Transactional
//    @Query("select distinct medicineName from Medicine medicine where medicine.symptom=?1")
//    List<String> findMedicineBySymptom(String sym);
}