package com.leetcode.sort;

public class InsertSort {
    private static int[] nums;

    private static void insertSort() {
        int size = nums.length;
        for (int i = 1; i < size; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j+1] = nums[j];
                j--;
            }

            nums[j+1] = key;
        }

        return;
    }

    public static void main(String[] args) {
        nums = new int[5];
        nums[0] = 2;
        nums[1] = 3;
        nums[2] = 1;
        nums[3] = 10;
        nums[4] = 6;
        insertSort();
        for (int x : nums) {
            System.out.println(x);
        }
    }
}
