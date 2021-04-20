package com.leetcode.dfs;

import com.leetcode.array.TreeNode;
/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.left.val >= root.val) {
            return false;
        }

        if (root.right != null && root.right.val <= root.val) {
            return false;
        }

        return compareRoot(root.val, root.left, true) && compareRoot(root.val, root.right, false)
                && isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean compareRoot(int rootVal, TreeNode node, Boolean isLeftNode) {
        if (node == null) {
            return true;
        }

        if (isLeftNode) {
            return rootVal > node.val && compareRoot(rootVal, node.left, isLeftNode)
                    && compareRoot(rootVal, node.right, isLeftNode);
        }

        return rootVal < node.val && compareRoot(rootVal, node.left, isLeftNode)
                && compareRoot(rootVal, node.right, isLeftNode);
    }
}
