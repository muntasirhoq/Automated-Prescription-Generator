package com.sd.Repositories;

import com.sd.Models.Medicine;
import com.sd.Models.UserDoc;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*@EnableJpaRepositories
class Config {}*/


public interface MedicineRepository extends CrudRepository<Medicine, Long> {

    //List<UserDoc> findByUsernameAndPassword(String username, String password);
    List<Medicine> findBySymptom(String symptom);

    List<Medicine> findByMedicineName(String medicineName);

    @Modifying
    @Transactional
    @Query("delete from Medicine medicine where medicine.medicineName = ?1")
    void deleteByMedicineName(String medicineName);

    @Modifying
    @Transactional
    @Query("select distinct symptom from Medicine medicine")
    List<String> allSymptoms();

    @Modifying
    @Transactional
    @Query("select distinct medicineName from Medicine medicine where medicine.symptom=?1")
    List<String> findMedicineBySymptom(String sym);
}