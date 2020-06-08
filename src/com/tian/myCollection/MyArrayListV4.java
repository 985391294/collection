package com.tian.myCollection;

/**
 * @Author: tian
 * @Date: 2020/3/12 15:30
 * @Desc: 手动实现一个自己的ArrayList V4版本
 *        数组边界的检查
 */
public class MyArrayListV4<E> {

    private Object[] elementData;
    private int size;

    private static final int DAFUALT_CAPACITY = 10;

    public MyArrayListV4(){
        elementData = new Object[DAFUALT_CAPACITY];
    }

    public MyArrayListV4(int capacity) {
        if(capacity < 0){
            throw new RuntimeException("容器的容量不能为负数");
        }else if(capacity == 0){
            elementData = new Object[DAFUALT_CAPACITY];
        }else{
            elementData = new Object[capacity];
        }
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
    
    public E get(int index){
        checkRange(index);
        return (E) elementData[index];
    }

    public void set(E element,int index){
        checkRange(index);
        elementData[index] = element;
    }

    /**
     * @Author: tian
     * @Date: 2020/3/12 16:21
     * @Desc: 检查索引是否越界
     */
    public void checkRange(int index){
        //判断索引是否合法
        if(index<0 || index> size-1){
            try {
                throw new Exception("索引越界："+index);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        MyArrayListV4 myArrayListV1 = new MyArrayListV4();
        for(int i=0;i<50;i++){
            myArrayListV1.add("tqz"+i);
        }
//        myArrayListV1.add("aa");
//        myArrayListV1.add("bb");
        
        System.out.println(myArrayListV1);
        myArrayListV1.set("abcd",10);
        System.out.println(myArrayListV1);

        Object o = myArrayListV1.get(10);
        System.out.println(o);
        System.out.println(myArrayListV1.get(20));
    }
}
