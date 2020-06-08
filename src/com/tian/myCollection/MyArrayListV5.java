package com.tian.myCollection;

/**
 * @Author: tian
 * @Date: 2020/3/13 13:26
 * @Desc: 手动实现一个自己的ArrayList V5版本
 *        添加删除、长度、是否为空等方法
 */
public class MyArrayListV5<E> {

    private Object[] elementData;
    private int size;

    private static final int DAFUALT_CAPACITY = 10;

    public MyArrayListV5(){
        elementData = new Object[DAFUALT_CAPACITY];
    }

    public MyArrayListV5(int capacity) {
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

    //根据元素删除
    public void remove(E element){
        for (int i=0;i<size;i++){
            if(element.equals(get(i))){ //容器中所有的比较操作，都是用equels而不是==
                remove(i);
            }
        }
    }

    //根据索引删除
    public void remove(int index){
        int numMoved = elementData.length-index-1;
        if(numMoved > 0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[--size] = null;
    }
    
    //集合的长度
    public int size(){
        return size;
    }
    
    //集合是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        
        MyArrayListV5 myArrayListV1 = new MyArrayListV5();
        for(int i=0;i<20;i++){
            myArrayListV1.add("tqz"+i);
        }
//        myArrayListV1.add("aa");
//        myArrayListV1.add("bb");
        
        myArrayListV1.set("abcd",10);
        System.out.println(myArrayListV1);

        myArrayListV1.remove(5);
        System.out.println(myArrayListV1);
        myArrayListV1.remove("tqz8");
        System.out.println(myArrayListV1);

        int size = myArrayListV1.size();
        System.out.println(size);
        System.out.println(myArrayListV1.isEmpty());

    }
}
