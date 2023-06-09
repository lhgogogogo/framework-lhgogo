package com.lhgogo.springframework.test.bean;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-26 14:28
 * @version:
 */


public class UserService {

    private String uId;

    private UserDao userDao;

    public UserService() {
    }

    public UserService(String uId) {
        this.uId = uId;
    }

    public UserService(String uId, UserDao userDao) {
        this.uId = uId;
        this.userDao = userDao;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.queryUserName(uId));
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
