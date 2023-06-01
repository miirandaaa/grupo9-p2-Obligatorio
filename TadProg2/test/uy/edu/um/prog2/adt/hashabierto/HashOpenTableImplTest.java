package uy.edu.um.prog2.adt.hashabierto;
import org.junit.Test;
import uy.edu.um.prog2.adt.hashabierto.HashOpenOpenTableImpl;
import uy.edu.um.prog2.adt.hashabierto.MyHashOpenTable;


import static org.junit.Assert.*;
public class HashOpenTableImplTest {
    @Test
    public void testHashTable(){
        MyHashOpenTable<Integer,String> tablaHash=new HashOpenOpenTableImpl<>(4);
        //Inserto datos en el hash
        tablaHash.put(1,"hola");
        tablaHash.put(4,"adios");
        tablaHash.put(7,"manuel");
        tablaHash.put(11,"jose");
        tablaHash.put(33,"perro");
        tablaHash.put(9,"arbol");
        tablaHash.put(8,"ola");
        tablaHash.put(2,"chau");

        //Compruebo que todos se encuentren dentro
        assertTrue(tablaHash.contains(1));
        assertTrue(tablaHash.contains(4));
        assertTrue(tablaHash.contains(7));
        assertTrue(tablaHash.contains(11));
        assertTrue(tablaHash.contains(33));
        assertTrue(tablaHash.contains(9));
        assertTrue(tablaHash.contains(8));
        assertTrue(tablaHash.contains(2));

        //Elimino un elemento
        tablaHash.remove(8);
        //Verifico que ya no se encuentre en el hash
        assertFalse(tablaHash.contains(8));
        //Verifico que el dato este bien asosciado a la llave
        assertEquals("perro",tablaHash.get(33));


    }
}
