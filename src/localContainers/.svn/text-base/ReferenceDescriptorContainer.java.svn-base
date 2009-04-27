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
import modelo.descriptors.ReferenceDescriptor;
import exceptions.DataBaseNotFoundException;
import java.util.LinkedList;

/**
 *
 * @author luis
 */
public class ReferenceDescriptorContainer extends Container {

    public ReferenceDescriptorContainer() {
        super();
    }

    /**
     * Saves one specific Reference Descriptor
     * @param refDesc
     */
    public void saveReferenceDescriptor(ReferenceDescriptor refDesc) {
        try {
            db.store(refDesc);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    /**
     * Deletes from DB an specific Reference Descriptor matching the given pattern
     * @param refDesc
     */
    public boolean deleteReferenceDescriptor(ReferenceDescriptor refDesc) {
        try {
            db.delete(db.queryByExample(refDesc).next());
            db.commit();
        } catch (Exception e) {
            db.close();
            return false;
        }
        return true;
    }

    /**
     * Searchs for one Reference Descriptor that matches witch an specific attribute
     * @param attribute
     * @return
     */
    public LinkedList<ReferenceDescriptor> getReferenceDescriptor(String attribute) {
        LinkedList<ReferenceDescriptor> readedData = new LinkedList<ReferenceDescriptor>();
        ReferenceDescriptor refDesc = new ReferenceDescriptor();
        try {
            ObjectSet readed = db.queryByExample(refDesc);
            while (readed.hasNext()) {
                readedData.add((ReferenceDescriptor) readed.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readedData;
    }

    /**
     * Returns the first ReferenceDescriptor element found in the DB
     * @return
     */
    public ReferenceDescriptor getReferenceDescriptor() throws DataBaseNotFoundException {
        ReferenceDescriptor refDesc = new ReferenceDescriptor();
        try {
            ObjectSet readed = db.queryByExample(ReferenceDescriptor.class);
            while (readed.hasNext()) {
                refDesc = (ReferenceDescriptor) readed.next();
                break;
            }
        } catch (com.db4o.ext.Db4oIOException dbe) {
            throw new DataBaseNotFoundException();
        } catch (Exception e) {

            e.printStackTrace();
        }

        return refDesc;
    }

    /**
     * Gets a list of all the reference descriptors
     * @return
     */
    public LinkedList<ReferenceDescriptor> retrieveAllReferenceDescriptors() {
        LinkedList<ReferenceDescriptor> readedData = new LinkedList<ReferenceDescriptor>();
        ReferenceDescriptor refDesc = new ReferenceDescriptor();

        try {
            ObjectSet readed = db.queryByExample(refDesc);
            while (readed.hasNext()) {
                readedData.add((ReferenceDescriptor) readed.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return readedData;
    }
}
