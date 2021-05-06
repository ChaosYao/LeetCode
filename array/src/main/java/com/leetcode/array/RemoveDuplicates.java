package com.leetcode.array;
/*
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if (size < 2) {
            return size;
        }

        int j = 1;
        for (int i = 1; i < size; i++) {
            if (nums[i-1] != nums[i]) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}
