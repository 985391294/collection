package com.tian.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: tian
 * @Date: 2020/3/16 16:19
 * @Desc: Collections工具类
 */
public class TestCollections {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add("tian" + i);
        }
        System.out.println(list);

        Collections.shuffle(list); //随机排序
        System.out.println(list);

        Collections.reverse(list); //逆序排列
        System.out.println(list);
        
        Collections.sort(list); //正常排序递增
        System.out.println(list);
    }
}
