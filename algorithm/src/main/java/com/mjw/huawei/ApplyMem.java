package com.mjw.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述：
 * <p>
 * 有一个简易内存池，内存按照大小粒度分类，每个粒度有若干个可用内存资源，用户会进行一系列内存申请，需要按需分配内存池中的资源，返回申请结果成功失败列表。
 * 分配规则如下：
 * 分配的内存要大于等于内存申请量，存在满足需求的内存就必须分配，优先分配粒度小的，但内存不能拆分使用。
 * 需要按申请顺序分配，先申请的先分配。
 * 有可用内存分配则申请结果为true，没有可用内存分配则返回false。
 * 注：不考虑内存释放。
 * <p>
 * 输入描述:
 * <p>
 * 第一行为内存池资源列表，包含内存粒度数据信息，粒度数据间用逗号分割，一个粒度信息内部用冒号分割，冒号前为内存粒度大小，冒号后为数量。资源列表不大于1024，每个粒度的数量不大于4096。
 * <p>
 * 第二行为申请列表，申请的内存大小间用逗号分隔。申请列表不大于100000。
 * <p>
 * 如：
 * <p>
 * 64:2,128:1,32:4,1:128
 * 50,36,64,128,127
 * 1
 * 2
 * 输出描述:
 * <p>
 * 输出为内存池分配结果。
 * <p>
 * 如：
 * <p>
 * true,true,true,false,false
 * 1
 * 示例
 * <p>
 * 输入：
 * <p>
 * 64:2,128:1,32:4,1:128
 * 50,36,64,128,127
 * 1
 * 2
 * 输出：
 * <p>
 * true,true,true,false,false
 * 1
 * 说明：
 * <p>
 * 内存池资源包含：64K共2个、128K共1个、32K共4个、1K共128个的内存资源；
 * <p>
 * 针对50,36,64,128,127的内存申请序列，分配的内存依次是：64,64,128,NULL,NULL,
 * <p>
 * 第三次申请内存时已经将128分配出去，因此输出结果是：
 * <p>
 * true,true,true,false,false
 * ————————————————
 * 版权声明：本文为CSDN博主「JOEL-T99」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_47243236/article/details/123465713
 */
public class ApplyMem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(",");
        List<Integer> list = new ArrayList<>();
        for (String s1 : split) {
            String[] temp = s1.split("\\:");
            for (int i = 0; i < Integer.parseInt(temp[1]); i++) {
                list.add(Integer.parseInt(temp[0]));
            }

        }
        int[] memList = new  int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            memList[i] = list.get(i);
        }
        Arrays.sort(memList);

        String applyListStr = scanner.nextLine();
        String[] applyStr = applyListStr.split(",");
        int[] applyList = new int[applyStr.length];
        for (int i = 0; i < applyStr.length; i++) {
            applyList[i] = Integer.parseInt(applyStr[i]);
        }
        Arrays.sort(applyList);

        List<Boolean> booleans = applyMem(memList, applyList);
        if (booleans.size() > 0) {
            StringBuilder result = new StringBuilder();
            result.append(booleans.get(0));
            for (int i = 1; i < booleans.size(); i++) {
                result.append("," + booleans.get(i));
            }
            System.out.println(result.toString());
        }
    }

    /**
     * @param memList   拥有的内存块
     * @param applyList 需要申请的内存空间列表
     */
    public static List<Boolean> applyMem(int[] memList, int[] applyList) {
        List<Boolean> result = new ArrayList<>();
        outerLook:for (Integer applyMen : applyList) {
            for (int i = 0; i < memList.length; i++) {
                if (applyMen.compareTo(memList[i]) < 0) {
                    memList[i] = 0;
                    result.add(true);
                    continue outerLook;
                }
            }
            result.add(false);
        }
        return result;
    }


}
