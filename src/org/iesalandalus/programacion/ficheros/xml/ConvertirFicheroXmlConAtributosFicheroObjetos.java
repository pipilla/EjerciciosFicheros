package org.iesalandalus.programacion.ficheros.xml;

import org.iesalandalus.programacion.ficheros.Persona;
import org.iesalandalus.programacion.utilidades.Entrada;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.*;

public class ConvertirFicheroXmlConAtributosFicheroObjetos {
    private static final String FICHERO = String.format("%s%s%s", "ejemplos", File.separator, "personas_atributos.xml");

    public static void main(String[] args) {
        System.out.printf("%nDime el nombre del fichero que quieres guardar como copia: ");
        String ficheroNuevo = Entrada.cadena();

        try (ObjectOutputStream entrada = new ObjectOutputStream(new FileOutputStream(ficheroNuevo))) {
            Document documentoXml = UtilidadesXml.leerDocumentoXml(FICHERO);
            if (documentoXml != null) {
                System.out.println("Fichero leído correctamente.");
                NodeList personas = documentoXml.getElementsByTagName("persona");
                for (int i = 0; i < personas.getLength(); i++) {
                    Node persona = personas.item(i);
                    if (persona.getNodeType() == Node.ELEMENT_NODE) {
                        String nombre = ((Element)persona).getAttribute("nombre");
                        int edad = Integer.parseInt(((Element)persona).getAttribute("edad"));
                        entrada.writeObject(new Persona(nombre, edad));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero.");
        } catch (IOException e) {
            System.out.println("Error inesperado de entrada/salida.");
        }


    }
}
