/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import control.Db4oConnectionManager;
import java.util.LinkedList;
import modelo.Citation;

/**
 *
 * @author alos
 */
public class RecuperadorDBCitas {
    public static void main(String[] args) {
        cloudContainers.CitationContainer contenedor = new cloudContainers.CitationContainer();
        System.out.println("Looking for all citations...");
        LinkedList<Citation> respuesta = contenedor.retrieveAllItemsLinkedList();
        System.out.println("Done retriving...");
        for(Citation cita: respuesta){
            System.out.println(cita.getDate());
        }
        Db4oConnectionManager.closeDB();
    }
}
