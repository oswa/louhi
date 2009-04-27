/*
 This file is part of Louhi.

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
import localContainers.NameDescriptorContainer;
import modelo.Author;

/**
 *
 * @author alos
 */
public class AuthorDescriptor extends Descriptor {

    private double allNamesValue = 10;
    private double valueForName = 0;
    private double valueForHalfName = 0;
    private double minScoreToPassName = 50;
    public DescriptorAnswer runRules(String aString) {
        DescriptorAnswer resp = new DescriptorAnswer();
        NameDescriptorContainer nameDescConta= new NameDescriptorContainer();
        Evaluator eva = new Evaluator();

        aString=eva.removeBugsInText(aString);

        NameDescriptor nameDesc = nameDescConta.getNameDescriptor();
        LinkedList<Author> authorList = new LinkedList<Author>();
        boolean allNames = true;
        for (Statement s : statements) {
            DescriptorAnswer aux = new DescriptorAnswer();
            String[] pice = aString.split("[ ]");
            LinkedList<String> pices = new LinkedList<String>();
            for(String p : pice){
                    p.replaceAll(" ", "");
                    if(p.length()>0)
                        pices.add(p);
            }

            
            int pares = 0;//we set this variable to count the pairs
            String possibleName="";//a helper string to put togather the names
            //if pice has an even number we need to make sure the last pice is evaluated so...
            int picesLenght = pices.size() % 2;
            boolean isEven=false;
            if (picesLenght != 0) {
                isEven = true;
            }
            int i = 0;

            //we count the things to get the value
            if(pices.size() > 1){
                if(!isEven)
                    valueForName = 100 / (pices.size() /2) ;//if its not an even number
                                                           // we simply divide it by 2
                else{
                    //we get how many pairs we can do plus a half
                    double wholeValue = 100 / ((pices.size()-1)/2);
                    this.valueForName = wholeValue;
                    this.valueForHalfName = wholeValue/2;
                }
            }
            else
                valueForName= 100;

            for (String aName : pices) {
                i++;
                if (pices.size() > 1) {
                    if (i == pices.size() && isEven) {
                        //if its the lastone
                        String meh = eva.removeSeparators(aName);
                        DescriptorAnswer ansAux = nameDesc.runRules(meh);
                        if (ansAux.getScore() >= minScoreToPassName) {
                            //creamos entonces a un autor nuevo
                            Author newAuthor = new Author();
                            newAuthor.setName(meh);
                            authorList.add(newAuthor);
                            resp.setAnswer(s);
                            resp.addToScore(this.valueForHalfName);
                        }else{
                            resp.addToScore(-valueForHalfName -20);
                        }
                    } else {
                        pares++;
                        if (pares == 2) {
                            possibleName = possibleName + " " + aName;
                        } else {
                            possibleName = aName;
                        }
                        if (pares == 2) {
                            DescriptorAnswer ansAux = nameDesc.runRules(possibleName);
                            if (ansAux.getScore() >= minScoreToPassName) {
                                //creamos entonces a un autor nuevo
                                String newAuthorName = "";
                                newAuthorName = newAuthorName + possibleName;
                                Author newAuthor = new Author();
                                newAuthor.setName(newAuthorName);
                                authorList.add(newAuthor);
                                resp.setAnswer(s);
                                resp.addToScore(valueForName);
                            } else {
                                allNames = false;
                                break;
                            }
                            pares = 0;
                        }
                    }//del q tiene el i
                } else {

                        String cleanName= eva.removeSeparators(aName);

                        DescriptorAnswer ansAux = nameDesc.runRules(cleanName);
                        if (ansAux.getScore() > minScoreToPassName) {
                            //creamos entonces a un autor nuevo
                            Author newAuthor = new Author();
                            newAuthor.setName(cleanName);
                            authorList.add(newAuthor);
                            resp.setAnswer(s);
                            resp.addToScore(valueForName);
                        }
                }//del de mas de uno
            }
        }
        if (allNames) {
            resp.addToScore(allNamesValue);
            resp.setObject(authorList);
        }
        resp.setDescriptorType(DescriptorType.AUTHOR);
        return resp;
    }



    public LinkedList<Statement> getStatements() {
        return statements;
    }

    public void setStatements(LinkedList<Statement> statements) {
        this.statements = statements;
    }
}
