package com.lsj.leetcode.problemset.algorithms.hard.on2018_04_27;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Desc MinWindow
 * @ProjectName LeetCode-Java
 * @Company com.lsj
 * @CreateTime 2018/4/27 18:26
 * @Author tianzhong
 */
public class MinWindow_MultiThread {
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
    public static void main(String[] args) throws Exception {
        String s = "wegdtzwabazduwwdysdetrrctotpcepalxdewzezbfewbabbseinxbqqplitpxtcwwhuyntbtzxwzyaufihclztckdwccpeyonumbpnuonsnnsjscrvpsqsftohvfnvtbphcgxyumqjzltspmphefzjypsvugqqjhzlnylhkdqmolggxvneaopadivzqnpzurmhpxqcaiqruwztroxtcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanllpunlyohwfsssiazeixhebipfcdqdrcqiwftutcrbxjthlulvttcvdtaiwqlnsdvqkrngvghupcbcwnaqiclnvnvtfihylcqwvderjllannflchdklqxidvbjdijrnbpkftbqgpttcagghkqucpcgmfrqqajdbynitrbzgwukyaqhmibpzfxmkoeaqnftnvegohfudbgbbyiqglhhqevcszdkokdbhjjvqqrvrxyvvgldtuljygmsircydhalrlgjeyfvxdstmfyhzjrxsfpcytabdcmwqvhuvmpssingpmnpvgmpletjzunewbamwiirwymqizwxlmojsbaehupiocnmenbcxjwujimthjtvvhenkettylcoppdveeycpuybekulvpgqzmgjrbdrmficwlxarxegrejvrejmvrfuenexojqdqyfmjeoacvjvzsrqycfuvmozzuypfpsvnzjxeazgvibubunzyuvugmvhguyojrlysvxwxxesfioiebidxdzfpumyon";
        String t = "ozgzyywxvtublcl";
        
        // s = "ADOBECODEBANC";
        // t = "ABC";
        
        long ss = System.currentTimeMillis ();
        System.err.println("最小覆盖子串：" + new MinWindow_MultiThread ().minWindow (s, t));
        
        System.err.println("耗时：" + (System.currentTimeMillis () - ss));
    }
    
    private int len;
    private String minWindow = "";
    private String target;
    
    public String minWindow(String s, String t) throws Exception {
        String res = "";
        if (s.length() < t.length()) {
            return res;
        }
        this.target = t;
        this.len = s.length ();
        
        if (s.length () <= 300) { // 少量数据单次处理
            searchMinWindow (s, t);
            return this.minWindow;
        }
        
        
        // int poolSize = s.length () / 50;
        ExecutorService service = Executors.newScheduledThreadPool (10);
        for (int i = 0; i < s.length(); i++) {
            String tmpStr = s.substring (i, s.length ());
            service.execute (new Runnable () {
                @Override
                public void run() {
                    searchMinWindow (tmpStr, t);
                }
            });
        }
        
        service.shutdown ();
        while (!service.isTerminated ()) {
            System.out.println("等待五秒再说...");
            Thread.sleep (TimeUnit.MILLISECONDS.toMillis (5000));
        }
        
        return this.minWindow;
    }
    
    public void searchMinWindow(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                // System.out.print("i = " + i + ", j = " + j);
                String tmpStr = s.substring(i, Math.min(j + 1, s.length()));
                // System.out.println(" : " + tmpStr);
            
                if (tmpStr.length() >= t.length()) {
                    boolean isMatched = true;
                    String newTmpStr = new String(tmpStr);
                    for (int k = 0; k < this.target.length(); k++) {
                        String chr = String.valueOf(this.target.charAt(k));
                        if (!newTmpStr.contains(chr)) {
                            isMatched = false;
                            break;
                        }
                        newTmpStr = newTmpStr.replaceFirst(chr, "");
                    }
                // if (isMatched) {
                // suitCount++;
                // System.out.println(tmpStr);
                //}
                    if (isMatched) {
                        compareAndSet (tmpStr);
                    }
                }
            }
        }
    }
    
    private synchronized void compareAndSet(String tmpSubStr){
        if (tmpSubStr.length() < len) {
            this.minWindow = tmpSubStr;
            this.len = tmpSubStr.length ();
        }
    }
}
