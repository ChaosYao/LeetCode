package com.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n < 2) {
            return "1";
        }

        List<String> result = new ArrayList() {{add("1");}};
        for (int i = 2; i <= n; i++) {
            String pre = result.get(result.size()-1);
            int count = 1;
            int j = 0;
            String tmp = "";
            while(j < pre.length()) {
                if (j + 1 < pre.length() && pre.charAt(j) == pre.charAt(j+1)) {
                    count++;
                } else {
                    tmp += String.valueOf(count) + pre.charAt(j);
                    count = 1;
                }
                j++;
            }
            result.add(tmp);
        }

        return result.get(result.size()-1);
    }
}
