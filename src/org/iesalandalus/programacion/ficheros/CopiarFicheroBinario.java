package org.iesalandalus.programacion.ficheros;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class CopiarFicheroBinario {
    private static final String FICHERO = String.format("%s%s%s", "ejemplos", File.separator, "pantera_rosa.jpg");
    public static void main(String[] args) {
        System.out.printf("%nDime el nombre del fichero que quieres guardar como copia: ");
        String ficheroNuevo = Entrada.cadena();

        try (FileInputStream ficheroCopia = new FileInputStream(ficheroNuevo);
             FileOutputStream entrada = new FileOutputStream(FICHERO)) {
            int origen;
            while ((origen = entrada.read()) != -1) {
                ficheroCopia.write(((char) origen));
            }
            System.out.println("Fichero copiado.");

        } catch (FileNotFoundException e) {
            if (e.getMessage().startsWith(ficheroNuevo)) {
                System.out.printf("No se puede leer el fichero %s.%n", ficheroNuevo);
            } else {
                System.out.printf("No se puede leer el fichero %s.%n", FICHERO);
            }
        } catch (IOException e) {
            if (e.getMessage().startsWith(ficheroNuevo)) {
                System.out.printf("Ha habido un error con el fichero %s.%n", ficheroNuevo);
            } else {
                System.out.printf("Ha habido un error con el fichero %s.%n", FICHERO);
            }
        }
    }
}
