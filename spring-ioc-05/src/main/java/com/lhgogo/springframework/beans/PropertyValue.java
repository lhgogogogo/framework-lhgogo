package com.lhgogo.springframework.beans;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-31 10:27
 * @version:
 */

public class PropertyValue {

    private final String name;

    private final Object value;

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }


}
