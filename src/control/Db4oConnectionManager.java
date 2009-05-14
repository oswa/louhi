/*
 *
 * This file is part of Louhi.

    Louhi is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License.

    Louhi is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Louhi.  If not, see <http://www.gnu.org/licenses/>.
 */

package control;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.config.Configuration;
import java.util.GregorianCalendar;
import util.OswaReader;

/**
 *
 * @author alos & oswa
 */
public class Db4oConnectionManager{

  /*protected static String host="localhost";//148.215.24.26";
  protected static String user= "admin";
  protected static String pass= "admin";
  protected static int port = 1983;*/
  
  private static ObjectContainer ref;
    private static String host;
    private static String pass;
    private static String user;
    private static int port;

  private Db4oConnectionManager()
  {
   
  }

    public static ObjectContainer getDb4oSingleton() {
        OswaReader or = new OswaReader();
        String host = or.getPropiedad("HOST");
        String pass = or.getPropiedad("PASS");
        String user = or.getPropiedad("USER");
        int port = Integer.parseInt(or.getPropiedad("PORT"));

        Configuration config = Db4o.newConfiguration();
        config.objectClass(GregorianCalendar.class).storeTransientFields(true);
        config.activationDepth(Integer.MAX_VALUE);
        if (ref == null) // it's ok, we can call this constructor
        // it's ok, we can call this constructor
        {
            ref = Db4o.openClient(config, host, port, user, pass);
        }

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
