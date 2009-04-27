/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebas.persistencia;

import pruebas.persistencia.Dog;
import java.util.LinkedList;

/**
 *
 * @author alos
 */
public class PruebaDeIDS {
    public static void main(String[] args) {
        Dog objPerro1 = new Dog();
        objPerro1.setNombre("Booby");
        objPerro1.setNumeroDePatas(4);
        LinkedList<String> listaApodos = new LinkedList<String>();
        listaApodos.add("Bob");
        listaApodos.add("Rooby");
        objPerro1.setApodos(listaApodos);

        DogContainer contenedor = new DogContainer();

        contenedor.saveDog(objPerro1);

        LinkedList<Dog> resp = contenedor.retrieveAllItemsLinkedList();
        for(Dog perro : resp){
            System.out.println("_____________________________________________________");
            System.out.println("Nombre: "+ perro.getNombre() +" Numero de patas: "+ perro.getNumeroDePatas());
            for(String apodo: perro.getApodos())
                System.out.println("Apodo:" +apodo);
        }
    }
}
