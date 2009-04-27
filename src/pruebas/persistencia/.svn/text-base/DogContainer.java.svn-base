/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas.persistencia;

import java.util.LinkedList;
import com.db4o.ObjectContainer;
import com.db4o.ObjectServer;
import com.db4o.Db4o;


import com.db4o.ObjectSet;
import com.db4o.config.Configuration;
import com.db4o.ext.DatabaseFileLockedException;
import com.db4o.query.Predicate;
import com.db4o.ta.TransparentActivationSupport;
import java.util.List;
import modelo.Citation;

/**
 *
 * @author alos
 */
public class DogContainer {
    public final static String NOMBREARCHIVO = "Perros.sfx";

    public void saveDog(Dog item) {
        Configuration configuration = Db4o.newConfiguration();
        configuration.activationDepth(6);
       ObjectContainer db = Db4o.openFile(configuration,NOMBREARCHIVO);
		try {

				db.store(item);

				System.out.println("Stored " + item);

		} catch (DatabaseFileLockedException ex) {
			ex.printStackTrace();
		} finally {
			db.close();
		}
    }

    public void deleteItems(Citation item) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public Object searchItemByID(int idBuscado) {

        return new Object();
    }


    public Object[] retrieveAllItems() {
        return null;
    }


    public LinkedList<Dog> retrieveAllItemsLinkedList() {
       ObjectContainer db = Db4o.openFile(NOMBREARCHIVO);
        try {
			ObjectSet result = db.queryByExample(Dog.class);
			LinkedList<Dog> item = new LinkedList<Dog>();
			for (int i = 0; i < result.size(); i++) {
				item.add((Dog) result.get(i));
			}
			return item;
        }
        finally {
            db.close();
        }
    }

    public List<Dog> getDogByName(String aName) {
        Configuration configuration = Db4o.newConfiguration();
        configuration.activationDepth(Integer.MAX_VALUE);
        ObjectContainer db = Db4o.openFile(configuration, NOMBREARCHIVO);

        final String name = aName;
        try {
                List<Dog> perros = db.query(new Predicate<Dog>() {
                public boolean match(Dog aDog) {
                    return (aDog.getNombre().compareToIgnoreCase(name) == 0);
                }
            });

            System.out.println("En el contenedor:");
            for(Dog t: perros){
            System.out.println(t.toString());
            }

            return perros;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Cerrando db");
            db.close();
        }
         return null;
    }

    



}
