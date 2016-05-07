package com.chenzhicheng.springlearn.web.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/**
 * Created by Administrator on 2016/5/7.
 */
public class JDKDynamicProxyTest implements Eatable{

    public void test(){
        InvocationHandler handler = new MyHandler(this);
        Eatable test = (Eatable)Proxy.newProxyInstance(this.getClass().getClassLoader(), this.getClass().getInterfaces(), handler);
        test.eat();
    }

    public static void main(String[] args){
        new JDKDynamicProxyTest().test();
    }

    public void eat() {
        System.out.println("eat delicious");
    }


    private static class MyHandler implements InvocationHandler{

        private Object target;

        public MyHandler(){

        }

        public MyHandler(Object target){
            this.target = target;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            AOPClass.begin(method.getName());
            Object result = method.invoke(target,args);
            AOPClass.end(method.getName());
            return result;
        }
    }

    private static class AOPClass{

        public static void begin(String methodName){
            System.out.println("begin " + methodName + "...");
        }

        public static void end(String methodName){
            System.out.println("end " + methodName + "...");
        }

    }

}
