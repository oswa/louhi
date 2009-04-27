/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas;

import localContainers.VolumeDescriptorContainer;
import modelo.descriptors.Statement;
import modelo.descriptors.Token;
import modelo.descriptors.VolumeDescriptor;

/**
 *
 * @author alos
 */
public class RecuperadorDeVolumeDescriptor {
     public static void main(String[] args) {
         VolumeDescriptorContainer volumeDescriptorContainer = new VolumeDescriptorContainer();
        VolumeDescriptor pd =  volumeDescriptorContainer.getVolumeDescriptor();
        for(Statement s : pd.getStatements()){
            System.out.println("-->"+s.toString());
            for(Token tok: s.getStatement()){
                System.out.println("Token: " + tok.toString());
            }
        }
        control.Db4oConnectionManager.closeDB();
    }
}
