package datastructures.queues;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.hamcrest.core.Is.is;

public class MyQueueTest {

    private MyQueue<Integer> myQueue = new MyQueue<>();

    @Test
    public void add() {
        assertThat(myQueue.size(), is(0));
        myQueue.add(10);
        assertThat(myQueue.size(), is(1));
        myQueue.add(20);
        assertThat(myQueue.size(), is(2));
    }

    @Test
    public void remove() {
        myQueue.add(10);
        assertThat(myQueue.remove(), is(10));
        myQueue.add(10);
        myQueue.add(20);
        assertThat(myQueue.remove(), is(10));
        assertThat(myQueue.remove(), is(20));
    }
}