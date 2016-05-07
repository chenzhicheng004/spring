package com.chenzhicheng.springlearn.web.dynamicproxy;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by Administrator on 2016/5/7.
 */
public class SpringDanymicProxyTest {

    public void test(){
        Waiter waiter = new Waiter();
        MyBeforeAdvice advice = new MyBeforeAdvice();
        ProxyFactory fac = new ProxyFactory();
        fac.setTarget(waiter);
        fac.addAdvice(advice);

        Waiter proxy = (Waiter)fac.getProxy();
        proxy.greetTo("tom");
        proxy.serveTo("tom");
    }

    public static void main(String[] args){
        new SpringDanymicProxyTest().test();
    }
}
