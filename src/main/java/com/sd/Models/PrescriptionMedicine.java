package com.sd.Models;

import javax.persistence.*;

/**
 * Created by Muntasir on 4/30/2017.
 */
@Entity
public class PrescriptionMedicine {
    @Id
    private long id;
    @Column
    private String medicineName;
    @Column
    private String time;

    public PrescriptionMedicine() {}

    public PrescriptionMedicine(long id, String medicineName, String time) {
        this.id = id;
        this.medicineName = medicineName;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
