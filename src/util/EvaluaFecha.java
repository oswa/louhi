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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;
import modelo.descriptors.Token;

/**
 *
 * @author oswaldo
 */
public class EvaluaFecha {

    public boolean isNumber(String tokenDate) {
        try{
            Integer.parseInt(tokenDate);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public int evaluaMes(String mes ) {
        int numMes=0;

        if(mes.equalsIgnoreCase("enero")||mes.equalsIgnoreCase("january")||mes.equalsIgnoreCase("janeiro")||mes.equalsIgnoreCase("janvier"))
            numMes=1;
        if(mes.equalsIgnoreCase("febrero")||mes.equalsIgnoreCase("february")||mes.equalsIgnoreCase("fevereiro")||mes.equalsIgnoreCase("fevrier"))
            numMes=2;
        if(mes.equalsIgnoreCase("marzo")||mes.equalsIgnoreCase("março")||mes.equalsIgnoreCase("march")||mes.equalsIgnoreCase("mars"))
            numMes=3;
        if(mes.equalsIgnoreCase("abril")||mes.equalsIgnoreCase("april")||mes.equalsIgnoreCase("avril"))
            numMes=4;
        if(mes.equalsIgnoreCase("mayo")||mes.equalsIgnoreCase("may")||mes.equalsIgnoreCase("maio")||mes.equalsIgnoreCase("mai"))
            numMes=5;
        if(mes.equalsIgnoreCase("junio")||mes.equalsIgnoreCase("june")||mes.equalsIgnoreCase("junho")||mes.equalsIgnoreCase("juin"))
            numMes=6;
        if(mes.equalsIgnoreCase("julio")||mes.equalsIgnoreCase("july")||mes.equalsIgnoreCase("julho")||mes.equalsIgnoreCase("juillet"))
            numMes=7;
        if(mes.equalsIgnoreCase("agosto")||mes.equalsIgnoreCase("august")||mes.equalsIgnoreCase("aout"))
            numMes=8;
        if(mes.equalsIgnoreCase("septiembre")||mes.equalsIgnoreCase("september")||mes.equalsIgnoreCase("septembro")||mes.equalsIgnoreCase("septembre"))
            numMes=9;
        if(mes.equalsIgnoreCase("octubre")||mes.equalsIgnoreCase("october")||mes.equalsIgnoreCase("octubro")||mes.equalsIgnoreCase("octobre"))
            numMes=10;
        if(mes.equalsIgnoreCase("noviembre")||mes.equalsIgnoreCase("november")||mes.equalsIgnoreCase("novembro")||mes.equalsIgnoreCase("novembre"))
            numMes=11;
        if(mes.equalsIgnoreCase("diciembre")||mes.equalsIgnoreCase("december")||mes.equalsIgnoreCase("dezembro")||mes.equalsIgnoreCase("decembre"))
            numMes=12;

        return numMes;
    }

    public Date validaFecha(String aString){
    String aStringRe ="";
    String fechaToken="";
    
            if(aString.indexOf("(")==0){
                aStringRe=aString.replace("(", "");
            }else{
                aStringRe=aString;
            }

        StringTokenizer token = new StringTokenizer(aStringRe);
        //LinkedList fecha=new LinkedList<String>();
        List<String> fecha = new ArrayList<String>();

        //Calendar calendar = new GregorianCalendar();
Locale l = new Locale("es","MX");
Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("America/Mexico_City"),l);
            


        while(token.hasMoreTokens()){
            String nextToken = token.nextToken();

           //Eliminamos los caracteres como (),.:;
           String tok1 = "";
           for (int x=0; x < nextToken.length(); x++) {
                if (nextToken.charAt(x) != '(')
                    tok1 += nextToken.charAt(x);
            }

           String tok2="";
           for(int y=0; y < tok1.length(); y++){
                if(tok1.charAt(y) !=',')
                    tok2 += nextToken.charAt(y);
           }

           String tok3="";
           for(int z=0; z<tok2.length(); z++){
               if(tok2.charAt(z)!=':')
                   tok3 += nextToken.charAt(z);
           }

           String tok4="";
           for(int a=0; a<tok3.length(); a++){
               if(tok3.charAt(a)!='.')
                   tok4 += nextToken.charAt(a);
           }

           //String tok5="";
           String lastToken="";
           for(int b=0; b<tok4.length(); b++){
               if(tok4.charAt(b)!=')')
                   lastToken += nextToken.charAt(b);
           }
           /*fecha=tok5;
           System.out.println("fecha: "+fecha);*/
           fechaToken = lastToken;
           fecha.add(fechaToken);
        }

        String fechaFinal="";
        for(int i=0;i<fecha.size();i++){
            fechaFinal=fechaFinal+" "+fecha.get(i);
        }
           System.out.println("elementos: "+fecha);
           System.out.println("elementos: "+fecha.size());
           System.out.println("fechaFINAL"+fechaFinal);
           
           StringTokenizer pFecha = new StringTokenizer(fechaFinal);
           Date fDate = new Date();
          
                while(pFecha.hasMoreTokens()){
                    String tok = pFecha.nextToken();
                    //comprobamos que sea un mes, un dia o un año
                     if(tok.length()==2){
                     int day = Integer.parseInt(tok);
                    calendar.set(Calendar.DAY_OF_MONTH, day);
                }

                if(tok.length()==4){
                    int anio=0;
                    try{
                         anio = Integer.parseInt(tok);
                     }catch(Exception e){
                        System.out.println(tok+" no es un año");
                     }
                    calendar.set(Calendar.YEAR, anio);
                }

                if(tok.length()<12){
                    EvaluaFecha evalua = new EvaluaFecha();
                    int month = evalua.evaluaMes(tok);
                    int mes=0;

                    if(month!=0){
                        calendar.set(Calendar.MONTH, month);
                        
                    }
                }
            }
                
          
           
        

        String dia = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(calendar.get(Calendar.MONTH));
        String anio = String.valueOf(calendar.get(Calendar.YEAR));


        System.out.println("dia--->"+dia);
        System.out.println("mes-->"+mes);
        System.out.println("año-->"+anio);

        String fechaPosible = dia+"/"+mes+"/"+anio;
        System.out.println("posibel fecha:"+fechaPosible);

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Calendar posibleFecha = GregorianCalendar.getInstance();
        Date d = new Date();
        
        try {
            d = format.parse(fechaPosible);
            posibleFecha.setTime(d);
        } catch (ParseException ex) {
            System.out.println("Exception :" + ex);
        }

        Date dateFinal = posibleFecha.getTime();
        return dateFinal;
    }

    public static void main(String [] args){
        EvaluaFecha e = new EvaluaFecha();
        //int d=e.evaluaMes("enero");
        Date date=e.validaFecha("enero, 11");
        //System.out.println(d);
        System.out.println(date);
    }

}
