package uy.edu.um.prog2.adt.hashabierto;

public class HashOpenNode<K,T>{
    private K key;
    private T data;
    private HashOpenNode<K,T> next;

    public HashOpenNode(K key, T data) {
        this.key = key;
        this.data = data;
        this.next = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public HashOpenNode<K, T> getNext() {
        return next;
    }

    public void setNext(HashOpenNode<K, T> next) {
        this.next = next;
    }
}
