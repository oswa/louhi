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

package modelo;

/**
 *
 * @author alos
 */
public class Author implements Node{
    public  String  name;

    /**
     * Default contructor
     */
    public Author(){}

    public Author(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        Author a = (Author)obj;
        if(this.name.compareToIgnoreCase(a.getName())==0)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return this.name;
    }

    
    
}
