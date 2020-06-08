package com.tian.collection;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: tian
 * @Date: 2020/3/16 15:18
 * @Desc: 调用的TreeMap
 */
public class TestTreeSet {

    public static void main(String[] args) {
        Set<Teacher> treeSet = new TreeSet<>();
        treeSet.add(new Teacher(3,"小明",6433));
        treeSet.add(new Teacher(5,"小王",2345));
        treeSet.add(new Teacher(6,"小张",6433));
        treeSet.add(new Teacher(2,"小周",8492));
        treeSet.add(new Teacher(1,"小李",9134));
        treeSet.add(new Teacher(4,"小赵",6295));

        for (Teacher teacher : treeSet) {
            System.out.println(teacher);
        }
    }
}

class Teacher implements Comparable<Teacher>{

    int id;
    String userName;
    double sarlay;

    public Teacher(int id, String userName, double sarlay) {
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
    public int compareTo(Teacher o) {
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
