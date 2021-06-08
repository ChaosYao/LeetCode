package com.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    private Map<String, Integer> map = new HashMap<>();

    public int romanToInt(String s) {
        init();
        int size = s.length();
        if (size < 1) {
            return 0;
        }

        int i = 0;
        int result = 0;
        while(i < size) {
            char c = s.charAt(i);
            Integer cur = map.get(String.valueOf(c));
            if (i+1 < size && cur < map.get(String.valueOf(s.charAt(i+1)))) {
                result += map.get(String.valueOf(s.charAt(i+1))) - cur;
                i+=2;
                continue;
            }

            result += cur;
            i++;
        }

        return result;
    }

    private void init() {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }
}
