/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import java.util.LinkedList;
import modelo.Author;

/**
 *
 * @author alos
 */
public class RecuperadorDeAutores {
 public static void main(String[] args) {
        cloudContainers.AuthorContainer contenedor = new cloudContainers.AuthorContainer();
        LinkedList<Author> respuesta = contenedor.retrieveAllAuthors();
        for(Author autor: respuesta){
            System.out.println("El Autor: " +autor.name);
        }
    }
}
