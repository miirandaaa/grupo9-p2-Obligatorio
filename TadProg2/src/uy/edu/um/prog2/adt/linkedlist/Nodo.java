package uy.edu.um.prog2.adt.linkedlist;

public class Nodo<T> {
    private Nodo next;
    private T value;

    public Nodo( T value) {
        this.next = null;
        this.value= value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Nodo<T>  getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }
}

