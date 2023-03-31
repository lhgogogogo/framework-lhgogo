package com.lhgogo.springframework.beans.factory.support;

import com.lhgogo.springframework.beans.BeansException;
import com.lhgogo.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ：linhui
 * @description ：jdk 实例化具体策略类
 * @date ：2023-03-30 15:11
 * @version:
 */

public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) {
        Class clazz = beanDefinition.getBeanClass();
        try {
            // 如果构造参数不为空时
            if (ctor != null) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}

