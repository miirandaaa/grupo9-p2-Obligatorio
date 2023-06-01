package uy.edu.um.prog2.adt.hash;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;

public interface MyHashTable<K,T>{
    void put(K key, T data);
    T get(K key);
    void remove(K key);
    MyLinkedList<K> keys();
    int size();
    boolean contains(K key);

}
