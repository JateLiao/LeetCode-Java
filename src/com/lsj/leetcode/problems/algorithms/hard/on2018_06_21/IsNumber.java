package com.lsj.leetcode.problems.algorithms.hard.on2018_06_21;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc IsNumber
 * @ProjectName LeetCode-Java
 * @Company com.lsj
 * @CreateTime 2018/6/21 21:35
 * @Author tianzhong
 */
public class IsNumber {
    /**
     * 验证给定的字符串是否为数字。
     * 例如:
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。
     */
    /**
     * Main Method: 请开始你的操作.
     *
     */
    public static void main(String[] args) {
        String string = "  -0.5 ";
        long s = System.currentTimeMillis ();
        boolean values = new IsNumber ().isNumber (string);
        System.err.println("IsNumber：" + values);
        System.err.println("耗时：" + String.valueOf (System.currentTimeMillis () - s));
    }
    
    public boolean isNumber(String s) {
        boolean res = false;
        
        if (null == s) {
            return res;
        }
        s = s.trim ();
        if (s.isEmpty ()) {
            return res;
        }
    
        Set<Character> validSet = new HashSet<> (127);
        for (int i = 0; i < 127; i++) {
            if ((i >= 48 && i <= 57) || i == 46 || i == 45 || i == 69 || i == 101) {
                validSet.add ((char)i);
            }
        }
        
        char[] arr = s.toCharArray ();
        int pointCount = 0; // 小数点数量
        int eCount = 0;
        for (char c : arr) {
            if (!validSet.contains (c)) {
                return false;
            }
            
            /** 小数点判断 */
            if (c == '.') {
                pointCount++;
            }
            if (pointCount > 1) {
                return false;
            }
    
            /** 字符 e 判断 */
            if (c == 'e' || c == 'E') {
                eCount++;
            }
            if (eCount > 1) {
                return false;
            }
        }
        res = true;
        
        return res;
    }
}
