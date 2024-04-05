package org.iesalandalus.programacion.ficheros;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class CopiarFicheroDeTextoFlujo {
    private static final String FICHERO = String.format("%s%s%s", "ejemplos", File.separator, "ficheroTexto.txt");

    public static void main(String[] args) {
        System.out.printf("%nDime el nombre del fichero que quieres guardar como copia: ");
        String nombreFichero = Entrada.cadena();
        File nuevoFichero = new File(nombreFichero);

        try (FileWriter ficheroCopia = new FileWriter(nuevoFichero)) {
            try (FileReader entrada = new FileReader(FICHERO)) {
                int origen;
                while ((origen = entrada.read()) != -1) {
                    ficheroCopia.write(((char) origen));
                }
                System.out.println("Fichero copiado.");
            } catch (FileNotFoundException e) {
                System.out.println("No se puede leer el fichero.");
            } catch (IOException e) {
                System.out.println("Ha habido un error con el fichero.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero.");
        } catch (IOException e) {
            System.out.println("Ha habido un error con el fichero.");
        }
    }
}
