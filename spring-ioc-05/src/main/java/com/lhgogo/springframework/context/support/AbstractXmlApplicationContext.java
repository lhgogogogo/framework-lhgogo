package com.lhgogo.springframework.context.support;

import com.lhgogo.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.lhgogo.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-04-04 16:17
 * @version:
 */

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    /*
    * 使用 XmlBeanDefinitionReader 类，处理了关于 XML 文件配置信息的操作
    * 同时这里又留下了一个抽象类方法，getConfigLocations()，此方法是为了从入口上下文类，拿到配置信息的地址描述
    * */
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String[] configLocations = getConfigLocations();
        if(null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
