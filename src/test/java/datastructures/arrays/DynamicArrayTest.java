package datastructures.arrays;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DynamicArrayTest {

    private DynamicArray<String> da = new DynamicArray<>(2);

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void add() {
        assertThat(da.size(), is(0));
        assertThat(da.add("a"), is(true));
        assertThat(da.add("b"), is(true));
        assertThat(da.add("c"), is(true));
        assertThat(da.size(), is(3));
        assertThat(da.get(0), is("a"));
    }

    @Test
    public void get() {
        assertThat(da.add("a"), is(true));
        assertThat(da.get(0), is("a"));
    }

    @Test
    public void set() {
        assertThat(da.add("a"), is(true));
        da.set(0, "b");
        assertThat(da.get(0), is("b"));
        da.set(1, "b");
        assertThat(da.get(1), is("b"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void setOutOfBounds() {
        da.set(3, "b");
    }

    @Test
    public void addAtIndex() {
        da = new DynamicArray<String>(3);
        da.add(0,"a");
        da.add(1,"c");
        da.add(1,"b");
        assertThat(da.get(0), is("a"));
        assertThat(da.get(1), is("b"));
        assertThat(da.get(2), is("c"));
    }

    @Test
    public void remove() {
        da.add(0,"a");
        da.add(1,"b");
        assertThat(da.size(), is(2));
        assertThat(da.get(1), is("b"));
        assertThat(da.remove(1), is("b"));
        assertThat(da.size(), is(1));
        assertNull(da.get(1));
    }

    @Test
    public void size() {
        assertThat(da.size(), is(0));
        assertThat(da.add("a"), is(true));
        assertThat(da.size(), is(1));
    }

    @Test
    public void contains() {
        da.add("a");
        assertThat(da.contains("a"), is(true));
    }


    @Test
    public void delete() {
        da.add("a");
        da.remove(0);
        assertThat(da.size(), is(0));

    }
}