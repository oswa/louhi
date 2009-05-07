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

import java.util.LinkedList;

/**
 *
 * @author alos
 */
public class Template {
    private Type type;
    private String name;
    private LinkedList<Node> citationRule = new LinkedList<Node>();

    public LinkedList<Node> getCitationRule() {
        return citationRule;
    }

    public void setCitationRule(LinkedList<Node> citationRule) {
        this.citationRule = citationRule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    @Override
    public String toString() {
        String aux ="Type: "+this.type+"\n" +  "Name: "+this.name+"\n" + "Rule: ";
        for(Node n : this.citationRule){
            if(n instanceof Author)
                aux=aux +" AUTHOR ";
            if(n instanceof Title)
                aux=aux +" TITLE ";
            if(n instanceof Date)
                aux=aux +" modelo.DATE ";
            if(n instanceof Pages)
                aux=aux +" PAGES ";
            if(n instanceof Volume)
                aux=aux +" VOLUME ";
            if(n instanceof Publisher)
                aux=aux +" PUBLISHER ";
            if(n instanceof Location)
                aux=aux +" LOCATION ";
            if(n instanceof PeriodicalTitle)
                aux=aux +" PERIODICTITLE";
        }
        return aux ;
    }
}
