package com.lhgogo.springframework.context.support;

import com.lhgogo.springframework.beans.BeansException;
import com.lhgogo.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.lhgogo.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-04-04 16:12
 * @version:
 */

public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext{

    private DefaultListableBeanFactory beanFactory;
    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory(){
        return new DefaultListableBeanFactory();
    }


    //由其他抽象类继承实现
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    /*
    * 获取了 DefaultListableBeanFactory 的实例化以及对资源配置的加载操作 loadBeanDefinitions(beanFactory)，
    * 在加载完成后即可完成对 spring.xml 配置文件中 Bean 对象的定义和注册，
    * 同时也包括实现了接口 BeanFactoryPostProcessor、BeanPostProcessor 的配置 Bean 信息
    * */
    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }
}
