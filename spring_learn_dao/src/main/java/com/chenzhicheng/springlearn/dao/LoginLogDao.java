package com.chenzhicheng.springlearn.dao;

import com.chenzhicheng.springlearn.common.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/5/2.
 */
@Repository("loginLogDao")
public class LoginLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog loginLog){
        String sql = "insert into login_log(user_id,ip,login_datetime) values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDateTime()});
    }

}
