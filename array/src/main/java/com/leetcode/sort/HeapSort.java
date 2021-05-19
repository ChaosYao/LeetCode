package com.leetcode.sort;

public class HeapSort {
    private int[] nums;
    private int size;
    private void maxHeapify(int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest;
        if (l < size && nums[i] <= nums[l]) {
            largest = l;
        } else {
            largest = i;
        }

        if (r < size && nums[largest] <= nums[r]) {
            largest = r;
        }

        if (i != largest) {
            int tmp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = tmp;
            maxHeapify(largest);
        }
    }

    private void buildMaxHeap() {
        int start = size % 2 == 0 ? size/2 - 1: size/2;
        for (int i = start; i >= 0; i--) {
            maxHeapify(i);
        }
    }

    private void sort() {
        buildMaxHeap();
        for (int i = size - 1; i >= 1; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            size--;
            maxHeapify(0);
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.nums = new int[] {1,4,51,2,3,45,6,7,1,23,4,5};
        heapSort.size = heapSort.nums.length;
        heapSort.sort();
        for (int x : heapSort.nums) {
            System.out.println(x);
        }
    }


}
