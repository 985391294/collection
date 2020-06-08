package com.tian.myCollection;

/**
 * @Author: tian
 * @Date: 2020/3/13 16:23
 * @Desc: 手动实现一个LinkedList V4版本
 *        实现添加元素和索引位置的方法
 */
public class MyLinkedListV4<E> {

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
    private void rangeCheck(int index){
        if(index < 0 || index > size-1){
            throw new RuntimeException("索引越界："+index);
        }
    }

    public ListNode getNode(int index){
        rangeCheck(index);
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

    public void add(int index,E element){
        rangeCheck(index);

        if(index == size){
           linkLast(element); //这个条件应该不会成立，因为索引永远不会等于size，只会比它小1
        }else {
            linkBefore(element,getNode(index));
        }
    }

    //如果添加的是最后一个索引之前的位置
    private void linkBefore(E element, ListNode node) {
        ListNode pred = node.previous;
        ListNode newNode = new ListNode(pred,element,node);
        node.previous = newNode;
        if(pred == null){
            first = newNode;
        }else {
            pred.next = newNode;
        }
        size++;
    }

    //如果是添加到最后一个索引的位置
    private void linkLast(E element) {
        ListNode node = last;
        ListNode newNode = new ListNode(node,element,null);
        last = newNode;
        if(node == null){
            first = newNode;
        }else {
            node.next = newNode;
        }
        size++;
    }

    public static void main(String[] args) {
        MyLinkedListV4 myLinkedList = new MyLinkedListV4();
        myLinkedList.add("a");
        myLinkedList.add("b");
        myLinkedList.add("c");
        myLinkedList.add("d");
        myLinkedList.add("e");

        System.out.println(myLinkedList);

        myLinkedList.add(4,"x");
        myLinkedList.add(5,"y");
        myLinkedList.add(0,"w");
        myLinkedList.add(7,"t");
        System.out.println(myLinkedList);

    }

}
