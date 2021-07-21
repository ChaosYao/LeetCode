package com.leetcode.huisu;

import java.util.ArrayList;
import java.util.List;
/*
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。

https://leetcode-cn.com/problems/combinations/
 */
public class Combine {
    private List<List<Integer>> result = new ArrayList<>();
    private int n;
    private int k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        findCombine(new ArrayList<>(), 1);
        return result;
    }

    private void findCombine(List<Integer> cur, int start) {
        if (cur.size() == k) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i <= n; i++) {
            cur.add(i);
            findCombine(cur, i+1);
            cur.remove(cur.size()-1);
        }
    }
}
