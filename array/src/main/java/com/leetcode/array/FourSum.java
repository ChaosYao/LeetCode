package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

注意：答案中不可以包含重复的四元组。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/4sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        if (size < 4) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < size; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            for (int j = i + 1; j < size; j++) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int m = j + 1;
                int n = size - 1;

                while(m < n) {
                    int count = nums[i] + nums[j] + nums[m] +nums[n];
                    if (count < target) {
                        m++;
                    } else if (count > target) {
                        n--;
                    } else {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[m]);
                        tmp.add(nums[n]);
                        result.add(tmp);

                        while(m < n && nums[m] == nums[m+1]) {
                            m++;
                        }

                        while(m < n && nums[n] == nums[n-1]) {
                            n--;
                        }

                        m++;
                        n--;
                    }

                }
            }
        }

        return result;
    }
}
