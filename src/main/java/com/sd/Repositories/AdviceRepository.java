package com.sd.Repositories;

import com.sd.Models.Advice;
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


public interface AdviceRepository extends CrudRepository<Advice, Long> {
    List<Advice> findBySymptom(String symptom);

    List<Advice> findByAdviceName(String adviceName);

    @Modifying
    @Transactional
    @Query("delete from Advice advice where advice.adviceName = ?1")
    void deleteByAdviceName(String adviceName);

    @Modifying
    @Transactional
    @Query("select distinct adviceName from Advice advice where advice.symptom=?1")
    List<String> findAdviceBySymptom(String sym);
}