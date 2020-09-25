package datastructures.linkedlist;

import datastructures.common.DataNode;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkedListTest {

    private LinkedList list = new LinkedList();

    @Test
    public void addFirst() {
        assertThat(list.getFirst().isPresent(), is(false));
        list.addFirst(1);
        assertThat(list.getFirst().get(), is(1));
        list.addFirst(2);
        assertThat(list.getFirst().get(), is(2));
    }

    @Test
    public void getLast() {
        list.addFirst(1);
        assertThat(list.getLast().get(), is(1));
        list.addFirst(2);
        assertThat(list.getLast().get(), is(1));
        assertThat(list.getFirst().get(), is(2));
    }

    @Test
    public void addLast() {
        list.addLast(1);
        assertThat(list.getFirst().get(), is(1));
        assertThat(list.getLast().get(), is(1));
        list.addLast(2);
        assertThat(list.getFirst().get(), is(1));
        assertThat(list.getLast().get(), is(2));
    }

    @Test
    public void size() {
        list.addLast(1);
        assertThat(list.size(), is(1));
        list.addLast(2);
        assertThat(list.size(), is(2));
    }

    @Test
    public void clear() {
        list.clear();
        assertThat(list.size(), is(0));
        list.addFirst(1);
        assertThat(list.size(), is(1));
        list.clear();
        assertThat(list.size(), is(0));
    }

    @Test
    public void DeleteWithValue() {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        assertThat(list.getFirst().get(), is(4));
        list.delete(4);
        assertThat(list.getFirst().get(), is(3));
        list.delete(2);
        assertThat(list.getFirst().get(), is(3));
        assertThat(list.size(), is(2));
    }

    @Test
    public void hasloop() {
        DataNode<Integer> four = new DataNode<>(4);
        DataNode<Integer> eight = new DataNode<>(8);
        eight.next = four;
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(four);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(eight);
        assertTrue(list.hasLoop());
    }

    @Test
    public void noLoop() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        assertFalse(list.hasLoop());
    }

    @Test
    public void firstLoopNode() {
        DataNode<Integer> four = new DataNode<>(4);
        DataNode<Integer> eight = new DataNode<>(8);
        eight.next = four;
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(four);
        list.addLast(5);
        list.addLast(eight);
        assertThat(list.firstLoopNode(),is(four));
    }

    @Test
    public void duplicates() {
        list.addFirst(1);
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(2);
        assertThat(list.size(), is(4));
        list.removeDuplicates();
        assertThat(list.size(), is(2));
    }
}