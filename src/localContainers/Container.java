/*
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

package localContainers;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.config.Configuration;
import java.util.GregorianCalendar;


/**
 *
 * @author alos & oswa
 */
public class Container {
    protected  ObjectContainer db = null;

    public Container(){
        Configuration config = Db4o.newConfiguration();
        config.objectClass(GregorianCalendar.class).storeTransientFields(true);
        db = Db4o.openFile(config, "LouhiAI.louhi");
    }

}

