package uy.edu.um.prog2.adt.heap;

public interface MyHeap<K extends Comparable<K>,T> {
    void agregar (K key,T elemento);
    T obtener();

    void eliminar();
    int obtenerSize();

}
