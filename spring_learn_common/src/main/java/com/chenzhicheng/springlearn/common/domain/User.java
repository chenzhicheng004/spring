package com.chenzhicheng.springlearn.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/2.
 */
public class User implements Serializable {

    private static final long serialVersionUID = -889793627127736759L;

    private long id;

    private String username;

    private String password;

    private int credits;

    private Date lastVisit;

    private String lastIp;

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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }
}
