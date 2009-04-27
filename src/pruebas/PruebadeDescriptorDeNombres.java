/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import localContainers.NameDescriptorContainer;

/**
 *
 * @author alos
 */
public class PruebadeDescriptorDeNombres {
     public static void main(String[] args) {
         NameDescriptorContainer nameDescriptorContainer = new NameDescriptorContainer();
        modelo.descriptors.NameDescriptor nd =  nameDescriptorContainer.getNameDescriptor();

        String f0 = "H.C.";
        String f1 = "Alos, Gato";
        String f2 = "Alos, G.";
        String f3 = "O’Connor, E. H.C.";

        modelo.descriptors.DescriptorAnswer resp = null;

        System.out.println("=========Prueba 0=========");
        System.out.println("Para: "+f0);
        resp =nd.runRules(f0);
        System.out.println("Respuesta: "+resp.getAnswer());
        System.out.println("Score: "+resp.getScore());

        System.out.println("=========Prueba 1=========");
        System.out.println("Para: "+f1);
        resp =nd.runRules(f1);
        System.out.println("Respuesta: "+resp.getAnswer());
        System.out.println("Score: "+resp.getScore());

        System.out.println("=========Prueba 2=========");
        System.out.println("Para: "+f2);
        resp =nd.runRules(f2);
        System.out.println("Respuesta: "+resp.getAnswer());
        System.out.println("Score: "+resp.getScore());

        System.out.println("=========Prueba 3=========");
        System.out.println("Para: "+f3);
        resp =nd.runRules(f3);
        System.out.println("Respuesta: "+resp.getAnswer());
        System.out.println("Score: "+resp.getScore());


        control.Db4oConnectionManager.closeDB();

    }
}
