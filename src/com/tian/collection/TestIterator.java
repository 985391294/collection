package com.tian.collection;

import java.util.*;

/**
 * @Author: tian
 * @Date: 2020/3/16 15:32
 * @Desc:
 */
public class TestIterator {

    public static void main(String[] args) {
//        testIteratorList();
//        testIteratorSet();
        testIteratorMap();
    }

    public static void testIteratorList(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");

        for (Iterator<String> iterator = list.iterator();iterator.hasNext();){
            String next = iterator.next();
            System.out.println(next);
        }
    }

    public static void testIteratorSet(){
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        set.add("dd");

        for (Iterator<String> iterator = set.iterator();iterator.hasNext();){
            String next = iterator.next();
            System.out.println(next);
        }
    }

    public static void testIteratorMap(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"aa");
        map.put(2,"bb");
        map.put(3,"cc");
        map.put(4,"dd");

        //第一种遍历的方式
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Iterator<Map.Entry<Integer,String>> iterator = entries.iterator();iterator.hasNext();){
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + "  " + next.getValue());
        }
        //第二种遍历的方式
        Set<Integer> integers = map.keySet();
        for(Iterator<Integer> iterator = integers.iterator();iterator.hasNext();){
            Integer key = iterator.next();
            System.out.println(key + "  " + map.get(key));
        }
    }
}
