package com.lsj.leetcode.problemset.algorithms.finished.easy._2019;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.problemset.algorithms.notfinished.easy.on_2019_03_07
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2019/3/714:28
 */
public class KMP {
    
    public static int indexOf(String str, String ptr) {
        if (null == ptr || ptr.isEmpty()) {
            return 0;
        }
        
        int[] next = new int[ptr.length()];
        calNext(ptr, next, ptr.length());
        
        int k = -1;
        for (int i = 0; i < str.length(); i++) {
            while (k > -1 && ptr.charAt(k + 1) != str.charAt(i)) { //ptr和str不匹配，且k>-1（表示ptr和str有部分匹配）
                k = next[k];
            }
            
            if (ptr.charAt(k + 1) == str.charAt(i)) {
                k++;
            }
            
            if (k == ptr.length() - 1) { // /说明k移动到ptr的最末端
                return i - ptr.length() + 1;
            }
        }
        
        return -1;
    }
    
    private static void calNext(String str, int[] next, int len) {
        next[0] = -1;//next[0]初始化为-1，-1表示不存在相同的最大前缀和最大后缀
        int k = -1;//k初始化为-1
        for (int q = 1; q <= len - 1; q++) {
            while (k > -1 && str.charAt(k + 1) != str.charAt(q)) {
                // 如果下一个不同，那么k就变成next[k]，注意next[k]是小于k的，无论k取任何值。
                k = next[k]; // 往前回溯
            }
            if (str.charAt(k + 1) == str.charAt(q)) {
                k++;
            }
            next[q] = k;
        }
    }
}
