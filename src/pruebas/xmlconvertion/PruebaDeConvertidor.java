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
         Citation c1 = new Citation();

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

        
        XStream xStream = new XStream(new DomDriver());
        xStream.registerConverter(new convertidores.ReferenceConverter());
        xStream.alias(c1.getArticleID(), Citation.class);
        String xml = xStream.toXML(c1);
        System.out.println(xml);

        Citation newCitation = (Citation)xStream.fromXML(xml);

        System.out.println(newCitation);

    }
}
