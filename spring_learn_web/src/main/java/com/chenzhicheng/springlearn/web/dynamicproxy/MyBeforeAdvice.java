package com.chenzhicheng.springlearn.web.dynamicproxy;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/5/7.
 */
public class MyBeforeAdvice implements MethodBeforeAdvice{

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("welcome " + objects[0] + " ...");
    }
}
