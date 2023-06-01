package uy.edu.um.prog2.adt.linkedlist;
import org.junit.Test;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;


import static org.junit.Assert.*;
public class LinkedListImplTest {

    @Test
    public void testListaEnlazada(){
        MyLinkedList<Integer> lista = new MyLinkedListImpl<>();
        //Añado 3 elementos
        lista.add(8);
        lista.add(14);
        lista.add(55);

        assertEquals(3,lista.size()); //Verifico que haya 3
        assertEquals((Integer)8, lista.get(0));//Verifico que el primer elemento sea 0
        assertEquals((Integer)55, lista.get(2));//Verifico que el tercer elemento sea 0
        //Elimino el primer elemento
        lista.remove(0);

        assertEquals(2,lista.size());//Verifico que haya 2 elmentos restantes
        //Elimino una posicion mayor al size de mi lista
        lista.remove(12);

        assertEquals(2,lista.size());//Verifico que no haya cambiado nada
        //Agrego un elemento al pricipio
        lista.addFirst(99);

        assertEquals((Integer)99, lista.get(0));//Verifico quue se haya insertado primero
        assertEquals((Integer)14, lista.get(1));//Verifico que el primero ahora es el segundo


        assertNull(lista.get(40));//Verifico que devuelve null al pedir un elemento con un indice mayor al size


    }

}
