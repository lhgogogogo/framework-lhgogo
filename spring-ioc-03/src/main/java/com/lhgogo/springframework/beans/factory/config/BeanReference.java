package com.lhgogo.springframework.beans.factory.config;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-31 10:51
 * @version:
 */

public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
