package com.leetcode.codeTop;

public class Trap {
    public int trap(int[] height) {
        int size = height.length;
        if (size < 1) {
            return 0;
        }

        int[] left = new int[size];
        int[] right = new int[size];
        for (int i = 1; i < size; i++) {
            left[i] = Math.max(left[i-1], height[i-1]);
        }

        for (int i = size - 2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i+1]);
        }

        int result = 0;
        for (int i = 0; i < size; i++) {
            int level = Math.min(left[i], right[i]);
            result += Math.max(0, level - height[i]);
        }

        return result;
    }
}
