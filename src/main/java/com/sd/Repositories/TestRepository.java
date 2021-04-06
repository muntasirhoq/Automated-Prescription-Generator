package com.sd.Repositories;

import com.sd.Models.Advice;
import com.sd.Models.Medicine;
import com.sd.Models.Test;
import com.sd.Models.UserDoc;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*@EnableJpaRepositories
class Config {}*/


public interface TestRepository extends CrudRepository<Test, Long> {

    List<Test> findBySymptom(String symptom);

    List<Test> findByTestName(String testName);

    @Modifying
    @Transactional
    @Query("delete from Test test where test.testName = ?1")
    void deleteByTestName(String testName);

    @Modifying
    @Transactional
    @Query("select distinct testName from Test test where test.symptom=?1")
    List<String> findTestBySymptom(String symptom);
}