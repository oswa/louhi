/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas.xmlconvertion;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import modelo.*;

/**
 *
 * @author alos
 */
public class PruebaDeConvertidor {
    public static void main(String[] args) {
        //GENERATING A CITATION
         TemporalReference c1 = new TemporalReference();

        Author a1= new Author("Autor1 C1");
        Author a2 = new Author("Autor2 C1");
        Author a3 = new Author("Autor3 C1");
        LinkedList<Author> listaDeAutores = new LinkedList<Author>();
        listaDeAutores.add(a1);
        listaDeAutores.add(a2);
        listaDeAutores.add(a3);

        Title t1 = new Title ("TITULO DE PRUEBA c1");
        Pages p1 = new Pages("1590-2044-1");
        Volume v1 = new Volume("Vol. 18-1");
        Location l1= new Location("Mexico");
        Publisher pu1 = new Publisher("O'Rally");
        String extra = "[1er edicion]";

        modelo.Date fecha1= new modelo.Date();
        GregorianCalendar gc = new GregorianCalendar();
        fecha1.setDate(gc);


        modelo.MetaData md = new modelo.MetaData();
      
        md.setKeywords("tennis, cars, computers, C1");
        md.setLanguage(Language.ENGLISH);
        md.setMaker("Acrobat Pro");
        md.setTheme("TESTING 1");
        PeriodicalTitle per=new PeriodicalTitle();
        per.setName("C1");

        c1.setIsbn("312klC1");
        c1.setIssn("as890C1");
        c1.setAuthors(listaDeAutores);
        c1.setDate(fecha1);
        c1.setTitle(t1);
        c1.setPages(p1);
        c1.setVolume(v1);
        c1.setLocation(l1);
        c1.setPublisher(pu1);
        c1.setExtra(extra);
        c1.setMetaData(md);
        c1.setType(Type.MAGAZINEARTICLE);
        c1.setArticleID("12345C1");
        c1.setIdRevCitada(12345);
        c1.setIdRevOrigen(12345);
        c1.setPeriodicalTitle(per);
        c1.setClasificacion(Clasificacion.AUTOCITA);
        c1.setIsNacional(true);
        c1.setNumber(new modelo.Number("2"));
        c1.setInstitution(new modelo.Institution("UAEM"));
        
        /*==========Ref 2****************/
         TemporalReference c2 = new TemporalReference();

         a1= new Author("AUTOR1 C2");
         a2 = new Author("AUTOR2 C2");
         listaDeAutores = new LinkedList<Author>();
         listaDeAutores.add(a1);
         listaDeAutores.add(a2);

         t1 = new Title ("TITULO DE PRUEBA C2");
         p1 = new Pages("15-20");
         v1 = new Volume("Vol. 2-2");
         l1= new Location("Paris");
         pu1 = new Publisher("Omega");
         extra = "[2er edicion]";

        fecha1= new modelo.Date();
        gc = new GregorianCalendar();
        fecha1.setDate(gc);


        md = new modelo.MetaData();
        md.setKeywords("busses, wheels, computers, C2");
        md.setLanguage(Language.ENGLISH);
        md.setMaker("Acrobat Pro 3");
        md.setTheme("TESTING 2");
        PeriodicalTitle per2=new PeriodicalTitle();
        per2.setName("C2");


        c2.setIsbn("ADS3432C2");
        c2.setIssn("23324DC2");
        c2.setAuthors(listaDeAutores);
        c2.setDate(fecha1);
        c2.setTitle(t1);
        c2.setPages(p1);
        c2.setVolume(v1);
        c2.setLocation(l1);
        c2.setPublisher(pu1);
        c2.setExtra(extra);
        c2.setMetaData(md);
        c2.setType(Type.MAGAZINEARTICLE);
        c2.setArticleID("23456C2");
        c2.setIdRevCitada(23456);
        c2.setIdRevOrigen(23456);
        c2.setPeriodicalTitle(per2);
        c2.setClasificacion(Clasificacion.AUTOCITA);
        c2.setIsNacional(true);
        c2.setNumber(new modelo.Number("22"));
        c2.setInstitution(new modelo.Institution("UPAEP"));
        LinkedList<TemporalReference> list = new LinkedList<TemporalReference>();

        list.add(c1);
        list.add(c2);

        control.AppController control = new control.AppController();

        control.convertToXML(list);


    }
}
