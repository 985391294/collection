package com.tian.myCollection;

/**
 * @Author: tian
 * @Date: 2020/3/15 15:23
 * @Desc: 手动实现一个HashMap V1版本
 */
public class MyHashMapV1<E,V> {

    MapNode[] table;

    public MyHashMapV1(){
        table = new MapNode[16]; //一般为2的整数幂
    }

    public void put(E key,V value){
        MapNode<E,V> newNode = new MapNode<>();
        newNode.hash = myHash(key.hashCode(),table.length);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null; //最后一个元素

        MapNode temp = table[newNode.hash];
        MapNode iterLast = null;

        boolean keyRepeat = false;

        if(temp == null){
            //此处数组元素为空，则直接将新节点放进去
            table[newNode.hash] = newNode;
        }else {
            //此处数组元素不为空，则遍历对应链表
            while(temp != null){
                //判断key是否重复，如果重复就覆盖了
                if(temp.key.equals(key)){
                    System.out.println("key已经存在了，进行覆盖的处理！！！！！！");
                    temp.value = value; //把value给覆盖一下就行了
                    keyRepeat = true;
                    break;
                }else {
                    //Key不重复的话，则进行遍历下一个
                    iterLast = temp;
                    temp = temp.next;
                }
            }

            //没有重复的key，就添加到链表的最后
            if(!keyRepeat){
                iterLast.next = newNode;
            }
        }
    }

    //计算出hash值
    public static int myHash(int hash,int length){
        return hash&(length-1);
    }

    public static void main(String[] args) {
        MyHashMapV1<Integer,String> myHashMap = new MyHashMapV1<>();
        myHashMap.put(10,"小明");
        myHashMap.put(20,"小王");
        myHashMap.put(30,"小张");

        myHashMap.put(53,"小明2");
        myHashMap.put(69,"小王2");
        myHashMap.put(85,"小张");
        
        for (int i=10;i<100;i++){
            System.out.println(i+",hash值："+myHash(i,16));
        }

        System.out.println(myHashMap);
    }
}
