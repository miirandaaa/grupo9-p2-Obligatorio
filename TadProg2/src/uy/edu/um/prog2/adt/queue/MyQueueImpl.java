package uy.edu.um.prog2.adt.queue;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

public class MyQueueImpl<T> implements MyQueue<T> {
    MyLinkedList<T> listaE=new MyLinkedListImpl<T>();
    @Override
    public void enqueue(T element) {
        listaE.add(element);

    }

    @Override
    public T dequeue() throws EmptyQueueException {
        if(listaE.size()!=0){
            T valor=listaE.get(0);
            listaE.remove(0);
            return valor;
        } else {
            throw new EmptyQueueException("Lista vacia");
        }

    }

    @Override
    public boolean isEmpty() {
        if(listaE.size()==0){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public int size() {
        return listaE.size();
    }
}

