package com.lhgogo.factory;

import com.lhgogo.dao.IUserDao;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author ：linhui
 * @description ：实现Bean工程
 * @date ：2023-03-15 11:05
 * @version:
 */

public class ProxyBeanFactory implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Class[] classes = {IUserDao.class};
        InvocationHandler handler = (proxy,method,args)-> "你被代理了:"+method.getName();
        return Proxy.newProxyInstance(contextClassLoader, classes, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }
}
