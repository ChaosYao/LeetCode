package com.leetcode.dfs;

import com.leetcode.array.TreeNode;
/*
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedArrayToBST {
    private int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        int size = nums.length;
        if (size == 1) {
            return new TreeNode(nums[0]);
        }

        this.nums = nums;
        int central = size % 2 == 1 ? (size - 1) / 2 : size / 2;
        TreeNode result = new TreeNode(nums[central]);
        result.left = buildNode(0, central - 1);
        result.right = buildNode(central + 1, size - 1);

        return result;
    }

    private TreeNode buildNode(int start, int end) {
        if (start > end) {
            return null;
        }

        int size = end - start + 1;
        int central = size % 2 == 1 ? (size - 1) / 2 : size / 2;
        central += start;
        TreeNode result = new TreeNode(nums[central]);
        result.left = buildNode(start, central - 1);
        result.right = buildNode(central + 1, end);
        return result;
    }
}
