/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package localContainers;
import java.sql.*;
import conexionOracle.Connect;
import java.util.LinkedList;
import modelo.RevistaID;

/**
 *
 * @author luis
 */
public class RevistasContainer {

    public static LinkedList<RevistaID> getListOfMagazines(){
        Connection con= Connect.getConnection();
        LinkedList<RevistaID> revistas= new LinkedList<RevistaID>();
        try{
            RevistaID rev=null;
            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery("select cveentrev, nomentrev FROM TBLENTREV");
            while (rset.next()){
                rev= new RevistaID();
                rev.setID( rset.getLong(1) );
                rev.setTitle( rset.getString(2) );
                revistas.add(rev);
            }
            stmt.close();
            Connect.CloseConnection(con);
            return revistas;
        }catch (Exception e){
            return null;
        }

        
    }

    public static void main(String args[]){
        LinkedList<RevistaID> rev=getListOfMagazines();

        for(RevistaID revid:rev){
            System.out.println(revid.getID());
            System.out.println(revid.getTitle());
            System.out.println("------------------------");
        }
    }
    
}
