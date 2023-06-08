package uy.edu.um.prog2.adt.heap;

public class MyHeapImpl<K extends Comparable<K>,T> implements MyHeap<K,T>{

    private boolean isMin;
    private HeapNode<K,T>[] heap;
    private int size;
    public MyHeapImpl(boolean isMin, int tamano) {
        this.size=0;
        this.isMin = isMin;
        this.heap = new HeapNode[tamano];
    }

    public boolean isMin() {
        return isMin;
    }

    public void setMin(boolean min) {
        isMin = min;
    }

    public HeapNode<K,T>[] getHeap() {
        return heap;
    }

    public void setHeap(HeapNode<K,T>[] heap) {
        this.heap = heap;
    }


    @Override
    public void agregar(K key, T elemento) {
        if(obtenerSize()== heap.length-1){
            duplicarTamano();
        }
        HeapNode<K,T> nodo=new HeapNode<>(key,elemento);
        if(size==0){
            heap[0]=nodo;
            size=size+1;
        } else{
            heap[size] = nodo;
            for(int pos=size; pos>0;pos--){
                int padre=(pos-1)/2;
                if((heap[pos].getKey().compareTo(heap[padre].getKey())<0 && isMin) || (heap[pos].getKey().compareTo(heap[padre].getKey())>0 && !isMin)){
                    HeapNode<K,T> aux=heap[padre];
                    heap[padre]=heap[pos];
                    heap[pos]=aux;
                }
                pos=padre+1;
            }
            size=size+1;
        }
    }

    @Override
    public T obtener() {
        return heap[0].getData();
    }

    @Override
    public void eliminar() {
        if(size==0){

        } else if(size==1){
            heap[0]=null;
            size=size-1;
        } else {
            heap[0]=heap[size-1];
            heap[size-1]=null;
            size=size-1;
            for(int pos=0; pos<size; pos++){
                int hijoizq = 2*pos + 1;
                int hijoder = 2*pos + 2;
                if(hijoizq<size && hijoder<size) {
                    if ((heap[pos].getKey().compareTo(heap[hijoizq].getKey()) > 0 && isMin) || (heap[pos].getKey().compareTo(heap[hijoder].getKey()) > 0 && isMin) ||
                        (heap[pos].getKey().compareTo(heap[hijoizq].getKey()) < 0 && !isMin) || (heap[pos].getKey().compareTo(heap[hijoder].getKey()) < 0 && !isMin)) {
                        HeapNode<K,T> aux;
                        if ((heap[hijoizq].getKey().compareTo(heap[hijoder].getKey()) > 0 && isMin) || (heap[hijoizq].getKey().compareTo(heap[hijoder].getKey()) < 0 && !isMin)) {
                            aux = heap[hijoder];
                            heap[hijoder] = heap[pos];
                            heap[pos] = aux;
                            pos = hijoder-1;
                        } else {
                            aux = heap[hijoizq];
                            heap[hijoizq] = heap[pos];
                            heap[pos] = aux;
                            pos = hijoizq-1;
                        }
                    } else {
                        break;
                    }
                } else if(hijoizq<size) {
                    if ((heap[pos].getKey().compareTo(heap[hijoizq].getKey()) > 0 && isMin) || (heap[pos].getKey().compareTo(heap[hijoizq].getKey()) < 0 && !isMin)) {
                        HeapNode<K,T> aux;
                        aux = heap[hijoizq];
                        heap[hijoizq] = heap[pos];
                        heap[pos] = aux;
                        pos = hijoizq-1;
                    } else {
                        break;
                    }

            } else {
                    break;
                }
            }
        }

    }


    @Override
    public int obtenerSize() {
        return this.size;
    }

    public void duplicarTamano(){
        HeapNode<K,T>[] heap2=  new HeapNode[this.heap.length*2];
        System.arraycopy(this.heap,0,heap2,0,this.size);
        this.heap=heap2;

    }

}
