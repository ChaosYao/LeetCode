package com.leetcode.huisu;

import java.util.*;
/*
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。


https://leetcode-cn.com/problems/permutations-ii/
 */
public class Permute1 {
    private List<List<Integer>> result = new ArrayList<>();
    private Map<Integer, Integer> map = new HashMap<>();
    private int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        initMap();
        find(new ArrayList());
        return result;
    }

    private void initMap() {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }
    }

    private void find(List<Integer> cur) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 0 || (i > 0 && nums[i-1] == nums[i])) {
                continue;
            }

            map.put(nums[i],map.get(nums[i])-1);
            cur.add(nums[i]);
            find(cur);
            map.put(nums[i], map.get(nums[i])+1);
            cur.remove(cur.size()-1);
        }
    }
}
