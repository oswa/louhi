/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import localContainers.TitleDescriptorContainer;
import modelo.descriptors.Statement;
import modelo.descriptors.Token;


/**
 *
 * @author alos
 */
public class RecuperadorDTitleDescriptor {

    public static void main(String[] args) {
        TitleDescriptorContainer titleDescriptorContainer = new TitleDescriptorContainer();
        modelo.descriptors.TitleDescriptor dd =  titleDescriptorContainer.getTitleDescriptor();
        for(Statement s : dd.getStatements()){
            System.out.println("-->"+s.toString());
            for(Token tok: s.getStatement()){
                System.out.println("Token: " + tok.toString());
            }
        }
        control.Db4oConnectionManager.closeDB();
    }
}
