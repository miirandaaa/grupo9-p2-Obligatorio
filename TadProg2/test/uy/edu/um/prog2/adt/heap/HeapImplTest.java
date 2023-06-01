package uy.edu.um.prog2.adt.heap;
import org.junit.Test;
import uy.edu.um.prog2.adt.heap.MyHeap;
import uy.edu.um.prog2.adt.heap.MyHeapImpl;


import static org.junit.Assert.*;
public class HeapImplTest {

    @Test
    public void testHeap(){

        //HEAP MINIMO
        MyHeap<Integer> heapMin= new MyHeapImpl<>(true,2);

        heapMin.agregar(10);
        heapMin.agregar(30);
        heapMin.agregar(50);
        heapMin.agregar(2);
        heapMin.agregar(3);

        assertEquals(5,heapMin.obtenerSize());//Verifico que haya 5 objetos

        assertEquals((Integer) 2,heapMin.obtener());//Verifico que el minimo sea 2

        heapMin.eliminar();

        assertEquals(4,heapMin.obtenerSize());//Verifico que hay disminuido el size a 4.

        assertEquals((Integer) 3,heapMin.obtener());//Verifico que al eliminar ahora el minimo sea 3

        heapMin.eliminar();
        heapMin.eliminar();
        heapMin.eliminar();

        assertEquals((Integer) 50,heapMin.obtener());//Verifico que al eliminar todos menos 1 nodo, el que queda sea 50

        //HEAP MAXIMO
        MyHeap<Integer> heapMax= new MyHeapImpl<>(false,2);

        heapMax.agregar(33);
        heapMax.agregar(41);
        heapMax.agregar(12);
        heapMax.agregar(50);
        heapMax.agregar(2);

        assertEquals(5,heapMax.obtenerSize()); //Verificar que haya 5 elementos

        assertEquals((Integer) 50, heapMax.obtener()); //Verificar que el maximo sea 50

        heapMax.eliminar();

        assertEquals(4,heapMax.obtenerSize()); //Verificar que haya 4 elementos al eliminar

        assertEquals((Integer) 41, heapMax.obtener()); //Verificar que el maximo sea 41 despues de eliminar

        heapMax.eliminar();
        heapMax.eliminar();
        heapMax.eliminar();

        assertEquals((Integer) 2,heapMax.obtener());//Verifico que al eliminar todos menos 1 nodo, el que queda sea 2
    }

}
