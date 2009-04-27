/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import java.util.LinkedList;

/**
 *
 * @author alos
 */
public class PruebasChava {
    public static void main(String[] args) {
        LinkedList<Object> lista = new LinkedList<Object>();
        lista.add("Perro");
        lista.add(new Long(9));
        LinkedList<String > listaString = new LinkedList<String >();
        for(Object o: lista){
            String aux="";
            Long unLong=0L;
            try{
                 aux = (String)o;
                listaString.add(aux);
            }catch(java.lang.ClassCastException e){
                 unLong = (Long)o;
                listaString.add(unLong+"");
            }
            for(String s: listaString){
                System.out.println(s);
            }
        }
    }
}
