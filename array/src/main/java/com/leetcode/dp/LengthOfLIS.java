package com.leetcode.dp;
/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        if (size < 2) {
            return size;
        }

        int[] tmpResult = new int[size];
        int max = 0;
        for (int i = 0; i < size; i++) {
            tmpResult[i] = 1;
        }

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    tmpResult[i] = Math.max(tmpResult[i], tmpResult[j] + 1);
                }
            }

            if (tmpResult[i] > max) {
                max = tmpResult[i];
            }
        }

        return max;
    }
}

/*
dp[n]  = max(dp[n-a]) + 1  where x[n] > x[a]
空间复杂度 O(n) 时间复杂度O（N^2）

二分法可以实现时间复杂度O(logN)，由于主要思想不是动态规划 ，这里就不编写了
主要思想就是将值放入数组中，通过二分法寻找与其最接近，并且大于它的值进行替换，如果没有则将值放入数组中，最后计算出数组长度
*/
