package com.chenzhicheng.springlearn.web.test;

import com.chenzhicheng.springlearn.common.domain.LoginLog;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2016/5/5.
 */
public class ApplicationContestTest {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        Object obj = context.getBean("loginLog");
        if(obj instanceof LoginLog) {
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(((LoginLog) obj).getLoginDateTime()));
        }
    }
}
