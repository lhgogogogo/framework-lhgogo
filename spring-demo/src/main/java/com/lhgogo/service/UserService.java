package com.lhgogo.service;

import com.lhgogo.dao.UserDao;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-15 15:33
 * @version:
 */

public class UserService {

    private UserDao userDao;

    public UserService() {
        System.out.println("我被初始化了，UserService");
    }

}
