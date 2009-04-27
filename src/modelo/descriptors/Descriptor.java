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
public abstract class Descriptor {


   protected LinkedList<Statement> statements = new LinkedList<Statement>();

   public void addStatement(Statement statement) {
        this.statements.add(statement);
    }

    public void removeStatement(Statement statement){
        this.statements.remove(statement);
    }

     public LinkedList<Statement> getStatements() {
        return statements;
    }

    public void setStatements(LinkedList<Statement> statements) {
        this.statements = statements;
    }

    public abstract DescriptorAnswer runRules(String aString);

}
