package datastructures.linkedlist;

import datastructures.common.DataNode;

public class FasterLinkedList {

    private DataNode<Integer> head, tail;

    //O(1)
    public void addFirst(DataNode<Integer> newHead) {
        if (head == null && tail == null) {
            head = newHead;
            tail = newHead;
        } else {
            head.next = newHead;
            head = newHead;
        }
    }

    //O(1)
    public void addLast(DataNode<Integer> newTail) {
        if (head == null && tail == null) {
            head = newTail;
            tail = newTail;
        } else {
            newTail.next = tail;
            tail = newTail;
        }
    }

    //O(n)
    public boolean delete(DataNode<Integer> node) {
        DataNode<Integer> current = tail;
        while(current.next != null) {
            if (current.next == node) {
                current.next = current.next.next;
                return true;
            } else if (current == node) {
                tail = tail.next;
                return true;
            }
            current=current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        DataNode<Integer> current = tail;
        while (current != null) {
            builder.append(current).append("->");
            current = current.next;
        }
        builder.append("null");
        return builder.toString();
    }

    public DataNode<Integer> getTail() {
        return tail;
    }

    public static void main(String[] args) {
        FasterLinkedList list = new FasterLinkedList();
        final DataNode<Integer> one = new DataNode<>(1);
        list.addFirst(one);
        final DataNode<Integer> two = new DataNode<>(2);
        list.addFirst(two);
        final DataNode<Integer> zero = new DataNode<>(0);
        list.addLast(zero);
        System.out.println(list);
        list.delete(two);
        System.out.println(list);
    }
}
