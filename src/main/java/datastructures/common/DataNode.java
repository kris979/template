package datastructures.common;

public class DataNode<E> {
    public E data;
    public DataNode<E> next = null;
    public DataNode(E data) {
        this.data = data;
    }
}
