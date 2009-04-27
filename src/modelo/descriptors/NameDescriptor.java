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
package modelo.descriptors;

import java.util.LinkedList;

/**
 *
 * @author alos
 */
public class NameDescriptor extends Descriptor {

    private double sameSeparator = 25.0;
    private double hasSameNumerOfSeparators = 25.0;
    private double penalty = -25.0;
    private double typeValue = 25.0;

    public DescriptorAnswer runRules(String aString) {
        DescriptorAnswer resp = new DescriptorAnswer();
        Evaluator eva = new Evaluator();

        // NameDescriptor nameDesc = nameDescContainer.getNameDescriptor();

        for (Statement s : statements) {
            DescriptorAnswer aux = new DescriptorAnswer();
            aux.setAnswer(s);
            LinkedList<String> separators = s.getSeparators();

            //first we check if this has the same number of separators
            if (s.containsSeparator()) {
                if (eva.getNumberOfSeparators(aString, separators) == s.getSeparators().size()) {
                    aux.addToScore(this.hasSameNumerOfSeparators);
                }
            } else {
                if (!eva.containsAnySeparators(aString)) {
                    aux.addToScore(this.hasSameNumerOfSeparators);
                }
            }

            //we see of how many blocks is the rule composed of and then check that with the string
            int numberOfBlocks = s.getNumberOfBlocks();
            String nombres[] = aString.split("[ ]");
            if (numberOfBlocks == nombres.length) {
                for (String cadenaPrueba : nombres) {
                    //if the string has integers this is not a name
                    if (!eva.containsIntegers(aString)) {
                        boolean checkedFirstLetter = false;
                        //We compare the tokens with the string
                        for (int i = 0; i < s.statement.size(); i++) {
                            Token tok = s.statement.get(i);
                            //If the token thinks the first thing is a capital letter we check
                            if (tok.getTokenType().equals(TokenType.CAPITALLETTER)) {
                                try {
                                    if (Character.isUpperCase(cadenaPrueba.charAt(0))) {
                                        aux.addToScore(typeValue);
                                        checkedFirstLetter = true;
                                    }
                                } catch (java.lang.StringIndexOutOfBoundsException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                //if the token is a smallletter we check the rest of  the word for them
                                //until we find a blank space
                                if (checkedFirstLetter) {
                                    if (tok.getTokenType().equals(TokenType.SMALLLETTERS)) {
                                        boolean hasAllSmallletters = false;
                                        for (int j = 1; j < cadenaPrueba.length(); j++) {//from one since the first letter has been checked
                                            //if the character is NOT a separator we continue
                                            if (!eva.isASeparator(cadenaPrueba.charAt(j), separators)) {
                                                if (!Character.isUpperCase(cadenaPrueba.charAt(j))) {
                                                    hasAllSmallletters = true;
                                                } else {
                                                    hasAllSmallletters = false;
                                                    break;
                                                }
                                            } else {
                                                //we are going to ckeck if by any chance the separator is in fact the same
                                                //separator that comes in order
                                                if (cadenaPrueba.charAt(j) + "".compareToIgnoreCase(separators.getFirst()) == 0) {
                                                    aux.addToScore(this.sameSeparator);
                                                    //now we remove this separator since its been checked
                                                    separators.removeFirst();
                                                }
                                            }//del si es un sparator
                                        }//del for the j=1
                                        if (hasAllSmallletters) {
                                            aux.addToScore(typeValue);
                                        }
                                    }//del is para ver si ahora piden small letters
                                } else {
                                    if (tok.getTokenType().equals(TokenType.SMALLLETTERS)) {
                                        boolean hasAllSmallletters = false;
                                        for (int j = 1; j < aString.length(); j++) {//from one since the first letter has been checked
                                            //if the character is NOT a separator we continue
                                            if (!eva.isASeparator(aString.charAt(j), separators)) {
                                                //if this is a whitespace we stop and continue to the next word
                                                if (Character.isWhitespace(aString.charAt(j))) {
                                                    //we remove the string we already compared
                                                    aString = aString.substring(j + 1, aString.length());
                                                    break;
                                                }

                                                if (!Character.isUpperCase(aString.charAt(j))) {
                                                    hasAllSmallletters = true;
                                                } else {
                                                    hasAllSmallletters = false;
                                                    break;
                                                }
                                            } else {
                                                //we are going to ckeck if by any chance the separator is in fact the same
                                                //separator that comes in order
                                                if (aString.charAt(j) + "".compareToIgnoreCase(separators.getFirst()) == 0) {
                                                    aux.addToScore(this.sameSeparator);
                                                    //now we remove this separator since its been checked
                                                    separators.removeFirst();
                                                }
                                            }//del si es un sparator
                                        }//del for the j=1
                                        if (hasAllSmallletters) {
                                            aux.addToScore(typeValue);
                                        }
                                    }//del is para ver si ahora piden small letters
                                }//del else del checkedFirstLetter
                            }//del else de capitalletters
                        }//del for de los tokens
                    } else {
                        aux.addToScore(this.penalty);
                    }//del if de los numeros
                    //Is this better then the lastone?
                    if (resp.getScore() < aux.getScore()) {
                        resp = aux;
                    }
                }//el de los nombres
            }//del if sobre los cachos
        }//del for de los statements
        return resp;
    }//del runRules
}
