package com.lsj.leetcode.problemset.algorithms.finished.medium._2019;

/**
 * @Title: ${FILE_NAME}
 * @Company: com.lsj
 * @Package com.lsj.leetcode.problemset.algorithms.finished.medium.on2018_08_17
 * @Description: ${TODO}
 * @Author liao
 * @Createtine 2018/8/170:13
 */
public class AddTwoNumbers {
    /**
     *
     * https://leetcode-cn.com/problems/add-two-numbers/
     *
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
        ListNode l1 = null, lh1 = null;
        ListNode l2 = null, lh2 = null;
    
        String str = "18";
        System.out.println("测试数据：" + str);
        for (int i = str.length() - 1; i >= 0; i--) {
            ListNode node = new ListNode(Integer.valueOf("" + str.charAt(i)));
            if (null == lh1) {
                lh1 = node;
            }
        
            if (null != l1) {
                l1.next = node;
            }
            l1 = node;
        }
        l1.next = null;
    
    
    
        str = "0";
        System.out.println("测试数据：" + str);
        for (int i = str.length() - 1; i >= 0; i--) {
            ListNode node = new ListNode(Integer.valueOf("" + str.charAt(i)));
            if (null == lh2) {
                lh2 = node;
            }
        
            if (null != l2) {
                l2.next = node;
            }
            l2 = node;
        }
        l2.next = null;
        
        
        
        long s = System.currentTimeMillis();
        ListNode node = AddTwoNumbers.addTwoNumbers(lh1, lh2);
        System.out.println("结果：");
        showListNode(node);
        
        node = official_addTwoNumbers(lh1, lh2);
        System.out.println("结果(官方)：");
        showListNode(node);
        
        System.out.println("耗时：" + String.valueOf(System.currentTimeMillis() - s));
    }
    
    public static ListNode official_addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    
    /**
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t_l1 = l1;
        ListNode t_l2 = l2;
        
        StringBuilder number = new StringBuilder();
        while (t_l1 != null) {
            number.append(t_l1.val);
            t_l1 = t_l1.next;
        }
        String num1 = number.toString();
        number.setLength(0);
        
        while (t_l2 != null) {
            number.append(t_l2.val);
            t_l2 = t_l2.next;
        }
        String num2 = number.toString();
        
        // 求和
        String sum = bigNumberAdd(num1, num2);
        // String.valueOf(Integer.valueOf(num1) + Integer.valueOf(num2));
    
        ListNode listNode = null, listNodeHead = null;
        for (int i = sum.length() - 1; i >= 0; i--) {
            ListNode node = new ListNode(Integer.valueOf("" + sum.charAt(i)));
            if (null == listNodeHead) {
                listNodeHead = node;
            }
        
            if (null != listNode) {
                listNode.next = node;
            }
            listNode = node;
        }
        listNode.next = null;
        
        return listNodeHead;
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
    
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
    }
    
    private static void showListNode(ListNode node) {
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {
            stringBuilder.append(node.val).append(", ");
            node = node.next;
        }
        if (stringBuilder.toString().endsWith(" ")) {
            stringBuilder.setLength(stringBuilder.length() - 2);
        }
        
        System.out.println(stringBuilder.toString());
    }
}
