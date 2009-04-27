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
public class Statement {
    public LinkedList<Token> statement;

    public Statement(LinkedList<Token> statement){
        this.statement= statement;
    }

    public LinkedList<Token> getStatement() {
        return statement;
    }

    public void setStatement(LinkedList<Token> statement) {
        this.statement = statement;
    }

    /**
     * If this statement contains a separator returns true
     * @return
     */
    public boolean containsSeparator(){
        for(Token tok : statement){
            if(tok.getTokenType().equals(TokenType.SEPARATOR))
                return true;
        }
        return false;
    }

    /**
     * Gets the separators as a list of Strings
     * @return
     */
    public LinkedList<String> getSeparators(){
        LinkedList<String> separatorList = new LinkedList<String>();
        for(Token tok : statement){
            if(tok.getTokenType().compareTo(TokenType.SEPARATOR)==0)
                separatorList.add(tok.getToken());
        }
        return separatorList;
    }
/**
 * Gets the number of diferent separators
 * @return
 */
    public int numberOfUniqueSeparators(){
        LinkedList<String> separatorList = this.getSeparators();
        LinkedList<String >aux = new LinkedList<String >();
        for(String sep: separatorList){
            boolean iguales = false;
            for(String sepaux: aux){
                if(sep.compareToIgnoreCase(sepaux)==0){
                    iguales=true;
                    break;
                }
            }
            if(!iguales)
                aux.add(sep);
        }
        return 0;
    }


    /**
     * Get the separators in one single string
     * @return
     */
    public String getSeparatorsAsString(){
        String  separators = "";
        for(Token tok : statement){
            if(tok.getToken().equals(TokenType.SEPARATOR))
                separators=separators+tok.getToken();
        }
        return separators;
    }

    @Override
    public boolean equals(Object obj) {
        boolean iguales = false;
        if(this.getClass() == obj.getClass()){
            Statement s = (Statement)obj;
            if(this.statement.size() == s.statement.size()){
                for(int i=0; i< this.statement.size();i++){
                    if(this.statement.get(i).equals(s.statement.get(i)))
                        return true;
                }
            }

        }
        return iguales;
    }

    @Override
    public String toString() {
        String aux ="";
        for(Token token : this.statement){
            if(token.getTokenType().compareTo(TokenType.SEPARATOR)==0)
                aux = aux + " - " + token.getToken();
            else
                if(token.getTokenType().equals(TokenType.STRING)){
                    if(token.getToken().length() > 0)
                        aux= aux + " - " + token.getToken();
                    else
                        aux= aux + " - " + token.getTokenType();
                }
                else
                    aux= aux + " - " + token.getTokenType().toString();
        }
        return aux;
    }

    int getNumberOfBlocks() {
        int separadores = 0;
        for(Token tok : this.statement){
            if(tok.getTokenType().equals(TokenType.SEPARATOR))
                separadores++;
        }
        return separadores+1;
    }


}
