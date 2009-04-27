/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import modelo.descriptors.AuthorDescriptor;

/**
 *
 * @author alos
 */
public class PruebaDeRegExp {
    public static void main(String[] args) {
            String cad= "Bonito, Gato. Feo, Perro";

            String []res = cad.split("[,.]");

            for(int i=0; i< res.length;i++)
                System.out.println(res[i]);

    }
}
