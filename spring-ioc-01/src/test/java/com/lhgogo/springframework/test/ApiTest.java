package com.lhgogo.springframework.test;

import com.lhgogo.springframework.BeanDefinition;
import com.lhgogo.springframework.BeanFactory;
import com.lhgogo.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-26 11:39
 * @version:
 */

public class ApiTest {

    @Test
    public void testBeanFactory() {
        // 初始化Bean工厂
        BeanFactory beanFactory = new BeanFactory();
        // 注册Bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        // 获取Bean实例
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }
}
