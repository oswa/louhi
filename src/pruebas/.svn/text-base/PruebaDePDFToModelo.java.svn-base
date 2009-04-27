package pruebas;

import java.text.SimpleDateFormat;

import org.pdfbox.exceptions.CryptographyException;
import org.pdfbox.exceptions.InvalidPasswordException;

public class PruebaDePDFToModelo {
	public static void main(String arg[]) {
		convertidores.PDFToModelo converter = new convertidores.PDFToModelo();
		modelo.EntidadPDF unPDF= new modelo.EntidadPDF();
		try {
			unPDF = converter.convertirAModelo("../PDF's/sql.pdf");
		} catch (CryptographyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleDateFormat formatter = new SimpleDateFormat();
		System.out.println("Titulo: "+unPDF.getTitulo());
		System.out.println("Autor: "+ unPDF.getAutor());
		System.out.println("No. de paginas: "+unPDF.getNumeroDePaginas());
		System.out.println("Tema: "+unPDF.getTema());
		System.out.println("Palabras clave: "+unPDF.getPalabrasClave());
		System.out.println("Creador: "+unPDF.getCreador());
		System.out.println("Productor: "+ unPDF.getProductor());
		System.out.println("Fecha de creacion: "+formatter.format(unPDF.getFechaDeCreacion().getTime()));
		System.out.println("Fecha de modificacion: "+ formatter.format(unPDF.getFechaDeModificacion().getTime()));
		System.out.println("==Contenido==");
		System.out.println(unPDF.getContenido());
	}
}
