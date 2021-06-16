package com.leetcode.string;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int length = s.length();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }

        return isPalind(str.toString());
    }

    private boolean isPalind(String str) {
        int length = str.length();
        if (length < 2) {
            return true;
        }

        int middle = length % 2 == 0 ? length / 2 - 1 : length / 2;
        for (int i = 0; i <= middle; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
