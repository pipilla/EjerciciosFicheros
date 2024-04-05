package org.iesalandalus.programacion.ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MostrarFicheroDeTextoBufer {
    private static final String FICHERO = String.format("%s%s%s", "ejemplos", File.separator, "ficheroTexto.txt");

    public static void main(String[] args) {
        try (FileReader entrada = new FileReader(FICHERO)) {
            int leido;
            while ((leido = entrada.read()) != -1) {
                System.out.print(((char) leido));
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero.");
        } catch (IOException e) {
            System.out.println("Ha habido un error con el fichero.");
        }
    }
}
