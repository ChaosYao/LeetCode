package com.leetcode.dfs;

import java.util.*;
/*
给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。

 

提示：

如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
所有的机场都用三个大写字母表示（机场代码）。
假定所有机票至少存在一种合理的行程。
所有的机票必须都用一次 且 只能用一次。
 

示例 1：

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reconstruct-itinerary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetResult {
    private List<String> result = new ArrayList<>();

    private Map<String, List<String>> map = new HashMap<>();

    private int size;

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> list : tickets) {
            if (map.containsKey(list.get(0))) {
                map.get(list.get(0)).add(list.get(1));
            } else {
                List<String> tmpList = new ArrayList<>();
                tmpList.add(list.get(1));
                map.put(list.get(0), tmpList);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            Collections.sort(list);
        }

        this.size = tickets.size() + 1;
        result.add("JFK");
        getResult("JFK");

        return result;
    }

    private boolean getResult(String key) {
        if (!map.containsKey(key) || map.get(key).size() < 1) {
            if (result.size() < size) {
                return false;
            } else {
                return true;
            }
        }

        List<String> tmpList = map.get(key);
        int listSize = tmpList.size();
        for (int i = 0; i < listSize; i++) {
            String tmpKey = tmpList.get(i);
            tmpList.remove(i);
            result.add(tmpKey);
            if (getResult(tmpKey)) {
                return true;
            }

            result.remove(result.size() - 1);
            tmpList.add(tmpKey);
            Collections.sort(tmpList);
        }

        return false;
    }
}
