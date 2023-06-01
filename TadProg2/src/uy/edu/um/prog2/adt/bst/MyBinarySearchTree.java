package uy.edu.um.prog2.adt.bst;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedList;

public interface MyBinarySearchTree<K extends Comparable<K>,T> {
    T find(K key);
    void insert (K key, T data);
    void delete (K key);
    MyLinkedList preOrder(MyLinkedList<K> listaPreOrder);
    MyLinkedList inOrder( MyLinkedList<K> listaInOrder);
    MyLinkedList postOrder( MyLinkedList<K> listaPostOrder);
    NodeBST<K,T> max();
    NodeBST<K,T> min();
}
