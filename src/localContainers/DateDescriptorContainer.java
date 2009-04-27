/*
 This file is part of Louhi.

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
import modelo.descriptors.DateDescriptor;

/**
 *
 * @author alos
 */
public class DateDescriptorContainer extends Container {

    public DateDescriptorContainer(){
        super();
    }
    /**
     * Saves one specific Date Descriptor
     * @param namDesc
     */
    public void saveDateDescriptor(DateDescriptor dd) {
       try {
            db.store(dd);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } 
    }

    /**
     * Deletes from DB an specificNameDescriptor matching the given pattern
     * @param namDesc
     */
    public  boolean deleteDateDescriptor(DateDescriptor dd) {
       
        try {
            db.delete(db.queryByExample(dd).next());
            db.commit();
        } catch (Exception e) {
           
            return false;
        } 
        return true;
    }

    /**
     * Returns the first DateDescriptor element found in the DB
     * @return
     */
    public DateDescriptor getDateDescriptor() {
        
        DateDescriptor dd = new DateDescriptor();
        try {
            ObjectSet readed = db.queryByExample(DateDescriptor.class);
            while (readed.hasNext()) {
                dd = (DateDescriptor) readed.next();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return dd;
    }

    /**
     * Searchs for one date Descriptor that matches witch an specific attribute
     * @param attribute
     * @return
     */
    public LinkedList<DateDescriptor> getDateDescriptor(String attribute) {
        

        LinkedList<DateDescriptor> readedData = new LinkedList<DateDescriptor>();
        DateDescriptor dd = new DateDescriptor();
        //namDesc.FIELD =attribute; //Assign here the attribute or field to compare to
        try {
            ObjectSet readed = db.queryByExample(dd);
            while (readed.hasNext()) {
                readedData.add((DateDescriptor) readed.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return readedData;
    }

    /**
     * Gets a list of all the date descriptors
     * @return
     */
    public LinkedList<DateDescriptor> retrieveAllDateDescriptors() {
        
        LinkedList<DateDescriptor> readedData = new LinkedList<DateDescriptor>();
        DateDescriptor dd = new DateDescriptor();

        try {
            ObjectSet readed = db.queryByExample(dd);
            while (readed.hasNext()) {
                readedData.add((DateDescriptor) readed.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return readedData;
    }

    public  LinkedList<DateDescriptor> retrieveAllItemsLinkedList() {
        
        LinkedList<DateDescriptor> readedData = new LinkedList<DateDescriptor>();
        DateDescriptor dd = new DateDescriptor();

        try {
            ObjectSet readed = db.queryByExample(dd);
            while (readed.hasNext()) {
                readedData.add((DateDescriptor) readed.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return readedData;
    }
}
