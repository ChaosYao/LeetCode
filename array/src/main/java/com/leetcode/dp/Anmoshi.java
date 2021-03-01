package com.leetcode.dp;

/*
一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/the-masseuse-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Anmoshi {
    public int massage(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        }

        if (size == 1) {
            return nums[0];
        }

        if (size == 2) {
            return getMax(nums[0], nums[1]);
        }
        int[] tmpResult = new int[size];
        tmpResult[0] = nums[0];
        tmpResult[1] = getMax(nums[0], nums[1]);

        for (int i = 2; i < size; i++) {
            tmpResult[i] = getMax(tmpResult[i-1], tmpResult[i-2] + nums[i]);
        }

        return tmpResult[size - 1];
    }

    private int getMax(int i, int j) {
        return i >= j ? i : j;
    }
}
