package com.leetcode.sort;
/*
给你一个 无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/insert-interval
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Insert {
    private int[][] intervals;

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] tmp = new int[intervals.length+1][2];
        for(int i = 0; i < intervals.length; i++) {
            tmp[i] = intervals[i];
        }

        tmp[intervals.length] = newInterval;
        this.intervals = tmp;
        return merge();

    }


    private int[][] merge() {
        quickSort(0, intervals.length-1);
        int index = 0;
        int[][] tmp = new int[intervals.length][2];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i-1][1]) {
                intervals[i][0] = intervals[i-1][0];
                intervals[i][1] = Math.max(intervals[i][1], intervals[i-1][1]);
            } else {
                tmp[index] = intervals[i-1];
                index++;
            }
        }

        tmp[index] = intervals[intervals.length-1];
        int[][] result = new int[index+1][2];

        for (int i = 0; i <= index; i++) {
            result[i] = tmp[i];
        }
        return result;
    }

    private void quickSort(int start, int end) {
        if (start < end) {
            int index = partition(start, end);
            quickSort(start, index - 1);
            quickSort(index + 1, end);
        }
    }

    private int partition(int start, int end) {
        int key = intervals[end][0];
        int j = start;
        for (int i = start; i < end; i++) {
            if (intervals[i][0] <= key) {
                int[] tmp = intervals[i];
                intervals[i] = intervals[j];
                intervals[j] = tmp;
                j++;
            }
        }

        int[] tmp = intervals[j];
        intervals[j] = intervals[end];
        intervals[end] = tmp;

        return j;
    }
}
