package com.tian.myCollection;

/**
 * @Author: tian
 * @Date: 2020/3/13 14:39
 * @Desc: 手动实现一个LinkedList V1版本
 *        实现add方法和toString
 */
public class MyLinkedListV1<E> {

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

    public static void main(String[] args) {
        MyLinkedListV1 myLinkedList = new MyLinkedListV1();
        myLinkedList.add("a");
        myLinkedList.add("b");
        myLinkedList.add("c");
        myLinkedList.add("d");
        System.out.println(myLinkedList);
    }

}
