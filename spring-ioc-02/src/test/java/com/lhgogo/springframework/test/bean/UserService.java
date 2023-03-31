package com.lhgogo.springframework.test.bean;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-26 14:28
 * @version:
 */


public class UserService {

    private String name;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
