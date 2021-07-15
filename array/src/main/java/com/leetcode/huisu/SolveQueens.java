package com.leetcode.huisu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-queens
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveQueens {
    private List<List<String>> result = new ArrayList<>();
    private int n;
    private Map<Integer, Boolean> map = new HashMap<>();
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        findQueen(new ArrayList<>(), 0);
        return result;
    }

    private void findQueen(List<String> cur, int row) {
        if (cur.size() == n) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (map.containsKey(i) && map.get(i)) {
                continue;
            }

            if (isValid(cur, row, i)) {
                String tmp = "";
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        tmp += "Q";
                    } else {
                        tmp += ".";
                    }
                }

                cur.add(tmp);
                map.put(i, true);
                findQueen(cur, row + 1);
                cur.remove(cur.size()-1);
                map.put(i,false);
            }
        }
    }

    private boolean isValid(List<String> cur, int row, int column) {
        for (int i = row - 1, j = column - 1; i >=0 && j>=0; j--, i--) {
            if (cur.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
            if (cur.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }
}
