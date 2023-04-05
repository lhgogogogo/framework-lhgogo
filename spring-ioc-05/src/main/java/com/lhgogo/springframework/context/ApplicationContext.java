package com.lhgogo.springframework.context;

import com.lhgogo.springframework.beans.factory.ListableBeanFactory;

/**
 * @author ：linhui
 * @description ：上下文接口
 * @date ：2023-04-04 15:33
 * @version:
 */

/**
 * ApplicationContext，继承于 ListableBeanFactory，也就继承了关于 BeanFactory 方法，
 * 比如一些 getBean 的方法。另外 ApplicationContext 本身是 Central 接口，
 * 但目前还不需要添加一些获取ID和父类上下文，所以暂时没有接口方法的定义。
 */
public interface ApplicationContext extends ListableBeanFactory {
}
