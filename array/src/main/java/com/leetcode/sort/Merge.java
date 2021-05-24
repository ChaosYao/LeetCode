package com.leetcode.sort;
/*
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

 



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Merge {
    private int[][] intervals;
    public int[][] merge(int[][] intervals) {
        this.intervals = intervals;
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
