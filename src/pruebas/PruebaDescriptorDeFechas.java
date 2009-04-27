/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import java.text.SimpleDateFormat;
import localContainers.DateDescriptorContainer;
import modelo.Date;
import modelo.descriptors.DescriptorAnswer;

/**
 *
 * @author alos
 */
public class PruebaDescriptorDeFechas {
    public static void main(String[] args) {
        DateDescriptorContainer dateDescriptorContainer = new DateDescriptorContainer();
        modelo.descriptors.DateDescriptor dd =  dateDescriptorContainer.getDateDescriptor();
        Date d = new Date();

        String f1 = "1993";
        String f1failed = "1993. Star";
        String f2 = "febrero";
        String f3 = "enero, 12";
        String f4 = "enero 12, 1993";
        String f5 = "(1993, enero 12)";
        String f6 = "(1993)";
        String f7 = "accessed November 12, 1993";

        SimpleDateFormat formatter = new SimpleDateFormat();
       


        DescriptorAnswer resp = null;
        System.out.println("=========Prueba 1=========");
        System.out.println("Para: "+f1);
        resp =dd.runRules(f1);
        modelo.Date aDate = (modelo.Date)resp.getObject();
        System.out.println("Respuesta: "+resp.getAnswer()+": "+ formatter.format(aDate.getDate().getTime()));
        System.out.println("Score: "+resp.getScore());
        System.out.println("Date segun su statement"+aDate.getDateWithStatement());

        System.out.println("=========Prueba 1 Fail=========");
        System.out.println("Para: "+f1failed);
        resp =dd.runRules(f1failed);
        aDate = (modelo.Date)resp.getObject();
        System.out.println("Respuesta: "+resp.getAnswer()+": "+formatter.format(aDate.getDate().getTime()));
        System.out.println("Score: "+resp.getScore());
        System.out.println("Date segun su statement "+aDate.getDateWithStatement());

        System.out.println("=========Prueba 2=========");
        System.out.println("Para: "+f2);
        resp =dd.runRules(f2);
        aDate = (modelo.Date)resp.getObject();
        System.out.println("Respuesta: "+resp.getAnswer()+": "+formatter.format(aDate.getDate().getTime()));
        System.out.println("Score: "+resp.getScore());
        System.out.println("Date segun su statement "+aDate.getDateWithStatement());
        
        System.out.println("=========Prueba 3=========");
        System.out.println("Para: "+f3);
        resp =dd.runRules(f3);
        aDate = (modelo.Date)resp.getObject();
        System.out.println("Respuesta: "+resp.getAnswer()+": "+formatter.format(aDate.getDate().getTime()));
        System.out.println("Score: "+resp.getScore());
        System.out.println("Date segun su statement "+aDate.getDateWithStatement());

        System.out.println("=========Prueba 4=========");
        System.out.println("Para: "+f4);
        resp =dd.runRules(f4);
        aDate = (modelo.Date)resp.getObject();
        System.out.println("Respuesta: "+resp.getAnswer()+": "+formatter.format(aDate.getDate().getTime()));
        System.out.println("Score: "+resp.getScore());
        System.out.println("Date segun su statement "+aDate.getDateWithStatement());

        System.out.println("=========Prueba 5=========");
        System.out.println("Para: "+f5);
        resp =dd.runRules(f5);
        aDate = (modelo.Date)resp.getObject();
        System.out.println("Respuesta: "+resp.getAnswer()+": "+formatter.format(aDate.getDate().getTime()));
        System.out.println("Score: "+resp.getScore());
        System.out.println("Date segun su statement "+aDate.getDateWithStatement());

        System.out.println("=========Prueba 6=========");
        System.out.println("Para: "+f6);
        resp =dd.runRules(f6);
        aDate = (modelo.Date)resp.getObject();
        System.out.println("Respuesta: "+resp.getAnswer()+": "+formatter.format(aDate.getDate().getTime()));
        System.out.println("Score: "+resp.getScore());
        System.out.println("Date segun su statement "+aDate.getDateWithStatement());

        System.out.println("=========Prueba 7=========");
        System.out.println("Para: "+f7);
        resp =dd.runRules(f7);
        aDate = (modelo.Date)resp.getObject();
        System.out.println("Respuesta: "+resp.getAnswer()+": "+formatter.format(aDate.getDate().getTime()));
        System.out.println("Score: "+resp.getScore());
        System.out.println("Date segun su statement "+aDate.getDateWithStatement());

        control.Db4oConnectionManager.closeDB();
    }
}
