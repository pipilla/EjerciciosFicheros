package org.iesalandalus.programacion.ficheros;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

public class EscribirFicheroDatosPrimitivos {

    private static final String FICHERO = String.format("%s%s%s", "ejemplos", File.separator, "ficheroTextoPrimitivo.bin");
    public static void main(String[] args) {
        try (DataOutputStream entrada = new DataOutputStream(new FileOutputStream(FICHERO))) {
            escribirContenido(entrada);
        } catch (FileNotFoundException e) {
            System.out.println("No se puede escribir el fichero.");
        } catch (IOException e) {
            System.out.println("Ha habido un error con el fichero.");
        }
    }

    private static void escribirContenido(DataOutputStream entrada) throws IOException {

        for (int i = 0; i < 10; i++) {
            System.out.print("Dime la cadena a escribir: ");
            entrada.writeUTF(Entrada.cadena());
            System.out.print("Dime el entero a escribir: ");
            entrada.writeInt(Entrada.entero());
            System.out.print("Dime el real doble a escribir: ");
            entrada.writeDouble(Entrada.realDoble());
            System.out.println();
        }
    }
}
