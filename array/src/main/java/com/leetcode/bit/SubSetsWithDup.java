package com.leetcode.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class SubSetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList());
        int count = 1;
        for (int i = 0; i < size; i++) {
            List<List<Integer>> tmpList = new ArrayList<>();
            if (i > 0 && nums[i-1] == nums[i]) {
                count++;
            } else {
                count = 1;
            }

            int length = result.size();
            int stop = length - length / count;
            for (int j = length-1; j >= stop;j--) {
                List<Integer> tmp = new ArrayList<>(result.get(j));
                tmp.add(nums[i]);
                tmpList.add(tmp);
            }

            result.addAll(tmpList);
        }

        return result;
    }
}
