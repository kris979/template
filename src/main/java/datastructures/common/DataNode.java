package datastructures.common;

public class DataNode<E> {

    public E data;
    public DataNode<E> next;
    public DataNode<E> previous;

    public DataNode(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "(" + data + ")";
    }
}
