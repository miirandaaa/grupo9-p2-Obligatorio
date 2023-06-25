import uy.edu.um.prog2.adt.hash.HashTableImpl;
import uy.edu.um.prog2.adt.hash.MyHashTable;
import uy.edu.um.prog2.adt.heapSort.HeapNode;

import java.io.IOException;
import java.util.Scanner;

public class DataBase {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean datosCargados = false;
        MyHashTable<String,User> hashUsers= new HashTableImpl<>(120000);
        MyHashTable<Long,Tweet> hashTweets= new HashTableImpl<>(650000);
        while (true) {
            System.out.println("Menu principal: \n1 Cargar Datos \n2 Pilotos mas Mencionados \n3 Top 15 Usuarios con mas Tweets \n4 Cantidad de Hashtags \n5 Hashtag mas Usado \n6 Top 7 Cuentas con mas Favoritos \n7 Cantidad de Tweets con una Frase Especifica \n8 Salir \nOpcion:  ");
            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion < 1 || opcion > 8) {
                System.out.println("Ingrese un número válido.");
                continue;
            }

            if (opcion == 1 && !datosCargados){
                //long startTime = System.currentTimeMillis(); // Start time
                CargaDatos carga = new CargaDatos();
                carga.datos(hashUsers,hashTweets);
                datosCargados = true;
                //long endTime = System.currentTimeMillis(); //End time
                //long executionTime = endTime - startTime; //Execution time in milliseconds
                //System.out.println("Execution time: " + executionTime + " milliseconds");
            }

            //Listar 10 pilotos activos mas mencionados en un mes y año especifico
            if (opcion == 2 && datosCargados){
                System.out.println("Ingrese el año que desea consultar (2021 o 2022): ");
                int anio = sc.nextInt();
                sc.nextLine();
                if (!validateAnio(anio)) {continue;}
                System.out.println("Ingrese el mes que desea consultar (2021(7-12) en 2022(1-8): ");
                int mes = sc.nextInt();
                sc.nextLine();
                if (!validateMes(anio,mes)) {continue;}
                //long startTime = System.currentTimeMillis();  //Start time
                HeapNode<Integer,String>[] heap = Funciones.topPilotos(anio, mes, hashTweets);
                System.out.println("Los 10 Pilotos mas Mencionados son: ");
                //long endTime = System.currentTimeMillis(); //End time
                //long executionTime = endTime - startTime;// Execution time in milliseconds
                //System.out.println("Execution time: " + executionTime + " milliseconds");
                for (int i = 0; i < 10; i++) {
                    System.out.println(heap[i].getData() + " " + heap[i].getKey());
                }
                System.out.println("Presione enter para continuar.");
                sc.nextLine();
            }

            //Top 15 usuarios con mas tweets
            if (opcion == 3 && datosCargados){
                //long startTime = System.currentTimeMillis();  //Start time
                HeapNode<Integer,User>[] heapUser =  Funciones.topUsuarios(hashUsers);
                //long endTime = System.currentTimeMillis(); //End time
                //long executionTime = endTime - startTime;// Execution time in milliseconds
                //System.out.println("Execution time: " + executionTime + " milliseconds");
                System.out.println("Los 15 Usuarios con mas Tweets son: ");
                for (int i = 0; i < 15; i++) {
                    System.out.println("Username: "+heapUser[i].getData().getName() + " - Cantidad de Tweets: "+ heapUser[i].getKey()+ " - Verificado: " + heapUser[i].getData().isVerified());
                }
                System.out.println("Presione enter para continuar.");
                sc.nextLine();
            }

            //Cantidad de distintos Hashtags en un dia especifico
            if (opcion == 4 && datosCargados){
                System.out.println("Ingrese el año que desea consultar (2021 o 2022): ");
                int anio = sc.nextInt();
                sc.nextLine();
                if (!validateAnio(anio)) {continue;}
                System.out.println("Ingrese el mes que desea consultar (2021(7-12) en 2021(1-8)): ");
                int mes = sc.nextInt();
                sc.nextLine();
                if (!validateMes(anio, mes)) {continue;}
                System.out.println("Ingrese el dia que desea consultar (1 al 31): ");
                int dia = sc.nextInt();
                sc.nextLine();
                if (!validateDia(dia)) {continue;}
                //long startTime = System.currentTimeMillis(); // Start time
                int cantidad = Funciones.cantidadHashtags(anio,mes, dia, hashTweets);
                //long endTime = System.currentTimeMillis(); //End time
                //long executionTime = endTime - startTime;// Execution time in milliseconds
                //System.out.println("Execution time: " + executionTime + " milliseconds");
                System.out.println("La cantidad de Hashtags es: " + cantidad);
                System.out.println("Presione enter para continuar.");
                sc.nextLine();

            }

            //Hashtag mas usado en un dia especifico sin tener en cuenta f1
            if (opcion == 5 && datosCargados){
                System.out.println("Ingrese el año que desea consultar (2021 o 2022): ");
                int anio = sc.nextInt();
                sc.nextLine();
                if (!validateAnio(anio)) {continue;}
                System.out.println("Ingrese el mes que desea consultar (2021(7-12) en 2021(1-8)): ");
                int mes = sc.nextInt();
                sc.nextLine();
                if (!validateMes(anio,mes)) {continue;}
                System.out.println("Ingrese el dia que desea consultar (1 al 31): ");
                int dia = sc.nextInt();
                sc.nextLine();
                if (!validateDia(dia)) {continue;}
                //long startTime = System.currentTimeMillis(); // Start time
                String hashMasUsado = Funciones.hashtagMasUsado(anio,mes, dia, hashTweets);
                //long endTime = System.currentTimeMillis(); //End time
                //long executionTime = endTime - startTime;// Execution time in milliseconds
                //System.out.println("Execution time: " + executionTime + " milliseconds");
                if(hashMasUsado==null){
                    System.out.println("No hay Hashtags en ese dia.");
                } else {
                    System.out.println("El Hashtag mas usado es: " + hashMasUsado);
                }
                System.out.println("Presione enter para continuar.");
                sc.nextLine();

            }

            //Top 7 usuarios con mas favoritos
            if (opcion == 6 && datosCargados){
                //long startTime = System.currentTimeMillis(); // Start time
                HeapNode<Integer,String>[] heapFavoritos =  Funciones.topFavoritos(hashUsers);
                //long endTime = System.currentTimeMillis(); //End time
                //long executionTime = endTime - startTime;// Execution time in milliseconds
                //System.out.println("Execution time: " + executionTime + " milliseconds");
                System.out.println("Los 7 Usuarios con mas Favoritos son: ");
                for (int i = 0; i < 7; i++) {
                    System.out.println("Username: "+heapFavoritos[i].getData() + " - Cantidad de favoritos: "+ heapFavoritos[i].getKey());
                }
                System.out.println("Presione enter para continuar.");
                sc.nextLine();

            }

            //Cantidad de tweets con una frase especifica
            if (opcion == 7 && datosCargados){
                System.out.println("Ingrese la frase que desea consultar: ");
                String frase = sc.nextLine();
                //long startTime = System.currentTimeMillis(); // Start time
                int cantidad=Funciones.cantidadTweetsFrase(frase,hashTweets);
                //long endTime = System.currentTimeMillis(); //End time
                //long executionTime = endTime - startTime;// Execution time in milliseconds
                //System.out.println("Execution time: " + executionTime + " milliseconds");
                System.out.println("La cantidad de Tweets con la frase es: "+cantidad);
                System.out.println("Presione enter para continuar.");
                sc.nextLine();
            }

            if (opcion == 8){
                break;
            }
        }
        sc.close();
    }
    private static boolean validateAnio(int anio) {
        if (anio < 2021 || anio > 2022) {
            System.out.println("Ingrese un año válido.");
            return false;
        }
        return true;
    }
    private static boolean validateMes(int anio, int mes) {
        if ((anio == 2021 && (mes < 7 || mes > 12)) || (anio == 2022 && (mes < 1 || mes > 8))) {
            System.out.println("Ingrese un mes válido.");
            return false;
        }
        return true;
    }
    private static boolean validateDia(int dia) {
        if (dia < 1 || dia > 31) {
            System.out.println("Ingrese un día válido.");
            return false;
        }
        return true;
    }
}
