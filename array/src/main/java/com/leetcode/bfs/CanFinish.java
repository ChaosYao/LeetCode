package com.leetcode.bfs;

import java.util.*;
/*
你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

 



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/course-schedule
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int size = prerequisites.length;
        if (size == 0) {
            return true;
        }


        Map<Integer, Integer> kMap = new HashMap<>();
        Map<Integer, List<Integer>> vMap = new HashMap<>();
        int result = 0;
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
            result++;
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

        return result == numCourses;
    }
}
