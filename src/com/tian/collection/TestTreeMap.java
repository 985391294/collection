package com.tian.collection;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: tian
 * @Date: 2020/3/15 18:18
 * @Desc:
 */
public class TestTreeMap {

    public static void main(String[] args) {
        Map<Integer,String> treeMap = new TreeMap<>();

        treeMap.put(2,"小明");
        treeMap.put(1,"小王");
        treeMap.put(3,"小李");
        treeMap.put(5,"小赵");
        treeMap.put(4,"小周");

        //treeMap底层默认实现了按照key排序
        for (Integer key : treeMap.keySet()){
            System.out.println(key +"  "+ treeMap.get(key));
        }
        
        Map<Student,String> studentMap = new TreeMap<>();
        studentMap.put(new Student(3,"小明",6433),"我是小明");
        studentMap.put(new Student(5,"小王",2345),"我是小王");
        studentMap.put(new Student(6,"小张",6433),"我是小张");
        studentMap.put(new Student(2,"小周",8492),"我是小周");
        studentMap.put(new Student(1,"小李",9134),"我是小李");
        studentMap.put(new Student(4,"小赵",6295),"我是小赵");
        
        for(Student key : studentMap.keySet()){
            System.out.println(key + "  " + studentMap.get(key));
        }
    }
}

class Student implements Comparable<Student>{
    int id;
    String userName;
    double sarlay;

    public Student(int id, String userName, double sarlay) {
        this.id = id;
        this.userName = userName;
        this.sarlay = sarlay;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", sarlay=" + sarlay +
                '}';
    }

    //负数：小于   正数：大于   0：等于
    @Override
    public int compareTo(Student o) {
        if(this.sarlay > o.sarlay){
            return 1;
        }else if(this.sarlay < o.sarlay){
            return -1;
        }else {
            if(this.id > o.id){
                return 1;
            }else if(this.id < o.id){
                return -1;
            }else {
                return 0;
            }
        }
    }
}
