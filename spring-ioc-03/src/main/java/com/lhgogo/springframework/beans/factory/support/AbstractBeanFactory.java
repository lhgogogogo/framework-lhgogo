package com.lhgogo.springframework.beans.factory.support;

import com.lhgogo.springframework.beans.factory.BeanFactory;
import com.lhgogo.springframework.beans.factory.config.BeanDefinition;

/**
 * @author ：linhui
 * @description ：抽象类定义模板方法
 * @date ：2023-03-26 13:36
 * @version:
 */

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName,null);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return doGetBean(beanName,args);
    }

    protected <T> T doGetBean(final String name, final Object[] objects){
        Object bean = getSingleton(name);
        if(bean != null){
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name,beanDefinition,objects);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object[] objects);
}
