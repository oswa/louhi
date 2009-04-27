/*
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

package conexionOracle;
import java.sql.*;
import util.OswaReader;

/**
 *
 * @author luis
 */

public class Connect {
  public static void main(String[] args) {
      getConnection();
 }

  public static Connection getConnection(){
      OswaReader osr=new OswaReader();
      String url= osr.getPropiedad("URL_ORA");
      String port= osr.getPropiedad("PORT_ORA");
      String database= osr.getPropiedad("DBNAME_ORA");
      String user= osr.getPropiedad("USER_ORA");
      String pwd= osr.getPropiedad("PWD_ORA");
        System.out.println(url+"-"+port+"-"+database+"-"+user+"-"+pwd);
      try {
          DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection con=DriverManager.getConnection("jdbc:oracle:thin:@"+url+":"+port+":"+database+"", user, pwd);
          return con;
      }catch(Exception e){
          e.printStackTrace();
          return null;
      }
  }

  public static void CloseConnection(Connection con){
      try{
          con.close();
      }catch(Exception e){
          e.printStackTrace();
      }
  }

}
