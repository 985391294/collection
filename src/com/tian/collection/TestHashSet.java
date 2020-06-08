package com.tian.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: tian
 * @Date: 2020/3/16 15:26
 * @Desc: 底层调用的HashMap    （没有顺序，不可重复）
 */
public class TestHashSet {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("aa");
        set.add("cc");
        
        System.out.println(set);

        set.remove("cc");
        System.out.println(set);
        
        Set<String> set1 = new HashSet<>();
        set1.add("dd");
        set.addAll(set1);
        System.out.println(set);
    }
}
