package com.leetcode.huisu;

import java.util.ArrayList;
import java.util.List;

public class FindPartition {
    private List<List<String>> result = new ArrayList<>();
    private String s;
    private Integer size;
    public List<List<String>> partition(String s) {
        this.s = s;
        this.size = s.length();
        findPartition(0, new ArrayList<>());
        return result;
    }

    private void findPartition(int start, List<String> cur) {
        if (start >= size) {
            result.add(new ArrayList(cur));
            return;
        }

        for (int i = start + 1; i <= size; i++) {
            String tmp = s.substring(start, i);
            if (!isReverse(tmp)) {
                continue;
            }

            cur.add(tmp);
            findPartition(i, cur);
            cur.remove(cur.size()-1);
        }
    }

    private boolean isReverse(String x) {
        if (x.length() == 1) {
            return true;
        }

        int length = x.length();
        int i = 0;
        int j = length-1;
        while(i < j) {
            if (x.charAt(i) != x.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
