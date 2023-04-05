package com.lhgogo.springframework.beans.factory.config;

import com.lhgogo.springframework.beans.BeansException;
import com.lhgogo.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-04-04 15:26
 * @version:
 */

public interface BeanFactoryPostProcessor {

    /**
     * @param beanFactory:
     * @return void
     * @author 林辉
     * @description 在所有的BeanDefinition加载完成后，实例化Bean对象之前，提供修改BeanDefinition属性的机制
     * @date 2023/4/4 15:29
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
