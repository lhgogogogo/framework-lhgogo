package com.lhgogo.springframework.beans.factory;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-04-06 14:45
 * @version:
 */

public interface DisposableBean {

    void destroy() throws Exception;
}
