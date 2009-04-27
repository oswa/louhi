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

/**
 *
 * @author alos
 */
public class Token implements modelo.Node{
    private TokenType tokenType;
    private String token="";
    private double value=0;
    public Token(TokenType tokenType){
       this.tokenType = tokenType;
    }

    public Token(TokenType tokenType, String sep) {
        this.tokenType = tokenType;
        this.token = sep;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenType getTokenType() {
        return tokenType;
    }


    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Token other = (Token) obj;
        if (this.tokenType != other.tokenType) {
            return false;
        }
        if ((this.token == null) ? (other.token != null) : !this.token.equals(other.token)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.tokenType != null ? this.tokenType.hashCode() : 0);
        hash = 29 * hash + (this.token != null ? this.token.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Type:" +this.tokenType + " Value:"+ this.value +" String: "+this.getToken();
    }
    
}
