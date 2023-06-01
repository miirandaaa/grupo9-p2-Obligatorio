package uy.edu.um.prog2.adt.stack;

import java.util.EmptyStackException;

public interface MyStack<T> {
    void push(T value );
    void pop() throws EmptyStackException;
    T top() throws EmptyStackException;
    int size();
    boolean isEmpty();
    public void makeEmpty();
}
