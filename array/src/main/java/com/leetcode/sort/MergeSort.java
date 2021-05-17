package com.leetcode.sort;

public class MergeSort {

    private static int[] nums;

    private static void mergeSort(int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        mergeSort(start, mid);
        mergeSort(mid+1, end);
        mergeTwo(start, mid, end);
    }

    private static void mergeTwo(int start, int mid, int end) {
        if (start >= end) {
            return;
        }
        int size1 = mid - start + 1;
        int size2 = end - mid;

        int[] tmp1 = new int[size1];
        int[] tmp2 = new int[size2];

        for (int i = 0; i < size1; i++) {
            tmp1[i] = nums[start + i];
        }

        for (int i = 0; i < size2; i++) {
            tmp2[i] = nums[mid + i + 1];
        }

        int m = 0;
        int n = 0;
        for (int i = start; i <= end; i++) {
            if (m >= size1) {
                nums[i] = tmp2[n];
                n++;
            } else if (n >= size2) {
                nums[i] = tmp1[m];
                m++;
            } else if (tmp1[m] <= tmp2[n]) {
                nums[i] = tmp1[m];
                m++;
            } else if (tmp1[m] > tmp2[n]) {
                nums[i] = tmp2[n];
                n++;
            }
        }
    }

    public static void main(String[] args) {
        nums = new int[7];
        nums[0] = 2;
        nums[1] = 3;
        nums[2] = 9;
        nums[3] = 8;
        nums[4] = 6;
        nums[5] = 1;
        nums[6] = 10;
        mergeSort(0, 6);

        for (int i : nums) {
            System.out.println(i);
        }
    }

}
