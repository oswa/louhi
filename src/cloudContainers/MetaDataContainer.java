/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cloudContainers;
import modelo.MetaData;
import com.db4o.ObjectSet;
import java.util.LinkedList;

/**
 *
 * @author luis
 */
public class MetaDataContainer extends Container {

    public MetaDataContainer(){
        super();
    }

    public void saveMD(MetaData md) {
       try {
            db.store(md);
            db.commit();
System.out.println("cloudC/MetaDataContainer-> guardo un metadata keywords: "+md.getKeywords());
        }catch(Exception e){
            e.printStackTrace();
        }
    }



    public LinkedList<MetaData> retrieveAllItemsLinkedList() {
        LinkedList<MetaData> item = new LinkedList<MetaData>();
        try {
            ObjectSet result = db.queryByExample(MetaData.class);
            for (int i = 0; i < result.size(); i++) {
                item.add((MetaData) result.get(i));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }


}
