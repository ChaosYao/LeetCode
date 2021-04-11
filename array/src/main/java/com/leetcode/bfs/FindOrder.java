package com.leetcode.bfs;

import java.util.*;
/*
现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。

可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/course-schedule-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int size = prerequisites.length;
        int[] result = new int[numCourses];

        if (size == 0) {
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }


        Map<Integer, Integer> kMap = new HashMap<>();
        Map<Integer, List<Integer>> vMap = new HashMap<>();
        int resultSize = 0;
        for (int i = 0; i < size; i++) {
            int[] tmp = prerequisites[i];
            if (kMap.containsKey(tmp[0])) {
                int val = kMap.get(tmp[0]);
                kMap.put(tmp[0], val+1);
            } else {
                kMap.put(tmp[0], 1);
            }

            if (vMap.containsKey(tmp[1])) {
                vMap.get(tmp[1]).add(tmp[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(tmp[0]);
                vMap.put(tmp[1], list);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!kMap.containsKey(i)) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            Integer course = queue.poll();
            result[resultSize] = course;
            resultSize++;
            List<Integer> tmpList = vMap.get(course);
            if (tmpList == null || tmpList.size() == 0) {
                continue;
            }

            for (Integer v : tmpList) {
                Integer tmpValue = kMap.get(v);
                if (tmpValue == 1) {
                    kMap.put(v, 0);
                    queue.offer(v);
                }

                kMap.put(v, tmpValue-1);
            }
        }

        return resultSize == numCourses ? result : new int[0];
    }
}
