package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    private List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n < 1) {
            return result;
        }
        build("",n, n);
        return result;
    }

    private void build(String cur, Integer left, Integer right) {
        if (left == 0 && right == 0) {
            result.add(cur);
        }

        if (left > 0) {
            build(cur + "(", left - 1, right);
        }

        if (right > left) {
            build(cur + ")", left, right - 1);
        }
    }
}
