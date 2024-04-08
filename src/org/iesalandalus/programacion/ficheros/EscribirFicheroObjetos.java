package org.iesalandalus.programacion.ficheros;

import java.io.*;

public class EscribirFicheroObjetos {
    private static final String FICHERO = String.format("%s%s%s", "ejemplos", File.separator, "ficheroObjetos.obj");
    public static void main(String[] args) {

        Persona persona;
        String[] nombres = {"Alejandro", "Juan Miguel", "Antonio", "Pedrito"};
        int[] edades = {18, 19, 37, 23};
        try (ObjectOutputStream entrada = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            for (int i = 0; i < edades.length; i++) {
                persona = new Persona(nombres[i], edades[i]);
                entrada.writeObject(persona);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero.");
        } catch (IOException e) {
            System.out.println("Error inesperado de entrada/salida.");
        }
    }
}
