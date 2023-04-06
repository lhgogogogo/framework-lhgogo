package com.lhgogo.springframework.beans.factory.support;

import com.lhgogo.springframework.beans.factory.config.BeanDefinition;

/**
 * @author ：linhui
 * @description ：bean定义注册接口
 * @date ：2023-03-26 14:12
 * @version:
 */

public interface BeanDefinitionRegistry {

    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);


}
