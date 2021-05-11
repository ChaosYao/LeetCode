package com.leetcode.array;

import java.util.Arrays;
/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum-closest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumCloseSet {
    public int threeSumClosest(int[] nums, int target) {
        int min = 10 * 10 * 10 * 10;
        int result = nums[0] + nums[1] + nums[2];
        int size = nums.length;
        if (size == 3) {
            return nums[0] + nums[1] + nums[2];
        }

        Arrays.sort(nums);
        for (int i = 0; i < size; i++) {
            int j = i + 1;
            int k = size - 1;
            while(j < k) {
                int count = nums[j] + nums[k] + nums[i];
                if (Math.abs(count - target) < min) {
                    min = Math.abs(count - target);
                    result = count;
                }

                if (count < target) {
                    j++;
                } else if (count > target) {
                    k--;
                } else {
                    return count;
                }
            }
        }

        return result;
    }
}
