/*
 *This file is part of Louhi.

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

import modelo.Month;
import java.util.LinkedList;

/**
 *
 * @author alos
 */
public class Evaluator {
    
    char []validCharsForName = {' ','\'','`','´','.','’'};//might have to be unicode later
    String [] validSeparators= {",",".",";",":","-"};

    public Evaluator() {
        //TODO rellenar las cosas de arriba desde la base de datos y hacerles un lugar donde se puedan capturar
    }


    

    

    /**
     * Returns true if the string is a number
     * @return
     */
    public boolean isNumber(String aString) {

        return false;
    }

    /**
     * Determines if the string is a pure String with no numbers
     * @param aString
     * @return
     */
    public boolean isString(String aString) {

        return false;
    }

    /**
     * Determines if the String is a name in the format: Xxxxx or X.
     * @param aString
     * @return
     */
    public boolean isName(String aString) {
        boolean resp=false;
        char firstLetter=aString.charAt(0);
        if(Character.isUpperCase(firstLetter))
            resp=true;
        for(int i=1; i<aString.length();i++){
            char ch = aString.charAt(i);
            if(!Character.isLetter(ch) && !this.isValidForName(ch))
                resp=false;
        }
        return resp;
    }


    /**
     * If the character is one of the separators it returns trues
     * @param c
     * @param separators
     * @return
     */
    public boolean isASeparator(char c, LinkedList<String> separators){
        boolean esSeparador= false;
        for(String separator: separators){
            if(separator.compareToIgnoreCase(c+"")==0)
                return true;
        }
        return esSeparador;
    }
    
    /**
     * Looks for this object in the working memory to see if it matches a publisher
     * @param aString
     * @return
     */
    public boolean wmPublisherChecker(String aString) {
        return false;
    }

    /**
     * Looks for this object in the working memory to see if it matches an Author
     * @param aString
     * @return
     */
    public boolean wmAuthorChecker(String aString) {
        return false;
    }

    /**
     * Looks for this object in the working memory to see if it matches a title
     * @param aString
     * @return
     */
    public boolean wmTitleChecker(String aString) {
        return false;
    }

    
    /**
     * Compares the character and makes sure that character can be used in a name
     * @param ch
     * @return
     */
    public boolean isValidForName(char ch) {
        boolean isValid = false;
        for (int i = 0; i < validCharsForName.length; i++) {
            if (ch == validCharsForName[i]) {
                isValid = true;
            }

        }
        return isValid;
    }

/**
 * If the string contains a number this returns true
 * @param aString
 * @return
 */
    public boolean containsIntegers(String aString){
       for(int i=0; i<aString.length();i++){
            if(Character.isDigit(aString.charAt(i)))
                return true;
       }
       return false;
    }

    /**
     * Gets the separator index
     * @param aString
     * @param separator
     * @return
     */
    public int getSeparatorPosition(String aString, String separator) {
        if (aString.contains(separator)) {
            return aString.indexOf(separator);
        }
        return -1;
    }

/**
 * Returns true if it has any of the separators
 * @param aString
 * @param separadores
 * @return
 */
    public boolean containsAnySeparators(String aString){
        for(String sep: this.validSeparators){
            if(aString.contains(sep))
                return true;
        }
        return false;
    }

    /**
     * Gets the number of separators in the string
     * @param aString
     * @param separadores
     * @return
     */
    public int getNumberOfSeparators(String aString, LinkedList<String> separadores) {
        int cont = 0;
        for (String sep : separadores) {
            for (int i = 0; i < aString.length(); i++) {
                if ((aString.charAt(i)+"").compareToIgnoreCase(sep)==0) 
                    cont++;
            }
        }
        return cont;
    }

    
    /**
     * Tests if this is a month
     * @param aPossibleMonth
     * @return
     */
    public boolean isAMonth(String aPossibleMonth) {
        Month meses[]= Month.values();
        for(Month e : meses){
            if(e.toString().compareToIgnoreCase(aPossibleMonth)==0)
                return true;
        }

        if(aPossibleMonth.compareToIgnoreCase("Mar\u00E7")==0)
            return true;

        if(aPossibleMonth.compareToIgnoreCase("f\u00E9vrier")==0)
            return true;
        if(aPossibleMonth.compareToIgnoreCase("ao\u00FBt")==0)
            return true;
        if(aPossibleMonth.compareToIgnoreCase("d\u00E9cembre")==0)
            return true;

        return false;
    }

    /**
     * Eliminates the commas from the string
     * @param aName
     * @return
     */
    public String removeSeparators(String aName) {
        String result="";
        for(int i=0;i<aName.length();i++){
            if(aName.charAt(i) != ',' && aName.charAt(i) != ':')
                result=result+aName.charAt(i);
        }
        return result;
    }
    

    public String removeBugsInText(String aString) {
       aString = aString.replace("&", "");
       aString = aString.replaceAll("and", "");
       aString = aString.replaceAll("y", "");
       aString = aString.replaceAll("\n", " ");

       

       return aString;
    }

   public static void main(String[] args) {
       Evaluator eva = new Evaluator();
       String f1 = "Aharon I. Etcoff N. Ariely D. Chabris C.F. O’Connor E. & Breiter,\nH.C";
       System.out.println(eva.removeBugsInText(f1));
    }
}
