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

import modelo.Title;

/**
 *
 * @author alos
 */
public class TitleDescriptor extends Descriptor {

    private double orderBonus = 5.0;
    private double finishedString = 5.0;

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
                                }else {
                                    //It means it just a regular word
                                    isTokenString = true;
                                    i= aString.length();
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
        resp.setDescriptorType(DescriptorType.TITLE);
        //TODO ver que onda con los otros tipos de titulos
        Title title = new Title(aString);
        resp.setObject(title);
        return resp;
    }//de run rules

    public double getOrderBonus() {
        return orderBonus;
    }

    public void setOrderBonus(double orderBonus) {
        this.orderBonus = orderBonus;
    }
}
