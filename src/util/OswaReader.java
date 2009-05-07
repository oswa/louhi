/*
 *
 * This file is part of Louhi.

    Louhi is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License.

    Louhi is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Louhi.  If not, see <http://www.gnu.org/licenses/>.
 */

package util;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author oswaldo
 */
public class OswaReader {
   private String CONFIGURATION_FILE = "/home/oswa/preferences.cfg";
   private static HashMap propiedades;

   /**
    * retorna el valor de la propiedad que se encuentra en el archivo de configuracion
    * @param nombre
    * @return
    */
   public String getPropiedad(String nombre) {
       try {
       FileInputStream f = new FileInputStream(CONFIGURATION_FILE);

       Properties propiedadesTemporales = new Properties();
       propiedadesTemporales.load(f);
       f.close();

       propiedades = new HashMap(propiedadesTemporales);

     } catch (Exception e) {
        System.out.println("Creando archivo de configuración..."+e);
     }
        String valor = (String) propiedades.get(nombre);
        
        if(valor.equals("")||valor.equals(null))
            System.err.println("El valor para "+nombre+" es null");

        //System.out.println(valor);
        return valor;
   }

   /**
    * guarda la configuracion en el archivo preferences.cfg
    * @param cambios
    */
   public void saveConfig(String cambios){
        String contenido = cambios;
        String [] atributos = contenido.split(",");
            String hostFinal = atributos[0];
            String portFinal = atributos[1];
            String userFinal = atributos[2];
            String passFinal = atributos[3];
            String confServer="HOST="+hostFinal+"\nPORT="+portFinal+"\nUSER="+userFinal+"\nPASS="+passFinal+"\n";
            //tambien guardamos la configuracion de oracle
            String oracleConf="URL_ORA="+getPropiedad("URL_ORA")+"\nPORT_ORA="+getPropiedad("PORT_ORA")
                                        +"\nDBNAME_ORA="+getPropiedad("DBNAME_ORA")+"\nUSER_ORA="+getPropiedad("USER_ORA")
                                        +"\nPWD_ORA="+getPropiedad("PWD_ORA");
            //creamos el string que contiene la configuracion final
            String conf=confServer+oracleConf;
            //System.out.println(conf);
            try{
                PrintWriter fileOut = new PrintWriter(new FileWriter(CONFIGURATION_FILE,false));
                fileOut.print(conf);
                fileOut.flush();
                fileOut.close();
            }catch(IOException e){
                System.out.println("error al escribir");
            }      
    }

   /*public static void main(String [] args){
        OswaReader or = new OswaReader();
       String cambios = "148.215.24.29,1983,admin,admin";
       or.saveConfig(cambios);
        System.out.println(or.getPropiedad("HOST"));
        System.out.println(or.getPropiedad("PORT"));
        System.out.println(or.getPropiedad("USER"));
        System.out.println(or.getPropiedad("PASS"));
        System.out.println("----------------");
        System.out.println(or.getPropiedad("URL_ORA"));
        System.out.println(or.getPropiedad("PWD_ORA"));
        System.out.println(or.getPropiedad("USER_ORA"));
        System.out.println(or.getPropiedad("DBNAME_ORA"));
        System.out.println(or.getPropiedad("PORT_ORA"));
   }*/
}