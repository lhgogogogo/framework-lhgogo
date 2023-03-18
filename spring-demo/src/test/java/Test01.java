import com.lhgogo.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-14 17:52
 * @version:
 */

public class Test01 {
    private final static Logger logger = LoggerFactory.getLogger(Test01.class);

    @Test
    public void test01() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        Class<?>[] classes = {IUserDao.class};
        InvocationHandler handler = (proxy,method,args)->"你被代理了"+method.getName();
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(contextClassLoader, classes, handler);
        String userInfo = userDao.queryUserInfo();
        System.out.println("测试结果:"+userInfo);
    }

    @Test
    public void test_IUserDao() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        String userInfo = userDao.queryUserInfo();
        System.out.println("测试结果：{}"+userInfo);
    }

    @Test
    public void test_alias() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config-alias.xml");
        logger.info("获取 Bean：{}", beanFactory.getBean("userService"));
        logger.info("获取 Bean 通过别名：{}", beanFactory.getBean("userService-alias01"));
        logger.info("获取 Bean 通过别名的别名：{}", beanFactory.getBean("userService-alias02"));
    }
}
