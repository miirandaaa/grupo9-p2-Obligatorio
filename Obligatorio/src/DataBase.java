import uy.edu.um.prog2.adt.hash.HashTableImpl;

import java.io.IOException;
import java.util.Scanner;

public class DataBase {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean datosCargados = false;
        int opcion = 0;
        while (opcion != 8) {
            System.out.println("Menu principal: \n1 Cargar Datos \n2 Pilotos mas Mencionados \n3 Top 15 Usuarios con mas Tweets \n4 Cantidad de Hashtags \n5 Hashtag mas Usado \n6 Top 7 Cuentas con mas Favoritos \n7 Cantidad de Tweets con una Frase Especifica \n8 Salir \nOpcion:  ");
            opcion = sc.nextInt();

            if (opcion == 1 && !datosCargados){
            CargaDatos carga = new CargaDatos();
            //carga.datos();
            datosCargados = true;
            }

            if (opcion == 2 && datosCargados) {
                System.out.println("Ingrese el año que desea consultar (2021 o 2022): ");
                int anio = sc.nextInt();
                System.out.println("Ingrese el mes que desea consultar (1 al 12): ");
                int mes = sc.nextInt();
                //Aca llamar a la funcion topPilotos de Funciones
                System.out.println("Los 10 Pilotos mas Mencionados son: ");
            }

            sc.close();
        }
    }
}
