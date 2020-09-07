package linkedlist;

import org.junit.Test;

import java.util.Optional;

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


}