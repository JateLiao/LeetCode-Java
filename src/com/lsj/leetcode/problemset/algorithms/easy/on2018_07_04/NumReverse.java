package com.lsj.leetcode.problemset.algorithms.easy.on2018_07_04;

/**
 * @Desc NumReverse
 * @ProjectName LeetCode-Java
 * @Company com.lsj
 * @CreateTime 2018/7/4 14:11
 * @Author tianzhong
 */
public class NumReverse {
    /**
     * 给定一个 32 位有符号整数，将整数中的数字进行反转。
     * 示例 1:
     * 输入: 123
     * 输出: 321
     * 示例 2:
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * 输入: 120
     * 输出: 21
     * 注意:
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
     */
    
    /**
     * Main Method: 请开始你的操作.
     *
     */
    public static void main(String[] args) {
        int num = 1;
        System.err.println("测试数字：" + num);
        long s = System.currentTimeMillis ();
        int values = new NumReverse ().reverse (num);
        System.err.println("反转数字：" + values);
        System.err.println("耗时：" + String.valueOf (System.currentTimeMillis () - s));
    }
    
    public int reverse(int x) {
        String numStr = String.valueOf (x);
        StringBuilder reverseVal = new StringBuilder ("");
        
        char firstChar = numStr.charAt (0); // 符号位
        if (firstChar == '-' || firstChar == '+') {
            reverseVal.append (numStr.substring (0, 1));
            numStr = numStr.substring (1, numStr.length ());
        }
        
        char[] numArr = numStr.toCharArray ();
        int len = numArr.length;
        int indexEnd = len % 2 == 0 ? len / 2 : len / 2 + 1;
        for (int i = 0; i < indexEnd; i++) {
        
        }
        
        return 0;
    }
    
}
