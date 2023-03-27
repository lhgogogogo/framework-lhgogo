package com.lhgogo.springframework.beans.factory.support;

import com.lhgogo.springframework.beans.BeansException;
import com.lhgogo.springframework.beans.factory.config.BeanDefinition;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-26 13:49
 * @version:
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{



    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return null;
    }


}
