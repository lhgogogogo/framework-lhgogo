package com.lhgogo.springframework.beans.factory.support;

import com.lhgogo.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-30 15:08
 * @version: Bean实例化策略接口
 */

public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,Object[] objects);
}
