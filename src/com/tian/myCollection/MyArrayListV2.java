package com.tian.myCollection;

/**
 * @Author: tian
 * @Date: 2020/3/12 15:27
 * @Desc: 手动实现一个自己的ArrayList  V2版本
 *      增加泛型
 */
public class MyArrayListV2<E> {

    private Object[] elementData;
    private int size;

    private static final int DAFUALT_CAPACITY = 10;

    public MyArrayListV2(){
        elementData = new Object[DAFUALT_CAPACITY];
    }

    public MyArrayListV2(int capacity){
        elementData = new Object[capacity];
    }

    public void add(E element){
        elementData[size++] = element;
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
        MyArrayListV2 myArrayListV1 = new MyArrayListV2();
        myArrayListV1.add("aa");
        myArrayListV1.add("bb");
        
        System.out.println(myArrayListV1);
    }
}
