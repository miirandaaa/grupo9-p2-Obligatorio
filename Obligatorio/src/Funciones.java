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
        Long[] keys=hash.keysLong();
        for (int i = 0; i < hash.size(); i++) {
            if (hash.get(keys[i]).getDate().getYear() == anio && hash.get(keys[i]).getDate().getMonthValue() == mes) {
                for (int j = 0; j < heap.length; j++) {
                    if (hash.get(keys[i]).getContent().toLowerCase().contains(heap[j].getData())) {
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
        String[] keys=hash.keysString();
        HeapNode<Integer, User>[] heap = new HeapNode[keys.length];
        for (int i = 0; i < hash.size(); i++) {
            heap[i] = new HeapNode<>(hash.get(keys[i]).getTweets().size(), hash.get(keys[i]));
        }
        HeapSort<Integer, User> heapSort = new HeapSort<>();
        heapSort.sort(heap);

        HeapNode<Integer, User>[] heapFinal = new HeapNode[15];
        System.arraycopy(heap, 0, heapFinal, 0, 15);
        return heapFinal;
    }

    public static int cantidadHashtags(int anio, int mes, int dia, MyHashTable<Long, Tweet> hash){
        MyHashTable<String,String> hashtagsHash=new HashTableImpl<>(45000);
        Long[] llaves= hash.keysLong();
        for (int i = 0; i < hash.size(); i++) {
            if (hash.get(llaves[i]).getDate().getYear() == anio && hash.get(llaves[i]).getDate().getMonthValue() == mes && hash.get(llaves[i]).getDate().getDayOfMonth() == dia) {
                for (int j = 0; j < hash.get(llaves[i]).getHashTags().size(); j++) {
                   String text =  hash.get(llaves[i]).getHashTags().get(j).getText();
                   if (!hashtagsHash.contains(text)){
                       hashtagsHash.put(text,text);
                   }
                }
            }
        }
        return hashtagsHash.size();
    }

    public static String  hashtagMasUsado(int anio, int mes, int dia, MyHashTable<Long, Tweet> hash){
        int cantidad = cantidadHashtags(anio,mes,dia,hash);
        MyHashTable<String, HeapNode<Integer,String>> hashHashtags = new HashTableImpl<>(cantidad);
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
                    }
                }
            }
        }
        HeapNode<Integer,String>[] heap = new HeapNode[hashHashtags.size()];
        String[] keys = hashHashtags.keysString();
        if(keys.length==0){
            return null;
        } else {
            for (int m = 0; m< keys.length; m++){
                heap[m] = hashHashtags.get(keys[m]);
            }
            HeapSort<Integer, String> heapSort = new HeapSort<>();
            heapSort.sort(heap);
            return heap[0].getData();
        }

    }

    public static HeapNode<Integer,String>[] topFavoritos(MyHashTable<String,User> hash){
        String[] keys= hash.keysString();
        HeapNode<Integer,String>[] heap = new HeapNode[keys.length];
        for(int i=0; i<keys.length;i++){
            User usuario=hash.get(keys[i]);
            heap[i]=new HeapNode<>(usuario.getUserFavourites(),usuario.getName());
        }
        HeapSort<Integer, String> heapSort = new HeapSort<>();
        heapSort.sort(heap);
        HeapNode<Integer, String>[] heapFinal = new HeapNode[7];
        System.arraycopy(heap, 0, heapFinal, 0, 7);
        return heapFinal;
    }

    public static int cantidadTweetsFrase(String frase,MyHashTable<Long, Tweet> hash){
        frase=frase.toLowerCase();
        Long[] keys= hash.keysLong();
        int contador=0;
        for(int i=0; i< keys.length;i++){
            if(hash.get(keys[i]).getContent().toLowerCase().contains(frase)){
                contador++;
            }
        }
        return contador;
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