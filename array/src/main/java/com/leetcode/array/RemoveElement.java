package com.leetcode.array;
/*
https://leetcode-cn.com/problems/remove-element/submissions/
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        if (size == 0) {
            return size;
        }

        int j = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}
