/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import control.Db4oConnectionManager;
import exceptions.DataBaseNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.descriptors.ReferenceDescriptor;

/**
 *
 * @author alos
 */
public class PuebaDeDescriptorDeReferencias {
    public static void main(String[] args) {
        localContainers.ReferenceDescriptorContainer contenedor = new localContainers.ReferenceDescriptorContainer();

        ReferenceDescriptor referenceDescriptor;
        try {
            referenceDescriptor = contenedor.getReferenceDescriptor();

            System.out.println(referenceDescriptor);

            for(modelo.descriptors.Statement s: referenceDescriptor.getStatements())
                System.out.println(s);
        } catch (DataBaseNotFoundException ex) {
            Logger.getLogger(PuebaDeDescriptorDeReferencias.class.getName()).log(Level.SEVERE, null, ex);
        }


        Db4oConnectionManager.closeDB();
    }
}
