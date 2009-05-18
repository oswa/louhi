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
    private String issn; //Issn of the magazine
    private String isbn;//isbn of the magazine
    private Type type; //el tipo si es revista, libro, conferencia, etc...
    private SoporteEnum soporte; //el soporte puede ser desconocido, impreso, electronico...
    private Title title; //el titulo del articulo citado
    private PeriodicalTitle periodicalTitle; //el nombre de la revista si es que es periodica
    private LinkedList<Author> author= new LinkedList<Author>();; //los autores citados
    private modelo.Date date;//la fecha de la cita
    private Publisher publisher;//la editorial
    private Location location;//el lugar de la cita
    private Pages pages;//el numero de paginas de la cita
    private Volume volume; //the volume in the reference
    private Institution institution;
    private Number number;
    private URL url;
    private Clasificacion clasificacion; //if its autocitations or not
    private boolean isNacional;
    private long IdRevOrigen; //ID de la revista origen de la cita
    private long IdRevCitada;//ID de la revista citada si es que esta en redalyc
    private String extra="";// all the stuff thats not on the other atributes
    private MetaData metaData; //contains aditional stuff for this reference
    private String articleID;//El ID de la revista, se toma del archivo
    private String originalCitation;//Stores the reference as found in the document
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
        institution = new Institution();
        number = new Number();
        url = new URL();
        date = new modelo.Date();
        this.soporte = SoporteEnum.DESCONOCIDO;

    }
    
    public Citation(TemporalReference tr){
        this.author = tr.getAutors();
        this.type = tr.getType();
        this.title = tr.getTitle();
        this.periodicalTitle = tr.getPeriodicalTitle();
        this.date = tr.getDate();
        this.publisher = tr.getPublisher();
        this.location = tr.getLocation();
        this.pages = tr.getPages();
        this.volume = tr.getVolume();
        this.clasificacion = tr.getClasificacion();
        this.isNacional = tr.isIsNacional();
        this.IdRevCitada = tr.getIdRevCitada();
        this.IdRevOrigen = tr.getIdRevOrigen();
        this.extra = tr.getExtra();
        this.metaData = tr.getMetaData();
        this.number = tr.getNumber();
        this.institution = tr.getInstitution();
        this.url = tr.getUrl();
        this.isbn = tr.getIsbn();
        this.issn =  tr.getIssn();
        this.soporte=tr.getSoporte();
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIssn() {
        return issn;
    }

    public String getOriginalCitation() {
        return originalCitation;
    }

    public void setOriginalCitation(String origCit) {
        this.originalCitation = origCit;
    }

    public void setIssn(String issn) {
        this.issn = issn;
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

    public String getArticleID() {
        return articleID;
    }

    public void setArticleID(String articleID) {
        this.articleID = articleID;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public SoporteEnum getSoporte() {
        return soporte;
    }

    public void setSoporte(SoporteEnum soporte) {
        this.soporte = soporte;
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
             String year= this.date.getDateWithStatement().substring(6);
             String month=this.date.getDateWithStatement().substring(3,5);
             if (Integer.parseInt(month)==1){month="Enero";} if (Integer.parseInt(month)==2){month="Febrero";}
             if (Integer.parseInt(month)==3){month="Marzo";} if (Integer.parseInt(month)==4){month="Abril";}
             if (Integer.parseInt(month)==5){month="Mayo";}  if (Integer.parseInt(month)==6){month="Junio";}
             if (Integer.parseInt(month)==7){month="Julio";} if (Integer.parseInt(month)==8){month="Agosto";}
             if (Integer.parseInt(month)==9){month="Septiembre";} if (Integer.parseInt(month)==10){month="Octubre";}
             if (Integer.parseInt(month)==11){month="Noviembre";} if (Integer.parseInt(month)==12){month="Diciembre";}
             String day=this.date.getDateWithStatement().substring(0,2);
            //TODO hacer uno diferente por su tipo
            if(this.type.equals(Type.MAGAZINEARTICLE)){
                 for(Author ath : this.author)
                        aString = aString + ath.getName();
                 aString = aString +"."+ year + "." + this.title +"."+ this.publisher +","+month+" "+day;
            }
            if(this.type.equals(Type.BOOK)){
                 for(Author ath : this.author)
                        aString = aString + ath.getName();
                 SimpleDateFormat formatter = new SimpleDateFormat();
                 aString = aString +"."+ formatter.format(this.date.getDate().getTime())+ "." + this.title +"."+ this.location + "." + this.publisher ;
            }
            if(this.type.equals(Type.JOURNALARTICLE)){
                 for(Author ath : this.author)
                        aString = aString + ath.getName();
                 SimpleDateFormat formatter = new SimpleDateFormat();
                 aString = aString +"."+ formatter.format(this.date.getDate().getTime())+ "." + this.title +"."+this.periodicalTitle + "." + this.volume + "."+ this.pages;
            }
            if(this.type.equals(Type.NEWSPAPERARTICLE)){
                 for(Author ath : this.author)
                        aString = aString + ath.getName();
                 aString = aString +"."+ year+ "." + this.title +"."+this.periodicalTitle + ","+ month+" "+day + ","+ this.pages;
            }
            if(this.type.equals(Type.NEWSPAPERARTICLENOAUTHOR)){
                 aString =this.periodicalTitle+"."+ year + "." + this.title +"."+ month+" "+day +","+this.extra + ","+ this.pages;
            }
            if(this.type.equals(Type.WEBPAGE)){
                 for(Author ath : this.author)
                        aString = aString + ath.getName();
                 aString = aString +"."+ year + "." + this.title +"."+ this.location +":"+ this.publisher +"."+this.extra;
            }

            if(this.soporte.equals(SoporteEnum.DESCONOCIDO)){
                 for(Author ath : this.author)
                        aString = aString + ath.getName();
                 SimpleDateFormat formatter = new SimpleDateFormat();
                 aString = aString +"."+ formatter.format(this.date.getDate().getTime())+ "." + this.title +"."+this.periodicalTitle + "." + this.volume + "."+ this.pages;
            }
            if(this.soporte.equals(SoporteEnum.ELECTRONICO)){
                 for(Author ath : this.author)
                        aString = aString + ath.getName();
                 aString = aString +"."+ year+ "." + this.title +"."+this.periodicalTitle + ","+ month+" "+day + ","+ this.pages;
            }
            if(this.soporte.equals(SoporteEnum.IMPRESO)){
                 aString =this.periodicalTitle+"."+ year + "." + this.title +"."+ month+" "+day +","+this.extra + ","+ this.pages;
            }
            if(this.soporte.equals(SoporteEnum.MIXTO)){
                 for(Author ath : this.author)
                        aString = aString + ath.getName();
                 aString = aString +"."+ year + "." + this.title +"."+ this.location +":"+ this.publisher +"."+this.extra;
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
        SoporteEnum soport= this.soporte;
        resp=String.valueOf(loc)+" "+String.valueOf(tit)+" "+String.valueOf(typ)+" "+String.valueOf(dat) + " " + String.valueOf(soport);
        return resp;
    }
    
}
