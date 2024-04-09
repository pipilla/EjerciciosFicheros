package org.iesalandalus.programacion.ficheros.csv;

import org.iesalandalus.programacion.ficheros.Persona;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.io.*;

import static java.lang.Integer.parseInt;

public class ConvertirFicheroObjetosEnCsv {
    private static final String FICHERO = String.format("%s%s%s", "ejemplos", File.separator, "datos.csv");
    private static final String SEPARADOR = ",";

    public static void main(String[] args) {
        System.out.printf("%nDime el nombre del fichero que quieres guardar como copia: ");
        String ficheroNuevo = Entrada.cadena();

        try (BufferedReader entrada = new BufferedReader(new FileReader(FICHERO));
        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ficheroNuevo))) {
            String leido;
            while ((leido = entrada.readLine()) != null) {
                String[] datos = leido.split(SEPARADOR);
                Persona persona = new Persona(datos[0], parseInt(datos[1]));
                salida.writeObject(persona);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no se ha podido encontrar.");
        } catch (IOException e) {
            System.out.println("Ha habido un error con el fichero.");
        }
    }

}
