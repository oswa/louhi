/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import localContainers.PeriodicalTitleDescriptorContainer;

/**
 *
 * @author alos
 */
public class PruebaDeDescriptorDePeriodicalTitles {
     public static void main(String[] args) {
        localContainers.PeriodicalTitleDescriptorContainer titleDescriptorContainer = new PeriodicalTitleDescriptorContainer();
        modelo.descriptors.PeriodicalTitleDescriptor td =  titleDescriptorContainer.getPeriodicalTitleDescriptor();

        String f0 = "Those who hunt elves.";
        String f1 = "The dog, the cat and the apple";
        String f2 = "\" Missing you \"";
        String f3 = "'Missing you'";

        modelo.descriptors.DescriptorAnswer resp = null;

        System.out.println("=========Prueba 0=========");
        System.out.println("Para: "+f0);
        resp =td.runRules(f0);
        System.out.println("Respuesta: "+resp.getAnswer());
        System.out.println("Score: "+resp.getScore());

        System.out.println("=========Prueba 1=========");
        System.out.println("Para: "+f1);
        resp =td.runRules(f1);
        System.out.println("Respuesta: "+resp.getAnswer());
        System.out.println("Score: "+resp.getScore());

        System.out.println("=========Prueba 2=========");
        System.out.println("Para: "+f2);
        resp =td.runRules(f2);
        System.out.println("Respuesta: "+resp.getAnswer());
        System.out.println("Score: "+resp.getScore());

        System.out.println("=========Prueba 3=========");
        System.out.println("Para: "+f3);
        resp =td.runRules(f3);
        System.out.println("Respuesta: "+resp.getAnswer());
        System.out.println("Score: "+resp.getScore());

        control.Db4oConnectionManager.closeDB();
    }
}
