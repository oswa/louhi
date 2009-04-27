/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import java.util.LinkedList;
import localContainers.*;
import modelo.Author;
import modelo.descriptors.DescriptorAnswer;

/**
 *
 * @author alos
 */
public class PruebaDeAuthorDescriptor {

 public static void main(String[] args) {
        AuthorDescriptorContainer authorDescriptorContainer = new AuthorDescriptorContainer();
        modelo.descriptors.AuthorDescriptor ad =  authorDescriptorContainer.getAuthorDescriptor();

        String f1 = "Aharon, I., Etcoff N., Ariely D., Chabris C.F., O’Connor E., & Breiter, Dracula \nH.C";
        String f2 = "Okuda, Michael,";
        String f3 = "Ok, Mi, Den Ive";
        String f4 = "Aharon, I., Etcoff, N., Ariely, D., Chabris, C.F., O’Connor, E. H.C.";
        String f5 = "Okuda, Michael, Denise Okuda. 1993.";

        DescriptorAnswer resp = null;

          System.out.println("=========Prueba 1=========");
        System.out.println("Para: "+f1);
        resp =ad.runRules(f1);
        System.out.println("Respuesta: "+resp.getAnswer());
        System.out.println("Score: "+resp.getScore());
        LinkedList<Author> listaAuthores = (LinkedList<Author>) resp.getObject();
        for(Author a: listaAuthores){
            System.out.println(a);
        }

        /*System.out.println("=========Prueba 2=========");
        System.out.println("Para: "+f2);
        resp =ad.runRules(f2);
        System.out.println("Respuesta: "+resp.getAnswer());
        System.out.println("Score: "+resp.getScore());
        listaAuthores = (LinkedList<Author>) resp.getObject();
        for(Author a: listaAuthores){
            System.out.println(a);
        }

        System.out.println("=========Prueba 3=========");
        System.out.println("Para: "+f3);
        resp =ad.runRules(f3);
        System.out.println("Respuesta: "+resp.getAnswer());
        System.out.println("Score: "+resp.getScore());
         listaAuthores = (LinkedList<Author>) resp.getObject();
        for(Author a: listaAuthores){
            System.out.println(a);
        }

        System.out.println("=========Prueba 4=========");
        System.out.println("Para: "+f4);
        resp =ad.runRules(f4);
        System.out.println("Respuesta: "+resp.getAnswer());
        System.out.println("Score: "+resp.getScore());
        listaAuthores = (LinkedList<Author>) resp.getObject();
        for(Author a: listaAuthores){
            System.out.println(a);
        }

        System.out.println("=========Prueba 5=========");
        System.out.println("Para: "+f5);
        resp =ad.runRules(f5);
        System.out.println("Respuesta: "+resp.getAnswer());
        System.out.println("Score: "+resp.getScore());
        listaAuthores = (LinkedList<Author>) resp.getObject();
        for(Author a: listaAuthores){
            System.out.println(a);
        }
*/
        control.Db4oConnectionManager.closeDB();

    }
}
