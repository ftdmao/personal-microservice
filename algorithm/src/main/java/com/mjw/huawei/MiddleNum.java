package com.mjw.huawei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述：
 * <p>
 * 众数是指一组数据中出现次数多的数，众数可以是多个。
 * 中位数是指把一组数据从小到大排列，最中间的那个数；如果这组数据的个数是奇数，那最中间那个就是中位数；如果这组数据的个数为偶数，那就把中间的两个数之和除以2就是中位数。
 * 查找整型数组中元素的众数并组成一个新的数组，求新数组的中位数。
 * 输入描述：
 * <p>
 * 输入一个一维整型数组，数组大小取值范围 0<n<1000
 * 数组中每个元素取值范围， 0<e<1000
 * 输出描述：
 * <p>
 * 输出众数组成的新数组的中位数。
 * ————————————————
 */
public class MiddleNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        String[] arrStr = in.split(" ");

        /**
         * 统计每个数字出现的次数
         */
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : arrStr) {
            int value = Integer.parseInt(s);
            Integer count = map.getOrDefault(value, 0);
            map.put(value, ++count);
        }

        /**
         * 找出众数，添加到新的数组中
         */
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int max = 0;
        Map<Integer, ArrayList<Integer>> resultMap = new HashMap();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue() >= max) {
                if (next.getValue() > max) {
                    resultMap.clear();
                }
                max = next.getValue();
                ArrayList<Integer> orDefault = resultMap.getOrDefault(max, new ArrayList<>());
                orDefault.add(next.getKey());
                resultMap.put(max, orDefault);
            }
        }

        /**
         * 从众数数组中算出中位数
         */
        Map.Entry<Integer, ArrayList<Integer>> next = resultMap.entrySet().iterator().next();
        ArrayList<Integer> value = next.getValue();
        value.sort(Comparator.comparing(e -> e));
        double result = 0;
        if (value.size() % 2 == 0) {
            result = (value.get(value.size() / 2 - 1) + value.get(value.size() / 2)) / 2;
        } else {
            result = value.get(value.size() / 2);
        }

        /**
         * 输出
         */
        String s = String.valueOf(result);
        System.out.println(s.replace(".0", ""));
    }


}
