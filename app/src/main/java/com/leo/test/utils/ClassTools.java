package com.leo.test.utils;

import java.lang.reflect.ParameterizedType;

/**
 * @author Leo.ZhangTJ
 * @time 2018/10/29
 * @function
 * @describe
 */
public class ClassTools {
    
    public static <T> Class<T> getTClass(Class<T> modelClass) {
        return (Class<T>) ((ParameterizedType) modelClass.getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
