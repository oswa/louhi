/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas.persistencia;

import java.util.LinkedList;

/**
 *
 * @author alos
 */
public class Dog {
    private String nombre;
    private int numeroDePatas;
    LinkedList<String> apodos = new LinkedList<String>();

    public LinkedList<String> getApodos() {
        return apodos;
    }

    public void setApodos(LinkedList<String> apodos) {
        this.apodos = apodos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDePatas() {
        return numeroDePatas;
    }

    public void setNumeroDePatas(int numeroDePatas) {
        this.numeroDePatas = numeroDePatas;
    }

    @Override
    public String toString() {
        String aux= "Nombre: "+this.nombre;
        aux= aux +" Apodos: ";
        for(String s: apodos){
            aux = aux +" "+ s;
        }
        return aux;
    }

    
}
