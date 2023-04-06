package com.lhgogo.springframework.test.common;

import com.lhgogo.springframework.beans.BeansException;
import com.lhgogo.springframework.beans.factory.config.BeanPostProcessor;
import com.lhgogo.springframework.test.bean.UserService;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-04-04 17:14
 * @version:
 */

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
