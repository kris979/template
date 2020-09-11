package datastructures.stacks;

import datastructures.common.DataNode;

public class MyStack<E> {

    private DataNode<E> head;

    public void push(E data) {
        DataNode<E> newNode = new DataNode<>(data);
        newNode.next = head;
        head = newNode;
    }

    public E pop() {
        E data = head.data;
        head = head.next;
        return data;
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
