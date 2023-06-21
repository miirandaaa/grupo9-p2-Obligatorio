package uy.edu.um.prog2.adt.heapsort;

import org.junit.Test;
import uy.edu.um.prog2.adt.heap.MyHeap;
import uy.edu.um.prog2.adt.heap.MyHeapImpl;
import uy.edu.um.prog2.adt.heapSort.HeapNode;
import uy.edu.um.prog2.adt.heapSort.HeapSort;


import static org.junit.Assert.*;

public class HeapSortImplTest {
    @Test
    public void testHeap(){
        HeapNode<Integer,String>[] lista=new HeapNode[7];

        lista[0]=new HeapNode<>(2,"SEPTIMO");
        lista[1]=new HeapNode<>(1000,"PRIMERO");
        lista[2]=new HeapNode<>(80,"CUARTO");
        lista[3]=new HeapNode<>(4,"SEXTO");
        lista[4]=new HeapNode<>(13,"QUINTO");
        lista[5]=new HeapNode<>(99,"TERCERO");
        lista[6]=new HeapNode<>(140,"SEGUNDO");

        HeapSort<Integer,String> ord=new HeapSort<>();
        ord.sort(lista);
        assertEquals("PRIMERO",lista[0].getData());
        assertEquals("SEGUNDO",lista[1].getData());
        assertEquals("TERCERO",lista[2].getData());
        assertEquals("CUARTO",lista[3].getData());

    }
}
