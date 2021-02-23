package com.leetcode.array;
/*
给你一个字符串 s，找到 s 中最长的回文子串。


 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int size = s.length();
        int max = 0;
        int[] result = new int[]{0,0};
        for (int i = 0; i < size; i ++) {
            int[] result1 = getPalindrome(s, i, i + 1);
            int[] result2 = getPalindrome(s, i, i);
            if (result1[1] - result1[0] > max) {
                max = result1[1] - result1[0];
                result = result1;
            }

            if (result2[1] - result2[0] > max) {
                max = result2[1] - result2[0];
                result = result2;
            }
        }

        return s.substring(result[0], result[1]+1);
    }

    private int[] getPalindrome(String s, int left , int right) {

        if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
            return right - left == 1 ? new int[] {left, left} : new int[] {left + 1, right - 1} ;
        }

        return getPalindrome(s, left - 1, right + 1);
    }
}

/*
动态规划
 */
