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
import modelo.descriptors.PagesDescriptor;

/**
 *
 * @author alos
 */
public class PagesDescriptorContainer extends Container {

    public PagesDescriptorContainer() {
        super();
    }

    /**
     * Saves one specific Author
     * @param atr
     */
    public void savePagesDescriptor(PagesDescriptor atr) {
        try {
            db.store(atr);
        //System.out.println("Se guardo: "+atr.name);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    /**
     * Deletes from DB an specific AuthorDescriptor matching the given pattern
     * @param atr
     */
    public boolean deleteAuthorDescriptor(PagesDescriptor atr) {
        try {
            db.delete(db.queryByExample(atr).next());
            db.commit();
        } catch (Exception e) {
            System.out.println("Error Borrando: " + atr.toString());
            return false;
        }
        return true;
    }

    /**
     * Returns the first PagesDescriptor element found in the DB
     * @return
     */
    public PagesDescriptor getPagesDescriptor() {
        PagesDescriptor pagesDesc = new PagesDescriptor();
        try {
            ObjectSet readed = db.queryByExample(PagesDescriptor.class);
            while (readed.hasNext()) {
                pagesDesc = (PagesDescriptor) readed.next();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pagesDesc;
    }
}
