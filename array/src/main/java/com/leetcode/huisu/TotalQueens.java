package com.leetcode.huisu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TotalQueens {
    private int result = 0;
    private int n;
    Map<Integer, Integer> map = new HashMap<>();
    public int totalNQueens(int n) {
        this.n = n;
        init();
        findQueen(0);
        return result;
    }

    private void init() {
        for (int i = 0; i < n; i++) {
            map.put(i, -1);
        }
    }

    private void findQueen(int row) {
        if (row == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (map.get(i) != -1 || !isValidQueen(row, i)) {
                continue;
            }

            map.put(i, row);
            findQueen(row + 1);
            map.put(i, -1);
        }
    }

    private boolean isValidQueen(int row, int column) {
        for (int i = row - 1, j = column - 1; i >=0 && j >= 0 ; i--, j--) {
            if (map.get(j) == i) {
                return false;
            }
        }

        for (int i = row - 1, j = column + 1; i >=0 && j < n; i--, j++) {
            if (map.get(j) == i) {
                return false;
            }
        }

        return true;
    }
}
