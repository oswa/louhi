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

package modelo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import modelo.descriptors.Statement;
import modelo.descriptors.Token;
import modelo.descriptors.TokenType;

//import java.util.Date;

/**
 *
 * @author Oswaldo
 */

public class Date implements Node{
    public GregorianCalendar date;
    public modelo.descriptors.Descriptor statements;

    public modelo.descriptors.Statement statement;
    private String originalDate;

    public GregorianCalendar getDate(){
        return date;
    }
    
    public void setDate(GregorianCalendar date){
        this.date=date;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public void setOriginalDate(String originalDate){
        this.originalDate = originalDate;
    }

    public String getOriginalDate(){
        return originalDate;
    }

    /**
     * retorna la fecha con el formato dd/mm/yyyy segun su statement
     * @return
     */
    public String getDateWithStatement() {
        String respuesta = "";
        String respuestaParcial="";
        LinkedList listFecha=new LinkedList();
        for (Token tok : getStatement().statement) {
        //le sacamos los elementos de la fecha si los tipos de token coinciden
            if (tok.getTokenType().equals(TokenType.DAYOFMONTH)) 
                listFecha.add(this.date.get(Calendar.DAY_OF_MONTH));
            
            if (tok.getTokenType().equals(TokenType.MONTH)) 
                listFecha.add(this.date.get(Calendar.MONTH)+1);             

            if (tok.getTokenType().equals(TokenType.YEAR)) 
                listFecha.add(this.date.get(Calendar.YEAR));
        }
        //extraemos los datos de la lista en un string
            for(int x=0;x<listFecha.size();x++)
                respuestaParcial+="/"+listFecha.get(x);
            //componemos la fecha
            for (int x=1; x < respuestaParcial.length(); x++)
                respuesta += respuestaParcial.charAt(x);
        
        return respuesta;
    }


    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat();
       return formatter.format(this.date.getTime());


    }

}
