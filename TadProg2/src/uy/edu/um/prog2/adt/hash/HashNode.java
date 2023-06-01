package uy.edu.um.prog2.adt.hash;

public class HashNode<K,T> {
    private K key;
    private T data;
    private boolean deleted;

    public HashNode(K key, T data) {
        this.key = key;
        this.data = data;
        this.deleted=false;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
