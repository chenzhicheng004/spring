package com.chenzhicheng.springlearn.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/2.
 */
public class LoginLog implements Serializable {

    private static final long serialVersionUID = -3082438729442840244L;

    private long id;

    private String ip;

    private Date loginDateTime;

    private long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(Date loginDateTime) {
        this.loginDateTime = loginDateTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
