package org.iesalandalus.programacion.ficheros.bufer;

import java.io.*;

public class MostrarFicheroDeTextoBufer {
    private static final String FICHERO = String.format("%s%s%s", "ejemplos", File.separator, "ficheroTexto.txt");

    public static void main(String[] args) {
        try (BufferedReader entrada = new BufferedReader(new FileReader(FICHERO))) {
            String leido;
            while ((leido = entrada.readLine()) != null) {
                System.out.printf("%s%n", leido);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero.");
        } catch (IOException e) {
            System.out.println("Ha habido un error con el fichero.");
        }
    }
}
