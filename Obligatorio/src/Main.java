import uy.edu.um.prog2.adt.hash.HashTableImpl;
import uy.edu.um.prog2.adt.hash.MyHashTable;

import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        MyHashTable<String,User> hashUsers= new HashTableImpl<>(630000);
        MyHashTable<String,HashTag> hashHashtags= new HashTableImpl<>(600000);
        MyHashTable<Long,Tweet> hashTweets= new HashTableImpl<>(630000);
        CargaDatos carga = new CargaDatos();
        carga.datos(hashUsers,hashHashtags,hashTweets);
        System.out.println(hashHashtags.size());
        System.out.println(hashUsers.size());
        System.out.println(hashTweets.size());
    }

}
