/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import control.Db4oConnectionManager;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import cloudContainers.CitationContainer;
import modelo.*;

/**
 *
 * @author alos
 */
public class RellenadorDeCitas {
    public static void main(String[] args) {
        CitationContainer refCont = new CitationContainer();

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

        System.out.println(fecha1.getDate().getTimeZone());

        modelo.MetaData md = new modelo.MetaData();
        md.setIsbn("312klC1");
        md.setIssn("as890C1");
        md.setKeywords("tennis, cars, computers, C1");
        md.setLanguage(Language.ENGLISH);
        md.setMaker("Acrobat Pro");
        md.setTheme("TESTING 1");
        PeriodicalTitle per=new PeriodicalTitle();
        per.setName("C1");



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

        refCont.saveItems(c1);

//=============================================
        Citation c2 = new Citation();

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
        md.setIsbn("ADS3432C2");
        md.setIssn("23324DC2");
        md.setKeywords("busses, wheels, computers, C2");
        md.setLanguage(Language.ENGLISH);
        md.setMaker("Acrobat Pro 3");
        md.setTheme("TESTING 2");
        PeriodicalTitle per2=new PeriodicalTitle();
        per2.setName("C2");


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

        refCont.saveItems(c2);
       //==========================

//-----------------------------------------
Citation c3 = new Citation();

         a1= new Author("AUTOR1 C3");
         a2 = new Author("AUTOR2 C3");
         a3 = new Author("AUTOR3 C3");
         Author a4 = new Author("AUTOR4 C3");
         listaDeAutores = new LinkedList<Author>();
         listaDeAutores.add(a1);
         listaDeAutores.add(a2);
         listaDeAutores.add(a3);
         listaDeAutores.add(a4);

         t1 = new Title ("Titulo de prueba C3");
         p1 = new Pages("15-20-3");
         v1 = new Volume("Vol. 2-3");
         l1= new Location("Paris");
         pu1 = new Publisher("Omega");
         extra = "[2er edicion]";

        fecha1= new modelo.Date();
        gc = new GregorianCalendar();
        fecha1.setDate(gc);


        md = new modelo.MetaData();
        md.setIsbn("ADS3432C3");
        md.setIssn("23324DC3");
        md.setKeywords("busses, wheels, computers, C3");
        md.setLanguage(Language.ENGLISH);
        md.setMaker("Acrobat Pro 3");
        md.setTheme("TESTING 3");
        PeriodicalTitle per3=new PeriodicalTitle();
        per3.setName("C3");


        c3.setAuthors(listaDeAutores);
        c3.setDate(fecha1);
        c3.setTitle(t1);
        c3.setPages(p1);
        c3.setVolume(v1);
        c3.setLocation(l1);
        c3.setPublisher(pu1);
        c3.setExtra(extra);
        c3.setMetaData(md);
        c3.setType(Type.MAGAZINEARTICLE);
        c3.setArticleID("34567C3");
        c3.setIdRevCitada(34567);
        c3.setIdRevOrigen(34567);
        c3.setPeriodicalTitle(per3);
        c3.setClasificacion(Clasificacion.AUTOCITA);
        c3.setIsNacional(true);

        refCont.saveItems(c3);
       //==========================


//--------------------------------------------------
Citation c4 = new Citation();

         a1= new Author("AUTOR1 C4");
         a2 = new Author("AUTOR2 C4");
         a3 = new Author("AUTOR3 C4");
         a4 = new Author("AUTOR4 C4");
         listaDeAutores = new LinkedList<Author>();
         listaDeAutores.add(a1);
         listaDeAutores.add(a2);
         listaDeAutores.add(a3);
         listaDeAutores.add(a4);

         t1 = new Title ("Titulo de prueba C4");
         p1 = new Pages("15-20-4");
         v1 = new Volume("Vol. 2-4");
         l1= new Location("Paris");
         pu1 = new Publisher("Omega");
         extra = "[2er edicion]";

        fecha1= new modelo.Date();
        gc = new GregorianCalendar();
        fecha1.setDate(gc);


        md = new modelo.MetaData();
        md.setIsbn("ADS3432C4");
        md.setIssn("23324DC4");
        md.setKeywords("busses, wheels, computers, C4");
        md.setLanguage(Language.ENGLISH);
        md.setMaker("Acrobat Pro 3");
        md.setTheme("TESTING 4");
        PeriodicalTitle per4=new PeriodicalTitle();
        per4.setName("C4");


        c4.setAuthors(listaDeAutores);
        c4.setDate(fecha1);
        c4.setTitle(t1);
        c4.setPages(p1);
        c4.setVolume(v1);
        c4.setLocation(l1);
        c4.setPublisher(pu1);
        c4.setExtra(extra);
        c4.setMetaData(md);
        c4.setType(Type.MAGAZINEARTICLE);
        c4.setArticleID("45678C4");
        c4.setIdRevCitada(45678);
        c4.setIdRevOrigen(45678);
        c4.setPeriodicalTitle(per4);
        c4.setClasificacion(Clasificacion.AUTOCITA);
        c4.setIsNacional(true);

        refCont.saveItems(c4);
       //==========================

//--------------------------------------------------
Citation c5 = new Citation();

         a1= new Author("AUTOR1 C5");
         a2 = new Author("AUTOR2 C5");
         a3 = new Author("AUTOR3 C5");
         a4 = new Author("AUTOR4 C5");
         Author a5 = new Author("AUTOR5 C5");
         listaDeAutores = new LinkedList<Author>();
         listaDeAutores.add(a1);
         listaDeAutores.add(a2);
         listaDeAutores.add(a3);
         listaDeAutores.add(a4);
         listaDeAutores.add(a5);

         t1 = new Title ("Titulo de prueba C5");
         p1 = new Pages("15-20-5");
         v1 = new Volume("Vol. 2-5");
         l1= new Location("Paris");
         pu1 = new Publisher("Omega");
         extra = "[2er edicion]";

        fecha1= new modelo.Date();
        gc = new GregorianCalendar();
        fecha1.setDate(gc);


        md = new modelo.MetaData();
        md.setIsbn("ADS3432C5");
        md.setIssn("23324DC5");
        md.setKeywords("busses, wheels, computers, C5");
        md.setLanguage(Language.ENGLISH);
        md.setMaker("Acrobat Pro 3");
        md.setTheme("TESTING 5");
        PeriodicalTitle per5=new PeriodicalTitle();
        per5.setName("C5");


        c5.setAuthors(listaDeAutores);
        c5.setDate(fecha1);
        c5.setTitle(t1);
        c5.setPages(p1);
        c5.setVolume(v1);
        c5.setLocation(l1);
        c5.setPublisher(pu1);
        c5.setExtra(extra);
        c5.setMetaData(md);
        c5.setType(Type.MAGAZINEARTICLE);
        c5.setArticleID("56789C5");
        c5.setIdRevCitada(56789);
        c5.setIdRevOrigen(56789);
        c5.setPeriodicalTitle(per5);
        c5.setClasificacion(Clasificacion.AUTOCITA);
        c5.setIsNacional(true);

        refCont.saveItems(c5);
       //==========================
        Db4oConnectionManager.closeDB();
System.out.println(" pruebas/rellenador de citas - Termino de guradar 5 ejemplos de citas");

    }
}
