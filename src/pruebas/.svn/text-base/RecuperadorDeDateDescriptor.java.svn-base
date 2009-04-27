/*
 * Obtine el descriptor con sus respectivas reglas
 */
package pruebas;

import java.util.LinkedList;
import localContainers.DateDescriptorContainer;
import modelo.descriptors.DateDescriptor;
import modelo.descriptors.Statement;
import modelo.descriptors.Token;

/**
 *
 * @author alos
 */
public class RecuperadorDeDateDescriptor {

    public static void main(String[] args) {
        DateDescriptorContainer dateDescriptorContainer = new DateDescriptorContainer();
        DateDescriptor dd =  dateDescriptorContainer.getDateDescriptor();
        for(Statement s : dd.getStatements()){
            System.out.println("-->"+s.toString());
            for(Token tok: s.getStatement()){
                System.out.println("Token: " + tok.toString());
            }
        }
        control.Db4oConnectionManager.closeDB();
    }
}
