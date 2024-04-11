package org.iesalandalus.programacion.ficheros;

import java.io.*;

public class LeerFicheroObjetos {
    private static final String FICHERO = String.format("%s%s%s", "ejemplos", File.separator, "personas_copia_elementos_xml.obj");
    public static void main(String[] args) {


        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO))) {
            Persona persona;
            int i = 0;
            while ((persona = (Persona) entrada.readObject()) != null) {
                i++;
                System.out.printf("Persona nº%s -> Nombre: %s - Edad: %s%n", i, persona.getNombre(), persona.getEdad());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero.");
        } catch (EOFException e) {
            System.out.println("Fichero leído correctamente.");
        } catch (IOException e) {
            System.out.println("No puedo abrir el fichero de entrada.");
        } catch (ClassNotFoundException e) {
            System.out.println("No puedo encontrar la clase que tengo que leer.");
        }
    }
}
