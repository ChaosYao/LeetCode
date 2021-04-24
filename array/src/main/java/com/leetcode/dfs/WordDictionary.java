package com.leetcode.dfs;

import java.util.*;

/*
请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。

实现词典类 WordDictionary ：

WordDictionary() 初始化词典对象
void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordDictionary {
    private Map<Integer, Set<String>> map;
    /** Initialize your data structure here. */
    public WordDictionary() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        int size = word.length();
        if (map.containsKey(size)) {
            map.get(size).add(word);
        } else {
            Set<String> set = new HashSet<>();
            set.add(word);
            map.put(word.length(), set);
        }
        x.pollFirst();
    }

    public boolean search(String word) {
        int size = word.length();
        if (!map.containsKey(size)) {
            return false;
        }
        for (String x : map.get(size)) {
            if (compareString(x, word)) {
                return true;
            }
        }

        return false;
    }

    private boolean compareString(String word, String target) {
        int size = word.length();
        for (int i = 0; i < size; i++) {
            if (word.charAt(i) == '.' || target.charAt(i) == '.') {
                continue;
            }

            if (word.charAt(i) != target.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
