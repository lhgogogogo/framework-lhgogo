package com.lhgogo.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-31 11:12
 * @version:
 */

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "小林");
        hashMap.put("10002", "憨子姐姐");
        hashMap.put("10003", "候大哥");
        hashMap.put("10004", "候二哥");
        hashMap.put("10005", "珍珍姐姐");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
