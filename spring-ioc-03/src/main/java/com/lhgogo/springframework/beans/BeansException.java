package com.lhgogo.springframework.beans;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-26 13:56
 * @version:
 */

public class BeansException extends RuntimeException{

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
