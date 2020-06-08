package com.tian.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author: tian
 * @Date: 2020/3/12 13:57
 * @Desc: 测试list的一些常用方法
 */
public class TestList {

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
    }

    public static void test1(){
        Collection<String> collection = new ArrayList<>();
        collection.add("田青钊");
        collection.add("tqz");
        System.out.println(collection);

        System.out.println("元素个数："+collection.size());

        System.out.println(collection.toArray());

        collection.remove("tqz");
        collection.clear(); //删除集合中所有的元素
        System.out.println("元素个数："+collection.size());

        System.out.println(collection.contains("tqz"));

    }

    public static void test2(){

        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        List<String> list1 = new ArrayList<>();
        list1.add("aa");
        list1.add("dd");
        list1.add("ee");

        System.out.println("原本的第一个list:"+list);
//        list.addAll(list1);

//        list.removeAll(list1);  //如果一个容器中已经含有这个元素，会把之前添加的容器里面的相同元素给删除掉
//        System.out.println("删除第二个容器之后的list："+list);

        list.retainAll(list1); //找出两个容器中相同的元素
        System.out.println(list);
        System.out.println("一个容器是否包含另外一个容器所有的元素："+list.containsAll(list1));
    }

    public static void test3(){

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        System.out.println(list);
        list.add(3,"tqz"); //添加到索引为3的位置
        
        System.out.println(list);

        list.add("C");
        
        System.out.println("第一个出现的位置："+list.indexOf("Afff")); //如果找到了返回索引，如果找不到了返回-1

        System.out.println("最后出现的位置："+list.lastIndexOf("C")); //如果找到了返回最后出现位置的索引，找不到返回-1


    }
}
