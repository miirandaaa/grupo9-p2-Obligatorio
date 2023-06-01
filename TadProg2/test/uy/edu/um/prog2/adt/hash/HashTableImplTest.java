package uy.edu.um.prog2.adt.hash;
import uy.edu.um.prog2.adt.hash.HashTableImpl;
import uy.edu.um.prog2.adt.hash.MyHashTable;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import org.junit.Test;


import static org.junit.Assert.*;
public class HashTableImplTest {

    @Test
    public void testHashTable(){
        MyHashTable<Integer,String> hash1= new HashTableImpl<>(5);

        hash1.put(4,"Nashe");
        hash1.put(5,"Hola");
        hash1.put(6,"Adios");
        hash1.put(7,"Perro");
        hash1.put(8,"Colo");

        assertEquals("Hola",hash1.get(5));
        assertEquals("Colo",hash1.get(8));

        try {
            hash1.get(10);
        } catch (RuntimeException e){
            assertTrue(true);
        }

        assertTrue(hash1.contains(8));
        assertFalse(hash1.contains(100));

        MyLinkedList<Integer> llaves= new MyLinkedListImpl<>();
        llaves=hash1.keys();

        assertEquals(5,llaves.size());
        assertEquals((Integer) 5,llaves.get(0));

        hash1.remove(4);
        hash1.remove(5);
        assertEquals(3,hash1.size());
        assertFalse(hash1.contains(5));

        hash1.put(10,"mimi");
        assertEquals("mimi",hash1.get(10));

    }
}
