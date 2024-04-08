package org.iesalandalus.programacion.ficheros;

import java.io.*;

public class LeerFicheroDatosPrimitivos {

    private static final String FICHERO = String.format("%s%s%s", "ejemplos", File.separator, "ficheroTextoPrimitivo.bin");
    public static void main(String[] args) {
        try (DataInputStream entrada = new DataInputStream(new FileInputStream(FICHERO))) {
            mostrarContenido(entrada);
        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el fichero.");
        } catch (IOException e) {
            System.out.println("Ha habido un error con el fichero.");
        }
    }

    private static void mostrarContenido(DataInputStream entrada) throws IOException{
        try {
            String texto = "";
            int entero;
            double decimal;
            int n = 0;
            while (texto != null) {
                texto = entrada.readUTF();
                entero = entrada.readInt();
                decimal = entrada.readDouble();
                n++;
                System.out.printf("Cadena nº%s -> Cadena: %s; Entero: %s; Real: %s;%n", n, texto, entero, decimal);
            }
        } catch (EOFException e) {
            System.out.println("Fichero leído.");
        }
    }
}
