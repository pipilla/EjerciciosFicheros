package org.iesalandalus.programacion.ficheros;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class CopiarFicheroDeTextoBufer {
    private static final String FICHERO = String.format("%s%s%s", "ejemplos", File.separator, "ficheroTexto.txt");

    public static void main(String[] args) {
        System.out.printf("%nDime el nombre del fichero que quieres guardar como copia: ");
        String ficheroNuevo = Entrada.cadena();

        try (BufferedWriter ficheroCopia = new BufferedWriter(new FileWriter(ficheroNuevo));
             BufferedReader entrada = new BufferedReader(new FileReader(FICHERO))) {
            String origen;
            while ((origen = entrada.readLine()) != null) {
            ficheroCopia.write(origen);
            ficheroCopia.newLine();
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
