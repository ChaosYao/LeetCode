package com.leetcode.sort;

public class CountingSort {
    private int[] nums;

    private void countingSort() {
        int[] b = new int[73];
        int[] c = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            b[nums[i]] = b[nums[i]] + 1;
        }

        for (int i = 1; i < 73; i++) {
            b[i] += b[i-1];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            c[b[nums[i]]-1] = nums[i];
            b[nums[i]] = b[nums[i]] - 1;
        }
        nums = c;
    }

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        countingSort.nums = new int[] {7,4,12,3,5,6,62,3,5,6,72,6,6};
        countingSort.countingSort();
        for (int i : countingSort.nums) {
            System.out.println(i);
        }

    }
}
