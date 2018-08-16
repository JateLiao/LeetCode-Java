package com.lsj.leetcode.problemset.algorithms.finished.medium.on2018_05_05;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.problemset.algorithms.finished.medium.on2018_05_05
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2018/5/510:32
 */
public class Multiply_Strings {
    
    /**
     * main method.
     **/
    public static void main(String[] args) {
        String num1 = "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
        String num2 = "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
        System.out.println("相加结果：" + bigNumberAdd(num1, num2));
        long s = System.currentTimeMillis();
        System.err.println("相乘结果：" + new Multiply_Strings ().multiply (num1, num2));
        System.out.println("耗时：" + (System.currentTimeMillis() - s));
    }
    
    /**
     * URL：https://leetcode-cn.com/problems/multiply-strings/description/
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     *
     * 示例 1:
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     *
     * 示例 2:
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     *
     * 说明：
     *     num1 和 num2 的长度小于110。
     *     num1 和 num2 只包含数字 0-9。
     *     num1 和 num2 均不以零开头，除非是数字 0 本身。
     *     不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     */
    
    /**
     * 涉及到大数相乘，大数相加
     */
    public String multiply(String num1, String num2) {
        if (null == num1 || num1.isEmpty() || null == num2 || num2.isEmpty()) {
            return null;
        }
        String result = "0";
        if ("0".equals(num1) || "0".equals(num2)) {
            return result;
        }
        String longFactor = num1.length() >= num2.length() ? num1 : num2; // 较长的因数
        String shortFactor = num1.equals(longFactor) ? num2 : num1; // 较短的因数
        int shortLen = shortFactor.length();
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < shortLen; i++) {
            char c = shortFactor.charAt(shortLen - 1 - i);
            if (c == '0') {
                continue;
            }
            int valInt = Integer.valueOf(String.valueOf(c));
            String tmpSum = longFactor;
            for (int j = 0; j < valInt - 1 && valInt > 1; j++) {
                tmpSum = bigNumberAdd(tmpSum, longFactor);
            }
            
            // 补充匹配位数个数的0
            if (i >= 1) {
                builder.setLength(0);
                builder.append(tmpSum);
                for (int j = 0; j < i; j++) {
                    builder.append("0");
                }
                tmpSum = builder.toString();
            }
            result = bigNumberAdd(result, tmpSum);
        }
        
        return result;
    }
    
    /**
     * bigNumberAdd.
     * @param num1 .
     * @param num2 .
     * @return result.
     */
    public static String bigNumberAdd(String num1, String num2) {
        String result = null;
    
        if (null == num1 || num1.isEmpty() || null == num2 || num2.isEmpty()) {
            return result;
        }
        String longNum = num1.length() >= num2.length() ? num1 : num2; // 较长的数
        String shortNum = num1.equals(longNum) ? num2 : num1; // 较短的数
        int shortLen = shortNum.length();
        int longLen = longNum.length();
        
        // 按位相加
        int privBit = 0; // 进位数
        String[] valueArr = new String[longLen + 1];
        for (int i = 0; i < longLen; i++) {
            int longI = Integer.valueOf(String.valueOf(longNum.charAt(longLen - 1 - i)));
            if (i < shortLen) {
                int shrtI = Integer.valueOf(String.valueOf(shortNum.charAt(shortLen - 1 - i)));
                int sum = longI + shrtI + privBit; // 两数相加，再加上之前的进位
    
                if (sum < 10) {
                    valueArr[longLen - i] = String.valueOf(sum);
                    privBit = 0;
                } else {
                    valueArr[longLen - i] = String.valueOf(sum - 10);
                    privBit = 1;
                }
                continue;
            }
            
            // 已做完低位重合部分相加过程
            if (privBit != 0) { // 还有进位，继续相加
                int sum = privBit + longI;
                if (sum < 10) {
                    valueArr[longLen - i] = String.valueOf(sum);
                    privBit = 0;
                } else {
                    valueArr[longLen - i] = String.valueOf(sum - 10);
                    privBit = 1;
                }
            } else {
                valueArr[longLen - i] = String.valueOf(longI);
            }
        }
        
        valueArr[0] = privBit != 0 ? String.valueOf(privBit) : "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < valueArr.length; i++) {
            if (null != valueArr[i]) {
                builder.append(valueArr[i]);
            }
        }
        result = builder.toString();
        //result = Arrays.toString(valueArr).replaceAll("\\[|\\]|,|\\s", "");
        return result;
    }
}

