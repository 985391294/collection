package com.tian.collection;

import java.util.*;

/**
 * @Author: tian
 * @Date: 2020/3/16 15:54
 * @Desc: 测试各种循环遍历
 */
public class TestRepeat {

    public static void main(String[] args) {
//        testList();
//        testSet();
        testMap();
    }

    /**
     * 遍历list的四种方法
     */
    public static void testList(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        System.out.println("=======第一种======");
        //遍历list的第一种方法(普通for循环)
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println("=======第二种======");
        //遍历list的第二种方法(增强for循环)
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("=======第三种======");
        //遍历list的第二种方法(迭代器iterator)
        for (Iterator<String> iterator = list.iterator();iterator.hasNext();){
            String next = iterator.next();
            System.out.println(next);
        }
        System.out.println("=======第四种======");
        //遍历list的第四种方法(迭代器2)
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }

    public static void testSet(){
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");

        System.out.println("=====第一种=====");
        for (String str : set){
            System.out.println(str);
        }
        System.out.println("=====第二种=====");
        for (Iterator<String> iterator = set.iterator();iterator.hasNext();){
            String next = iterator.next();
            System.out.println(next);
        }
    }

    public static void testMap(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"aa");
        map.put(2,"bb");
        map.put(3,"cc");
        map.put(4,"dd");

        System.out.println("=====第一种方法=====");
        Set<Integer> integers = map.keySet();
        for (Iterator<Integer> integerIterator = integers.iterator();integerIterator.hasNext();){
            Integer key = integerIterator.next();
            System.out.println(key + "  " + map.get(key));
        }
        System.out.println("=====第二种方法=====");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Iterator<Map.Entry<Integer,String>> entryIterator = entries.iterator();entryIterator.hasNext();){
            Map.Entry<Integer, String> entry = entryIterator.next();
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
    }
}
