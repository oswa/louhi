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

import java.util.LinkedList;

/**
 *
 * @author alos
 */
public class CitationDescriptor extends Descriptor {
    double sameSeparator=25.0;
    double hasSameNumerOfSeparators=25.0;
    double typeValue=25.0;

    public DescriptorAnswer runRules(String object) {
        DescriptorAnswer resp = new DescriptorAnswer();
        Evaluator eva = new Evaluator();
        for (Statement s : statements) {
            DescriptorAnswer aux = new DescriptorAnswer();
            aux.setAnswer(s);
            LinkedList<String> separators = s.getSeparators();


            //first we check if this has the same number of separators
            if (object.indexOf(separators.getFirst()) == object.lastIndexOf(separators.getFirst())) {
                aux.addToScore(this.hasSameNumerOfSeparators);
            }
            //if it has the same separator
            if (object.contains(separators.getFirst())) {
                aux.addToScore(sameSeparator);
                //since the references only start at one point in the text we use the first one
                int separatorInitialPos = eva.getSeparatorPosition(object, separators.getFirst());

                //we get the las position of the separator to split the string
                int separatorLastPos = separatorInitialPos + separators.getFirst().length();
                //we check to see if the back and front of the separator matches the correct type
                String before = object.substring(0, separatorInitialPos - 1); // -1 to get just before the separator
                String after = object.substring(separatorLastPos + 1, object.length());
                //TODO maybe not do this
                aux.setObject(after);
            }

            //Is this better then the lastone?
            if (resp.getScore() < aux.getScore()) {
                resp = aux;
            }

        }
        return resp;
    }


}
