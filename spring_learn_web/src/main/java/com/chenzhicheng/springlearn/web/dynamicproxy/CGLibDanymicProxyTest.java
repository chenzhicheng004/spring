package com.chenzhicheng.springlearn.web.dynamicproxy;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/5/7.
 */
public class CGLibDanymicProxyTest implements MethodInterceptor {

    public void eat(){
        System.out.println("eat bad");
    }

    public void test(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.getClass());
        enhancer.setCallback(this);
        CGLibDanymicProxyTest test = (CGLibDanymicProxyTest)enhancer.create();
        test.eat();
    }

    public static void main(String[] rags){
        new CGLibDanymicProxyTest().test();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("begin " + method.getName() + "...");
        Object result = methodProxy.invokeSuper(o,objects);
        return result;
    }
}
