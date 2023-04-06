package com.lhgogo.springframework.beans.factory.config;

/**
 * @author ：linhui
 * @description ：单例Bean注册接口
 * @date ：2023-03-26 13:32
 * @version:
 */

public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
