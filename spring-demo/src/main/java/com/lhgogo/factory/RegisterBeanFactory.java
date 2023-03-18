package com.lhgogo.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author ：linhui
 * @description ：Bean 注册
 * @date ：2023-03-15 11:12
 * @version:
 */

public class RegisterBeanFactory implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        //定义 Bean，GenericBeanDefinition，这里主要设置了我们的代理类工厂
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(ProxyBeanFactory.class);
        //创建 Bean 定义处理类，BeanDefinitionHolder，这里需要的主要参数；定义 Bean 和名称
        BeanDefinitionHolder definitionHolder = new BeanDefinitionHolder(beanDefinition, "userDao");
        //最后将我们自己的bean注册到spring容器中去，registry.registerBeanDefinition()
        BeanDefinitionReaderUtils.registerBeanDefinition(definitionHolder,beanDefinitionRegistry);

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
