package com.leetcode.sort;
/*
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

 

示例

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-colors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        int m = 0;
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                m++;
            } else if (nums[i] == 1) {
                n++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i < m) {
                nums[i] = 0;
            } else if (i < m + n) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }

    }
}
