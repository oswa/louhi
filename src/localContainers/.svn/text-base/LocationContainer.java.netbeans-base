/*
 *This file is part of Louhi.

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
import com.db4o.query.Predicate;
import java.util.LinkedList;
import java.util.List;
import modelo.Location;

/**
 *
 * @author alos
 */
public class LocationContainer extends Container{

    public LocationContainer(){
        super();
    }
    /**
     * Looks for the location on the DB
     * @param aString
     * @return
     */
    public boolean isLocation(String aString) {
        

        final String location = aString;
        try {
                List<Location> locations = db.query(new Predicate<Location>() {
                public boolean match(Location aLocation) {
                    return (aLocation.nameOfLocation.compareToIgnoreCase(location) == 0);
                }
            });

            if (locations.size() != 0)
                return true;
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return false;
    }

    /**
     * Saves the location on the DB
     * @param loc
     */
    public  void saveLocation(Location loc) {
       

        try {
            db.store(loc);
        //System.out.println("Se guardo: "+atr.name);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } 
    }

    /**
     * Deletes from DB an specific Location matching the given pattern
     * @param args
     */
    public boolean deleteLocation(Location loc) {
       
        try {
            db.delete(db.queryByExample(loc).next());
            db.commit();
        } catch (Exception e) {
            System.out.println("Error Borrando: " + loc.getNameOfLocation());
            db.close();
            return false;
        } 
        return true;
    }

    /**
     * Searchs for one Location matching a given location name
     * @param atrNam
     * @return
     */
    public  LinkedList<Location> getLocationByName(String atrNam) {
      
        LinkedList<Location> readedData = new LinkedList<Location>();
        Location loc = new Location();
        loc.setNameOfLocation(atrNam);

        try {

            ObjectSet readed = db.queryByExample(loc);
            while (readed.hasNext()) {
                readedData.add((Location) readed.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 

        return readedData;
    }

    /**
     * Gets a list of all the existing Locations
     * @return
     */
    public LinkedList<Location> retrieveAllLocations() {
        
        LinkedList<Location> readedData = new LinkedList<Location>();
        Location loc = new Location();
        try {

            ObjectSet foundData = db.queryByExample(Location.class);
            while (foundData.hasNext()) {
                readedData.add((Location) foundData.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 
        return readedData;
    }
}
