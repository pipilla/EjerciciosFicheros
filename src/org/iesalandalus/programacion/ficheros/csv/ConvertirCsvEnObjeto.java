package org.iesalandalus.programacion.ficheros.csv;

import org.iesalandalus.programacion.ficheros.Persona;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

import static java.lang.Integer.parseInt;

public class ConvertirCsvEnObjeto {
    private static final String FICHERO = String.format("%s%s%s", "ejemplos", File.separator, "copia_personas_csv.obj");
    private static final String SEPARADOR = ",";

    public static void main(String[] args) {
        System.out.printf("%nDime el nombre del fichero que quieres guardar como copia: ");
        String ficheroNuevo = Entrada.cadena();

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO));
        BufferedWriter salida = new BufferedWriter(new FileWriter(ficheroNuevo))) {
            Persona persona;
            while ((persona = (Persona) entrada.readObject()) != null) {
                salida.write(String.format("%s%s%d%n", persona.getNombre(), SEPARADOR, persona.getEdad()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no se ha podido encontrar.");
        } catch (EOFException e) {
            System.out.println("Fichero copiado correctamente.");
        } catch (IOException e) {
            System.out.println("Ha habido un error con el fichero.");
        } catch (ClassNotFoundException e) {
            System.out.println("No puedo encontrar la clase que tengo que leer.");
        }
    }

}
