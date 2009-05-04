/*This file is part of Louhi.

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

package modelo.descriptors;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import util.EvaluaFecha;

/**
 *
 * @author alos & oswa
 */
public class DateDescriptor extends Descriptor {

    private double orderBonus = 40.0;
    private double finishedString = 60.0;

    @Override
    public DescriptorAnswer runRules(String aString) {
        DescriptorAnswer resp = new DescriptorAnswer();
        Evaluator eva = new Evaluator();
        for (Statement s : this.statements) {
            DescriptorAnswer aux = new DescriptorAnswer();
            aux.setAnswer(s);
            boolean inOrder = true;
            int i = 0;
            for (Token tok : s.getStatement()) {

                /*For YEAR tokens*/
                if (tok.getTokenType().equals(TokenType.YEAR)) {
                    boolean isTokenYear = false;
                    String aPossibleYear = "";
                    int cont = 0;
                    try {
                        if (Character.isWhitespace(aString.charAt(i))) {
                            i++;
                        }
                        int last = i + 4;
                        for (; i < last; i++) {
                            cont++;
                            char c = aString.charAt(i);
                            if (Character.isDigit(c) || cont == 4) {//TODO fix this i==4 fails
                                aPossibleYear = aPossibleYear + c;
                            }
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        isTokenYear = false;
                    }
                    if (aPossibleYear.length() == 4)//and some other stuff i can think of
                    {
                        isTokenYear = true;
                    }

                    if (isTokenYear) {
                        aux.addToScore(tok.getValue());
                    } else {
                        inOrder = false;
                    }
                }//del token year

                /*For MONTH tokens*/
                if (tok.getTokenType().equals(TokenType.MONTH)) {
                    boolean isTokenMonth = false;
                    String aPossibleMonth = "";
                    try {
                        if (Character.isWhitespace(aString.charAt(i))) {
                            i++;
                        }
                        for (; i < aString.length(); i++) {
                            char c = aString.charAt(i);
                            if (Character.isLetter(c)) {
                                aPossibleMonth = aPossibleMonth + c;
                            } else {
                                break;
                            }
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        isTokenMonth = false;
                    }
                    //we check if its a month
                    if (eva.isAMonth(aPossibleMonth)) {
                        isTokenMonth = true;
                    }
                    if (isTokenMonth) {
                        aux.addToScore(tok.getValue());

                    } else {
                        inOrder = false;
                    }
                }

                /*For SEPARATOR tokens*/
                if (tok.getTokenType().equals(TokenType.SEPARATOR)) {
                    boolean isTokenSeparator = false;
                    try {
                        if (Character.isWhitespace(aString.charAt(i))) {
                            i++;
                        }
                        char c = aString.charAt(i);
                        i++;
                        if (eva.containsAnySeparators(c + "")) {
                            isTokenSeparator = true;
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        isTokenSeparator = false;
                    }
                    if (isTokenSeparator) {
                        aux.addToScore(tok.getValue());

                    } else {
                        inOrder = false;
                    }
                }

                /*For STRING tokens*/
                if (tok.getTokenType().equals(TokenType.STRING)) {
                    boolean isTokenString = false;
                    try {
                        if (Character.isWhitespace(aString.charAt(i))) {
                            i++;
                        }
                        
                        char theChar = ' ';
                        if (tok.getToken() != null) {
                            if (tok.getToken().length() == 1) {
                                char c = aString.charAt(i);
                                i++;
                                theChar = tok.getToken().charAt(0);
                                if (c == theChar) {//TODO validate
                                    isTokenString = true;
                                }

                            } else {
                                //if its just any string
                                isTokenString = true;
                                if (tok.getToken().length() != 0) {//it means we got a word to compare
                                    int last = i + tok.getToken().length();
                                    for (; i < last; i++) {
                                        char c = aString.charAt(i);
                                        if (!Character.isLetter(c)) {
                                            isTokenString = false;
                                            break;
                                        }
                                    }
                                }else{
                                    //It means it just a regular word
                                    isTokenString = true;
                                    for(;;i++){
                                        char c = aString.charAt(i);
                                        if(Character.isWhitespace(c))
                                            break;
                                        if(!Character.isLetter(c)){
                                            isTokenString=false;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                        isTokenString = false;
                    }
                    if (isTokenString) {
                        aux.addToScore(tok.getValue());

                    } else {
                        inOrder = false;
                    }
                }

                /*For DAYOFMONTH tokens*/
                if (tok.getTokenType().equals(TokenType.DAYOFMONTH)) {
                    boolean isTokenDayOfMonth = false;
                    String aPossibleDayOfMonth = "";
                    try {
                        if (Character.isWhitespace(aString.charAt(i))) {
                            i++;
                        }
                        int last = i + 2;
                        for (; i < last; i++) {
                            char c = aString.charAt(i);
                            if (Character.isDigit(c)) {//o.O cont works?
                                aPossibleDayOfMonth = aPossibleDayOfMonth + c;
                            }
                        }

                    } catch (StringIndexOutOfBoundsException e) {
                        isTokenDayOfMonth = false;
                    }
                    if (aPossibleDayOfMonth.length() == 2)//and some other stuff i can think of
                    {
                        isTokenDayOfMonth = true;
                    }
                    if (isTokenDayOfMonth) {
                        aux.addToScore(tok.getValue());
                    } else {
                        inOrder = false;
                    }
                }


            }//de los tokens

            //Did it finish with all the string?
            if (i != aString.length()) {
                aux.addToScore(-1 * finishedString);
            //System.out.println("Did not finished string penalty!");
            } else {

                if (inOrder) {
                    aux.addToScore(orderBonus);
                //System.out.println("*BONUS*: In order!");
                } else {
                    aux.addToScore(-1 * orderBonus);
                //System.out.println("Not in order...suffering from a penalty");
                }
            }
            if (aux.getScore() > resp.getScore()) {
                resp = aux;
            }
        }//de los statements
        resp.setDescriptorType(DescriptorType.DATE);

        //intentamos parsear la fecha
        modelo.Date fecha = new modelo.Date();
        try{
        //aqui vamos a construir la fecha
        Statement stm = resp.getAnswer();
        //guardamos el statement 
        fecha.setOriginalDate(aString);
        //guardamos el statement
        fecha.setStatement(stm);
        //aqui vamos a separar el String de a cuerdo al statement
        String dateTemp="";
        String [] caracter={".",",","(",")",";",":","-","_"," "};

        for(int i=0;i<caracter.length;i++){
             String charX=caracter[i];
             int n=aString.indexOf(charX);
             if(n!=-1)
                 aString=aString.replace(charX,",");

             dateTemp=aString;
        }
        //guardamos la fecha separada por ","
        StringTokenizer tok = new StringTokenizer(dateTemp);        
        String listDate="";
        while(tok.hasMoreTokens()){
           String nextToken = tok.nextToken();
           //cleanDate.add(nextToken);
           listDate+=nextToken;
        }
        //ahora guardamos los valores de la fecha, mes y año segun su statement
        String [] preDate = listDate.split(",");
        String dia="";
        String mes="";
        String anio="";

        for(Token token : stm.getStatement()){
            for(int i =0;i<stm.getStatement().size();i++){
                   token = stm.getStatement().get(i);

                   if(token.getTokenType().equals(TokenType.MONTH)){
                        mes=preDate[i];
                   }

                   if(token.getTokenType().equals(TokenType.YEAR)){
                       anio=preDate[i];
                   }

                   if(token.getTokenType().equals(TokenType.DAYOFMONTH)){
                       dia=preDate[i];
                   }
            }            
            
        }
        //construimos el date
        java.util.Date date = new java.util.Date();
        GregorianCalendar cal = new GregorianCalendar();
        EvaluaFecha eFecha = new EvaluaFecha();
        //agregamos dia, mes y año a calendar si el statement los contiene, sino agregamos los valores de la fecha actual
        if(!mes.equals("")){
            int month=0;
            int numMes = eFecha.evaluaMes(mes);
            if(eFecha.isNumber(mes)){
                month=Integer.parseInt(mes);
                cal.set(Calendar.MONTH, month);
            }else{
                if(numMes!=0){
                    cal.set(Calendar.MONTH, numMes-1);
                }
            }
        }

        if(!dia.equals("")){
            if(eFecha.isNumber(dia)){
                int day=Integer.parseInt(dia);
                cal.set(Calendar.DAY_OF_MONTH, day);
            }
        }

        if(!anio.equals("")){
            if(eFecha.isNumber(anio)){
                int year=Integer.parseInt(anio);
                cal.set(Calendar.YEAR, year);
            }
        }     
        //enviamos el calendar que contruimos
        //modelo.Date fecha = new modelo.Date();
        fecha.setDate(cal);
       // System.out.println("-------------\ngetDate() :"+fecha.getDate());
        resp.setObject(fecha);

        }catch(Exception e){
            fecha.setDate(null);
            resp.setAnswer(null);
        }
        return resp;
    }//de run rules

   

    public double getOrderBonus() {
        return orderBonus;
    }

    public void setOrderBonus(double orderBonus) {
        this.orderBonus = orderBonus;
    }
}
