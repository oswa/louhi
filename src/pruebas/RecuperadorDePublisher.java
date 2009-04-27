/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import localContainers.PublisherDescriptorContainer;
import modelo.descriptors.Statement;
import modelo.descriptors.Token;

/**
 *
 * @author alos
 */
public class RecuperadorDePublisher {
   public static void main(String[] args) {
       PublisherDescriptorContainer publisherDescriptorContainer = new PublisherDescriptorContainer();
        modelo.descriptors.PublisherDescriptor dd = publisherDescriptorContainer.getPublisherDescriptor();
        for (Statement s : dd.getStatements()) {
            System.out.println("-->" + s.toString());
            for (Token tok : s.getStatement()) {
                System.out.println("Token: " + tok.toString());
            }
        }
        control.Db4oConnectionManager.closeDB();
    }
}
