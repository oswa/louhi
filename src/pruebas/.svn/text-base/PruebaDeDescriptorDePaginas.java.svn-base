/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import localContainers.PagesDescriptorContainer;
import modelo.descriptors.DescriptorAnswer;

/**
 *
 * @author alos
 */
public class PruebaDeDescriptorDePaginas {

    public static void main(String[] args) {
        PagesDescriptorContainer pagesDescriptorContainer = new PagesDescriptorContainer();

        modelo.descriptors.PagesDescriptor pd =  pagesDescriptorContainer.getPagesDescriptor();

        String f1 = "133";
        String f2 = "120-133";
        String f3 = "pp 144";

        DescriptorAnswer resp = null;
        System.out.println("=========Prueba 1=========");
        System.out.println("Para: "+f1);
        resp =pd.runRules(f1);
        System.out.println("Respuesta: "+resp.getAnswer()+": "+resp.getObject().toString());
        System.out.println("Score: "+resp.getScore());

        System.out.println("=========Prueba 2=========");
        System.out.println("Para: "+f2);
        resp =pd.runRules(f2);
        System.out.println("Respuesta: "+resp.getAnswer()+": "+resp.getObject().toString());
        System.out.println("Score: "+resp.getScore());

        System.out.println("=========Prueba 3=========");
        System.out.println("Para: "+f3);
        resp =pd.runRules(f3);
        System.out.println("Respuesta: "+resp.getAnswer()+": "+resp.getObject().toString());
        System.out.println("Score: "+resp.getScore());

        control.Db4oConnectionManager.closeDB();
    }
}
