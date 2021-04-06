package com.sd.Repositories;

import com.sd.Models.Medicine;
import com.sd.Models.MedicineCompany;
import com.sd.Models.UserDoc;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*@EnableJpaRepositories
class Config {}*/


public interface MedicineCompanyRepository extends CrudRepository<MedicineCompany, Long> {

    List<MedicineCompany> findByMedicineName(String medicineName);

    //List<UserDoc> findByUsernameAndPassword(String username, String password);

    @Modifying
    @Transactional
    @Query("delete from MedicineCompany medicine where medicine.medicineName = ?1")
    void deleteByMedicineName(String medicineName);
}