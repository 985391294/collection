package com.tian.myCollection;

/**
 * @Author: tian
 * @Date: 2020/3/15 16:53
 * @Desc: 手动实现一个HashMap V2版本
 *        实现toString()方法
 */
public class MyHashMapV2<K,V> {

    MapNode[] table;
    int size;

    public MyHashMapV2(){
        table = new MapNode[16]; //一般为2的整数幂
    }

    //此处没有考虑扩容的问题，jdk源码做了处理
    public void put(K key,V value){
        MapNode<K,V> newNode = new MapNode<>();
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
            size++;
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
                size++;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        //遍历数组
        for(int i=0;i<table.length;i++){
            MapNode temp = table[i];
            while(temp!=null){
                sb.append(temp.key + ":" + temp.value + ",");
                //把下一个元素继续指向temp，直到下一个元素没有
                temp = temp.next;
            }
        }
        sb.setCharAt(sb.length()-1, '}');
        return sb.toString();
    }

    //计算出hash值
    public static int myHash(int hash,int length){
        return hash&(length-1);
    }

    //根据key获取value
    public V get(K key){
        int hash = myHash(key.hashCode(), table.length);
        V value = null;
        if(table[hash]!=null){
            MapNode<K,V> temp = table[hash];
            while(temp!=null){
                if(temp.key.equals(key)){
                    value = temp.value;
                    break;
                }
            }
        }
        return value;
    }
    public static void main(String[] args) {
        MyHashMapV2<Integer,String> myHashMap = new MyHashMapV2<>();
        myHashMap.put(10,"小明");
        myHashMap.put(20,"小王");
        myHashMap.put(30,"小张");

        myHashMap.put(53,"小明2");
        myHashMap.put(69,"小王2");
        myHashMap.put(85,"小张");
        
//        for (int i=10;i<100;i++){
//            System.out.println(i+",hash值："+myHash(i,16));
//        }
        System.out.println(myHashMap);
        
        System.out.println(myHashMap.get(10));
        System.out.println(myHashMap.get(53));
    }
}
