package com.tian.collection;

/**
 * @Author: tian
 * @Date: 2020/3/12 13:00
 * @Desc: 测试泛型
 */
public class MyGeneric {

    public static void main(String[] args) {
        MyCollection<String> myCollection = new MyCollection();
//        myCollection.set(111,0);
        myCollection.set("123",1);

//        int o = (int) myCollection.get(0);
        String string = (String) myCollection.get(1);
//        System.out.println(o);
        System.out.println(string);

    }
}

class MyCollection<E>{
    Object[] objects = new Object[5];

    public void set(E object,int index){
        objects[index] = object;
    }

    public E get(int index){
        return (E) objects[index];
    }
}
