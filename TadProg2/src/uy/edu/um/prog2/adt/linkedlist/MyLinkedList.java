package uy.edu.um.prog2.adt.linkedlist;

public interface MyLinkedList<T> {
    void add(T value );
    void remove(int position);
    T get(int position);
    int size();
    public void addFirst(T value);

}
