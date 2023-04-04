package com.lhgogo.springframework.beans.factory;

import com.lhgogo.springframework.beans.BeansException;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author ：linhui
 * @description ：扩展beanFactory接口
 * @date ：2023-04-03 9:11
 * @version:
 */

public interface ListableBeanFactory extends BeanFactory {

    /**
     * @param type:
     * @return Map<String,T>
     * @author 林辉
     * @description 根据类型返回bean的实例
     * @date 2023/4/3 9:13
     */

    <T> Map<String, T> getBeansOfType(@Param("type") Class<T> type) throws BeansException;

    /**
     * @param :
     * @return String
     * @author 林辉
     * @description 返回注册表中所有的Bean名称
     * @date 2023/4/3 9:14
     */
    String[] getBeanDefinitionNames();

}
