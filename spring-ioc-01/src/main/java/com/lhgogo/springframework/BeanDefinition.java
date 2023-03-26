package com.lhgogo.springframework;

/**
 * @author ：linhui
 * @description ：定义bean实例化信息
 * @date ：2023-03-26 11:31
 * @version:
 */

public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
