package com.lsj.leetcode.problemset.algorithms.hard.on2018_06_21;

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
        String string = "2e0";
        long s = System.currentTimeMillis ();
        boolean values = new IsNumber ().isNumber (string);
        System.err.println("测试字符串：" + string);
        System.err.println("IsNumber：" + values);
        System.err.println("耗时：" + String.valueOf (System.currentTimeMillis () - s));
    }
    
    private static final char[] WRONG_BE_CHARS= {'e', 'E'};
    
    public boolean isNumber(String s) {
        if (null == s) {
            return false;
        }
        s = s.trim ();
        if (s.isEmpty ()) {
            return false;
        }
     
        if (s.length () == 1 && (((int)s.charAt (0)) < 48 || ((int)s.charAt (0)) > 57)) { // e开头或结尾
            return false;
        }
    
        Set<Character> validSet = new HashSet<> (127);
        Set<Character> numSet = new HashSet<> (10);
        for (int i = 0; i < 127; i++) {
            if ((i >= 48 && i <= 57)) {
                validSet.add ((char)i);
                numSet.add ((char)i);
            }
            if (i == 43 || i == 46 || i == 45 || i == 69 || i == 101) {
                validSet.add ((char)i);
            }
        }
        
        char[] arr = s.toCharArray ();
        int len = '.' == arr[arr.length - 1] ? arr.length - 1 : arr.length;
        int pointCount = 0; // 小数点数量
        int eCount = 0;
        int validCount = 0;
        int numCount = 0;
        int numCountAfterE = 0;
        int index = 1;
        for (char c : arr) {
            if (index == 1 && (c == '-' || c == '+')) { // 正负号
                index++;
                continue;
            }
            /** 开头结尾字符判断 */
            if ((index == 1 || index == len) && isWrongBE (c)) {
                return false;
            }
            if (!validSet.contains (c)) {
                return false;
            }
            
            /** -/+ */
            if (index != 1 && arr[index - 1 - 1] != 'e' && arr[index - 1 - 1] != 'E' && (c == '-' || c == '+')) {
                return false;
            }
            
            /** 小数点判断 */
            if (c == '.') {
                if (eCount > 0) { // e后面不能出现小数点
                    return false;
                }
                pointCount++;
            }
            if (pointCount > 1) {
                return false;
            }
            if (index == 1 && c == '.') { // 小数点开头
                index++;
                continue;
            }
    
            /** 字符 e 判断 */
            if (c == 'e' || c == 'E') {
                eCount++;
            }
            if ((eCount>0 && numCount < 1) || eCount > 1) {
                return false;
            }
            if (numSet.contains (c)) {
                numCountAfterE = eCount > 0 ? ++numCountAfterE : numCountAfterE;
                numCount++;
            }
            index++;
            validCount++;
        }
        if (validCount < 1 || numCount < 1 || (eCount > 0 && numCountAfterE < 1)) {
            return false;
        }
        return true;
    }
    
    private boolean isWrongBE(char s) {
        for (int i = 0; i < WRONG_BE_CHARS.length; i++) {
            if (s == WRONG_BE_CHARS[i]) {
                return true;
            }
        }
        return false;
    }
}
