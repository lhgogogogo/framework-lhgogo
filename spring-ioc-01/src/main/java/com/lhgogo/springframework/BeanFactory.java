package com.lhgogo.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：linhui
 * @description ：创建Bean的工厂
 * @date ：2023-03-26 11:31
 * @version:
 */

public class BeanFactory {

    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name){
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name,BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
    }
}
