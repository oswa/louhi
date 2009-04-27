/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import localContainers.VolumeDescriptorContainer;
import modelo.descriptors.DescriptorAnswer;

/**
 *
 * @author alos
 */
public class PruebaDeDescriptorDeVolumen {

    public static void main(String[] args) {
        VolumeDescriptorContainer volumeDescriptorContainer = new VolumeDescriptorContainer();
        modelo.descriptors.VolumeDescriptor pd = volumeDescriptorContainer.getVolumeDescriptor();

        String f1 = "vol. 12";
        String f2 = "1205";
        String f3 = "12:";
        String f4 = "32, 512-612";

        DescriptorAnswer resp = null;
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

        System.out.println("=========Prueba 4=========");
        System.out.println("Para: " + f4);
        resp = pd.runRules(f4);
        System.out.println("Respuesta: " + resp.getAnswer());
        System.out.println("Score: " + resp.getScore());

        control.Db4oConnectionManager.closeDB();
    }
}
