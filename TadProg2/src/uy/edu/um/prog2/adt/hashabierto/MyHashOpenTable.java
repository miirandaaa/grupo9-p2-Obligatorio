package uy.edu.um.prog2.adt.hashabierto;

public interface MyHashOpenTable<K,T> {
    void put(K key, T value);
    boolean contains(K key);
    void remove(K key);
    T get(K key);
}
