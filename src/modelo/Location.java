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

package modelo;

/**
 *
 * @author alos
 */
public class Location implements Node{
    public String nameOfLocation="";

    public Location(){}
    
    public Location(String aString) {
        this.nameOfLocation=aString;
    }

    public String getNameOfLocation() {
        return nameOfLocation;
    }

    public void setNameOfLocation(String nameOfPlace) {
        this.nameOfLocation = nameOfPlace;
    }

    @Override
    public String toString() {
        return this.nameOfLocation;
    }
 
}
