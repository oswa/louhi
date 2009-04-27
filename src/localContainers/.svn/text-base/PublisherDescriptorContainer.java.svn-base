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
import modelo.descriptors.PublisherDescriptor;

/**
 *
 * @author alos
 */
public class PublisherDescriptorContainer extends Container {

    public PublisherDescriptorContainer() {
        super();
    }

    /**
     * Saves one specific PublisherDescriptor
     * @param atr
     */
    public void savePublisherDescriptor(PublisherDescriptor atr) {
        try {
            db.store(atr);
        //System.out.println("Se guardo: "+atr.name);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    /**
     * Deletes from DB an specific PublisherDescriptor matching the given pattern
     * @param atr
     */
    public boolean deletePublisherDescriptor(PublisherDescriptor atr) {
        try {
            db.delete(db.queryByExample(atr).next());
            db.commit();
        } catch (Exception e) {
            System.out.println("Error Borrando: " + atr.toString());
            db.close();
            return false;
        }
        return true;
    }

    /**
     * Returns the first PublisherDescriptor element found in the DB
     * @return
     */
    public PublisherDescriptor getPublisherDescriptor() {
        PublisherDescriptor publisherDesc = new PublisherDescriptor();
        try {
            ObjectSet readed = db.queryByExample(PublisherDescriptor.class);
            while (readed.hasNext()) {
                publisherDesc = (PublisherDescriptor) readed.next();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publisherDesc;
    }
}
