/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import localContainers.PublisherDescriptorContainer;

/**
 *
 * @author alos
 */
public class PruebaDeDescriptorDePublisher {

    public static void main(String[] args) {
        PublisherDescriptorContainer publisherDescriptorContainer = new PublisherDescriptorContainer();
        modelo.descriptors.PublisherDescriptor pd = publisherDescriptorContainer.getPublisherDescriptor();
        String f1 = "Facultad de Chile";
        String f2 = "O'relly";
        String f3 = "Okuda Michael Denise";

        modelo.descriptors.DescriptorAnswer resp = null;
        System.out.println("=========Prueba 1=========");
        System.out.println("Para: " + f1);
        resp = pd.runRules(f1);
        System.out.println("Respuesta: " + resp.getAnswer());
        System.out.println("Score: " + resp.getScore());

        System.out.println("=========Prueba 2=========");
        System.out.println("Para: " + f2);
        resp = pd.runRules(f2);
        System.out.println("Respuesta: " + resp.getAnswer());
        System.out.println("Score: " + resp.getScore());

        System.out.println("=========Prueba 3=========");
        System.out.println("Para: " + f3);
        resp = pd.runRules(f3);
        System.out.println("Respuesta: " + resp.getAnswer());
        System.out.println("Score: " + resp.getScore());

        control.Db4oConnectionManager.closeDB();
    }

}
