package pruebas.persistencia;

import java.util.LinkedList;
import localContainers.AuthorDescriptorContainer;
import modelo.descriptors.Statement;

/**
 *
 * @author alos
 */
public class PruebaDeContenedorDeAuthorDescritptor {
    public static void main(String[] args){
       AuthorDescriptorContainer authorDescriptorContainer = new AuthorDescriptorContainer();

        modelo.descriptors.AuthorDescriptor descAuthor = authorDescriptorContainer.getAuthorDescriptor();

        if(descAuthor!=null){
            System.out.println("No es null del todo");
            LinkedList<Statement> lista = descAuthor.getStatements();
            System.out.println("Size: "+lista.size());
            for(Statement s : lista){
                System.out.println(s.toString());
            }
        }else
            System.out.println("Es null");

        control.Db4oConnectionManager.closeDB();
    }
}
