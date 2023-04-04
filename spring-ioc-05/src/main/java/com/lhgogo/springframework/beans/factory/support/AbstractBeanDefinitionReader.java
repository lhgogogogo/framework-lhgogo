package com.lhgogo.springframework.beans.factory.support;

import com.lhgogo.springframework.core.io.DefaultResourceLoader;
import com.lhgogo.springframework.core.io.ResourceLoader;

/**
 * @author ：linhui
 * @description ：Bean读取的抽象类实现
 * @date ：2023-04-03 14:43
 * @version:
 */

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry){
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }
    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
