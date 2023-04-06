package com.lhgogo.springframework.beans.factory;

/**
 * @author ：linhui
 * @description ：初始化bean接口
 * @date ：2023-04-06 14:35
 * @version:
 */

public interface InitializingBean {

    /**
     * @param :
     * @return void
     * @author 林辉
     * @description 处理了属性填充后调用
     * @date 2023/4/6 14:36
     */
    void afterPropertiesSet() throws Exception;

}
