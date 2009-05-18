/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author alos
 */
public class Number implements Node{
    private String number="";

    public Number(){}

    public Number(String string) {
        this.number = string;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return this.number;
    }


    
}
