package com.tian.myCollection;

/**
 * @Author: tian
 * @Date: 2020/3/13 15:08
 * @Desc: 手动实现一个LinkedList V2版本
 *        实现get()
 */
public class MyLinkedListV2<E> {

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
        ListNode temp = null;
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
        return (E) temp.element;
    }
    public void rangeCheck(int index){
        if(index < 0 || index > size-1){
            throw new RuntimeException("索引越界："+index);
        }
    }


    public static void main(String[] args) {
        MyLinkedListV2 myLinkedList = new MyLinkedListV2();
        myLinkedList.add("a");
        myLinkedList.add("b");
        myLinkedList.add("c");
        myLinkedList.add("d");
        myLinkedList.add("e");

        System.out.println(myLinkedList);

        System.out.println(myLinkedList.get(2));
    }

}
