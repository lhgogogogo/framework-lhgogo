package com.lhgogo.springframework.beans.factory;

import com.lhgogo.springframework.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-31 10:28
 * @version:
 */

public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValueList.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues(){
       return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }
}

