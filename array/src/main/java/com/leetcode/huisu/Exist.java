package com.leetcode.huisu;

import java.util.ArrayList;
import java.util.List;

/*
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exist {
    private int[][] mem;
    private boolean result = false;
    private String word;
    private char[][] board;
    public boolean exist(char[][] board, String word) {
        List<String> x= new ArrayList<>();
        int length = board.length;
        int size = board[0].length;
        this.word = word;
        this.board = board;
        mem = new int[length][size];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == word.charAt(0)) {
                    mem[i][j] = 1;
                    findExist(String.valueOf(board[i][j]), i, j, 0);
                    mem[i][j] = 0;
                    if (result) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void findExist(String cur, int row, int column, int index) {
        if (index == word.length() - 1) {
            result = cur.equals(word);
            return;
        }

        if (row + 1 < board.length && mem[row+1][column] == 0
                && board[row+1][column] == word.charAt(index+1)) {
            mem[row+1][column] = 1;
            findExist(cur + board[row+1][column], row+1, column, index + 1);
            mem[row+1][column] = 0;
        }

        if (!result && column - 1 >= 0 && mem[row][column-1] == 0
                && board[row][column-1] == word.charAt(index+1)) {
            mem[row][column-1] = 1;
            findExist(cur + board[row][column-1], row, column-1, index + 1);
            mem[row][column-1] = 0;
        }

        if (!result && column + 1 < board[0].length && mem[row][column+1] == 0
                && board[row][column+1] == word.charAt(index+1)) {
            mem[row][column+1] = 1;
            findExist(cur + board[row][column+1], row, column+1, index + 1);
            mem[row][column+1] = 0;
        }

        if (!result && row - 1 >= 0 && mem[row-1][column] == 0
                && board[row-1][column] == word.charAt(index+1)) {
            mem[row-1][column] = 1;
            findExist(cur + board[row-1][column], row-1, column, index + 1);
            mem[row-1][column] = 0;
        }
    }
}
