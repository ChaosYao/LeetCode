package com.leetcode.string;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int length = strs.length;
        if (length < 1) {
            List<List<String>> result = new ArrayList<>();
            return result;
        }

        for (int i = 0; i < length; i++) {
            String tmp = strs[i];
            char[] chars = tmp.toCharArray();
            Arrays.sort(chars);
            String tmp1 = String.valueOf(chars);
            if (map.containsKey(tmp1)) {
                List<String> tmpList = map.get(tmp1);
                tmpList.add(tmp);
            } else {
                map.put(tmp1, new ArrayList(){{add(tmp);}});
            }
        }

        return map.entrySet().stream().map(e->e.getValue()).collect(Collectors.toList());
    }
}
