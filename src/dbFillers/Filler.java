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

package dbFillers;

import control.Db4oLocalConnectionManager;
import java.util.LinkedList;
import localContainers.*;
import modelo.descriptors.*;


/**
 *
 * @author alos
 */
public class Filler {

    public static void main(String[] args) {
        /************Decriptor de nombre************/
        Token t1 = new Token(TokenType.CAPITALLETTER);
        Token t2 = new Token(TokenType.SMALLLETTERS);

       //Ahora creamos el estatement con los tokens adecuados
        LinkedList<Token> listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        Statement statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de nombres
        modelo.descriptors.NameDescriptor descriptorNombre = new modelo.descriptors.NameDescriptor();
        descriptorNombre.addStatement(statement);

        t1 = new Token(TokenType.CAPITALLETTER);
        t2 = new Token(TokenType.SMALLLETTERS);
        Token t3 = new Token(TokenType.SEPARATOR,",");
        Token t4 = new Token(TokenType.CAPITALLETTER);
        Token t5 = new Token(TokenType.SMALLLETTERS);
       //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        listaDeTokens.add(t4);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de nombres
        descriptorNombre.addStatement(statement);

        t1 = new Token(TokenType.CAPITALLETTER);
        t2 = new Token(TokenType.SMALLLETTERS);
        t3 = new Token(TokenType.SEPARATOR,",");
        t4 = new Token(TokenType.CAPITALLETTER);
        t5 = new Token(TokenType.STRING,".");
       //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        listaDeTokens.add(t4);
        listaDeTokens.add(t5);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de nombres
        descriptorNombre.addStatement(statement);

        t1 = new Token(TokenType.CAPITALLETTER);
        t2 = new Token(TokenType.SMALLLETTERS);
        t3 = new Token(TokenType.SEPARATOR,",");
        t4 = new Token(TokenType.CAPITALLETTER);
        t5 = new Token(TokenType.SEPARATOR," ");
        Token t6 = new Token(TokenType.CAPITALLETTER);
        Token t7 = new Token(TokenType.STRING,".");
        Token t8 = new Token(TokenType.CAPITALLETTER);
        Token t9 = new Token(TokenType.STRING,".");
       //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        listaDeTokens.add(t4);
        listaDeTokens.add(t5);
        listaDeTokens.add(t6);
        listaDeTokens.add(t7);
        listaDeTokens.add(t8);
        listaDeTokens.add(t9);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de nombres
        descriptorNombre.addStatement(statement);
        NameDescriptorContainer nameDescCont = new NameDescriptorContainer();
        nameDescCont.saveNameDescriptor(descriptorNombre);
        System.out.println("Guardando descriptores de nombres");




        /************Descriptor de Referencias************/
         t1 = new Token(TokenType.STRING);
         t2 = new Token(TokenType.SEPARATOR, "REFERENCIAS");
         t3 = new Token(TokenType.STRING);

       //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        ReferenceDescriptor descriptorReferencias = new ReferenceDescriptor();
        descriptorReferencias.addStatement(statement);
        //Creamos la primera regla o statement de las referencias
         t4 = new Token(TokenType.STRING);
         t5 = new Token(TokenType.SEPARATOR, "Referencias	bibliográficas");
         t6 = new Token(TokenType.STRING);

       //Ahora creamos el estatement con los tokens adecuados
        LinkedList<Token> listaDeTokens2= new LinkedList<Token>();
        listaDeTokens2.add(t4);
        listaDeTokens2.add(t5);
        listaDeTokens2.add(t6);
        Statement statement2 = new Statement(listaDeTokens2);
        //Le agregaos el statement a la lista de statements de autores
        descriptorReferencias.addStatement(statement2);

         //Creamos la primera regla o statement de las referencias
         t7 = new Token(TokenType.STRING);
         t8 = new Token(TokenType.SEPARATOR, "References");
         t9 = new Token(TokenType.STRING);
       //Ahora creamos el estatement con los tokens adecuados
        LinkedList<Token> listaDeTokens3= new LinkedList<Token>();
        listaDeTokens3.add(t7);
        listaDeTokens3.add(t8);
        listaDeTokens3.add(t9);
        Statement statement3 = new Statement(listaDeTokens3);
        //Le agregaos el statement a la lista de statements de referencias
        descriptorReferencias.addStatement(statement3);
        ReferenceDescriptorContainer refDescCont = new ReferenceDescriptorContainer();
        refDescCont.saveReferenceDescriptor(descriptorReferencias);
        System.out.println("Guardo descriptores de referencias");


        /**********Descriptor de Autores*************/
        t1 = new Token(TokenType.NAME);
        t1.setValue(100);
        
       //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        AuthorDescriptor autorDesc = new AuthorDescriptor();
        autorDesc.addStatement(statement);
        AuthorDescriptorContainer authorDescCont = new AuthorDescriptorContainer();
        authorDescCont.saveAuthorDescriptor(autorDesc);
        System.out.println("Guarde un autor descriptor");


        /*/**********Descriptor de Fechas***********/
        DateDescriptor dateDesc = new DateDescriptor();


         t1 = new Token(TokenType.YEAR);
         t1.setValue(100);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        dateDesc.addStatement(statement);

        t1 = new Token(TokenType.MONTH);
        t1.setValue(100);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        dateDesc.addStatement(statement);
        
        t1 = new Token(TokenType.MONTH);
        t2 = new Token(TokenType.SEPARATOR,",");
        t3 = new Token(TokenType.DAYOFMONTH);
        t1.setValue(40);
        t2.setValue(30);
        t3.setValue(30);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        dateDesc.addStatement(statement);


        t1 = new Token(TokenType.MONTH);
        t2 = new Token(TokenType.DAYOFMONTH);
        t3 = new Token(TokenType.SEPARATOR,",");
        t4 = new Token(TokenType.YEAR);
        t1.setValue(30);
        t2.setValue(23);
        t3.setValue(23);
        t4.setValue(23);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        listaDeTokens.add(t4);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        dateDesc.addStatement(statement);

        t1 = new Token(TokenType.STRING,"(");
        t2 = new Token(TokenType.YEAR);
        t3 = new Token(TokenType.SEPARATOR,",");
        t4 = new Token(TokenType.MONTH);
        t5 = new Token(TokenType.DAYOFMONTH);
        t6 = new Token(TokenType.STRING,")");
        t1.setValue(17);
        t2.setValue(20);
        t3.setValue(10);
        t4.setValue(20);
        t5.setValue(15);
        t6.setValue(17);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        listaDeTokens.add(t4);
        listaDeTokens.add(t5);
        listaDeTokens.add(t6);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        dateDesc.addStatement(statement);

        t1 = new Token(TokenType.STRING,"(");
        t2 = new Token(TokenType.YEAR);
        t3 = new Token(TokenType.STRING,")");
        t1.setValue(33);
        t2.setValue(33);
        t3.setValue(33);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        dateDesc.addStatement(statement);

        t1 = new Token(TokenType.STRING);
        t2 = new Token(TokenType.MONTH);
        t3 = new Token(TokenType.DAYOFMONTH);
        t4 = new Token(TokenType.SEPARATOR,",");
        t5 = new Token(TokenType.YEAR);
        t1.setValue(10);
        t2.setValue(30);
        t3.setValue(20);
        t4.setValue(20);
        t5.setValue(20);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        listaDeTokens.add(t4);
        listaDeTokens.add(t5);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        dateDesc.addStatement(statement);
        DateDescriptorContainer dateDescCont = new DateDescriptorContainer();
        dateDescCont.saveDateDescriptor(dateDesc);
        System.out.println("Guarde un date descriptor");


        /**********Descriptor de Paginas*************/
        t1 = new Token(TokenType.INTEGER);
        t2 = new Token(TokenType.SEPARATOR, "-");
        t3 = new Token(TokenType.INTEGER);
        t1.setValue(33);
        t2.setValue(33);
        t3.setValue(33);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        PagesDescriptor pagesDesc = new PagesDescriptor();
        pagesDesc.addStatement(statement);
        //otro
        t1 = new Token(TokenType.INTEGER);
        t1.setValue(100);
       //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        pagesDesc.addStatement(statement);
        //otro
        t1 = new Token(TokenType.STRING,"pp");
        t2 = new Token(TokenType.INTEGER);
        t1.setValue(50);
        t2.setValue(50);
       //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        pagesDesc.addStatement(statement);

        PagesDescriptorContainer pagesDescCont = new PagesDescriptorContainer();
        pagesDescCont.savePagesDescriptor(pagesDesc);
        System.out.println("Guarde un pages descriptor");

        /**********Descriptor de Titulos*************/
        t1 = new Token(TokenType.STRING);
        t1.setValue(100);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        statement = new Statement(listaDeTokens);
        //otro
        //Le agregaos el statement a la lista de statements de referencias
        TitleDescriptor titleDesc = new TitleDescriptor();
        titleDesc.addStatement(statement);
        t1 = new Token(TokenType.STRING,"\"");
        t2 = new Token(TokenType.STRING);
        t3 = new Token(TokenType.STRING,"\"");
        t1.setValue(35);
        t2.setValue(30);
        t3.setValue(35);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        titleDesc.addStatement(statement);
        //otro
        t1 = new Token(TokenType.STRING);
        t1.setValue(100);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        titleDesc.addStatement(statement);
        //otro
        t1 = new Token(TokenType.STRING,"'");
        t2 = new Token(TokenType.STRING);
        t3 = new Token(TokenType.STRING,"'");
        t1.setValue(35);
        t2.setValue(30);
        t3.setValue(35);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        titleDesc.addStatement(statement);
        TitleDescriptorContainer titleDescCont = new TitleDescriptorContainer();
        titleDescCont.saveTitleDescriptor(titleDesc);
        System.out.println("Guarde un title descriptor");

        /**********Descriptor de Lugares*************/
         t1 = new Token(TokenType.CAPITALLETTER);
         t2 = new Token(TokenType.SMALLLETTERS);
         t1.setValue(50);
         t2.setValue(50);
       //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de nombres
        modelo.descriptors.LocationDescriptor locationDescriptor = new modelo.descriptors.LocationDescriptor();
        locationDescriptor.addStatement(statement);

        t1 = new Token(TokenType.CAPITALLETTER);
        t2 = new Token(TokenType.SMALLLETTERS);
        t3 = new Token(TokenType.SEPARATOR,",");
        t4 = new Token(TokenType.CAPITALLETTER);
        t5 = new Token(TokenType.SMALLLETTERS);
        t1.setValue(25);
        t2.setValue(22);
        t3.setValue(6);
        t4.setValue(25);
        t5.setValue(22);
       //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        listaDeTokens.add(t4);
        listaDeTokens.add(t5);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de nombres
        locationDescriptor.addStatement(statement);

        t1 = new Token(TokenType.CAPITALLETTER);
        t2 = new Token(TokenType.SMALLLETTERS);
        t3 = new Token(TokenType.SEPARATOR,",");
        t4 = new Token(TokenType.CAPITALLETTER);
        t5 = new Token(TokenType.STRING,".");
        t1.setValue(25);
        t2.setValue(22);
        t3.setValue(6);
        t4.setValue(25);
        t5.setValue(22);
       //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        listaDeTokens.add(t4);
        listaDeTokens.add(t5);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de nombres
        locationDescriptor.addStatement(statement);
        LocationDescriptorContainer locDescCont= new LocationDescriptorContainer();
        locDescCont.saveLocationDescriptor(locationDescriptor);
        System.out.println("Guardando Location descriptor");

         /************Decriptor de Editoriales************/
         t1 = new Token(TokenType.NAME);
         t1.setValue(100);
         //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de nombres
        modelo.descriptors.PublisherDescriptor publisherDescriptor = new modelo.descriptors.PublisherDescriptor();
        publisherDescriptor.addStatement(statement);
        //otro
        t1 = new Token(TokenType.STRING);
        t1.setValue(95);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        publisherDescriptor.addStatement(statement);
        PublisherDescriptorContainer publisherDescCont= new PublisherDescriptorContainer();
        publisherDescCont.savePublisherDescriptor(publisherDescriptor);
        System.out.println("Guardando Publisher descriptor");

        /****************Descriptor de Volumenes**************/
        t1 = new Token(TokenType.STRING,"vol.");
        t2 = new Token(TokenType.INTEGER);
        t1.setValue(50);
        t2.setValue(50);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        modelo.descriptors.VolumeDescriptor volDesc = new modelo.descriptors.VolumeDescriptor();
        volDesc.addStatement(statement);
        //otro
        t1 = new Token(TokenType.INTEGER);
        t1.setValue(100);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        volDesc.addStatement(statement);
        t1 = new Token(TokenType.INTEGER);
        t2 = new Token(TokenType.STRING,":");
        t1.setValue(50);
        t2.setValue(50);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        volDesc.addStatement(statement);
        VolumeDescriptorContainer volDesCCont = new VolumeDescriptorContainer();
        volDesCCont.saveVolumeDescriptor(volDesc);
        System.out.println("Guarde un volume descriptor");

        /**********Descriptor de PeriodicalTitulos*************/
        t1 = new Token(TokenType.STRING);
        t1.setValue(100);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        statement = new Statement(listaDeTokens);
        //otro
        //Le agregaos el statement a la lista de statements de referencias
        PeriodicalTitleDescriptor periodicalTitleDesc = new PeriodicalTitleDescriptor();
        periodicalTitleDesc.addStatement(statement);
        t1 = new Token(TokenType.STRING,"\"");
        t2 = new Token(TokenType.STRING);
        t3 = new Token(TokenType.STRING,"\"");
        t1.setValue(35);
        t2.setValue(30);
        t3.setValue(35);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        periodicalTitleDesc.addStatement(statement);
        //otro
        t1 = new Token(TokenType.STRING);
        t1.setValue(100);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        periodicalTitleDesc.addStatement(statement);
        //otro
        t1 = new Token(TokenType.STRING,"'");
        t2 = new Token(TokenType.STRING);
        t3 = new Token(TokenType.STRING,"'");
        t1.setValue(35);
        t2.setValue(30);
        t3.setValue(35);
        //Ahora creamos el estatement con los tokens adecuados
        listaDeTokens= new LinkedList<Token>();
        listaDeTokens.add(t1);
        listaDeTokens.add(t2);
        listaDeTokens.add(t3);
        statement = new Statement(listaDeTokens);
        //Le agregaos el statement a la lista de statements de referencias
        periodicalTitleDesc.addStatement(statement);
        PeriodicalTitleDescriptorContainer periodicalTitleDescCont = new PeriodicalTitleDescriptorContainer();
        periodicalTitleDescCont.savePeriodicalTitleDescriptor(periodicalTitleDesc);
        System.out.println("Guarde un periodicaltitle descriptor");

        Db4oLocalConnectionManager.closeDB();
    }
}
