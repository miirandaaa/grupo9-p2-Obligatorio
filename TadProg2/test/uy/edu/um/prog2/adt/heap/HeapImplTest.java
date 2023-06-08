package uy.edu.um.prog2.adt.heap;
import org.junit.Test;
import uy.edu.um.prog2.adt.heap.MyHeap;
import uy.edu.um.prog2.adt.heap.MyHeapImpl;


import static org.junit.Assert.*;
public class HeapImplTest {

    @Test
    public void testHeap(){

        //HEAP MINIMO
        MyHeap<Integer,String> heapMin= new MyHeapImpl<>(true,2);
        heapMin.agregar(10,"10");
        heapMin.agregar(30,"30");
        heapMin.agregar(50,"50");
        heapMin.agregar(2,"2");
        heapMin.agregar(3,"3");

        assertEquals(5,heapMin.obtenerSize());//Verifico que haya 5 objetos

        assertEquals("2",heapMin.obtener());//Verifico que el minimo sea 2

        heapMin.eliminar();

        assertEquals(4,heapMin.obtenerSize());//Verifico que hay disminuido el size a 4.

        assertEquals( "3",heapMin.obtener());//Verifico que al eliminar ahora el minimo sea 3

        heapMin.eliminar();
        heapMin.eliminar();
        heapMin.eliminar();

        assertEquals( "50",heapMin.obtener());//Verifico que al eliminar todos menos 1 nodo, el que queda sea 50

        //HEAP MAXIMO
        MyHeap<Integer,String> heapMax= new MyHeapImpl<>(false,2);

        heapMax.agregar(33,"33");
        heapMax.agregar(41,"41");
        heapMax.agregar(12,"12");
        heapMax.agregar(50,"50");
        heapMax.agregar(2,"2");

        assertEquals(5,heapMax.obtenerSize()); //Verificar que haya 5 elementos

        assertEquals( "50", heapMax.obtener()); //Verificar que el maximo sea 50

        heapMax.eliminar();

        assertEquals(4,heapMax.obtenerSize()); //Verificar que haya 4 elementos al eliminar

        assertEquals("41", heapMax.obtener()); //Verificar que el maximo sea 41 despues de eliminar

        heapMax.eliminar();
        heapMax.eliminar();
        heapMax.eliminar();

        assertEquals( "2",heapMax.obtener());//Verifico que al eliminar todos menos 1 nodo, el que queda sea 2
    }

}
