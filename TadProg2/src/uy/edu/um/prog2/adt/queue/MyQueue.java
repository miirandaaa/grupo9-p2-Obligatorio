package uy.edu.um.prog2.adt.queue;

public interface MyQueue<T>  {
    void enqueue (T element);
    T dequeue () throws EmptyQueueException;
    boolean isEmpty();
    int size();
}
