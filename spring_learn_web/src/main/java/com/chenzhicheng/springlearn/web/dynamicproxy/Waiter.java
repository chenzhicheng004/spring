package com.chenzhicheng.springlearn.web.dynamicproxy;

/**
 * Created by Administrator on 2016/5/7.
 */
public class Waiter {

    public void greetTo(String name){
        System.out.println("greet to " + name + " ...");
    }

    public void serveTo(String name){
        System.out.println("serve to " + name + " ...");
    }
}
