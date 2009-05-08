/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas.persistencia;

import control.Db4oConnectionManager;
import java.util.LinkedList;
import modelo.Author;

/**
 *
 * @author alos
 */
public class PruebaDePersistenciaDeAutores {
    public static void main(String[] args) {
        Author a1 = new Author("Pablo, Picaso");
        Author a2 = new Author("Antony Hopkins");

       cloudContainers.AuthorContainer contenedorDeAutores = new cloudContainers.AuthorContainer();

       contenedorDeAutores.saveAuthor(a1);
       contenedorDeAutores.saveAuthor(a2);

        LinkedList<Author> authors = contenedorDeAutores.retrieveAllAuthors();

        for(Author a: authors)
            System.out.println(a.getName());

        Db4oConnectionManager.closeDB();
    }
}
