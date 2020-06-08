package com.tian.myCollection;

import java.util.LinkedList;

/**
 * @Author: tian
 * @Date: 2020/3/13 15:46
 * @Desc: 手动实现一个LinkedList V3版本
 *        实现remove()方法
 */
public class MyLinkedListV3<E> {

    private ListNode first;
    private ListNode last;

    private int size;

    //添加方法
    public void add(E element){
        ListNode node = new ListNode(element);
        if(first == null){
            first = node;
            last = node;
        }else {
            node.previous = last;
            node.next = null;

            last.next = node;
            last = node;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode temp = first;
        while (temp != null){
            sb.append(temp.element + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    //根据索引获取
    public E get(int index){
        rangeCheck(index);
        ListNode temp = getNode(index);
        return (E) temp.element;
    }

    //检查索引是否越界
    public void rangeCheck(int index){
        if(index < 0 || index > size-1){
            throw new RuntimeException("索引越界："+index);
        }
    }

    public ListNode getNode(int index){
        ListNode temp = null;
        //采用二叉树的方法去查找，提高效率
        if(index <= (size>>1)){
            temp = first;
            for (int i=0;i<index;i++){
                temp = temp.next;
            }
        }else {
            temp = last;
            for(int i=size-1;i>index;i--){
                temp = temp.previous;
            }
        }
        return temp;
    }

    //根据索引删除
    public void remove(int index){
        rangeCheck(index);
        ListNode temp = getNode(index);
        if(temp != null){
            ListNode up = temp.previous;
            ListNode down = temp.next;

            if(up != null){
                up.next = down;
            }
            if(down != null){
                down.previous = up;
            }

            //删除第一个的时候
            if(index == 0){
                first = down;
            }
            //删除最后一个的时候
            if(index == size-1){
                last = up;
            }

            size--;
        }


    }

    public static void main(String[] args) {
        MyLinkedListV3 myLinkedList = new MyLinkedListV3();
        myLinkedList.add("a");
        myLinkedList.add("b");
        myLinkedList.add("c");
        myLinkedList.add("d");
        myLinkedList.add("e");


        LinkedList linkedList = null;
        System.out.println(myLinkedList);

        myLinkedList.remove(0);
        myLinkedList.remove(0);
        System.out.println(myLinkedList);

    }

}
