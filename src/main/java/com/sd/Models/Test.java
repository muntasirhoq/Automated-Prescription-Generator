package com.sd.Models;

import javax.persistence.*;

/**
 * Created by Muntasir on 4/30/2017.
 */
@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = false)
    private String testName;
    @Column
    private String symptom;

    public Test(String test, String symptom) {
        this.testName = test;
        this.symptom = symptom;
    }

    public Test(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String test) {
        this.testName = test;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
}
