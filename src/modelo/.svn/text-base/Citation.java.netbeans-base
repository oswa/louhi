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

package modelo;

import java.text.SimpleDateFormat;
import java.util.LinkedList;

/**
 *
 * @author alos & oswa
 */
public class Citation {
    private Type type;
    private Title title;
    private LinkedList<Author> author= new LinkedList<Author>();;
    private modelo.Date date;
    private Publisher publisher;
    private Location location;
    private Pages pages;
    private Volume volume;
    private Clasificacion clasificacion;
    private long IdRevOrigen;
    private long IdRevCitada;
    private String extra="";// all the stuff thats not on the other atributes
    private MetaData metaData; //contains aditional stuff for this reference

    public Citation(){
        title = new Title();
        publisher = new Publisher();
        location = new Location();
        pages = new Pages();
        volume= new Volume();

        date = new modelo.Date();
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public LinkedList<Author> getAutors() {
        return author;
    }

    public void setAuthors(LinkedList<Author> autors) {
        this.author = autors;
    }

    public modelo.Date getDate() {
        return date;
    }

    public void setDate(modelo.Date date) {
        this.date=date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public MetaData getMetaData() {
        return this.metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public Pages getPages() {
        return pages;
    }

    public void setPages(Pages pages) {
        this.pages = pages;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Volume getVolume() {
        return volume;
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public Clasificacion getClasificacion(){
        return clasificacion;
    }

    public void setClasificacion(Clasificacion clasificacion){
        this.clasificacion=clasificacion;
    }

    public long getIdRevOrigen(){
        return IdRevOrigen;
    }

    public void setIdRevOrigen(long IdRevOrigen){
        this.IdRevOrigen=IdRevOrigen;
    }

    public long getIdRevCitada(){
        return IdRevCitada;
    }

    public void setIdRevCitada(long IdRevCitada){
        this.IdRevCitada=IdRevCitada;
    }

    /**
     * Gets the citation in a predefined template if null is passed the template returns a Chigago citation
     * @param template
     * @return
     */
    public String getCitation(Template template) {
        String aString = "";
        if (template != null) {
            for (Node n : template.getCitationRule()) {
                if (n.getClass() == Author.class) {
                    for(Author ath : this.author)
                        aString = aString + ath.getName();
                }
                if (n.getClass() == Title.class)
                        aString = aString + this.title;
                if (n.getClass() == Volume.class)
                        aString = aString + this.volume;
                if (n.getClass() == Date.class)
                        aString = aString + this.date;
                if (n.getClass() == Publisher.class)
                        aString = aString + this.publisher;
                if (n.getClass() == Location.class)
                        aString = aString + this.location;
                if (n.getClass() == Pages.class)
                        aString = aString + this.location;
            }
        } else {
            //TODO hacer uno diferente por su tipo
            if(this.type.equals(Type.MAGAZINEARTICLE)){
                 for(Author ath : this.author)
                        aString = aString + ath.getName();
                 SimpleDateFormat formatter = new SimpleDateFormat();
                 aString = aString +"."+ formatter.format(this.date.getDate().getTime())+ "." + this.title +"." +this.metaData.getMagazineTitle();
            }
        }
        return aString;
    }
    
}
