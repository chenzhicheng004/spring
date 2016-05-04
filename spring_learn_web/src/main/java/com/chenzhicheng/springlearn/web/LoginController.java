package com.chenzhicheng.springlearn.web;

import com.chenzhicheng.springlearn.common.domain.LoginLog;
import com.chenzhicheng.springlearn.common.domain.User;
import com.chenzhicheng.springlearn.common.vo.LoginCommand;
import com.chenzhicheng.springlearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Administrator on 2016/5/3.
 */
@Controller("loginController")
public class LoginController {

    public LoginController(){
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUsername(),loginCommand.getPassword());
        if(!isValidUser){
            return new ModelAndView("login","error","invalid");
        }else{
            User user = userService.getUserByName(loginCommand.getUsername());
            user.setLastIp(request.getRemoteAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }
    }

}
