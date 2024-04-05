package org.iesalandalus.programacion.ficheros;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MostrarPropiedades {
    public static void main(String[] args) {
        String nombreFichero;
        do {
            System.out.printf("%nDime el fichero que quieres que muestre: ");
            nombreFichero = Entrada.cadena();
            if (!nombreFichero.equals("FIN")) {
                File fichero = new File(nombreFichero);
                if (!fichero.exists()) {
                    System.out.printf("El fichero %s no existe.%n", nombreFichero);
                } else {
                    if (fichero.isFile()) {
                        System.out.printf("%s es un archivo.%n", nombreFichero);
                    } else if (fichero.isDirectory()) {
                        System.out.printf("%s es un directorio.%n", nombreFichero);

                        if (fichero.list() != null) {
                            System.out.printf("Su contenido es el siguiente:%n");
                            for (String nombreFicheros : fichero.list()) {
                                System.out.printf("%s%n", nombreFicheros);
                            }
                        } else {
                            System.out.printf("El directorio está vacío.%n");
                        }
                    }
                    if (fichero.canRead()) {
                        System.out.printf("Tiene permisos de lectura.%n");
                    }
                    if (fichero.canWrite()) {
                        System.out.printf("Tiene permisos de escritura.%n");
                    }
                    if (fichero.canExecute()) {
                        System.out.printf("Se puede ejecutar.%n");
                    }
                    if (fichero.isHidden()) {
                        System.out.printf("Es un fichero oculto.%n");
                    }
                    System.out.printf("Longitud: %s bytes%n", fichero.length());
                    LocalDate ultimaModificacion = new Timestamp(fichero.lastModified()).toLocalDateTime().toLocalDate();
                    System.out.printf("Última modificación: %s%n", ultimaModificacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                }
            }
        } while (!nombreFichero.equals("FIN"));
    }
}
