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
    private Type type; //el tipo si es revista, libro, conferencia, etc...
    private Title title; //el titulo del articulo citado
    private PeriodicalTitle periodicalTitle; //el nombre de la revista si es que es periodica
    private LinkedList<Author> author= new LinkedList<Author>();; //los autores citados
    private modelo.Date date;//la fecha de la cita
    private Publisher publisher;//la editorial
    private Location location;//el lugar de la cita
    private Pages pages;//el numero de paginas de la cita
    private Volume volume; //the volume in the reference
    private Clasificacion clasificacion; //if its autocitations or not
    private boolean isNacional;
    private long IdRevOrigen; //ID de la revista origen de la cita
    private long IdRevCitada;//ID de la revista citada si es que esta en redalyc
    private String extra="";// all the stuff thats not on the other atributes
    private MetaData metaData; //contains aditional stuff for this reference

    /*
     NOTE: The periodical title basicly contains the string of the titlte of the publication if its periodical.
     * The IdRevCitada contains the ID of the magazine if its in the redalyc DB
     */



    public Citation(){
        title = new Title();
        publisher = new Publisher();
        location = new Location();
        pages = new Pages();
        volume= new Volume();
        periodicalTitle = new PeriodicalTitle();
        date = new modelo.Date();
    }

    public PeriodicalTitle getPeriodicalTitle() {
        return periodicalTitle;
    }

    public void setPeriodicalTitle(PeriodicalTitle periodicalTitle) {
        this.periodicalTitle = periodicalTitle;
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
        return this.publisher;
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

    public boolean isIsNacional() {
        return isNacional;
    }

    public void setIsNacional(boolean isNacional) {
        this.isNacional = isNacional;
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
                 aString = aString +"."+ formatter.format(this.date.getDate().getTime())+ "." + this.title +"." ;
            }
        }
        return aString;
    }


    /**
     * recupera algunos elementos de la cita y los desplega en un string
     * @return
     */
    @Override
    public String toString() {
        String resp="";
        Location loc = this.location;
        modelo.Date dat = this.date;
        Title tit = this.title;
        Type typ = this.type;
        resp=String.valueOf(loc)+" "+String.valueOf(tit)+" "+String.valueOf(typ)+" "+String.valueOf(dat);
        return resp;
    }
    
}
