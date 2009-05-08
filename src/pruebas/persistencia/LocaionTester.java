/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas.persistencia;

import java.util.LinkedList;
import java.util.Vector;
import cloudContainers.LocationContainer;
import modelo.Location;

/**
 *
 * @author alos
 */
public class LocaionTester {
    public static void main(String[] args) {
        String aCountry= "Paris";
        LocationContainer locationContainer = new LocationContainer();

        System.out.println(locationContainer.isLocation(aCountry));

        
        control.Db4oConnectionManager.closeDB();
    }
}
