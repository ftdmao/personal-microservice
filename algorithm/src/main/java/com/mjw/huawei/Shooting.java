package com.mjw.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * /*
 * 给定一个射击比赛成绩单
 * 包含多个选手若干次射击的成绩分数
 * 请对每个选手按其最高三个分数之和进行降序排名
 * 输出降序排名后的选手id序列
 * 条件如下
 * 1. 一个选手可以有多个射击成绩的分数，且次序不固定
 * 2. 如果一个选手成绩少于3个，则认为选手的所有成绩无效，排名忽略该选手
 * 3. 如果选手的成绩之和相等，则相等的选手按照其id降序排列
 * <p>
 * 输入描述:
 * 输入第一行
 * 一个整数N
 * 表示该场比赛总共进行了N次射击
 * 产生N个成绩分数
 * 2<=N<=100
 * <p>
 * 输入第二行
 * 一个长度为N整数序列
 * 表示参与每次射击的选手id
 * 0<=id<=99
 * <p>
 * 输入第三行
 * 一个长度为N整数序列
 * 表示参与每次射击选手对应的成绩
 * 0<=成绩<=100
 * <p>
 * 输出描述:
 * 符合题设条件的降序排名后的选手ID序列
 * <p>
 * 示例一
 * 输入:
 * 13
 * 3,3,7,4,4,4,4,7,7,3,5,5,5
 * 53,80,68,24,39,76,66,16,100,55,53,80,55
 * 输出:
 * 5,3,7,4
 * 说明:
 * 该场射击比赛进行了13次
 * 参赛的选手为{3,4,5,7}
 * 3号选手成绩53,80,55 最高三个成绩的和为188
 * 4号选手成绩24,39,76,66  最高三个成绩的和为181
 * 5号选手成绩53,80,55  最高三个成绩的和为188
 * 7号选手成绩68,16,100  最高三个成绩的和为184
 * 比较各个选手最高3个成绩的和
 * 有3号=5号>7号>4号
 * 由于3号和5号成绩相等  且id 5>3
 * 所以输出5,3,7,4
 */
public class Shooting {

    public static void main(String[] args) {

        int shootingCount = 13;
        int[] personIndex = {3, 3, 7, 4, 4, 4, 4, 7, 7, 3, 5, 5, 5};
        int[] scoreIndex = {53, 80, 68, 24, 39, 76, 66, 16, 100, 55, 53, 80, 55};
        sort(shootingCount, personIndex, scoreIndex);
    }

    /**
     * @param shootingCount 射击次数
     * @param personIndex   射击选手顺序
     * @param scoreIndex    射击份数顺序
     * @return
     */
    public static List<Integer> sort(int shootingCount, int[] personIndex, int[] scoreIndex) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < shootingCount; i++) {
            List<Integer> scores = map.get(personIndex[i]);
            if (scores == null) {
                scores = new ArrayList<>();
            }
            scores.add(scoreIndex[i]);
            map.put(personIndex[i], scores);
        }
        List<Integer> collect = map.entrySet().stream().filter(e -> e.getValue().size() >= 3).sorted(
                (o1, o2) -> {
                    List<Integer> list1 = o1.getValue();
                    List<Integer> list2 = o2.getValue();
                    Integer value1 = list1.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.summingInt(e -> e));
                    Integer value2 = list2.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.summingInt(e -> e));
                    if (value1.equals(value2)) {
                        return o2.getKey() - o1.getKey();
                    } else {
                        return value2.compareTo(value1);
                    }
                }
        ).map(e -> (int) (((Map.Entry) e).getKey())).collect(Collectors.toList());
        return collect;
    }


}
