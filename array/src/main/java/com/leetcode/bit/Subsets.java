package com.leetcode.bit;

import java.util.ArrayList;
import java.util.List;
/*
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList());
        for (int i = 0; i < size; i++) {
            List<List<Integer>> tmpList = new ArrayList<>();
            for (List<Integer> list : result) {
                List<Integer> tmp = new ArrayList<>(list);
                tmp.add(nums[i]);
                tmpList.add(tmp);
            }

            result.addAll(tmpList);
        }

        return result;
    }
}
