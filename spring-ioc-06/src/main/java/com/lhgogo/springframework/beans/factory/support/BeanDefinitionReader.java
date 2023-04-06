package com.lhgogo.springframework.beans.factory.support;

import com.lhgogo.springframework.beans.BeansException;
import com.lhgogo.springframework.core.io.Resource;
import com.lhgogo.springframework.core.io.ResourceLoader;

/**
 * @author ：linhui
 * @description ：定义Bean的读取接口
 * @date ：2023-04-03 10:46
 * @version:
 */

public interface BeanDefinitionReader {

    /**
     * @return BeanDefinitionRegistry
     * @author 林辉
     * @description 获取Bean的定义注册
     * @date 2023/4/3 10:50
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * @return ResourceLoader
     * @author 林辉
     * @description 获取资源加载器
     * @date 2023/4/3 10:51
     */
    ResourceLoader getResourceLoader();

    /**
     * @param resource:
     * @author 林辉
     * @description 根据resource加载资源
     * @date 2023/4/3 14:28
     */
    void loadBeanDefinitions(Resource resource)throws BeansException;

    /**
     * @param resources:
     * @author 林辉
     * @description 根据resource数组加载资源
     * @date 2023/4/3 14:29
     */
    void loadBeanDefinitions(Resource... resources) throws BeansException;

    /**
     * @param location:
     * @author 林辉
     * @description 根据地址加载资源
     * @date 2023/4/3 14:29
     */
    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;
}
