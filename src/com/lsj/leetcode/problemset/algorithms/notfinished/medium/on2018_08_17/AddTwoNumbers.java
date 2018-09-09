package com.lsj.leetcode.problemset.algorithms.notfinished.medium.on2018_08_17;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.problemset.algorithms.notfinished.medium.on2018_08_17
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2018/8/170:13
 */
public class AddTwoNumbers {
    /**
     * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    
    /**
     * main method.
     **/
    public static void main(String[] args) {
    
        String str = "";
        System.err.println("测试数据：" + str);
        long s = System.currentTimeMillis ();
        ListNode node = AddTwoNumbers.addTwoNumbers(null, null);
        System.err.println("结果：" + node);
        System.err.println("耗时：" + String.valueOf (System.currentTimeMillis () - s));
    }
    
    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        synchronized (ListNode.class) {
            System.out.println("Hah!!");
        }
        return null;
    }
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
