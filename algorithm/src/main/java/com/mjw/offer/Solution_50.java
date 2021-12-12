package com.mjw.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * 剑指 Offer 50. 第一个只出现一次的字符
 */
public class Solution_50 {

    /**
     * 最笨的算法
     *
     * @param s
     * @return
     */
    public char firstUniqChar_hash(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        Iterator<Character> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Character key = iterator.next();
            if (map.get(key) == 1) {
                return key;
            }
        }
        return ' ';
    }


    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        for (char c : sc) {
            if (dic.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        Solution_50 solution = new Solution_50();
        solution.firstUniqChar_hash(s);
        System.out.println(solution.firstUniqChar(s));
    }
}
