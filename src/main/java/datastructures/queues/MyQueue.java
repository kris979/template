package datastructures.queues;

import datastructures.common.DataNode;

public class MyQueue<E> {

    private DataNode<E> head;
    private DataNode<E> tail;

    public void add(E data) {
        DataNode<E> newNode = new DataNode<>(data);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null){
            head = tail;
        }
    }

    public E remove() {
        if (head == null)
            return null;
        else {
            E data = head.data;
            head = head.next;
            return data;
        }
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        int size = 1;
        DataNode<E> current = head;
        while(current.next != null) {
            current = current.next;
            size++;
        }
        return size;
    }

}
