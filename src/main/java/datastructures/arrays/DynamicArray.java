package datastructures.arrays;

import java.util.*;

public class DynamicArray<E> implements List<E> {

    private Object[] objects;
    private int capacity;
    private int size;

    private void checkCapacity(int index) {
        if (index >= capacity) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.objects = new Object[capacity];
    }

    @Override
    public E get(int index) {
        checkCapacity(index);
        return (E)objects[index];
    }

    @Override
    public E set(int index, E element) {
        checkCapacity(index);
        objects[index] = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
        checkCapacity(index);
        for (int i = capacity-1; i > index; i--) {
            objects[i] = objects[i-1];
        }
        objects[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        checkCapacity(index);
        Object s = objects[index];
        if (index == capacity-1) {
            objects[index] = null;
        } else {
            for (int i = index; i < capacity-1; i++) {
                objects[i] = objects[i+1];
            }
        }
        size--;
        return (E)s;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (Object object : objects) {
            if (object.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        if (objects.length == capacity) {
            capacity *= 1.5;
            objects = Arrays.copyOf(this.objects, capacity);
        }
        objects[size++] = e;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
    }
}
