package com.leetcode.array;

import java.util.Arrays;
/*
实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须 原地 修改，只允许使用额外常数空间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextPermutation {
    private int[] nums;
    public void nextPermutation(int[] nums) {
        int size = nums.length;
        if (size < 2) {
            return;
        }

        this.nums = nums;
        for (int i = size - 1; i >= 1; i--) {
            if (nums[i] > nums[i-1]) {
                for (int j = size-1; j >= i; j--) {
                    if (nums[j] > nums[i-1]) {
                        swapNum(j, i-1);
                        Arrays.sort(nums, i, size);
                        return;
                    }
                }
            }
        }

        int i = 0;
        int j = size - 1;
        while(i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }

        return;
    }

    private void swapNum(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
