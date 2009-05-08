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

import localContainers.*;
import com.db4o.ObjectSet;
import java.util.LinkedList;
import modelo.Title;

/**
 *
 * @author Alos & Oswaldo
 */
public class TitleContainer extends Container {

    public TitleContainer() {
        super();
    }

    public void saveTitle(Title tit) {
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
    public boolean deleteTitle(Title tit) {
        try {
            db.delete(db.queryByExample(tit).next());
            db.commit();
        } catch (Exception e) {
            System.out.println("Error Borrando: " + tit.getATitle());
            return false;
        }
        return true;
    }

    /**
     * Searchs for one Title matching a given title name
     * @param atrNam
     * @return
     */
    public LinkedList<Title> getTitleByName(String atrNam) {
        LinkedList<Title> readedData = new LinkedList<Title>();
        Title tit = new Title();
        tit.setATitle(atrNam);
        try {

            ObjectSet readed = db.queryByExample(tit);
            while (readed.hasNext()) {
                readedData.add((Title) readed.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return readedData;
    }

    /**
     * Gets a list of all the existing Titles
     * @return
     */
    public LinkedList<Title> retrieveAllTitles() {
        LinkedList<Title> readedData = new LinkedList<Title>();
        Title tit = new Title();
        try {

            ObjectSet readed = db.queryByExample(tit);
            while (readed.hasNext()) {
                readedData.add((Title) readed.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return readedData;
    }
}
