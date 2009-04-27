/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import localContainers.LocationDescriptorContainer;
import modelo.descriptors.Statement;
import modelo.descriptors.Token;

/**
 *
 * @author alos
 */
public class RecuperadorDeLocationDescriptors {

    public static void main(String[] args) {
        LocationDescriptorContainer locationDescriptorContainer = new LocationDescriptorContainer();
        modelo.descriptors.LocationDescriptor dd = locationDescriptorContainer.getLocationDescriptor();
        for (Statement s : dd.getStatements()) {
            System.out.println("-->" + s.toString());
            for (Token tok : s.getStatement()) {
                System.out.println("Token: " + tok.toString());
            }
        }
        control.Db4oConnectionManager.closeDB();
    }
}
