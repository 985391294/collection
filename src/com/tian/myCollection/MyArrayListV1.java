package com.tian.myCollection;

/**
 * @Author: tian
 * @Date: 2020/3/12 15:18
 * @Desc: 手动实现一个自己的ArrayList  V1版本
 */
public class MyArrayListV1 {

    private Object[] elementData;
    private int size;

    private static final int DAFUALT_CAPACITY = 10;

    public MyArrayListV1(){
        elementData = new Object[DAFUALT_CAPACITY];
    }

    public MyArrayListV1(int capacity){
        elementData = new Object[capacity];
    }

    public void add(Object object){
        elementData[size++] = object;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<size;i++){
            sb.append(elementData[i]+",");
        }
//        sb.append("]");
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        MyArrayListV1 myArrayListV1 = new MyArrayListV1();
        myArrayListV1.add("aa");
        myArrayListV1.add("bb");
        
        System.out.println(myArrayListV1);
    }
}
