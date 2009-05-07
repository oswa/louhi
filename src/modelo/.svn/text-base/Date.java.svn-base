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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import modelo.descriptors.Statement;
import modelo.descriptors.Token;
import modelo.descriptors.TokenType;
import util.EvaluaFecha;

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

    /**
     * Default constructor
     */
    public Date(){}

    /**
     *
     * @param aString
     */
    public Date(String aString){
        this.date=creaDate(aString);
    }

   


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

    /**
     * crea un gregorian calendar a partir de un string
     * @param aString
     * @return
     */
    public GregorianCalendar creaDate(String aString) {
        LinkedList<String> dateFinal=new LinkedList<String>();
        GregorianCalendar cal = new GregorianCalendar();
        String dateTemp="";
        List<String> cleanDate = new ArrayList<String>();
        List<String> listDate = new ArrayList<String>();
        String [] meses={"enero","january","janeiro","janvier","febrero","february","fevereiro","fevrier","marzo","março","march","mars",
                "abril","april","avril","mayo","may","maio","mai","junio","june","junho","juin","julio","july","julho","juillet","agosto","august","aout",
                "septiembre","september","septembro","septembre","octubre","october","octubro","octobre","noviembre","november","novembro","novembre",
                "diciembre","december","dezembro","decembre"};
        int diasPorMes[] =   { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        //eliminamos caracteres raros del string que contiene la fecha
        String [] caracter={".",",","(",")",";",":","-","_"};

        for(int i=0;i<caracter.length;i++){
             String charX=caracter[i];
             int n=aString.indexOf(charX);
             if(n!=-1)
                 aString=aString.replace(charX, " ");

             dateTemp=aString;
        }
        //aqui vamos a guardar nuestros valores de la fecha
        String dia="0";
        int mes=0;
        String anio="0";
        StringTokenizer token = new StringTokenizer(dateTemp);
        //llenamos la lista limpia que contiene nuestra posible fecha
        while(token.hasMoreTokens()){
           String nextToken = token.nextToken();
           cleanDate.add(nextToken);
        }
        //System.out.println("cleanDate: "+cleanDate);

        //comparamos elementos de la lista con un mes
        for(int i=0;i<cleanDate.size();i++){
            String tokenDate = cleanDate.get(i);
            //comparamos si su longitud es menor a 10 y alguno de los string coincide con un mes
            if(tokenDate.toCharArray().length<=10&&isNumber(tokenDate)==false){
                EvaluaFecha eva = new EvaluaFecha();
                int m=eva.evaluaMes(tokenDate);

                if(m!=0){
                    mes=m;
                    //agregamos el mes 
                    cal.set(Calendar.MONTH, m-1);
                    listDate.add(String.valueOf(m));
                    cleanDate.remove(i);
                }else{
                    int index=0;
                    for(int x=0;x<meses.length;x++){
                        String month = meses[x];
                        //para los meses que aveces vienen abrviados
                        if(tokenDate.regionMatches(true, 0, month, 0, 2)){
                            int numMes=eva.evaluaMes(month);
                            //agregamos el mes
                            cal.set(Calendar.MONTH, numMes-1);
                            mes=numMes;
                            listDate.add(String.valueOf(mes));
                            index = i;
                        }
                    }
                    if(index!=0)
                        cleanDate.remove(index);
                }
            }
        }
        //System.out.println("lista despues de obtener un mes ----> "+cleanDate);
        //si la lista no trae un string, pero si un numero  que se parezca a un mes
        if(mes==0){
            for(int i=0;i<cleanDate.size();i++){
                String tokenDate = cleanDate.get(i);
                //si es un numero y esta entre 1 y 12 es un mes
                if(tokenDate.toCharArray().length<=2&&isNumber(tokenDate)){
                    int nMes=Integer.parseInt(tokenDate);
                    if(nMes>0&&nMes<=12){
                        mes=nMes;
                        //agregamos el mes
                        cal.set(Calendar.MONTH, nMes-1);
                        listDate.add(String.valueOf(mes));
                        cleanDate.remove(i);
                    }
                }
            }
        }else{
            /*//validamos año bisciesto
            if ( mes == 2 && diaPrueba == 29 && ( anio % 400 == 0 || ( anio % 4 == 0 && anio % 100 != 0 ) ) ){

            }*/

            for(int i=0;i<cleanDate.size();i++){
            String tokenDate = cleanDate.get(i);
            //si su longitud es de dos o un elementos y es un numero es un dia
                if(tokenDate.toCharArray().length<=2&&isNumber(tokenDate)){
                    int day=Integer.parseInt(tokenDate);
                    if(day>0&&day<=diasPorMes[mes]){
                        dia=tokenDate;
                        //agregamos el dia
                        cal.set(Calendar.DAY_OF_MONTH, day);
                        listDate.add(dia);
                        cleanDate.remove(i);
                    }else{
                        System.out.println(tokenDate+" no es un dia");
                    }
                }
            }
            //System.out.println("lista despues de evaluar un dia ----> "+cleanDate);
            //System.out.println("ya traigo el mes");
        }

        //comparamos los elementos restantes de la lista con un año
        for(int i=0;i<cleanDate.size();i++){
            String tokenDate = cleanDate.get(i);

            //si tiene 4 elemantos y es un numero es un año
            if(tokenDate.toCharArray().length==4&&isNumber(tokenDate)){
                if(Integer.parseInt(tokenDate)>1000&&Integer.parseInt(tokenDate)<3000){
                    anio=tokenDate;
                    int year = Integer.parseInt(tokenDate);
                    //agregamos el anio
                    cal.set(Calendar.YEAR, year);
                    listDate.add(anio);
                    cleanDate.remove(i);
                }else{
                    System.out.println(tokenDate+" no es un año");
                }

            }
        }
        //System.out.println("lista despues de evaluar un año ----> "+cleanDate);
        return cal;
        
    }

    private static boolean isNumber(String tokenDate) {
        try{
            Integer.parseInt(tokenDate);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    
}
