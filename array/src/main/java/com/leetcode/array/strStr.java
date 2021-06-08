package com.leetcode.array;

public class strStr {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }

        if (needle.equals("")) {
            return 0;
        }

        int size = haystack.length();
        int size1 = needle.length();

        for (int i = 0; i < size - size1 + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                String tmp = haystack.substring(i, i+size1);
                if (tmp.equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }
}
