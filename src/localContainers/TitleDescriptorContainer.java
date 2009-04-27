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
import modelo.descriptors.TitleDescriptor;

/**
 *
 * @author alos
 */
public class TitleDescriptorContainer extends Container {

    public TitleDescriptorContainer(){
        super();
    }


    public void saveTitleDescriptor(TitleDescriptor tit) {
        

        try {
            db.store(tit);
        //System.out.println("Se guardo: "+atr.name);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    /**
     * Deletes from DB an specific Title matching the given pattern
     * @param args
     */
    public  boolean deleteTitleDescriptor(TitleDescriptor tit) {
       
        try {
            db.delete(db.queryByExample(tit).next());
            db.commit();
        } catch (Exception e) {
            System.out.println("Error Borrando: " + tit);
            db.close();
            return false;
        } 
        return true;
    }



       /**
     * Returns the first ReferenceDescriptor element found in the DB
     * @return
     */
    public  TitleDescriptor getTitleDescriptor() {
        
        TitleDescriptor titDesc = new TitleDescriptor();
        try {
            ObjectSet readed = db.queryByExample(TitleDescriptor.class);
            while (readed.hasNext()) {
                titDesc = (TitleDescriptor) readed.next();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return titDesc;
    }
}
