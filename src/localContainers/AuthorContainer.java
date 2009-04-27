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
import control.Db4oConnectionManager;
import java.util.LinkedList;
import modelo.Author;

/**
 *
 * @author alos
 */
public class AuthorContainer extends localContainers.Container{
    

    public AuthorContainer(){
        super();
    }



    public  boolean isAuthor(String aString) {

        LinkedList<Author> readedData = new LinkedList<Author>();
        Author atr = new Author();
        atr.setName(aString);

        try {

            ObjectSet readed = db.queryByExample(atr);
            while (readed.hasNext()) {
                readedData.add((Author) readed.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(readedData == null)
            return false;
        else
            return true;
    }

    
    /**
     * Saves one specific Author
     * @param atr
     */
    public void saveAuthor(Author atr) {
        try {
            db.store(atr);
        //System.out.println("Se guardo: "+atr.name);
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

    /**
     * Deletes from DB an specific Author matching the given pattern
     * @param atr
     */
    public  boolean deleteAuthor(Author atr) {
        try {
            db.delete(db.queryByExample(atr).next());
            db.commit();
        } catch (Exception e) {
            System.out.println("Error Borrando: " + atr.getName());
            db.close();
            return false;
        } 
        return true;
    }


    /**
     * Searchs for one Author matching a given name
     * @param atrNam
     * @return
     */
    public  LinkedList<Author> getAuthorByFullName(String  atrNam) {

        LinkedList<Author> readedData = new LinkedList<Author>();
        Author atr = new Author();
        atr.setName(atrNam);

        try {

            ObjectSet readed = db.queryByExample(atr);
            while (readed.hasNext()) {
                readedData.add((Author) readed.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } 

        return readedData;
    }


    /**
     * Searchs for one Author matching a given name
     * @param atrNam
     * @return
     */
    public  LinkedList<Author> getAuthorByFullNameLinked(String atrNam) {

        LinkedList<Author> readedData = new LinkedList<Author>();
        Author atr = new Author();
        atr.setName(atrNam);

        try {

            ObjectSet readed = db.queryByExample(atr);
            while (readed.hasNext()) {
                readedData.add((Author) readed.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return readedData;
    }

    /**
     * Gets a full list of Authors existing in the DB
     * @return
     */
    public  LinkedList<Author> retrieveAllAuthors() {
        LinkedList<Author> readedData = new LinkedList<Author>();
        Author atr = new Author();

        try {

            ObjectSet readed = db.queryByExample(atr);
            while (readed.hasNext()) {
                readedData.add((Author) readed.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return readedData;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Db4oConnectionManager.closeDB();
    }



}
