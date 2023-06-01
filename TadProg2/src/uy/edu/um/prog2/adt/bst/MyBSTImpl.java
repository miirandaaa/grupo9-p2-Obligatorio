package uy.edu.um.prog2.adt.bst;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;

public class MyBSTImpl<K extends Comparable<K>,T> implements MyBinarySearchTree<K,T> {
    private NodeBST<K,T> root;

    public MyBSTImpl() {
        this.root = null;
    }

    public NodeBST<K, T> getRoot() {
        return root;
    }

    public void setRoot(NodeBST<K, T> root) {
        this.root = root;
    }

    @Override
    public T find(K key) {
        return root.findN(key);
    }

    @Override
    public void insert(K key, T data) {
        if(this.root==null){
            this.root=new NodeBST<K,T>(key,data);
        } else {
            this.root.insert(key,data);
        }
    }
    @Override
    public void delete(K key) {
        if(root!=null){
            //Si quiero eliminar la raiz y no tiene hijos
            if(root.getKey().compareTo(key)==0 && root.getLeftChild()==null && root.getRightChild()==null){
                this.root=null;
            }
            root.delete(key,null);
        }

    }

    @Override
    public NodeBST<K, T> max() {
        return root.max();
    }

    @Override
    public NodeBST<K, T> min() {
        return root.min();
    }
    @Override
    public MyLinkedList<K> inOrder(MyLinkedList<K> lista) {
        this.root.inOrder(lista,root);
        return lista;
    }
    @Override
    public MyLinkedList<K> postOrder(MyLinkedList<K> lista) {
        this.root.postOrder(lista,root);
        return lista;
    }
    @Override
    public MyLinkedList<K> preOrder(MyLinkedList<K> lista) {
        this.root.preOrder(lista,root);
        return lista;
    }

}

