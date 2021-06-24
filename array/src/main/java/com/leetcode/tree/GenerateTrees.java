package com.leetcode.tree;

import com.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。


https://leetcode-cn.com/problems/unique-binary-search-trees-ii/

 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1,n);
    }


    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i-1);
            List<TreeNode> rights = generateTrees(i+1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    result.add(node);
                }
            }
        }

        return result;
    }
}
