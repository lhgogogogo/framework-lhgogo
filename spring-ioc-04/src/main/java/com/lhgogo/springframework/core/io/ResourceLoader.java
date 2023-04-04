package com.lhgogo.springframework.core.io;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-04-03 10:33
 * @version: 资源加载器  获取资源接口
 */

public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
