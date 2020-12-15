package com.lsj.leetcode.problemset.algorithms.notfinished.hard._2018;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc MinWindow
 * @ProjectName LeetCode-Java
 * @Company com.lsj
 * @CreateTime 2018/4/27 18:26
 * @Author tianzhong
 */
public class MinWindow {
    /**
     * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
     * 示例：
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     * 说明：
     * 如果 S 中不存这样的子串，则返回空字符串 ""。
     * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
     */
    
    /**
     * Main Method: 请开始你的操作.
     *
     */
    public static void main(String[] args) {
        String s =
                "wegdtzwabazduwwdysdetrrctotpcepalxdewzezbfewbabbseinxbqqplitpxtcwwhuyntbtzxwzyaufihclztckdwccpeyonumbpnuonsnnsjscrvpsqsftohvfnvtbphcgxyumqjzltspmphefzjypsvugqqjhzlnylhkdqmolggxvneaopadivzqnpzurmhpxqcaiqruwztroxtcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanllpunlyohwfsssiazeixhebipfcdqdrcqiwftutcrbxjthlulvttcvdtaiwqlnsdvqkrngvghupcbcwnaqiclnvnvtfihylcqwvderjllannflchdklqxidvbjdijrnbpkftbqgpttcagghkqucpcgmfrqqajdbynitrbzgwukyaqhmibpzfxmkoeaqnftnvegohfudbgbbyiqglhhqevcszdkokdbhjjvqqrvrxyvvgldtuljygmsircydhalrlgjeyfvxdstmfyhzjrxsfpcytabdcmwqvhuvmpssingpmnpvgmpletjzunewbamwiirwymqizwxlmojsbaehupiocnmenbcxjwujimthjtvvhenkettylcoppdveeycpuybekulvpgqzmgjrbdrmficwlxarxegrejvrejmvrfuenexojqdqyfmjeoacvjvzsrqycfuvmozzuypfpsvnzjxeazgvibubunzyuvugmvhguyojrlysvxwxxesfioiebidxdzfpumyon";
        String t = "ozgzyywxvtublcl";
        
        //s = "ADOBECODEBANC";
        //t = "ABC";
        long ss = System.currentTimeMillis();
        System.err.println("最小覆盖子串：" + MinWindow.minWindow(s, t));
        
        System.err.println("耗时：" + (System.currentTimeMillis() - ss));
    }
    
    
    public static String minWindow2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int minStart = 0, minEnd = 0;
        int count = t.length();
        for (char c : t.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char val = s.charAt(right);
            if (map.containsKey(val)) {
                map.put(val, map.get(val) - 1);
                if (map.get(val) >= 0) {
                    count--;
                }
            }
            while (count == 0) {
                if (right - left < min) {
                    min = right - left;
                    minStart = left;
                    minEnd = right;
                }
                char temp = s.charAt(left);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0) count++;
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd + 1);
    }
    
    
    public static String minWindow(String s, String t) {
        int suitCount = 0;
        String res = "";
        if (s.length() < t.length()) {
            return res;
        }
        int len = Integer.MAX_VALUE;
        int t_len = t.length();
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i ; j < s.length(); j++) {
                String tmpStr = s.substring(i, Math.min(j + 1, s.length()));
                if (tmpStr.length() >= t.length()) {
                    boolean isMatched = true;
                    String newTmpStr = new String(tmpStr);
                    for (int k = 0; k < t.length(); k++) {
                        String chr = String.valueOf(t.charAt(k));
                        if (!newTmpStr.contains(chr)) {
                            isMatched = false;
                            break;
                        }
                        newTmpStr = newTmpStr.replaceFirst(chr, "");
                    }
                    //if (isMatched) {
                    //    suitCount++;
                    //    System.out.println(tmpStr);
                    //}
                    
                    if (isMatched && tmpStr.length() < len) {
                        res = tmpStr;
                        len = res.length();
                    }
                }
            }
        }
        
        System.out.println("匹配子串总数据：" + suitCount);
        
        return res;
    }
}
