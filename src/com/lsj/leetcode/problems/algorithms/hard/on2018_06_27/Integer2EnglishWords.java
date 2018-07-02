package com.lsj.leetcode.problems.algorithms.hard.on2018_06_27;

/**
 * @Desc Integer2EnglishWords
 * @ProjectName LeetCode-Java
 * @Company com.lsj
 * @CreateTime 2018/6/27 21:37
 * @Author tianzhong
 */
public class Integer2EnglishWords {
    
    /**
     * 将非负整数转换为其对应的英文表示。可以保证给定输入小于 231 - 1 。
     * 示例 1:
     * 输入: 123
     * 输出: "One Hundred Twenty Three"
    
     * 示例 2:
     * 输入: 12345
     * 输出: "Twelve Thousand Three Hundred Forty Five"
     
     * 示例 3:
     * 输入: 1234567
     * 输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
    
     * 示例 4:
     * 输入: 1234567891
     * 输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
     */

    /**
     * Main Method: 请开始你的操作.
     *
     */
    public static void main(String[] args) {
        int num = 100024554;
        long s = System.currentTimeMillis ();
        String values = new Integer2EnglishWords ().numberToWords (num);
        System.err.println("测试数字：" + num);
        System.err.println("numberToWords：" + values);
        System.err.println("耗时：" + String.valueOf (System.currentTimeMillis () - s));
    }
    
    private static final String[] NUM_ARR = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] NUM_TENS_ARR = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] NUM_TENS_JR_ARR = {"Eleven", "Twelve", "Thirteen", "Forteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] UNIT_ARR = {"Hundred", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num < 0 || num > Integer.MAX_VALUE) {
            return null;
        }
        String numStr = String.valueOf (num);
        int len = numStr.length ();
        String[] numArr = new String[len % 3 == 0 ? len / 3 :  len / 3 + 1]; // 三位数字数组
        int lenArr = numArr.length;
        StringBuilder valueSb = new StringBuilder ();
        String value = "";
    
        for (int i = 0; i < lenArr; i++) {
            int endIndex = len - i * 3;
            String numSub = numStr.substring (Math.max (endIndex - 3, 0), endIndex);
            numArr[lenArr - 1 - i] = numSub;
            
            while (numSub.charAt (0) == '0') { // 首部0清除
                numSub = numSub.substring (1, numSub.length ());
            }
            
            int lenSub = numSub.length ();
            char[] arr = numSub.toCharArray ();
            for (int j = 0; j < arr[i]; j++) {
                char c = arr[i];
                if (c == '0') {
                    continue;
                }
                valueSb.append (NUM_ARR[Integer.valueOf (String.valueOf (c))]);
                if (lenSub == 3) {
                    valueSb.append (UNIT_ARR[0]);
                } else if (lenSub == 2 && c != '0') {
                    valueSb.append (UNIT_ARR[0]);
                } else if (lenSub == 1 && c != '0') {
                    valueSb.append (NUM_ARR[Integer.valueOf (String.valueOf (c))]);
                }
                --lenSub;
            }
        }
        
        return valueSb.toString ();
    }
}
