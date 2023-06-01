package uy.edu.um.prog2.adt.bst;
import uy.edu.um.prog2.adt.bst.MyBSTImpl;
import uy.edu.um.prog2.adt.bst.MyBinarySearchTree;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import org.junit.Test;


import static org.junit.Assert.*;
public class BSTImplTest {
    @Test
    public void testArbolBinario() {
        MyLinkedList<Integer> lista = new MyLinkedListImpl<>();
        MyBinarySearchTree<Integer, String> arbol = new MyBSTImpl<>();
        //Inserto datos al arbol
        arbol.insert(10, "root");
        arbol.insert(5,"cinco");
        arbol.insert(2,"dos");
        arbol.insert(8,"ocho");
        arbol.insert(20,"veinte");
        arbol.insert(15,"quince");
        arbol.insert(30,"treinta");

        //Verifico que se encuentren todos los elementos
        arbol.inOrder(lista);
        MyLinkedList<Integer> lista2 = new MyLinkedListImpl<>();
        lista2.add(2);
        lista2.add(5);
        lista2.add(8);
        lista2.add(10);
        lista2.add(15);
        lista2.add(20);
        lista2.add(30);

        for(int i=0; i<lista2.size(); i++){
            assertEquals(lista2.get(i),lista.get(i));
        }

        //Verifico que funcione el maximo y minimo
        assertEquals((Integer) 30,arbol.max().getKey());
        assertEquals((Integer) 2,arbol.min().getKey());

        //Verifico el eliminar

        arbol.delete(20);//Elimino el 20 del arbol
        lista2.remove(5);//Elimino el 20 de mi lista pasada
        MyLinkedList<Integer> listaOrden = new MyLinkedListImpl<>();
        arbol.inOrder(listaOrden);//Recorro el arbol con un inorder
        for(int i=0; i<lista2.size(); i++){
            assertEquals(lista2.get(i),listaOrden.get(i)); //Verifico que se encuentran todos los nodos
        }

        //Verifico el eliminar la raiz

        arbol.delete(10);//Elimino el 10 del arbol
        lista2.remove(3);//Elimino el 10 de mi lista pasada
        MyLinkedList<Integer> listaOrdenR = new MyLinkedListImpl<>();
        arbol.inOrder(listaOrdenR);//Recorro el arbol con un inorder
        for(int i=0; i<listaOrdenR.size(); i++){
            System.out.println(listaOrdenR.get(i)); //Verifico que se encuentran todos los nodos
        }

    }
}
