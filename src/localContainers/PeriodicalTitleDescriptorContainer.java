/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package localContainers;

import com.db4o.ObjectSet;
import modelo.descriptors.PeriodicalTitleDescriptor;

/**
 *
 * @author alos
 */
public class PeriodicalTitleDescriptorContainer  extends Container{
  public PeriodicalTitleDescriptorContainer(){
        super();
    }


    public void savePeriodicalTitleDescriptor(PeriodicalTitleDescriptor tit) {


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
    public  boolean deletePeriodicalTitleDescriptor(PeriodicalTitleDescriptor tit) {

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
    public PeriodicalTitleDescriptor getPeriodicalTitleDescriptor() {

        PeriodicalTitleDescriptor titDesc = new PeriodicalTitleDescriptor();
        try {
            ObjectSet readed = db.queryByExample(PeriodicalTitleDescriptor.class);
            while (readed.hasNext()) {
                titDesc = (PeriodicalTitleDescriptor) readed.next();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return titDesc;
    }
}
