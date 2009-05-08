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
import java.util.LinkedList;
import java.util.Vector;
import com.db4o.ObjectContainer;
import com.db4o.Db4o;


import com.db4o.ObjectSet;
import modelo.Citation;
import modelo.descriptors.CitationDescriptor;
import modelo.Author;


/**
 *
 * @author alos
 */
public class CitationContainer extends Container {

    public CitationContainer(){
        super();
    }

    public void saveItems(Citation item) {
       

        try {
            //Hacer la validacion para q no halla dups
            db.store(item);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public CitationDescriptor getFirstCitationDescriptor(){
       
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
    }



/**
 * Deletes from DB an specific Citation matching the given pattern
 * @param atr
 */
    public boolean deleteCitation(Citation cit){
        
        try{
            db.delete( db.queryByExample(cit).next() );
            db.commit();
        }catch(Exception e){
            System.out.println("Error Borrando");
            db.close();
            return false;
        }
       
        return true;
    }

   


    
    public LinkedList<Citation> retrieveAllItemsLinkedList() {
          LinkedList<Citation> item = new LinkedList<Citation>();
        try {
			ObjectSet result = db.queryByExample(Citation.class);
			
			for (int i = 0; i < result.size(); i++) {
				item.add((Citation) result.get(i));
			}
        }catch(Exception e){
                e.printStackTrace();
            }
			return item;
        }
       
    


}
