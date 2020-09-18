package datastructures.linkedlist;

import datastructures.common.DataNode;

import java.util.HashSet;
import java.util.Optional;

public class LinkedList {

    private DataNode<Integer> head;

    public void addFirst(int data) {
        DataNode newHead = new DataNode(data);
        newHead.next = head;
        head = newHead;
    }

    //O(1)
    public Optional<Integer> getFirst() {
        if (head != null) {
            return Optional.of(head.data);
        } else {
            return Optional.empty();
        }
    }

    //O(n)
    public Optional<Integer> getLast() {
        if (head == null) {
            return Optional.empty();
        }
        DataNode<Integer> current = head;
        while(current.next != null) {
            current = current.next;
        }
        return Optional.of(current.data);
    }

    public void addLast(final int data) {
        DataNode<Integer> newLast = new DataNode(data);

        if (head == null) {
            head = newLast;
            return;
        }

        DataNode current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newLast;
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        int counter = 1;
        DataNode<Integer> current = head;
        while(current.next != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

    public void clear() {
        head = null;
    }

    public void delete(final int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        DataNode<Integer> current = head;
        while(current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
    }

    public void removeDuplicates() {
        DataNode<Integer> current = head;
        DataNode<Integer> previous = null;
        HashSet<Integer> uniques = new HashSet<>();
        while (current != null) {
            if (uniques.contains(current.data)) {
                previous.next = current.next; //skip duplicate
            } else {
                uniques.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }
}
