package com.lhgogo.springframework.test;

import com.lhgogo.springframework.beans.factory.config.BeanDefinition;
import com.lhgogo.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.lhgogo.springframework.test.bean.UserService;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

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
        UserService userService = (UserService) beanFactory.getBean("userService","林俊杰");
        userService.queryUserInfo();
        // 4.第二次获取bean
//        UserService userService1 = (UserService) beanFactory.getBean("userService","林俊杰");
//        userService1.queryUserInfo();
    }

    @Test
    public void test_newInstance() throws IllegalAccessException, InstantiationException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }

    @Test
    public void test_constructor() throws Exception {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService userService = declaredConstructor.newInstance("林俊杰");
        System.out.println(userService);
    }

    /**
     * @param :
     * @return void
     * @author 林辉
     * @description 获取构造函数信息
     * @date 2023/3/31 9:13
     */
    @Test
    public void test_parameterTypes() throws Exception {
        Class<UserService> aClass = UserService.class;
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        Constructor<?> constructor = null;
        for (Constructor<?> ctor : declaredConstructors) {
            if (ctor.getParameterTypes().length == 1) {
                constructor = ctor;
                break;
            }
        }
        Constructor<UserService> declaredConstructor1 = aClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService userService = declaredConstructor1.newInstance( "林俊杰");
        System.out.println(userService);
    }

    @Test
    public void test_cglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object ojb = enhancer.create(new Class[]{String.class},new Object[]{"林俊杰"});
        System.out.println(ojb);
    }
}
