package com.leetcode.dp;

/*
当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：

若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。

返回 A 的最大湍流子数组的长度

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-turbulent-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxTurbulenceSize {
    public int maxTurbulenceSize(int[] arr) {
        int size = arr.length;
        if (size < 1) {
            return size;
        }

        if (size == 2) {
            return arr[1] != arr[0] ? 2 : 1;
        }

        int tmpResult = 2;
        int max = 1;
        for (int i = 2; i < size; i++) {
            if (arr[i] == arr[i-1]) {
                tmpResult = 1;
            } else if (arr[i-1] == arr[i-2]) {
                tmpResult = 2;
            } else if ((arr[i-1] > arr[i-2]) != (arr[i] > arr[i-1])) {
                tmpResult++;
            } else {
                tmpResult = 2;
            }

            if (tmpResult > max) {
                max = tmpResult;
            }
        }

        return max;
    }

}

/*
要考虑相等这个corner case
 */