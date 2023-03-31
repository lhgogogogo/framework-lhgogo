package com.lhgogo.springframework.beans.factory;

/**
 * @author ：linhui
 * @description ：bean工厂接口
 * @date ：2023-03-26 13:37
 * @version:
 */

public interface BeanFactory {

    Object getBean(String beanName);

    Object getBean(String beanName,Object... args);
}
