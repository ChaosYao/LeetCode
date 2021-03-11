package com.leetcode.dp;

import java.util.List;
/*
给定一个三角形 triangle ，找出自顶向下的最小路径和。

每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/triangle
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 1) {
            return triangle.get(0).get(0);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < size; i ++) {
            List<Integer> tmp = triangle.get(i);
            List<Integer> lastTmp = triangle.get(i-1);
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    tmp.set(j, lastTmp.get(j) + tmp.get(j));
                } else if (j == i) {
                    tmp.set(j, lastTmp.get(j-1) + tmp.get(j));
                } else {
                    tmp.set(j, Math.min(lastTmp.get(j-1), lastTmp.get(j)) + tmp.get(j));
                }

                if (i == size - 1 && tmp.get(j) < min) {
                    min = tmp.get(j);
                }
            }
            triangle.set(i, tmp);
        }

        return min;
    }
}
/*
时间换空间了
 */
