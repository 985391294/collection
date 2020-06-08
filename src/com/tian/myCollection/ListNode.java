package com.tian.myCollection;

/**
 * @Author: tian
 * @Date: 2020/3/13 14:18
 * @Desc:
 */
public class ListNode<E> {

    ListNode previous; //上一个节点
    ListNode next; //下一个节点
    E element; //元素数据

    public ListNode(E element) {
        this.element = element;
    }

    public ListNode(ListNode previous, E element, ListNode next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public ListNode getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode previous) {
        this.previous = previous;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}
