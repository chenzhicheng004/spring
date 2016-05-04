package com.chenzhicheng.springlearn.service;

import com.chenzhicheng.springlearn.common.domain.LoginLog;
import com.chenzhicheng.springlearn.common.domain.User;
import com.chenzhicheng.springlearn.dao.LoginLogDao;
import com.chenzhicheng.springlearn.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/5/2.
 */
@Service("userService")
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String username,String password){
        int count = userDao.getMatchCount(username,password);
        return count > 0;
    }

    public User getUserByName(String username){
        return userDao.getUserByName(username);
    }

    public void loginSuccess(User user){
        user.setCredits(5 + user.getCredits());
        LoginLog log = new LoginLog();
        log.setUserId(user.getId());
        log.setIp(user.getLastIp());
        log.setLoginDateTime(user.getLastVisit());

        userDao.updateUser(user);
        loginLogDao.insertLoginLog(log);
    }
}
