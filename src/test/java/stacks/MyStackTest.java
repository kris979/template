package stacks;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MyStackTest {

    private MyStack<Integer> myStack = new MyStack<>();

    @Test
    public void push() {
        myStack.push(1);
        assertThat(myStack.size(), is(1));
    }

    @Test
    public void pop() {
        myStack.push(10);
        assertThat(myStack.size(), is(1));
        assertThat(myStack.pop(), is(10));
        assertThat(myStack.size(), is(0));
    }
}