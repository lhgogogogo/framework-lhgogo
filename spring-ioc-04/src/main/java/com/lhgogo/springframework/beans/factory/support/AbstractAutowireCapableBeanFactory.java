package com.lhgogo.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.lhgogo.springframework.beans.BeansException;
import com.lhgogo.springframework.beans.PropertyValue;
import com.lhgogo.springframework.beans.factory.PropertyValues;
import com.lhgogo.springframework.beans.factory.config.BeanDefinition;
import com.lhgogo.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-26 13:49
 * @version:
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();


    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean = null;
        try {
            bean =  createBeanInstance(beanDefinition, beanName, args);
            // 给bean填充属性
            applyPropertyValues(beanName,bean,beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName,bean);
        return bean;
    }

    /**
     * @param beanDefinition: bean定义类
     * @param beanName: bean名称
     * @param args: 参数
     * @return Object
     * @author 林辉
     * @description 创建Bean的实例
     * @date 2023/3/31 10:44
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition,String beanName,Object[] args){
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] constructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            if(null != args && constructor.getParameterTypes().length == args.length){
                constructorToUse = constructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,constructorToUse,args);
    }

    /**
     * @param :
     * @return void
     * @author 林辉
     * @description 属性填充
     * @date 2023/3/31 10:43
     */
    protected void applyPropertyValues(String beanName, Object bean , BeanDefinition beanDefinition){
        try {
        // 获取属性集合
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        // 遍历属性
        for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
            Object value = propertyValue.getValue();
            String name = propertyValue.getName();
            if(value instanceof BeanReference){
                // a依赖b,获取b的实例化
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getBeanName());
            }
            // 属性填充
            BeanUtil.setFieldValue(bean,name,value);
        }
        } catch (Exception e) {
            throw new BeansException("Error setting property values：" + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }


}
