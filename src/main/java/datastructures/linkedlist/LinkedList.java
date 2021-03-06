package datastructures.linkedlist;

import datastructures.common.DataNode;

import java.util.HashSet;
import java.util.Optional;

public class LinkedList {

    private DataNode<Integer> head, slow, fast;

    public void addFirst(int data) {
        DataNode<Integer> newHead = new DataNode<>(data);
        addFirst(newHead);
    }

    public void addFirst(final DataNode<Integer> node) {
        node.next = head;
        head = node;
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
        while (current.next != null) {
            current = current.next;
        }
        return Optional.of(current.data);
    }

    public void addLast(final int data) {
        DataNode<Integer> newLast = new DataNode<>(data);
        addLast(newLast);
    }

    public void addLast(DataNode<Integer> newLast) {
        if (head == null) {
            head = newLast;
            return;
        }

        DataNode<Integer> current = head;
        while (current.next != null) {
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
        while (current.next != null) {
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
        while (current.next != null) {
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

    public boolean hasLoop() {
        if (head == null || head.next == null || head.next.next == null) {
            return false;
        }
        slow = head.next;
        fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        System.out.println("Loop detected:" + slow + "," + fast);
        return true;
    }


    public DataNode<Integer> firstLoopNode() {
        hasLoop();
        slow = head;
        while (slow != fast) {
            System.out.println(slow + "," + fast);
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println("First node of the loop: " + slow);
        return slow;
    }
}
