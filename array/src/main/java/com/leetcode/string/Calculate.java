package com.leetcode.string;

import java.util.Deque;
import java.util.LinkedList;
/*
给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

整数除法仅保留整数部分。

 https://leetcode-cn.com/problems/basic-calculator-ii/
 */
public class Calculate {
    public int calculate(String s) {
        s = s.trim();
        Deque<Integer> numQue = new LinkedList<>();
        Deque<Character> strQue = new LinkedList<>();
        int i = 0;
        String tmp = "";
        while(i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                ;
            } else if (c == '-' || c == '+') {
                numQue.offerLast(Integer.valueOf(tmp));
                strQue.offerLast(c);
                tmp = "";
            } else if (c == '/' || c == '*') {
                int tmpNum = Integer.valueOf(tmp);
                i++;
                while(s.charAt(i) == ' ') {
                    i++;
                }

                String intTmp = "";
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    intTmp += s.charAt(i);
                    i++;
                }

                if (c == '/') {
                    tmp = String.valueOf(tmpNum / Integer.valueOf(intTmp));
                } else {
                    tmp = String.valueOf(tmpNum * Integer.valueOf(intTmp));
                }
                continue;
            } else {
                tmp += c;
            }

            i++;
        }

        if(tmp != "") {
            numQue.offer(Integer.valueOf(tmp));
        }

        while(!strQue.isEmpty()) {
            int numOne = numQue.pollFirst();
            int numTwo = numQue.pollFirst();
            Character sign = strQue.pollFirst();
            if (sign == '+') {
                numQue.offerFirst(numOne + numTwo);
            } else {
                numQue.offerFirst(numOne - numTwo);
            }
        }

        return numQue.pollLast();
    }
}
