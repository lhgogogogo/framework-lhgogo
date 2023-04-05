package com.lhgogo.springframework.context;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-04-04 15:35
 * @version:
 */

import com.lhgogo.springframework.beans.BeansException;

/**
 * ConfigurableApplicationContext 继承自 ApplicationContext，并提供了 refresh 这个核心方法。
 * 如果你有看过一些 Spring 源码，那么一定会看到这个方法。 接下来也是需要在上下文的实现中完成刷新容器的操作过程。
 * */

public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * @param :
     * @return void
     * @author 林辉
     * @description 刷新容器
     * @date 2023/4/4 15:37
     */
    void refresh() throws BeansException;
}
