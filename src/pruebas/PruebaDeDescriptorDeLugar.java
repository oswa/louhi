/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import localContainers.LocationDescriptorContainer;

/**
 *
 * @author alos
 */
public class PruebaDeDescriptorDeLugar {

    public static void main(String[] args) {
        LocationDescriptorContainer locationDescriptorContainer = new LocationDescriptorContainer();
        modelo.descriptors.LocationDescriptor ld = locationDescriptorContainer.getLocationDescriptor();
        String f0 = "New York";
        String f1 = "Londres";
        String f2 = "México";
        String f3 = "Paris, Francia";

        modelo.descriptors.DescriptorAnswer resp = null;
        System.out.println("=========Prueba 0=========");
        System.out.println("Para: " + f0);
        resp = ld.runRules(f0);
        System.out.println("Respuesta: " + resp.getAnswer()+": "+resp.getObject().toString());
        System.out.println("Score: " + resp.getScore());

        System.out.println("=========Prueba 1=========");
        System.out.println("Para: " + f1);
        resp = ld.runRules(f1);
        System.out.println("Respuesta: " + resp.getAnswer()+": "+resp.getObject().toString());
        System.out.println("Score: " + resp.getScore());

        System.out.println("=========Prueba 2=========");
        System.out.println("Para: " + f2);
        resp = ld.runRules(f2);
        System.out.println("Respuesta: " + resp.getAnswer()+": "+resp.getObject().toString());
        System.out.println("Score: " + resp.getScore());

        System.out.println("=========Prueba 3=========");
        System.out.println("Para: " + f3);
        resp = ld.runRules(f3);
        System.out.println("Respuesta: " + resp.getAnswer()+": "+resp.getObject().toString());
        System.out.println("Score: " + resp.getScore());

        control.Db4oConnectionManager.closeDB();
    }
}
