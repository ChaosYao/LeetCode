package com.leetcode.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1：



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {
    private List<List<Integer>> result = new ArrayList<>();

    private int[] candidates;

    private Integer target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        findSum(new ArrayList(), 0, 0);
        return result;
    }

    private void findSum(List<Integer> cur, Integer sum, int start) {
        if (sum.equals(target)) {
            result.add(new ArrayList<>(cur));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start;i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            sum += candidates[i];
            cur.add(candidates[i]);
            findSum(cur, sum, i);
            sum -= candidates[i];
            cur.remove(cur.size()-1);
        }
    }
}
