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
        nums = new int[] {2,3,1,10,6};
        insertSort();
        for (int x : nums) {
            System.out.println(x);
        }
    }
}
