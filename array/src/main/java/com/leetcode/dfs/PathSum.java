package com.leetcode.dfs;

import com.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

叶子节点 是指没有子节点的节点。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum {
    private List<List<Integer>> result = new ArrayList<>();
    private int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return result;
        }

        this.targetSum = targetSum;
        if (root.left == null && root.right ==null) {
            if (root.val == targetSum) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(targetSum);
                result.add(tmp);
            }

            return result;
        }

        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(root.val);
        sumNode(root.left, tmpList, root.val);
        sumNode(root.right, tmpList, root.val);

        return result;
    }

    private void sumNode(TreeNode node, List<Integer> list, Integer sum) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (sum + node.val == targetSum) {
                list.add(node.val);
                result.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        list.add(node.val);
        sumNode(node.left, list, sum + node.val);
        sumNode(node.right, list, sum + node.val);
        list.remove(list.size()-1);
    }
}
