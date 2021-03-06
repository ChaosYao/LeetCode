package com.leetcode.dp;
/*
一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：

'A' -> 1
'B' -> 2
...
'Z' -> 26
要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。

给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。

题目数据保证答案肯定是一个 32 位 的整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decode-ways
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumDecodings {
    public int numDecodings(String s) {
        int size = s.length();
        if (size == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[size+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 1; i < size; i++) {
            int combinedValue = Integer.parseInt(s.substring(i-1,i+1));
            if (combinedValue == 0 || (s.charAt(i) == '0' && combinedValue > 27)) {
                return 0;
            }

            if (s.charAt(i) == '0' && combinedValue < 27) {
                dp[i+1] = dp[i-1];
            } else if (s.charAt(i-1) != '0' && combinedValue < 27) {
                dp[i+1] += dp[i-1] + dp[i];
            } else {
                dp[i+1] = dp[i];
            }
        }

        return dp[size];
    }
}
