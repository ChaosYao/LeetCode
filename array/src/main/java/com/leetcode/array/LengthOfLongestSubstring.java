package com.leetcode.array;

/*
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        if (size < 2) {
            return size;
        }

        int i = 0;
        int j = 1;
        int max = 1;

        while(i < size && j < size) {
            String tmp = s.substring(i,j);
            if (tmp.contains(String.valueOf(s.charAt(j)))) {
                if (j - i > max) {
                    max = j - i;
                }
                i += tmp.indexOf(s.charAt(j)) + 1;
            }
            j++;
        }

        if (j - i > max) {
            max =  j - i;
        }

        return max;
    }
}

/*
滑动窗口
 */
