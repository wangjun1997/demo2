package com.example.demo;

import java.lang.reflect.Field;

/**
 * @author wangjun
 * @name demo2
 * @time 2019/11/28 9:23
 */
public class demo {
    public static void main(String[] args){
        Integer i=10;
        Integer j=20;
        swap(i,j);
        System.out.println("i="+i+"j="+j);
    }

    private static void swap(Integer i, Integer j) {
        int temp = i.intValue();
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.setInt(i,j);
            field.setInt(j,temp);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
