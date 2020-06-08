package com.tian.collection;

/**
 * @Author: tian
 * @Date: 2020/3/14 13:53
 * @Desc:
 */
public class TestHash {

    public static void main(String[] args) {
        int hash = 25860399;
        int length = 16;

        indexFor(hash,length);
        int hash1 = hash(hash);
        System.out.println("jdk1.8处理hash算法："+hash1);
    }

    public static int indexFor(int hash,int length){
        System.out.println(hash&(length-1));
        
        System.out.println(hash%length);
        return hash&(length-1);
    }

    public static int hash(int hash){
        hash ^= (hash>>>20) ^ (hash>>>12);
        return hash ^ (hash>>>7) ^ (hash>>>4);
    }
}
