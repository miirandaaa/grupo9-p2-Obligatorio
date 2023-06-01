package uy.edu.um.prog2.adt.bst;


import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;

public class NodeBST <K extends Comparable<K>, T>{
    private K key;
    private T data;
    private NodeBST <K, T> leftChild;
    private NodeBST <K, T> rightChild;

    public NodeBST(K key, T data) {
        this.key = key;
        this.data = data;
        this.leftChild=null;
        this.rightChild=null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public NodeBST<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeBST<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public NodeBST<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeBST<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    public T findN(K key) {
        T datos=null;
        if(this.key.compareTo(key)==0){
            datos=this.data;

        } else if (this.key.compareTo(key)<0) {
            if(this.rightChild!=null){
                return this.rightChild.findN(key);
            } else {
                return null;
            }
        } else {
            if(this.leftChild!=null){
                return this.leftChild.findN(key);
            } else {
                return null;
            }

        }
        return datos;
    }

    public NodeBST<K,T> max(){
        NodeBST<K,T> maximo=null;
        if(this.rightChild!=null){
            if(this.rightChild.rightChild!=null){
                return this.rightChild.max();
            } else {
                maximo=this.rightChild;
            }
        } else {
            maximo=this;
        }

        return maximo;
    }

    public NodeBST<K,T> min(){
        NodeBST<K,T> minimo=null;
        if(this.leftChild!=null){
            if(this.leftChild.leftChild!=null){
                return this.leftChild.min();
            } else {
                minimo=this.leftChild;
            }
        } else {
            minimo=this;
        }

        return minimo;
    }

    public void insert(K key,T data){
        if(this.key.compareTo(key)<=0){
            if(this.rightChild!=null){
                this.rightChild.insert(key,data);
            } else {
                NodeBST<K,T> der=new NodeBST<K,T>(key,data);
                this.setRightChild(der);
            }
        } else{
            if(this.leftChild!=null){
                this.leftChild.insert(key,data);
            } else {
                NodeBST<K,T> izq=new NodeBST<K,T>(key,data);
                this.setLeftChild(izq);
            }
        }
    }


    public void delete(K key, NodeBST<K,T> padre){
        //Comparo la clave que busco con la de donde estoy parado
        if(this.key.compareTo(key)<0){
            if(this.rightChild!=null){
                this.rightChild.delete(key,this);//Como es mas grande la que busco, voy a la derecha
            }
        }
        else if(this.key.compareTo(key)>0){
            if(this.leftChild!=null){
                this.leftChild.delete(key,this);//Como es mas chica la que busco, voy a la izquierda
            }
        } else if(this.key.compareTo(key)==0) {
            //Como es son iguales, el nodo donde estoy es el que busco
            if(this.leftChild!=null && this.rightChild!=null ){
                //Veo si tiene ambos hijos
                NodeBST<K,T> minimo=this.rightChild.min(); //Busco el minimo del arbol derecho
                //Swapeo los datos del minimo y como este va a ser nodo hoja, lo elimino.
                K llaveMin=minimo.getKey();
                T datosMin=minimo.getData();
                this.delete(minimo.getKey(),this);
                this.setKey(llaveMin);
                this.setData(datosMin);

            } else if(this.leftChild!=null && this.rightChild==null){
                //Veo si tiene solo hijo izquierdo
                NodeBST<K,T> maximo=this.leftChild.max();
                K llaveMax=maximo.getKey();
                T datosMax=maximo.getData();
                this.delete(maximo.getKey(),this);
                this.setKey(llaveMax);
                this.setData(datosMax);
            } else if(this.leftChild==null && this.rightChild!=null){
                //Veo si tiene solo hijo dereho
                NodeBST<K,T> minimo=this.rightChild.min();
                K llaveMin=minimo.getKey();
                T datosMin=minimo.getData();
                this.delete(minimo.getKey(),this);
                this.setKey(llaveMin);
                this.setData(datosMin);
            } else if(this.leftChild==null && this.rightChild==null){
                //Veo si es nodo hoja
                //Como es hoja, no tiene hijos entonces solo necesito marcar como null su clave y los datos.
                if(padre.getKey().compareTo(key)>0){
                    padre.setLeftChild(null);
                } else {
                    padre.setRightChild(null);
                }
                this.setKey(null);
                this.setData(null);
            }

        }

    }

    public MyLinkedList inOrder(MyLinkedList<K> listaInOrder, NodeBST<K,T> nodo) {
        if(nodo==null){
            return null;
        }
        inOrder(listaInOrder,nodo.leftChild);
        listaInOrder.add(nodo.key);
        inOrder(listaInOrder,nodo.rightChild);
        return listaInOrder;
    }
    public MyLinkedList postOrder(MyLinkedList<K> listaPostOrder, NodeBST<K,T> nodo) {
        if(nodo==null){
            return null;
        }
        postOrder(listaPostOrder,nodo.leftChild);
        postOrder(listaPostOrder,nodo.rightChild);
        listaPostOrder.add(nodo.key);
        return listaPostOrder;
    }
    public MyLinkedList preOrder(MyLinkedList<K> listaPreOrder, NodeBST<K,T> nodo) {
        if(nodo==null){
            return null;
        }
        listaPreOrder.add(nodo.key);
        preOrder(listaPreOrder,nodo.leftChild);
        preOrder(listaPreOrder,nodo.rightChild);

        return listaPreOrder;
    }


}
