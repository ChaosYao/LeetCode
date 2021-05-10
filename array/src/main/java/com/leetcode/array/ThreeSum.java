package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }

            int start = i + 1;
            int end = size - 1;
            while(start < end) {
                if (nums[start] + nums[end] < -1 * nums[i]) {
                    start++;
                } else if (nums[start] + nums[end] > -1 * nums[i]) {
                    end--;
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[start]);
                    tmp.add(nums[end]);
                    result.add(tmp);
                    while(start < end && nums[start] == nums[start+1]) {
                        start++;
                    }

                    while(start < end && nums[end] == nums[end-1]) {
                        end--;
                    }
                    start++;
                    end--;
                }
            }
        }

        return result;
    }
}
