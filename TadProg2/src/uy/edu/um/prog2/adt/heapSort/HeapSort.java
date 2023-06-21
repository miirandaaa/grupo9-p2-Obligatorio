package uy.edu.um.prog2.adt.heapSort;

import uy.edu.um.prog2.adt.bst.NodeBST;

import java.util.ArrayList;

public class HeapSort <K extends Comparable<K>,T>{

    public HeapNode<K,T>[] sort(HeapNode<K,T>[] lista){
        int largo=lista.length;
        //TRANSFORMAR ARRAY A HEAP
        for(int i=0; i<largo; i++){
            int actual=i;
            int padre=(i-1)/2;
            while(padre !=0){
                if(lista[padre].getKey().compareTo(lista[actual].getKey())>0){
                    swap(padre,actual,lista);
                    actual=padre;
                    padre=(actual-1)/2;
                } else {
                    break;
                }
            }
            if(padre==0){
                if(lista[padre].getKey().compareTo(lista[actual].getKey())>0){
                    swap(padre,actual,lista);
                }
            }

        }
        //TRANSFORMAR HEAP A LISTA ORDENADA
        int j=largo-1;
       while(j>0){
           HeapNode<K,T> aux=lista[0];
           lista[0]=lista[j];
           lista[j]=aux;
           j--;
           int k=0;
           while(k<j){
               int hijoizq=(2*k)+1;
               int hijoder=(2*k)+2;
               if(hijoder<=j){
                   if(lista[k].getKey().compareTo(lista[hijoizq].getKey())>0||lista[k].getKey().compareTo(lista[hijoder].getKey())>0){
                       if(lista[hijoder].getKey().compareTo(lista[hijoizq].getKey())>0){
                           swap(hijoizq,k,lista);
                           k=hijoizq;
                       } else {
                           swap(hijoder,k,lista);
                           k=hijoder;
                       }
                   } else {
                       break;
                   }
               } else if(hijoizq<=j){
                   if(lista[k].getKey().compareTo(lista[hijoizq].getKey())>0){
                       swap(hijoizq,k,lista);
                       k=hijoizq;
                   } else {
                       break;
                   }
               } else {
                   break;
               }
           }
       }

        return lista;
    }

    private void swap(int nodo1,int nodo2,HeapNode<K,T>[] lista){
        HeapNode<K,T> aux=lista[nodo1];
        lista[nodo1]=lista[nodo2];
        lista[nodo2]=aux;
    }

    public void print(HeapNode<K,T>[] lista){

        for(int i=0; i<lista.length;i++){
            System.out.println(lista[i].getData());
        }
    }


}
