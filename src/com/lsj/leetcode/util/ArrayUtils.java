package com.lsj.leetcode.util;

import java.util.Arrays;

/**
 * @Desc ArrayUtils
 * @ProjectName LeetCode-Java
 * @Company com.lsj
 * @CreateTime 2018/8/3 11:41
 * @Author tianzhong
 */
public class ArrayUtils {
    
    /**
     * 数组遍历打印.
     * @param objs objs.
     */
    public static void showArrays(Object[] objs) {
        if (null == objs || objs.length < 1) {
            return;
        }
        
        StringBuilder stringBuilder = new StringBuilder("[ ");
        for (Object obj : objs) {
            if (null == obj) {
                stringBuilder.append("null, ");
            } else {
                stringBuilder.append(obj.toString()).append(" ,");
            }
        }
        if (stringBuilder.toString().endsWith(",")) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        stringBuilder.append("]");
        
        System.out.println(stringBuilder.toString());
    }
    
    /**
     * 数组遍历打印.
     * @param objs objs.
     */
    public static void showArrays(int[] objs) {
        if (null == objs) {
            return;
        }
        Integer[] vals = new Integer[objs.length];
        for (int i = 0; i < objs.length; i++) {
            vals[i] = objs[i];
        }
        showArrays(vals);
    }
}
