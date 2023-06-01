package uy.edu.um.prog2.adt.hashabierto;

public class HashOpenOpenTableImpl<K,T> implements MyHashOpenTable<K,T> {
    private int size;

    private HashOpenNode<K,T>[] table;

    public HashOpenOpenTableImpl(int size) {
        this.size = size;
        this.table = new HashOpenNode[size];
    }

    @Override
    public void put(K key, T value) {
        HashOpenNode<K,T> nodo =new HashOpenNode<K,T>(key,value);
        int keyHash=key.hashCode();
        int indice=keyHash%size;

        if (table[indice]==null) {
            table[indice]=nodo;
        } else {
            HashOpenNode<K,T> first=table[indice];
            while(first.getNext()!=null){
                first=first.getNext();
            }
            first.setNext(nodo);
        }
    }

    @Override
    public boolean contains(K key) {
        int keyHash=key.hashCode();
        int indice=keyHash%size;

        HashOpenNode<K,T> first=table[indice];
        while (first.getKey()!= key && first.getNext()!=null){
            first=first.getNext();
        }
        if(first.getKey()==key){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void remove(K key) {
        int keyHash=key.hashCode();
        int indice=keyHash%size;
        HashOpenNode<K,T> first=table[indice];
        if(contains(key)){
            if(first.getKey()==key){
                table[indice]=first.getNext();
            } else {
                while (first.getNext().getKey()!=key){
                    first=first.getNext();
                }
                first.setNext(first.getNext().getNext());
            }
        }
    }
    public T get(K key) {
        int keyHash=key.hashCode();
        int indice=keyHash%size;

        HashOpenNode<K,T> first=table[indice];
        while (first.getKey()!= key && first.getNext()!=null){
            first=first.getNext();
        }
        if(first.getKey()==key){
            return first.getData();
        } else {
            return null;
        }

    }

}
