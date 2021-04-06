package com.sd.Models;

import javax.persistence.*;

/**
 * Created by Muntasir on 4/30/2017.
 */
@Entity
public class MedicineCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column (unique=true)
    private String medicineName;
    @Column
    private String comapnyName;

    public MedicineCompany(String medicineName, String comapnyName) {
        this.medicineName = medicineName;
        this.comapnyName = comapnyName;
    }

    public MedicineCompany(){}

    public String getComapnyName() {
        return comapnyName;
    }

    public void setComapnyName(String comapnyName) {
        this.comapnyName = comapnyName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }
}
