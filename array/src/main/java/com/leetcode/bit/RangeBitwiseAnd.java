package com.leetcode.bit;
/*
给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

区间内的数字，相同的前缀会留下，其余都为0，并且在之后的操作中也一直为0.随着相同的前缀越来越少，相与的结果也会越来越小，随着不断的进位，后面的位一定会为0
 */
public class RangeBitwiseAnd {
    public int rangeBitwiseAnd(int left, int right) {
        int result = left;
        for (int i = left+1; i>= 0 && i <= right; i++) {
            if(result == 0) {
                return 0;
            }

            result &= i;
        }

        return result;
    }

    public int rangeBitwiseAndBest(int left, int right) {
        int i = 0;
        while(left != right) {
            left >>= 1;
            right >>= 1;
            i++;
        }

        return left << i;
    }
}
