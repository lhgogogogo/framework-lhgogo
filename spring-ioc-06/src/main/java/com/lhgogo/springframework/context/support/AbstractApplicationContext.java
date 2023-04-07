package com.lhgogo.springframework.context.support;

import com.lhgogo.springframework.beans.BeansException;
import com.lhgogo.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.lhgogo.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.lhgogo.springframework.beans.factory.config.BeanPostProcessor;
import com.lhgogo.springframework.context.ConfigurableApplicationContext;
import com.lhgogo.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-04-04 15:39
 * @version:
 */

/*
* AbstractApplicationContext 继承 DefaultResourceLoader 是为了处理 spring.xml 配置资源的加载。
* 之后是在 refresh() 定义实现过程，包括：
* 1 创建 BeanFactory，并加载 BeanDefinition
* 2 获取 BeanFactory
* 3 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
* 4 BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
* 5 提前实例化单例Bean对象
* 另外把定义出来的抽象方法，refreshBeanFactory()、getBeanFactory() 由后面的继承此抽象类的其他抽象类实现
* */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    @Override
    public void refresh() throws BeansException {
        //1 创建BeanFactory,并加载BeanDefinition
        refreshBeanFactory();
        //2 获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        //3 在bean实例化之前，执行BeanFactoryPostProcessor(Invoke factory processors registered as beans in the context.)
        invokeBeanFactoryPostProcessors(beanFactory);
        //4 BeanPostProcessor 需要提前于其他bean对象实例化之前执行注册操作
        registerBeanPostProcessors(beanFactory);
        //5  提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();

    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }

    protected abstract ConfigurableListableBeanFactory getBeanFactory();

    protected abstract void refreshBeanFactory() throws BeansException;

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public Object getBean(String beanName) {
        return getBeanFactory().getBean(beanName);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return getBeanFactory().getBean(beanName, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }
}
