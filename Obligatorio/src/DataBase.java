import uy.edu.um.prog2.adt.hash.HashTableImpl;
import uy.edu.um.prog2.adt.hash.MyHashTable;
import uy.edu.um.prog2.adt.heapSort.HeapNode;

import java.io.IOException;
import java.util.Scanner;

public class DataBase {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean datosCargados = false;
        MyHashTable<String,User> hashUsers= new HashTableImpl<>(630000);
        MyHashTable<String,HashTag> hashHashtags= new HashTableImpl<>(600000);
        MyHashTable<Long,Tweet> hashTweets= new HashTableImpl<>(630000);
        while (true) {
            System.out.println("Menu principal: \n1 Cargar Datos \n2 Pilotos mas Mencionados \n3 Top 15 Usuarios con mas Tweets \n4 Cantidad de Hashtags \n5 Hashtag mas Usado \n6 Top 7 Cuentas con mas Favoritos \n7 Cantidad de Tweets con una Frase Especifica \n8 Salir \nOpcion:  ");
            int opcion = sc.nextInt();

            if (opcion == 1 && !datosCargados){
            CargaDatos carga = new CargaDatos();
            carga.datos(hashUsers,hashHashtags,hashTweets);
            datosCargados = true;
            }

            if (opcion == 2 && datosCargados){
                System.out.println("Ingrese el año que desea consultar (2021 o 2022): ");
                int anio = sc.nextInt();
                System.out.println("Ingrese el mes que desea consultar (1 al 12): ");
                int mes = sc.nextInt();
                HeapNode<Integer,String>[] heap = Funciones.topPilotos(anio, mes, hashTweets);
                System.out.println("Los 10 Pilotos mas Mencionados son: ");
                for (int i = 0; i < 10; i++) {
                    System.out.println(heap[i].getData() + " " + heap[i].getKey());
                }
            }

            if (opcion == 3 && datosCargados){
                HeapNode<Integer,User>[] heapUser =  Funciones.topUsuarios(hashUsers);
                System.out.println("Los 15 Usuarios con mas Tweets son: ");
                for (int i = 0; i < 15; i++) {
                    System.out.println("Username: "+heapUser[i].getData().getName() + " Cantidad de Tweets: "+ heapUser[i].getKey()+ " Verificado: " + heapUser[i].getData().isVerified());
                }
            }

            if (opcion == 4 && datosCargados){
                System.out.println("Ingrese el año que desea consultar (2021 o 2022): ");
                int anio = sc.nextInt();
                System.out.println("Ingrese el mes que desea consultar (1 al 12): ");
                int mes = sc.nextInt();
                System.out.println("Ingrese el dia que desea consultar (1 al 31): ");
                int dia = sc.nextInt();
                int cantidad = Funciones.cantidadHashtags(anio,mes, dia, hashTweets);
                System.out.println("La cantidad de Hashtags es: " + cantidad);

            }

            if (opcion == 5 && datosCargados){
                System.out.println("Ingrese el año que desea consultar (2021 o 2022): ");
                int anio = sc.nextInt();
                System.out.println("Ingrese el mes que desea consultar (1 al 12): ");
                int mes = sc.nextInt();
                System.out.println("Ingrese el dia que desea consultar (1 al 31): ");
                int dia = sc.nextInt();
                String hashMasUsado = Funciones.hashtagMasUsado(anio,mes, dia, hashTweets);
                System.out.println("El Hashtag mas usado es: " + hashMasUsado);
            }

            if (opcion == 6 && datosCargados){
                Funciones.topFavoritos();
                System.out.println("Los 7 Usuarios con mas Favoritos son: ");
            }

            if (opcion == 7 && datosCargados){
                System.out.println("Ingrese la frase que desea consultar: ");
                String frase = sc.nextLine();
                Funciones.cantidadTweetsFrase(frase);
                System.out.println("La cantidad de Tweets con la frase es: ");
            }

            if (opcion == 8){
                break;
            }
        }
    }
}
