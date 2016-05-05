package com.chenzhicheng.springlearn.web.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/5/5.
 */
public class ApplicationContestTest {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        Object obj = context.getBean("loginLog");
        System.out.println(obj);
    }
}
