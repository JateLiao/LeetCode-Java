package com.lsj.leetcode.problemset.algorithms.finished.medium._2021;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author liaoshijie@jojoreading.com
 * @since 2021/6/12 下午10:05
 */
public class Maximum_Swap_670 {
    /**
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     *
     * 示例 1 :
     *
     * 输入: 2736
     * 输出: 7236
     * 解释: 交换数字2和数字7。
     *
     * 示例 2 :
     *
     * 输入: 9973
     * 输出: 9973
     * 解释: 不需要交换。
     *
     * 注意:
     *
     *     给定数字的范围是 [0, 108]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-swap
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * main method.
     **/
    public static void main(String[] args) {
        int num = 1993;
        int result = maximumSwap(num);
        System.out.println(result);
    }

    public static int maximumSwap(int num) {
        // 先转一波int数组
        char[] charArray = String.valueOf(num).toCharArray();
        Integer[] arr = new Integer[charArray.length];
        Integer[] oriArr = new Integer[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            arr[i] = Character.getNumericValue(charArray[i]);
            oriArr[i] = Character.getNumericValue(charArray[i]);
        }
        // 排个序
        Arrays.sort(arr, Collections.reverseOrder());
        // 直到不是最大数再和最大数交换
        for (int i = 0; i < oriArr.length; i++) {
            int a = oriArr[i];
            int b = arr[i];
            if (a == b) {
                continue;
            }
            // 找到最后一个剩下最大值的原始位置
            int index = 0;
            for (int j = i + 1; j < oriArr.length; j++) {
                if (oriArr[j].equals(arr[i])) {
                    index = j;
                }
            }
            // 交换
            int oriNum = oriArr[i];
            int replaceNum = oriArr[index];
            oriArr[i] = replaceNum;
            oriArr[index] = oriNum;
            break;
        }
        StringBuilder builder = new StringBuilder();
        Arrays.stream(oriArr).forEach(builder::append);
        return Integer.parseInt(builder.toString());
    }
}
