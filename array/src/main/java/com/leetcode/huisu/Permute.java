package com.leetcode.huisu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
https://leetcode-cn.com/problems/permutations/
 */
public class Permute {
    private List<List<Integer>> result = new ArrayList<>();
    private Map<Integer, Boolean> map = new HashMap<>();
    private int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        initMap();
        find(new ArrayList());
        return result;
    }

    private void initMap() {
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], false);
        }
    }

    private void find(List<Integer> cur) {
        boolean sign = true;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i])) {
                continue;
            }

            sign = false;
            map.put(nums[i], true);
            cur.add(nums[i]);
            find(cur);
            map.put(nums[i], false);
            cur.remove(cur.size()-1);
        }

        if (sign) {
            result.add(new ArrayList<>(cur));
        }
    }
}
