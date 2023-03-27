package com.lhgogo.springframework.test;

import com.lhgogo.springframework.beans.factory.config.BeanDefinition;
import com.lhgogo.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.lhgogo.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-26 14:28
 * @version:
 */

public class ApiTest {

    @Test
    public void test_beanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.注册Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registryBeanDefinition("userService",beanDefinition);
        // 3.第一次获取Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
        // 4.第二次获取bean
        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService1.queryUserInfo();
    }
}
