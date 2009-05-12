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
package cloudContainers;

import com.db4o.ObjectSet;
import java.util.LinkedList;
import modelo.TemporalReference;
import modelo.descriptors.CitationDescriptor;

/**
 *
 * @author oswa
 */
public class TemporalReferencesContainer extends Container {

    public TemporalReferencesContainer() {
        super();
    }

    public void saveItems(TemporalReference item) {
        try {
            //Hacer la validacion para q no halla dups
            db.store(item);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /*public CitationDescriptor getFirstCitationDescriptor(){

    CitationDescriptor citDesc=new CitationDescriptor();
    try{
    ObjectSet readed = db.queryByExample(CitationDescriptor.class);
    while (readed.hasNext()){
    citDesc=(CitationDescriptor)readed.next();
    break;
    }
    }catch(Exception e){
    e.printStackTrace();
    }

    return citDesc;
    }*/
    /**
     * Deletes from DB an specific Citation matching the given pattern
     * @param atr
     */
    public boolean deleteTemporalReference(TemporalReference cit) {

        try {
            db.delete(db.queryByExample(cit).next());
            db.commit();
        } catch (Exception e) {
            System.out.println("Error Borrando");
            db.close();
            return false;
        }

        return true;
    }

    public LinkedList<TemporalReference> retrieveAllItemsLinkedList() {
        LinkedList<TemporalReference> item = new LinkedList<TemporalReference>();
        try {
            ObjectSet result = db.queryByExample(TemporalReference.class);

            for (int i = 0; i < result.size(); i++) {
                item.add((TemporalReference) result.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}
