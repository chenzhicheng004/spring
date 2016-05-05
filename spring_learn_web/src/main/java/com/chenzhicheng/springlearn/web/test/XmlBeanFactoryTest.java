package com.chenzhicheng.springlearn.web.test;

import com.chenzhicheng.springlearn.common.domain.LoginLog;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * Created by Administrator on 2016/5/5.
 */
public class XmlBeanFactoryTest {

    public static void main(String[] args) throws Exception{
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:beans.xml");

        XmlBeanFactory fac = new XmlBeanFactory(resource);
        LoginLog log = fac.getBean("loginLog", LoginLog.class);
        System.out.println(log.getId());
    }
}
