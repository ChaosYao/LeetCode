package com.leetcode.bit;
/*
给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。

 

进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/single-number-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber2 {
    public int[] singleNumber(int[] nums) {
        int tmp = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            tmp ^= nums[i];
        }

        int j = 0;
        for (; j <= 31; j++) {
            if ((tmp >> j & 1) == 1) {
                break;
            }
        }

        int sign = 1 << j;
        int a = 0;
        int b = 0;
        for (int i = 0; i < size; i++) {
            if ((nums[i] & sign) == sign) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }

        return new int[] {a, b};
    }
}
