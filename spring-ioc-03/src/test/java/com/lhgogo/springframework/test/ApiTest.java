package com.lhgogo.springframework.test;

import com.lhgogo.springframework.beans.PropertyValue;
import com.lhgogo.springframework.beans.factory.PropertyValues;
import com.lhgogo.springframework.beans.factory.config.BeanDefinition;
import com.lhgogo.springframework.beans.factory.config.BeanReference;
import com.lhgogo.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.lhgogo.springframework.test.bean.UserDao;
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
    public void test_BeanFactory() {
        // 1 初始化bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2 注册bean
        beanFactory.registryBeanDefinition("userDao",new BeanDefinition(UserDao.class));
        // 3 userService设置属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));
        // 4 userService注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registryBeanDefinition("userService", beanDefinition);
        // 5 userService获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }


}
