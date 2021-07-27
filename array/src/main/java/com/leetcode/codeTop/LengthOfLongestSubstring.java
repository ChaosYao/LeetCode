package com.leetcode.codeTop;
/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。



https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }

        int max = 0;
        int size = s.length();
        int i = 1;
        String tmp = "";
        int start = 0;
        while(i < size) {
            tmp = s.substring(start, i);
            if (tmp.contains(String.valueOf(s.charAt(i)))) {
                start += tmp.indexOf(String.valueOf(s.charAt(i))) + 1;
                if (max < tmp.length()) {
                    max = tmp.length();
                }
            }
            i++;
        }

        if (i - start > max) {
            max = i - start;
        }
        return max;
    }
}
