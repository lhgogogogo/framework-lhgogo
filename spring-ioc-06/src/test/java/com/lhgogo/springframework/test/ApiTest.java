package com.lhgogo.springframework.test;

import com.lhgogo.springframework.context.support.ClassPathXmlApplicationContext;
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
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        // 1.初始化BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String userInfo = userService.queryUserInfo();
        System.out.println("测试结果："+ userInfo);

    }


}
