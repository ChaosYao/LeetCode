package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinations {
    private List<String> result = new ArrayList<>();
    Map<String, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() < 1) {
            return result;
        }

        init();
        findParam("", digits);
        return result;
    }

    private void init() {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
    }

    private void findParam(String str, String digits) {
        if (digits == null || digits.length() < 1) {
            result.add(str);
            return;
        }

        String oneHalf = String.valueOf(digits.charAt(0));
        String twoHalf = digits.substring(1, digits.length());
        String params = map.get(oneHalf);
        for (char c : params.toCharArray()) {
            findParam(str + c, twoHalf);
        }
    }
}
