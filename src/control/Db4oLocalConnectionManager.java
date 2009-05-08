/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.config.Configuration;
import java.util.GregorianCalendar;

/**
 *
 * @author alos
 */
public class Db4oLocalConnectionManager {

  /*protected static String host="localhost";//148.215.24.26";
  protected static String user= "admin";
  protected static String pass= "admin";
  protected static int port = 1983;*/

  private static ObjectContainer ref;



  public static ObjectContainer getDb4oSingleton()
  {
    Configuration config = Db4o.newConfiguration();
    config.objectClass(GregorianCalendar.class).storeTransientFields(true);
    if (ref == null)
        // it's ok, we can call this constructor
            // it's ok, we can call this constructor
            ref = Db4o.openFile(config, "LouhiAI.louhi");

    return ref;
  }

  @Override
  public Object clone()
	throws CloneNotSupportedException
  {
    throw new CloneNotSupportedException();
    // that'll teach 'em
  }

  public static void closeDB() {
        if(ref != null)
            ref.close();
    }
}
