package com.lsj.leetcode.algorithm.sort.quick;

import com.lsj.leetcode.util.ArrayUtils;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.algorithm.sort.quick
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2019/3/2423:30
 */
public class QuickSort {
    /**
     * main method.
     **/
    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        
        System.out.println("排序前：");
        ArrayUtils.showArrays(arr);
        
        //arr = quickSort(arr);
        arr = quickSort_rec(arr);
        
        System.out.println("排序后：");
        ArrayUtils.showArrays(arr);
    }
    
    /**
     * 快速排序，非递归；
     * @param arr arr.
     * @return arr.
     */
    public static int[] quickSort(int[] arr) {
        int pos = arr[0]; // 选取第一个元素作为哨兵
        int left = 1, right = arr.length - 1;
        int tmp = 0;
        
        while (left < right) {
            while (arr[right] >= pos && left != right) { // 从右向左找到一个小于哨兵的元素
                right--;
            }
            arr[left] = arr[right];
            
            while (arr[left] <= pos && left != right) { // 从左向右找到一个大于哨兵的元素
                left++;
            }
            arr[right] = arr[left];
        }
        
        
        //while (arr[right] >= pos && left != right) { // 从右向左找到一个小于哨兵的元素
        //    right--;
        //}
        //
        //while (arr[left] <= pos && left != right) { // 从左向右找到一个大于哨兵的元素
        //    left++;
        //}
        //
        //// 交换
        //if (left != right) {
        //    tmp = arr[left];
        //    arr[left] = arr[right];
        //    arr[right] = tmp;
        //}
        //
        //if (left == right) {
        //    tmp = arr[0];
        //    arr[0] = arr[right];
        //    arr[right] = tmp;
        //}
        
        return arr;
    }
    
    /**
     * 快速排序，递归；
     * @param arr arr.
     * @return arr.
     */
    public static int[] quickSort_rec(int[] arr) {
        sort_rec(arr, 0, arr.length - 1);
        return arr;
    }
    
    private static void sort_rec(int[] arr, int left, int right) {
        if (left >= right) { // 出口
            return;
        }
        
        int position = getPosition(arr, left, right);
        sort_rec(arr, left, position - 1);
        sort_rec(arr, position + 1, right);
    }
    
    private static int getPosition(int[] arr, int left, int right) {
        int pos = arr[left]; // 选取第一个元素作为哨兵
        int begin_left = left; // 记录初始left，即哨兵位置
        int tmp;
        
        while (left < right) {
            while (arr[right] >= pos && left != right) { // 从右向左找到一个小于哨兵的元素
                right--;
            }
    
            while (arr[left] <= pos && left != right) { // 从左向右找到一个大于哨兵的元素
                left++;
            }
    
            // 交换
            if (left != right) {
                tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
    
            if (left == right) {
                tmp = arr[begin_left];
                arr[begin_left] = arr[right];
                arr[right] = tmp;
            }
        }
        
        return left;
    }
}
