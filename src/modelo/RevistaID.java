/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author luis
 */
public class RevistaID {
    private String title;
    private long id;

    public void setTitle(String titulo){
        this.title=titulo;
    }

    public String getTitle(){
        return this.title;
    }


    public void setID(long cve){
        this.id=cve;
    }

    public long getID(){
        return this.id;
    }

}
