package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        String tmp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (tmp != "") {
                    list.add(tmp);
                    tmp = "";
                }
                continue;
            } else {
                tmp += s.charAt(i);
            }
        }

        if (tmp != "") {
            list.add(tmp);
        }

        for (int i = list.size() - 1; i >= 1; i--) {
            result.append(list.get(i)).append(" ");
        }

        result.append(list.get(0));
        return result.toString();
    }
}
