package com.leetcode.listnode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。

有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。

 



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/restore-ip-addresses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RestoreIpAddresses {
    private Set<String> result = new HashSet<>();
    public List<String> restoreIpAddresses(String s) {
        int length = s.length();
        if (length < 4 || length > 12) {
            return new ArrayList<String>(result);
        }

        if (s.charAt(0) == '0') {
            findIp(1, s, "0");
        } else {
            for (int i = 0; i < 3; i++) {
                String tmp = s.substring(0, i+1);
                if (Integer.valueOf(tmp) > 255) {
                    break;
                }

                findIp(i+1, s, tmp);
            }
        }

        return new ArrayList<String>(result);
    }

    private void findIp(Integer pos, String s, String pre) {
        if (pos == s.length()) {
            if (pre.split("\\.").length == 4) {
                result.add(pre);
            }
            return;
        }

        if (pos < s.length() && s.charAt(pos) == '0') {
            findIp(pos + 1, s, pre + "." + "0");
            return;
        }

        for (int i = pos; i < (s.length() - pos < 4 ? s.length() : pos + 3); i++) {
            String tmp = s.substring(pos, i+1);
            if (Integer.valueOf(tmp) > 255) {
                break;
            }

            findIp(i+1, s, pre + "." + tmp);
        }
    }
}
