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
                Funciones.topPilotos(anio, mes);
                System.out.println("Los 10 Pilotos mas Mencionados son: ");
            }

            if (opcion == 3 && datosCargados){
                Funciones.topUsuarios();

                System.out.println("Los 15 Usuarios con mas Tweets son: ");
            }

            if (opcion == 4 && datosCargados){
                System.out.println("Ingrese el año que desea consultar (2021 o 2022): ");
                int anio = sc.nextInt();
                System.out.println("Ingrese el mes que desea consultar (1 al 12): ");
                int mes = sc.nextInt();
                System.out.println("Ingrese el dia que desea consultar (1 al 31): ");
                int dia = sc.nextInt();
                Funciones.cantidadHashtags(anio,mes, dia);
                System.out.println("La cantidad de Hashtags es: ");
            }

            if (opcion == 5 && datosCargados){
                System.out.println("Ingrese el año que desea consultar (2021 o 2022): ");
                int anio = sc.nextInt();
                System.out.println("Ingrese el mes que desea consultar (1 al 12): ");
                int mes = sc.nextInt();
                System.out.println("Ingrese el dia que desea consultar (1 al 31): ");
                int dia = sc.nextInt();
                HashTag hash = Funciones.hashtagMasUsado(anio,mes, dia);
                System.out.println("El Hashtag mas usado es:  ");
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



            sc.close();
        }
    }
}
