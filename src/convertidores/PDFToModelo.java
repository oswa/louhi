package convertidores;

import control.AppController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import modelo.EntidadPDF;

import org.pdfbox.examples.pdmodel.PrintDocumentMetaData;
import org.pdfbox.exceptions.CryptographyException;
import org.pdfbox.exceptions.InvalidPasswordException;
import org.pdfbox.pdfparser.PDFParser;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.pdmodel.PDDocumentCatalog;
import org.pdfbox.pdmodel.PDDocumentInformation;
import org.pdfbox.pdmodel.common.PDMetadata;

import org.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.pdfbox.util.PDFTextStripper;

public class PDFToModelo {

    private FileInputStream file = null;
    private PDDocument document = null;
    private AppController control = null;

    public PDFToModelo(AppController control) {
        this.control = control;
    }

    //private String passwordPDF = "12345red9"; //varibale que contiene el passwor por default
    /**
     * Abre el archivo especificado en la ruta
     * @param archivo
     * @return
     * @throws org.pdfbox.exceptions.CryptographyException
     * @throws org.pdfbox.exceptions.InvalidPasswordException
     */
    public EntidadPDF convertirAModelo(String archivo) throws CryptographyException, InvalidPasswordException {
        EntidadPDF aPDF = new EntidadPDF();
        boolean ratonSeCalloDeLaRueda = false;
        try {
            control.setStatus("Cargando el PDF...");
            file = new FileInputStream(archivo);
            PDFParser parser = new PDFParser(file);
            parser.parse();
            document = parser.getPDDocument();

            if (document.isEncrypted()) {
                control.setStatus("Documento encriptado..intentando desencriptar...");
                document.decrypt("12345red9");
                document.setEncryptionDictionary(null);
                document.getDocument().getTrailer().setItem("Encrypt", null);
            } else {
                control.setStatus("Documento libre...viva la libertad!!!");
            }

            //Obtenemos las paginas
            PDFTextStripper stripper = new PDFTextStripper(); // no ese tipo de stripper -.-
            aPDF.setContenido(stripper.getText(document));


            control.setStatus("Rellenando modelo...");
            //una ves leído le sacamos la sopa
            PDDocumentInformation info = document.getDocumentInformation();
            PDDocumentCatalog cat = document.getDocumentCatalog();




            PDMetadata metadata = cat.getMetadata();
            aPDF.setTitulo(info.getTitle());
            aPDF.setAutor(info.getAuthor());
            aPDF.setNumeroDePaginas(document.getNumberOfPages());
            aPDF.setTema(info.getSubject());
            aPDF.setPalabrasClave(info.getKeywords());
            aPDF.setCreador(info.getCreator());
            aPDF.setProductor(info.getProducer());
            aPDF.setFechaDeCreacion(info.getCreationDate());
            aPDF.setFechaDeModificacion(info.getModificationDate());
            //aPDF.setRawMetadata(metadata.toString());


        } catch (FileNotFoundException e) {
            control.setStatus("El raton se callo de la rueda: no se encontro el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            control.setStatus("El raton se callo de la rueda: no se pudo abrir el archivo");
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    control.setStatus("El raton se callo de la rueda: no se pudo cerrar el archivo");
                    e.printStackTrace();
                }
            }
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    control.setStatus("El raton se callo de la rueda: no se pudo cerrar el documento");
                    e.printStackTrace();
                }
            }
        }


        return aPDF;
    }

    public EntidadPDF convertirAModelo(File archivo) throws CryptographyException, InvalidPasswordException {
        EntidadPDF aPDF = new EntidadPDF();
        boolean ratonSeCalloDeLaRueda = false;
        try {
            control.setStatus("Cargando el PDF...");
            file = new FileInputStream(archivo.getAbsolutePath());
            PDFParser parser = new PDFParser(file);
            parser.parse();
            document = parser.getPDDocument();
            if (document.isEncrypted()) {
                control.setStatus("Documento encriptado..intentando desencriptar...");
                //probamos desencriptar con las posibles claves
                String[] passwordPosible = {"12345RED", "12345red", "12345red9", "12345RED9", ""};

                boolean next = true;
                for (int through = 0; through < passwordPosible.length; through++) {
//System.out.println("PDFToModelo-> convertirAModelo -> "+passwordPosible[through]);
                    try {
                        document.decrypt(passwordPosible[through]);
                        break;
                    } catch (Exception e) {
                        if (through == (passwordPosible.length - 1)) {
                            next = false;
                        }
                    }
                }

                if (next == false) {
                    return null;
                }




                document.setEncryptionDictionary(null);
                document.getDocument().getTrailer().setItem("Encrypt", null);
            } else {
                control.setStatus("Documento libre...viva la libertad!!!");
            }

            //Obtenemos las paginas
            PDFTextStripper stripper = new PDFTextStripper(); // no ese tipo de stripper -.-
            aPDF.setContenido(stripper.getText(document));
            control.setStatus("Rellenando modelo...");
            //una ves leído le sacamos la sopa
            PDDocumentInformation info = document.getDocumentInformation();
            PDDocumentCatalog cat = document.getDocumentCatalog();
            PDMetadata metadata = cat.getMetadata();


            aPDF.setTitulo(info.getTitle());
            aPDF.setAutor(info.getAuthor());
            aPDF.setNumeroDePaginas(document.getNumberOfPages());
            aPDF.setTema(info.getSubject());
            aPDF.setPalabrasClave(info.getKeywords());
            aPDF.setCreador(info.getCreator());
            aPDF.setProductor(info.getProducer());
            aPDF.setFechaDeCreacion(info.getCreationDate());
            aPDF.setFechaDeModificacion(info.getModificationDate());
            //aPDF.setRawMetadata(metadata.toString());


        } catch (FileNotFoundException e) {
            control.setStatus("El raton se callo de la rueda: no se encontro el archivo");
            e.printStackTrace();
        } catch (IOException e) {
            control.setStatus("El raton se callo de la rueda: no se pudo abrir el archivo");
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    control.setStatus("El raton se callo de la rueda: no se pudo cerrar el archivo");
                    e.printStackTrace();
                }
            }
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    control.setStatus("El raton se callo de la rueda: no se pudo cerrar el documento");
                    e.printStackTrace();
                }
            }
        }


        return aPDF;
    }
    /*Metodo del password
     *
     */

    public EntidadPDF convertirAModelo(File archivo, String passwordPDF2) throws CryptographyException, InvalidPasswordException {
        EntidadPDF aPDF = new EntidadPDF();
        boolean ratonSeCalloDeLaRueda = false;
        try {
            control.setStatus("Cargando el PDF...");
            file = new FileInputStream(archivo.getAbsolutePath());
            PDFParser parser = new PDFParser(file);
            parser.parse();
            document = parser.getPDDocument();
            if (document.isEncrypted()) {
                control.setStatus("Documento encriptado..intentando desencriptar...");
                document.decrypt(passwordPDF2);
                document.setEncryptionDictionary(null);
                document.getDocument().getTrailer().setItem("Encrypt", null);
            } else {
                control.setStatus("Documento libre...viva la libertad!!!");
            }

            //Obtenemos las paginas
            PDFTextStripper stripper = new PDFTextStripper(); // no ese tipo de stripper -.-
            aPDF.setContenido(stripper.getText(document));
            control.setStatus("Rellenando modelo...");
            //una ves leído le sacamos la sopa
            PDDocumentInformation info = document.getDocumentInformation();
            PDDocumentCatalog cat = document.getDocumentCatalog();
            PDMetadata metadata = cat.getMetadata();

            PDDocumentOutline outline = cat.getDocumentOutline();
            //       System.out.println("Outline: "+ outline.getOpenCount());
            //poner la validacio a null


            aPDF.setTitulo(info.getTitle());
            aPDF.setAutor(info.getAuthor());
            aPDF.setNumeroDePaginas(document.getNumberOfPages());
            aPDF.setTema(info.getSubject());
            aPDF.setPalabrasClave(info.getKeywords());
            aPDF.setCreador(info.getCreator());
            aPDF.setProductor(info.getProducer());
            aPDF.setFechaDeCreacion(info.getCreationDate());
            aPDF.setFechaDeModificacion(info.getModificationDate());
            //aPDF.setRawMetadata(metadata.toString());


        } catch (FileNotFoundException e) {
            control.setStatus("El raton se callo de la rueda: no se encontro el archivo");
            e.printStackTrace();
        } catch (InvalidPasswordException e) {
            control.setStatus("Password Incorrecta");
            e.printStackTrace();
        } catch (IOException e) {
            control.setStatus("El raton se callo de la rueda: no se pudo abrir el archivo");
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    System.out.println("El raton se callo de la rueda: no se pudo cerrar el archivo");
                    e.printStackTrace();
                }
            }
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    System.out.println("El raton se callo de la rueda: no se pudo cerrar el documento");
                    e.printStackTrace();
                }
            }
        }


        return aPDF;
    }

    /********************/
    public static void main(String arg[]) {
        PDDocument document = null;
        FileInputStream file = null;
        try {
            file = new FileInputStream("meh.pdf");
            PDFParser parser = new PDFParser(file);
            parser.parse();
            document = parser.getPDDocument();
            if (document.isEncrypted()) {
                try {
                    document.decrypt("");
                } catch (InvalidPasswordException e) {
                    System.err.println("El raton se callo de la rueda: el documento tiene password.");
                    System.exit(1);
                } catch (CryptographyException e) {
                    e.printStackTrace();
                }
            }
            PrintDocumentMetaData meta = new PrintDocumentMetaData();
            meta.printMetadata(document);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printMetadata(PDDocument document) throws IOException {
        PDDocumentInformation info = document.getDocumentInformation();
        PDDocumentCatalog cat = document.getDocumentCatalog();
        PDMetadata metadata = cat.getMetadata();
        System.out.println("Paginas totales=" + document.getNumberOfPages());
        System.out.println("Titulo=" + info.getTitle());
        System.out.println("Autor=" + info.getAuthor());
        System.out.println("Tema=" + info.getSubject());
        System.out.println("Palabras clave=" + info.getKeywords());
        System.out.println("Creador=" + info.getCreator());
        System.out.println("Productor=" + info.getProducer());
        System.out.println("Fecha decreacion=" + formatDate(info.getCreationDate()));
        System.out.println("Fecha de modificacion=" + formatDate(info.getModificationDate()));
        if (metadata != null) {
            System.out.println("Metadata=" + metadata.getInputStreamAsString());
        }
    }

    private String formatDate(Calendar date) {
        String retval = null;
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat();
            retval = formatter.format(date.getTime());
        }
        return retval;
    }
}
