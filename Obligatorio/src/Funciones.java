import uy.edu.um.prog2.adt.hash.HashTableImpl;
import uy.edu.um.prog2.adt.hash.MyHashTable;
import uy.edu.um.prog2.adt.heapSort.HeapNode;
import uy.edu.um.prog2.adt.heap.MyHeapImpl;
import uy.edu.um.prog2.adt.heapSort.HeapSort;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Funciones {

    public static HeapNode<Integer, String>[] topPilotos(int anio, int mes, MyHashTable<Long, Tweet> hash) {
        HeapNode<Integer, String>[] heap = leerArchivo("Obligatorio/src/Data/drivers.txt");
        for (long i = 0; i < hash.size(); i++) {
            if (hash.get(i).getDate().getYear() == anio && hash.get(i).getDate().getMonthValue() == mes) {
                for (int j = 0; j < heap.length; j++) {
                    if (hash.get(i).getContent().toLowerCase().contains(heap[j].getData())) {
                        heap[j].setKey(heap[j].getKey() + 1);
                    }
                }
            }

        }
        HeapSort<Integer, String> heapSort = new HeapSort<>();
        heapSort.sort(heap);
        return heap;
    }


    public static HeapNode<Integer,User>[] topUsuarios(MyHashTable<String,User> hash){
        MyLinkedList<String> keys = hash.keys();
        HeapNode<Integer, User>[] heap = new HeapNode[keys.size()];
        for (int i = 0; i < hash.size(); i++) {
            hash.get(keys.get(i)).getTweets().size();
            heap[i] = new HeapNode<>(hash.get(keys.get(i)).getTweets().size(), hash.get(keys.get(i)));
        }
        HeapSort<Integer, User> heapSort = new HeapSort<>();
        heapSort.sort(heap);

        HeapNode<Integer, User>[] heapFinal = new HeapNode[15];
        for (int i = 0; i < 15; i++) {
            heapFinal[i] = heap[i];
        }
        return heapFinal;
    }

    public static int cantidadHashtags(int anio, int mes, int dia, MyHashTable<Long, Tweet> hash){
        MyLinkedList<Long> keys = hash.keys();
        MyLinkedList<String> hashtagslist = new MyLinkedListImpl<>();
        for (int i = 0; i < hash.size(); i++) {
            if (hash.get(keys.get(i)).getDate().getYear() == anio && hash.get(keys.get(i)).getDate().getMonthValue() == mes && hash.get(keys.get(i)).getDate().getDayOfMonth() == dia) {
                for (int j = 0; j < hash.get(keys.get(i)).getHashTags().size(); j++) {
                   String text =  hash.get(keys.get(i)).getHashTags().get(j).getText();
                   if (!hashtagslist.contains(text)){
                          hashtagslist.add(text);
                   }
                }
            }
        }
        return hashtagslist.size();
    }

    public static HashTag hashtagMasUsado(int anio, int mes, int dia){
        //recorrer el hash table y buscar el hashtag con mas tweets
        return null;
    }

    public static HeapNode<Integer,String>[] topFavoritos(){
        //heap sort para ordenar por cantidad de favoritos de mayor a menor
        return null;
    }

    public static int cantidadTweetsFrase(String frase){
        //recorrer el hash table y sumar la cantidad de tweets que contengan la frase
        return 0;
    }

    private  static HeapNode<Integer,String>[] leerArchivo(String nombreArchivo) {
        HeapNode<Integer,String>[] lista=new HeapNode[20];

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int contador = 0;
            while ((linea = br.readLine()) != null) {
                lista[contador]= new HeapNode<>(0,linea.toLowerCase());
                contador ++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

}