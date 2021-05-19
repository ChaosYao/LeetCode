package com.leetcode.sort;

public class QuickSort {
    private int[] nums;
    public void quickSort(int start, int end) {
        if (start < end) {
            int index = partition(start, end);
            quickSort(start, index - 1);
            quickSort(index + 1, end);
        }
    }

    private int partition(int start, int end) {
        int num = nums[end];
        int j = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= num) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }

        int tmp = nums[j];
        nums[j] = num;
        nums[end] = tmp;
        return j;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.nums = new int[] {2,3,4,1,5,72,3};
        quickSort.quickSort(0, 6);
        for (int x : quickSort.nums) {
            System.out.println(x);
        }
    }
}
