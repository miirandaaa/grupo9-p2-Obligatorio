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
        HeapNode<Integer, String>[] heap = leerArchivo("src/Data/drivers.txt");
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
        MyLinkedList<String> hashtagslist = new MyLinkedListImpl<>();
        for (long i = 0; i < hash.size(); i++) {
            if (hash.get(i).getDate().getYear() == anio && hash.get(i).getDate().getMonthValue() == mes && hash.get(i).getDate().getDayOfMonth() == dia) {
                for (int j = 0; j < hash.get(i).getHashTags().size(); j++) {
                   String text =  hash.get(i).getHashTags().get(j).getText();
                   if (!hashtagslist.contains(text)){
                          hashtagslist.add(text);
                   }
                }
            }
        }
        return hashtagslist.size();
    }

    public static String  hashtagMasUsado(int anio, int mes, int dia, MyHashTable<Long, Tweet> hash){
        int cantidad = cantidadHashtags(anio,mes,dia,hash);
        MyHashTable<String, HeapNode<Integer,String>> hashHashtags = new HashTableImpl<>(cantidad);
        int contador = 0;
        boolean encontrado = false;
        for (long  i = 0; i < hash.size(); i++) {
            if (hash.get(i).getDate().getYear() == anio && hash.get(i).getDate().getMonthValue() == mes && hash.get(i).getDate().getDayOfMonth() == dia) {
                for (int j = 0; j < hash.get(i).getHashTags().size(); j++) {
                    String text =  hash.get(i).getHashTags().get(j).getText();
                    if (hashHashtags.contains(text) && !text.equalsIgnoreCase("f1")){
                            hashHashtags.get(text).setKey(hashHashtags.get(text).getKey()+1);
                            encontrado = true;
                            break;
                    }
                    if (!encontrado && !text.equalsIgnoreCase("f1")){
                        HeapNode<Integer,String> nuevo = new HeapNode<>(0,text);
                        hashHashtags.put(text,nuevo);
                        contador++;
                    }
                }
            }
        }
        HeapNode<Integer,String>[] heap = new HeapNode[hashHashtags.size()];
        MyLinkedList<String> keys = hashHashtags.keys();
        for (int m = 0; m< keys.size(); m++){
            heap[m] = hashHashtags.get(keys.get(m));
        }
        HeapSort<Integer, String> heapSort = new HeapSort<>();
        heapSort.sort(heap);
        return heap[0].getData();
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