/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import control.Db4oConnectionManager;
import java.util.LinkedList;
import modelo.Citation;
import modelo.TemporalReference;

/**
 *
 * @author alos
 */
public class RecuperadorDBCitas {
    public static void main(String[] args) {
        cloudContainers.CitationContainer contenedor = new cloudContainers.CitationContainer();
        //cloudContainers.TemporalReferencesContainer contenedor = new cloudContainers.TemporalReferencesContainer();
        System.out.println("Looking for all citations...");
        //LinkedList<TemporalReference> respuesta = contenedor.retrieveAllItemsLinkedList();
        LinkedList<Citation> respuesta = contenedor.retrieveAllItemsLinkedList();
        System.out.println("Done retriving..." + respuesta.size());
        for(Citation cita: respuesta){
            System.out.println(cita.getDate());
            System.out.println("----------cita "+cita+"-------------");
            System.out.println("autores: "+cita.getAutors());
            System.out.println("paginas: "+cita.getPages());
            System.out.println("titulo: "+cita.getTitle());
            System.out.println("volume: "+cita.getVolume());
            System.out.println(cita.getPublisher());
            System.out.println(cita.getPeriodicalTitle());
            System.out.println(cita.getIdRevCitada());
            System.out.println(cita.getIdRevOrigen());
            System.out.println(cita.getLocation());
            System.out.println("tipo: "+cita.getType());
            System.out.println("issn: "+cita.getMetaData().getIssn());
            System.out.println("isbn: "+cita.getMetaData().getIsbn());
            System.out.println("lenguaje: "+cita.getMetaData().getLanguage());
            
            System.out.println("fecha: "+cita.getDate());
        }
        Db4oConnectionManager.closeDB();
    }
}
