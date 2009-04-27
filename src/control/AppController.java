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

package control;

import exceptions.DataBaseNotFoundException;
import localContainers.TitleContainer;
import org.pdfbox.exceptions.CryptographyException;
import org.pdfbox.exceptions.InvalidPasswordException;

import convertidores.*;
import java.io.File;
import modelo.*;
import interfaz.*;
import java.util.LinkedList;
import java.util.StringTokenizer;
import localContainers.AuthorContainer;
import localContainers.Container;
import localContainers.LocationContainer;
import localContainers.PublisherContainer;

public class AppController {
    private Interfaz gui;
    public EntidadPDF elPDF;
    private DescriptorManager descManager = new DescriptorManager();
    String referencias ="";
    AuthorContainer authorContainer = new AuthorContainer();
    PublisherContainer publisherContainer = new PublisherContainer();
    LocationContainer locationContainer = new LocationContainer();
    TitleContainer titleContainer = new TitleContainer();

    public AppController() {
        this.gui= new Interfaz(this);
        this.gui.setVisible(true);

    }


    /**
	 * Convierte el arcvhivo elegido a PDF dejandolo en el mismo directorio
	 * @param archivo
	 * @throws InvalidPasswordException
	 * @throws CryptographyException
	 */
	public void  convertirPDFToXML(String archivo)throws NoSePudoException, CryptographyException, InvalidPasswordException{
		PDFToModelo convertidorAModelo = new PDFToModelo();
		ModeloToXML convertidorAXML = new ModeloToXML();
		EntidadPDF unPDF = convertidorAModelo.convertirAModelo(archivo);
		convertidorAXML.convertirAXML(unPDF);
	}

    /**
     * Convierte el archivo elegido a un PDF
     * @param archivo
     * @return
     * @throws control.NoSePudoException
     * @throws org.pdfbox.exceptions.CryptographyException
     * @throws org.pdfbox.exceptions.InvalidPasswordException
     */
    public EntidadPDF convertirPDFAModelo(File archivo)throws NoSePudoException, CryptographyException, InvalidPasswordException{
        PDFToModelo convertidorAModelo = new PDFToModelo();
		elPDF = convertidorAModelo.convertirAModelo(archivo);
        System.out.println("Termine convirtiendo: " + elPDF.getTitulo());
        return elPDF;
    }

    public LinkedList<TemporalReference> findCitations(LinkedList<String> listaDeCitas, String probableType) {
        return descManager.getCitations(listaDeCitas, probableType);
    }

    /**
     * Gets the DescriptorManager to extract the needed information
     * @param content
     * @return
     */
    public String findReferences(String content) throws DataBaseNotFoundException {
       this.referencias = descManager.getReferences(content);
       return this.referencias;
    }

    

    /**
     * Gets a EntidadPDF object
     * @return
     */
    public EntidadPDF getThePDF() {
        return elPDF;
    }
	/**
	 * Itera sobre todos los archivos .PDF que estan en el directorio y los convierte dejandolos en el mismo directorio
	 * @param directorio
	 */
	public void batchConvertirPDFToXML(String directorio) {

	}

    /**
     * guarda un autor
     * @param value
     */
    public void saveAuthor(String value){
        Author atr = new Author();
        atr.setName(value);
        authorContainer.saveAuthor(atr);
    }

    /**
     * guarda un editorial
     * @param value
     */
    public void savePublisher(String value) {
        Publisher pbl = new Publisher();
        pbl.setName(value);
        publisherContainer.savePublisher(pbl);
    }

    /**
     * guarda un titulo
     * @param value
     */
    public void saveTitle(String value) {
        Title tit = new Title();
        tit.setATitle(value);
        titleContainer.saveTitle(tit);
    }

    /**
     * guarda un lugar
     * @param value
     */
    public void saveLocation(String value) {
        Location loc = new Location();
        loc.setNameOfLocation(value);
        locationContainer.saveLocation(loc);
    }

    /**
     * recupera todos los autores
     * @return
     */
    public LinkedList<Author> retrieveAllAuthors(){
        LinkedList<Author> lista = authorContainer.retrieveAllAuthors();
         return lista;
    }

    /**
     * recupera todas las editoriales de la base
     * @return
     */
    public LinkedList<Publisher> retrieveAllPublishers() {
        LinkedList<Publisher> lista = publisherContainer.retrieveAllPublishers();
        return lista;
    }

    /**
     * recupera todos los lugares de la base
     * @return
     */
    public LinkedList<Location> retrieveAllLocations() {
        LinkedList<Location> lista = locationContainer.retrieveAllLocations();
        return lista;
    }

    /**
     * recupera todos los titulos de la base
     * @return
     */
    public LinkedList<Title> retrieveAllTitles() {
        new Container();
        LinkedList<Title> lista = titleContainer.retrieveAllTitles();
        return lista;
    }

    /**
     * borra un editorial
     * @param valueSelected
     */
    public void deletePublisher(String valueSelected) {
        Publisher pbl = new Publisher();
        pbl.name = valueSelected;
        publisherContainer.deletePublisher(pbl);
    }

    /**
     * borra un autor 
     * @param valueSelected
     */
    public void deleteAuthor(String valueSelected) {
        Author atr = new Author();
        atr.name = valueSelected;
        authorContainer.deleteAuthor(atr);
    }

    /**
     * borra un titulo
     * @param valueSelected
     */
    public void deleteTitle(String valueSelected) {
        Title tit = new Title();
        tit.title = valueSelected;
        titleContainer.deleteTitle(tit);
    }

    /**
     *boora un lugar
     * @param valueSelected
     */
     public void deleteLocation(String valueSelected) {
        Location loc = new Location();
        loc.nameOfLocation = valueSelected;
        locationContainer.deleteLocation(loc);
    }
     
    /**
     *valida la direccion ip
     * @param hostDireccion
     * @return
     */
     public boolean validaIP(String hostDireccion) {
        StringTokenizer st = new StringTokenizer( hostDireccion, "." );

         //verifica que sean 4 elementos
         if ( st.countTokens() != 4 ) {
             return false;
        }

         //verifica los 4 elementos de la ip, de i a 3 digitos y que esten entre 0 y 255
         while ( st.hasMoreTokens() ) {
             String nro = st.nextToken();
             if ( ( nro.length() > 3 ) || ( nro.length() < 1 ) ) {
                 return false;
             }
             int nroInt = 0;
             try {
                 nroInt = Integer.parseInt( nro );
             }
             catch ( NumberFormatException s ) {
                 return false;
             }
             if ( ( nroInt < 0 ) || ( nroInt > 255 ) ) {
                 return false;
             }
         }
         return true;
    }


/**
 * Saves the citation list that it recives
 * @param listaCitas
 */
    public void saveCitations(LinkedList<TemporalReference> listaCitas){
        localContainers.CitationContainer contenedorDeCitas = new localContainers.CitationContainer();
        for(Citation cit : listaCitas){
            contenedorDeCitas.saveItems(cit);
        }
    }

	public static void main(String arg[]){
		AppController control= new AppController();
	}

}
