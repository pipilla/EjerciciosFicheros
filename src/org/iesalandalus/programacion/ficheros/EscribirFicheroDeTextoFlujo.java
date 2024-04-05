package org.iesalandalus.programacion.ficheros;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

import static org.iesalandalus.programacion.utilidades.Entrada.cadena;

public class EscribirFicheroDeTextoFlujo {
    private static final String FICHERO = String.format("%s%s%s", "ejemplos", File.separator, "ficheroTexto.txt");

    public static void main(String[] args) {
        try (FileWriter entrada = new FileWriter(FICHERO)) {
            System.out.println("Escribe el contenido del fichero:");
            String escrito;
            while (!(escrito = Entrada.cadena()).equals("|")) {
                entrada.write(escrito);
                entrada.write(String.format("%n"));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero.");
        } catch (IOException e) {
            System.out.println("Ha habido un error con el fichero.");
        }
    }
}
