/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas.persistencia;

import control.Db4oConnectionManager;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author alos
 */
public class DogContainerTester {
    public static void main(String[] args) {

        DogContainer cont = new DogContainer();

        Dog d1 = new Dog();
        d1.setNombre("Bobby");
        LinkedList<String> nicknames = new LinkedList<String>();
        nicknames.add("bob");
        nicknames.add("bobo");
        d1.setApodos(nicknames);

        Dog d2= new Dog();
        d2.setNombre("Lucky");
        LinkedList<String> nicknames2 = new LinkedList<String>();
        nicknames2.add("lol");
        nicknames2.add("uky");
        d2.setApodos(nicknames2);

        cont.saveDog(d1);
        cont.saveDog(d2);


       
        Db4oConnectionManager.closeDB();
    }
}
