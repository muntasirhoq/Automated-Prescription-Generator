package com.sd.Models;

import javax.persistence.*;

/**
 * Created by Muntasir on 4/30/2017.
 */
@Entity
public class UserDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column (unique=true)
    private String username;
    @Column
    private String password;

    public UserDoc(long id, String username, String password) {
        this.id=id;
        this.username=username;
        this.password = password;
    }

    public UserDoc(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
