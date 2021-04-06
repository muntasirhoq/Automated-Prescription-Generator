package com.sd.Models;

import javax.persistence.*;

/**
 * Created by Muntasir on 4/30/2017.
 */
@Entity
public class Advice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String adviceName;
    @Column
    private String symptom;

    public Advice(String advice, String symptom) {
        this.adviceName = advice;
        this.symptom = symptom;
    }

    public Advice(){}

    public String getAdviceName() {
        return adviceName;
    }

    public void setAdviceName(String advice) {
        this.adviceName = advice;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
