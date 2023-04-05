package com.lhgogo.springframework.test.common;

import com.lhgogo.springframework.beans.BeansException;
import com.lhgogo.springframework.beans.PropertyValue;
import com.lhgogo.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.lhgogo.springframework.beans.factory.PropertyValues;
import com.lhgogo.springframework.beans.factory.config.BeanDefinition;
import com.lhgogo.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-04-04 17:12
 * @version:
 */

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company","改为:林氏集团"));
    }
}
