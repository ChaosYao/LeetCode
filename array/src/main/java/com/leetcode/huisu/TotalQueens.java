package com.leetcode.huisu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalQueens {
    private int result = 0;
    private int n;
    private Map<Integer, Boolean> map = new HashMap<>();

    public int totalNQueens(int n) {
        this.n = n;
        findQueen(new ArrayList<>(), 0);
        return result;
    }

    private void findQueen(List<String> cur, int row) {
        if (cur.size() == n) {
            result++;
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
