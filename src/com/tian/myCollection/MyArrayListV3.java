package com.tian.myCollection;

/**
 * @Author: tian
 * @Date: 2020/3/12 15:30
 * @Desc: 手动实现一个自己的ArrayList V3版本
 *        实现扩容
 */
public class MyArrayListV3<E> {

    private Object[] elementData;
    private int size;

    private static final int DAFUALT_CAPACITY = 10;

    public MyArrayListV3(){
        elementData = new Object[DAFUALT_CAPACITY];
    }

    public MyArrayListV3(int capacity){
        elementData = new Object[capacity];
    }

    public void add(E element){
        //1.什么时候扩容
        if(this.size == elementData.length){
            //2.怎么扩容  (原来的长度加上原来长度的一半，比如：10 + 10/2)  jkd源码也是这么实现的
            Object[] newArray = new Object[elementData.length + (elementData.length>>1)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
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
        MyArrayListV3 myArrayListV1 = new MyArrayListV3();
        for(int i=0;i<50;i++){
            myArrayListV1.add("tqz"+i);
        }
//        myArrayListV1.add("aa");
//        myArrayListV1.add("bb");
        
        System.out.println(myArrayListV1);
    }
}
