package com.mjw.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 *
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 *
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 示例 2：
 *
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 105
 * s[i]=='A'、'C'、'G' or 'T'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/repeated-dna-sequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode187 {

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s).size());
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        int length = s.length();
        if (length < 10) {
            return result;
        }
        int left = 0;
        int right = 9;
        Map<String, Integer> map = new HashMap<>();
        while (right < length) {
            String window = s.substring(left, right+1);
            if (map.containsKey(window)) {
                Integer count = map.get(window);
                map.put(window, ++count);
            } else {
                map.put(window, 1);
            }
            left++;
            right++;
        }
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> next = it.next();
            if (next.getValue() > 1) {
                result.add(next.getKey());
            }
        }
        return result;
    }

}
