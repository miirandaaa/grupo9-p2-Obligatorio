Para la ejecución, solo hay que poner los datasets dentro de la carpeta Data y ejecutar la clase DataBase que es donde se encuentra el main
Recomendamos abrir el proyecto seleccionando la carpeta obligatorio 
file->open project->(ruta donde tenga cargada la carpeta principal)->grupo9-p2-Obligatorio->Obligatorio
Para poder ejecutar la carga de datos debe añadir la librería commons-csv-1.10.0, para descargarla deberá acceder al siguiente link:
https://commons.apache.org/proper/commons-csv/download_csv.cgi
luego, deberá descomprimir el archivo en alguna carpeta que usted prefiera, ir a intellij
file->project structure->libraries
y ahi seleccionar la carpeta donde descargó la librería para luego añadirla al proyecto
----CONSIDERACIONES----
Las porximas consideraciones se explayan más en el pdf, pero en pocas palabras:
Consideramos el nombrbre de usuario como identificador de los usuarios.
Consideramos los favoritos como la cantidad de likes dados por el usuario y suponemos que el ultimo tweet del ususario corresponde al último ingresado en el sistema.
Los hashtags serán tomados case-insensitive.
Los reportes 1 y 6 son case-sensitive, es decir, dependiendo de la manera que sea escrito el input, dará resultados distintos.
