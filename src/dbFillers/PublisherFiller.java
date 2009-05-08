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
import control.Db4oConnectionManager;
import java.util.LinkedList;
import modelo.Publisher;
import cloudContainers.PublisherContainer;
/**
 *
 * @author luis
 */
public class PublisherFiller {
    
    public static void main(String[] args) {
   //     Publisher pub=new Publisher();
        PublisherContainer cont= new PublisherContainer();


        Publisher pub1= new Publisher("Mc Graw Hill");
        cont.savePublisher(pub1);

        Publisher pub2=new Publisher("UAEM");
        cont.savePublisher(pub2);

        Publisher pub3 = new Publisher("Antrop\u00F3logos Iberoamericanos en Red");
        cont.savePublisher(pub3);

        Publisher pub4=new Publisher("ISSN");
        cont.savePublisher(pub4);

        Publisher pub5=new Publisher("McPearson");
        cont.savePublisher(pub5);

        Publisher pub6 =new Publisher("Universidad de Concepci\u00F3n");
        cont.savePublisher(pub6);

        Publisher pub7=new Publisher("Fondo de Cultura Econ\u00F3mica.");
        cont.savePublisher(pub7);

        Publisher pub8= new Publisher("Impr. de Gutenberg");
        cont.savePublisher(pub8);

        Publisher pub9=new Publisher("SociedadEspa\u00F1ola de Librer\u00EDa");
        cont.savePublisher(pub9);

        Publisher pub10=new Publisher("Imprenta de la Biblioteca Nacional");
        cont.savePublisher(pub10);

        Publisher pub11=new Publisher("Impr. El Labrador");
        cont.savePublisher(pub11);

        Publisher pub12= new Publisher("Porr\u00FAa");
        cont.savePublisher(pub12);

        Publisher  pub13 = new Publisher("Quimant\u00FA");
        cont.savePublisher(pub13);

        Publisher pub14= new Publisher("Planeta");
        cont.savePublisher(pub14);

        Publisher pub15=new Publisher("Imprenta de la Opini\u00F3n");
        cont.savePublisher(pub15);

        Publisher pub16=new Publisher("Biblioteca Ayacucho");
        cont.savePublisher(pub16);

        Publisher pub17= new Publisher("Impr.Cervantes");
        cont.savePublisher(pub17);

        Publisher pub18= new Publisher("Edit. Nova");
        cont.savePublisher(pub18);

         Publisher pub19= new Publisher("Cuadernos del B\u00EDo-B\u00EDo");
        cont.savePublisher(pub19);

        //Imprime todas las editoriales guardadas en la base de datos
        System.out.println("Editoriales: ");
        LinkedList<Publisher> nvec= cont.retrieveAllPublishers();
        for (int i=0; i<nvec.size();i++){
            System.out.println(nvec.get(i));
        }
        Db4oConnectionManager.closeDB();
    }
}

