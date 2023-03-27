package com.lhgogo.springframework.beans.factory.config;

/**
 * @author ：linhui
 * @description ：bean定义类
 * @date ：2023-03-26 13:29
 * @version:
 */

public class BeanDefinition {

    public Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
