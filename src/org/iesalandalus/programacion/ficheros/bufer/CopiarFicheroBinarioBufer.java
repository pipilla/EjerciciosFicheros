package org.iesalandalus.programacion.ficheros.bufer;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class CopiarFicheroBinarioBufer {
    private static final String FICHERO = String.format("%s%s%s", "ejemplos", File.separator, "pantera_rosa.jpg");
    public static void main(String[] args) {
        System.out.printf("%nDime el nombre del fichero que quieres guardar como copia: ");
        String ficheroNuevo = Entrada.cadena();

        try (BufferedOutputStream ficheroCopia = new BufferedOutputStream(new FileOutputStream(ficheroNuevo));
             BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(FICHERO))) {
            int origen;
            while ((origen = entrada.read()) != -1) {
                ficheroCopia.write(origen);
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
