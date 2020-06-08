package com.tian.myCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Author: tian
 * @Date: 2020/3/15 19:03
 * @Desc: hashSet底层是调用的hashMap
 */
public class MyHashSet {

    TreeSet treeSet = new TreeSet(); //调用的TreeMap
    TreeMap treeMap = new TreeMap();
    HashSet hashSet = new HashSet(); //调用的HashMap
    HashMap hashMap;

    private static final Object PERSENT = new Object();

    public MyHashSet(){
        hashMap = new HashMap();
    }

    public void add(Object object){
        hashMap.put(object,PERSENT);
    }

    public int size(){
        return hashMap.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object key : hashMap.keySet()){
            sb.append(key + ",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add("小明");
        myHashSet.add("小王");
        myHashSet.add("小李");
        System.out.println(myHashSet);
        System.out.println("个数："+myHashSet.size());

        HashSet set;
    }
}
