package uy.edu.um.prog2.adt.heap;

public interface MyHeap<T extends Comparable<T>> {
    void agregar (T elemento);
    T obtener();

    void eliminar();
    int obtenerSize();

}
