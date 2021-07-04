package com.leetcode.listnode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> store = new ArrayDeque<>();
        int length = path.length();
        if (length < 1) {
            return "/";
        }

        String[] paths = path.split("/");
        for (String x : paths) {
            if (x.equals(".") || x.equals("")) {
                continue;
            } else if (x.equals("..")) {
                if (!store.isEmpty()) {
                    store.pollLast();
                }
            } else {
                store.offerLast(x);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String str : store) {
            result.append("/").append(str);
        }

        return result.toString().length() < 1 ? "/" : result.toString();
    }
}
