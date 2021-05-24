package com.leetcode.sort;

public class BubbleSort {
    private int[] nums;

    private void bulleSort() {
        int size = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            boolean hasSort = true;
            for (int j = nums.length - 1; j > 0; j--) {
                if (nums[j] < nums[j-1]) {
                    hasSort = false;
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                }
            }
            if (hasSort) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.nums = new int[] {6,5,4,3,2,1};
        bubbleSort.bulleSort();
        for (int x : bubbleSort.nums) {
            System.out.println(x);
        }
    }
}
