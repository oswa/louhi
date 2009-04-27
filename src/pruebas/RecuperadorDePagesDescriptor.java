/*
 * Obtine el descriptor con sus respectivas reglas
 */
package pruebas;

import localContainers.PagesDescriptorContainer;
import modelo.descriptors.PagesDescriptor;
import modelo.descriptors.Statement;
import modelo.descriptors.Token;

/**
 *
 * @author alos
 */
public class RecuperadorDePagesDescriptor {
    public static void main(String[] args) {
        PagesDescriptorContainer pagesDescriptorContainer = new PagesDescriptorContainer();
        PagesDescriptor pd =  pagesDescriptorContainer.getPagesDescriptor();
        for(Statement s : pd.getStatements()){
            System.out.println("-->"+s.toString());
            for(Token tok: s.getStatement()){
                System.out.println("Token: " + tok.toString());
            }
        }
        control.Db4oConnectionManager.closeDB();
    }
}


