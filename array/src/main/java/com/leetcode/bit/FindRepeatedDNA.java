package com.leetcode.bit;

import java.util.*;
/*
所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/repeated-dna-sequences
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRepeatedDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        int size = s.length();
        if (size < 11) {
            return result;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        int first = 0;
        for (int i = 0; i < 10; i++) {
            first = first << 2 | map.get(s.charAt(i));
        }
        Set<Integer> list = new HashSet<>();
        list.add(first);
        int mask = (1 << 20) - 1;
        for (int i = 10; i < size; i++) {
            first = ((first << 2) & mask) | map.get(s.charAt(i));
            if (list.contains(first) && !result.contains(s.substring(i-9, i+1))) {
                result.add(s.substring(i-9, i+1));
            } else {
                list.add(first);
            }
        }

        return result;
    }
}
