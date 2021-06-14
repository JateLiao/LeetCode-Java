package com.lsj.leetcode.problemset.algorithms.finished.easy._2019;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.problemset.algorithms.notfinished.easy.on_2019_03_07
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2019/3/710:19
 */
public class ImplementStrStr {
    /**
     * 题号：28
     * https://leetcode-cn.com/problems/implement-strstr/
     *
     * 实现 strStr_JDK() 函数。
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * 示例 1:
     *
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     *
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     *
     * 说明:
     *
     * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     *
     * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
     */


    /**
     * main method.
     **/
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println("测试数据：" + haystack + ", " + needle);
        long s1 = System.currentTimeMillis();
        int index = strStr_JDK(haystack, needle);
        System.out.println("结果：" + index);
        System.out.println("耗时：" + (System.currentTimeMillis() - s1));


        s1 = System.currentTimeMillis();
        index = strStr2(haystack, needle);
        System.out.println("结果(非JDK)：" + index);
        System.out.println("耗时：" + (System.currentTimeMillis() - s1));

        s1 = System.currentTimeMillis();
        index = KMP.indexOf(haystack, needle);
        System.out.println("结果(KMP算法)：" + index);
        System.out.println("耗时：" + (System.currentTimeMillis() - s1));
    }

    public static int strStr(String haystack, String needle) {
        if (null == needle || needle.isEmpty() || haystack.equals(needle)) {
            return 0;
        }

        char[] h_arr = haystack.toCharArray();
        char[] n_arr = needle.toCharArray();

        int index_h = 0, index_n = 0;
        for (; index_h < h_arr.length; index_h++) {
            if (index_n == n_arr.length) { // 完全匹配完成
                return index_h - index_n;
            }

            if (h_arr[index_h] == n_arr[index_n]) {
                index_n++;
            } else { // 出现不匹配
                index_h -= index_n;
                index_n = 0;
            }
        }

        return -1;
    }

    public static int strStr_JDK(String haystack, String needle) {
        if (null == needle || needle.isEmpty()) {
            return 0;
        }

        return haystack.indexOf(needle);
    }

    public static int strStr2(String haystack, String needle) {
        if (null == needle || needle.isEmpty() || needle.equals(haystack)) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }

        char[] h_arr = haystack.toCharArray();
        char[] n_arr = needle.toCharArray();

        for (int i = 0; i < h_arr.length; i++) {
            if (h_arr[i] != n_arr[0]) {
                continue;
            }
            boolean matched = true;
            for (int j = 0; j < n_arr.length; j++) {
                if (i + j > h_arr.length - 1) {
                    matched = false;
                    break;
                }
                if (n_arr[j] != h_arr[i + j]) {
                    matched = false;
                    break;
                }
            }
            if (!matched) {
                continue;
            }
            return i;
        }

        return -1;
    }
}
