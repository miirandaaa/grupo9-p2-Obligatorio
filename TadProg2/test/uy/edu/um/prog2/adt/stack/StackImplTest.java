package uy.edu.um.prog2.adt.stack;
import org.junit.Test;
import uy.edu.um.prog2.adt.stack.MyStack;
import uy.edu.um.prog2.adt.stack.MyStackImpl;


import java.util.EmptyStackException;

import static org.junit.Assert.*;
public class StackImplTest {
    @Test
    public void testStack() {
        MyStack<Integer> pila = new MyStackImpl<>();

        //Pruebo añadir elementos a la pila
        pila.push(1);
        pila.push(13);
        pila.push(7);
        pila.push(22);

        assertEquals(4,pila.size()); //Verifico que se hayan ingresado los 4 elementos
        try {
            assertEquals((Integer) 22, pila.top()); //Verifico que el elemento de "mas arriba" sea el ultimo que ingrese
        } catch (EmptyStackException e){
            fail(e.getMessage());
        }

        //Pruebo eliminar un elemento

        try {
            pila.pop();
        } catch (EmptyStackException e){
            fail(e.getMessage());
        }

        assertEquals(3,pila.size()); //Verifico que se haya eliminado un elemento

        try {
            assertEquals((Integer) 7, pila.top()); //Verifico que el elemento de "mas arriba" sea el siguiente al elminado
        } catch (EmptyStackException e){
            fail(e.getMessage());
        }

        assertFalse(pila.isEmpty());//Verifico el is empty

        //Pruebo usar el vaciar stack;
        pila.makeEmpty();

        assertTrue(pila.isEmpty());//Verifico que se encuentre vacia

        //Verifico que me lanze y agarre la excepcion correcta
        try {
            pila.pop();
        } catch (EmptyStackException e){
            assertTrue(true);
        }

    }
}
