package uy.edu.um.prog2.adt.queue;
import org.junit.Test;
import uy.edu.um.prog2.adt.queue.EmptyQueueException;
import uy.edu.um.prog2.adt.queue.MyQueue;
import uy.edu.um.prog2.adt.queue.MyQueueImpl;


import static org.junit.Assert.*;
public class QueueImplTest {
    @Test
    public void testQueue() {
        MyQueue<Integer> cola = new MyQueueImpl<>();

        //Pruebo ingresar elementos a la cola
        cola.enqueue(40);
        cola.enqueue(5);
        cola.enqueue(91);


        assertEquals(3,cola.size());//verifico que la cola tenga 3 elementos.
        //Compruebo el dequeue
        try {
            assertEquals((Integer) 40, cola.dequeue()); //Verifico que se elimina el elemento 40
        } catch (EmptyQueueException e) {
            fail(e.getMessage());
        }
        //Compruebo la funcion que me dice si una lista se enceuntra vacia

        assertFalse(cola.isEmpty()); //Como no esta vacia espero un false
        try {
             cola.dequeue();
        } catch (EmptyQueueException e) {
            fail(e.getMessage());
        }
        try {
            cola.dequeue();
        } catch (EmptyQueueException e) {
            fail(e.getMessage());
        }

        //Vuelvo a comprobar el isEmpty ahora que la lista esta vacia

        assertTrue(cola.isEmpty()); //Como esta vacia espero un true
    }
}
