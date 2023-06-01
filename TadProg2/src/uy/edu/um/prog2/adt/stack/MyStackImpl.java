package uy.edu.um.prog2.adt.stack;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

import java.util.EmptyStackException;


public class MyStackImpl<T> implements MyStack<T> {
    MyLinkedList<T> listaE=new MyLinkedListImpl<T>();

    @Override
    public void push(T value) {
        listaE.addFirst(value);
    }

    @Override
    public void pop() {
        if (listaE.size()!=0){
            listaE.remove(0);
        } else {
            throw new EmptyStackException();
        }

    }

    @Override
    public T top() {
        if(listaE.size()!=0){
            return listaE.get(0);
        } else {
            throw new EmptyStackException();
        }

    }

    @Override
    public int size() {
        return listaE.size();
    }

    public boolean isEmpty() {
        if(listaE.size()==0){
            return true;
        } else {
            return false;
        }

    }

    public void makeEmpty() {
        while(size()!=0){
            pop();
        }

    }
}
