package com.algorithm.leetcode;

import org.junit.Test;

/**
 * @author lhh
 * @date 2020/9/8 21:18
 * .求无重复字符的最长子串
 */
public class LeetCode003 {

    @Test
    public void fun1() {
        String s = "aa";
        int longestSubstring = lengthOfLongestSubstring(s);
        System.out.println("最长子串长度:" + longestSubstring);
        int i = lengthOfLongestSubstring2(s);
        System.out.println(i);

    }

    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        int left = 0;
        int right = 0;
        int[] freq = new int[256];
        while (right < s.length() - 1) {
            if (freq[s.charAt(right)] == 0) {
                freq[s.charAt(right)]++;
                right++;
            } else {
                freq[s.charAt(left)]--;
                left++;
            }
            int temp = right - left;
            res = res >= temp ? res : temp;
        }
        return res;
    }

    /**
     * .输入字符
     *
     * @param s 原始字符串
     * @return 最长子串长度
     */
    public int lengthOfLongestSubstring(String s) {
        // 索引值是ASCII的值，用来记录对应ASCII出现的频率
        int[] freq = new int[256];
        int left = 0, right = -1;// 滑动窗口为s
        int res = 0;// 用来记录子串的长度。
        while (right + 1 < s.length()) {
            if (freq[s.charAt(right + 1)] == 0) {
                right++;
                freq[s.charAt(right)]++;
            } else {
                freq[s.charAt(left)]--;
                left++;
            }
            int temp = right - left + 1;
            res = res >= temp ? res : temp;
        }
        return res;
    }
}
