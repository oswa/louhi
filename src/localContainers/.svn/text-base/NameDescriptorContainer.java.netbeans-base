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

import com.db4o.ObjectSet;
import java.util.LinkedList;
import modelo.descriptors.NameDescriptor;

/**
 *
 * @author luis
 */
public class NameDescriptorContainer extends Container {

    public NameDescriptorContainer() {
        super();
    }

    /**
     * Saves one specific Name Descriptor
     * @param namDesc
     */
    public void saveNameDescriptor(NameDescriptor namDesc) {

        try {
            db.store(namDesc);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    /**
     * Deletes from DB an specificNameDescriptor matching the given pattern
     * @param namDesc
     */
    public boolean deleteNameDescriptor(NameDescriptor namDesc) {
        try {
            db.delete(db.queryByExample(namDesc).next());
            db.commit();
        } catch (Exception e) {
            db.close();
            return false;
        }
        return true;
    }

    /**
     * Returns the first NameDescriptor element found in the DB
     * @return
     */
    public NameDescriptor getNameDescriptor() {
        NameDescriptor namDesc = new NameDescriptor();
        try {
            ObjectSet readed = db.queryByExample(NameDescriptor.class);
            while (readed.hasNext()) {
                namDesc = (NameDescriptor) readed.next();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return namDesc;
    }

    /**
     * Searchs for one Name Descriptor that matches witch an specific attribute
     * @param attribute
     * @return
     */
    public LinkedList<NameDescriptor> getNameDescriptor(String attribute) {

        LinkedList<NameDescriptor> readedData = new LinkedList<NameDescriptor>();
        NameDescriptor namDesc = new NameDescriptor();
        //namDesc.FIELD =attribute; //Assign here the attribute or field to compare to
        try {
            ObjectSet readed = db.queryByExample(namDesc);
            while (readed.hasNext()) {
                readedData.add((NameDescriptor) readed.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readedData;
    }

    /**
     * Gets a list of all the name descriptors
     * @return
     */
    public LinkedList<NameDescriptor> retrieveAllNameDescriptors() {
        LinkedList<NameDescriptor> readedData = new LinkedList<NameDescriptor>();
        NameDescriptor namDesc = new NameDescriptor();

        try {
            ObjectSet readed = db.queryByExample(namDesc);
            while (readed.hasNext()) {
                readedData.add((NameDescriptor) readed.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readedData;
    }
}
