package convertidores;

import java.io.File;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import modelo.*;

public class ModeloToXML {

	public void convertirAXML(EntidadPDF unPDF) {
		System.out.println("Creando la estructura del XML...");
		Document document = null;
		DocumentBuilder builder = null;

		//para las fechas
		SimpleDateFormat formatter = new SimpleDateFormat();


		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			builder = factory.newDocumentBuilder();
			document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		Element root = document.createElement("PDFDocumento");
		// Insert child Manifest
		document.appendChild(root);

		/*METADATA*/
		Element metadata = document.createElement("PDFMetadata");
		root.appendChild(metadata);

		Node titulo = document.createElement("titulo");
		titulo.setTextContent(unPDF.getTitulo());
		metadata.appendChild(titulo);

		Node tema = document.createElement("tema");
		tema.setTextContent(unPDF.getTema());
		metadata.appendChild(tema);

		Node autor = document.createElement("autor");
		autor.setTextContent(unPDF.getAutor());
		metadata.appendChild(autor);

		Node creador = document.createElement("creador");
		creador.setTextContent(unPDF.getCreador());
		metadata.appendChild(creador);

		Node productor = document.createElement("productor");
		productor.setTextContent(unPDF.getProductor());
		metadata.appendChild(productor);

		Node palabrasClave = document.createElement("palabrasClave");
		palabrasClave.setTextContent(unPDF.getPalabrasClave());
		metadata.appendChild(palabrasClave);

		Node fechaDeCreacion = document.createElement("fechaDeCreacion");
		fechaDeCreacion.setTextContent(formatter.format(unPDF.getFechaDeCreacion().getTime()));
		metadata.appendChild(fechaDeCreacion);

		Node fechaDeModificacion = document.createElement("fechaDeModificacion");
		fechaDeModificacion.setTextContent(formatter.format(unPDF.getFechaDeModificacion().getTime()));
		metadata.appendChild(fechaDeModificacion);
		/*FIN DE METADATA*/

		/*CONTENIDO*/
		Node paginas = document.createElement("PDFPaginas");
		root.appendChild(paginas);

		Node contenido = document.createElement("contenido");
		contenido.setTextContent(unPDF.getContenido());
		paginas.appendChild(contenido);

		// Normalizing the DOM
		document.getDocumentElement().normalize();
		System.out.println("Se termino de crear la estructura del XML...el raton esta feliz!");
		writeXMLToFile("pdfXML.xml", document);
	}

	public void writeXMLToFile(String filename, Document document) {
		try {
			System.out.println("Escribiendo el archivo XML...");
			// Prepare the DOM document for writing
			Source source = new DOMSource(document);

			// Prepare the output file
			File file = new File(filename);
			StreamResult result = new StreamResult(file);

			// Write the DOM document to the file
			// Get Transformer
			Transformer xformer = TransformerFactory.newInstance()
					.newTransformer();
			// Write to a file
			xformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			System.out.println("TransformerConfigurationException: " + e);
		} catch (TransformerException e) {
			System.out.println("TransformerException: " + e);
		}
		System.out.println("Se termino de escribir el XML...el raton esta feliz!");
	}
}
