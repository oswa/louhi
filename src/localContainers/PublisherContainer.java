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
import modelo.Publisher;

/**
 *
 * @author alos
 */
public class PublisherContainer extends Container {

    public PublisherContainer() {
        super();
    }

    /**
     * Checks to see if its a publisher
     * @param aString
     * @return
     */
    public boolean isPublisher(String aString) {

        LinkedList<Publisher> readedData = new LinkedList<Publisher>();
        Publisher atr = new Publisher();
        atr.setName(aString);
        try {

            ObjectSet readed = db.queryByExample(atr);
            while (readed.hasNext()) {
                readedData.add((Publisher) readed.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (readedData.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Saves one specific Publisher
     * @param atr
     */
    public void savePublisher(Publisher pbl) {
        try {
            db.store(pbl);
        //System.out.println("Se guardo: "+atr.name);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    /**
     * Deletes from DB an specific Publisher matching the given pattern
     * @param args
     */
    public boolean deletePublisher(Publisher pbl) {
        try {
            db.delete(db.queryByExample(pbl).next());
            db.commit();
        } catch (Exception e) {
            System.out.println("Error Borrando: " + pbl.name);
            db.close();
            return false;
        }
        return true;
    }

    /**
     * Searchs for one Publisher matching a given publisher name
     * @param atrNam
     * @return
     */
    public LinkedList<Publisher> getPublisherByName(String atrNam) {

        LinkedList<Publisher> readedData = new LinkedList<Publisher>();
        Publisher pbl = new Publisher();
        pbl.name = atrNam;

        try {

            ObjectSet readed = db.queryByExample(pbl);
            while (readed.hasNext()) {
                readedData.add((Publisher) readed.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return readedData;
    }

    /**
     * Gets a list of all the existing Publishers
     * @return
     */
    public LinkedList<Publisher> retrieveAllPublishers() {
        LinkedList<Publisher> readedData = new LinkedList<Publisher>();
        Publisher pbl = new Publisher();

        try {

            ObjectSet readed = db.queryByExample(pbl);
            while (readed.hasNext()) {
                readedData.add((Publisher) readed.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return readedData;
    }
}
