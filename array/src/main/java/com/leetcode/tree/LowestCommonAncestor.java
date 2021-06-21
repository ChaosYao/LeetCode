package com.leetcode.tree;

import com.leetcode.array.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    List<TreeNode> pList = new ArrayList<>();
    List<TreeNode> qList = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, true);
        find(root, q, false);
        int size = pList.size();
        int size1 = qList.size();
        for (int i = 0; i < size; i++) {
            if (i >= qList.size()) {
                return pList.get(size-i);
            }

            if (pList.get(size - i - 1).val != qList.get(size1 - 1 - i).val) {
                return pList.get(size-i);
            }
        }

        return pList.get(0);
    }

    private boolean find(TreeNode root, TreeNode f, Boolean sign) {
        if (root == null) {
            return false;
        }

        if (root.val == f.val) {
            if (sign) {
                pList.add(root);
            } else {
                qList.add(root);
            }

            return true;
        }

        if (find(root.left, f, sign)) {
            if (sign) {
                pList.add(root);
            } else {
                qList.add(root);
            }
            return true;
        }

        if(find(root.right, f, sign)) {
            if (sign) {
                pList.add(root);
            } else {
                qList.add(root);
            }
            return true;
        }

        return false;
    }
}
