/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import control.DescriptorManager;
import java.util.LinkedList;
import modelo.*;

/**
 *
 * @author alos
 */
public class PruebaDeDescriptores {

    public static void main(String[] args) {
        try {
            DescriptorManager dm = new DescriptorManager();
            String cita1 = "Okuda, Michael, Denise Okuda. 1993. Star trek chronology: The history of the future. New York: Pocket Books.";
            String cita2 = "Aron, R. (1961). Dimensions de la conscience historique. Paris: Plon";
            String cita3 = "Ayer, A.J. (1959). Logical Positivism. Nueva York, Free Press";
            String cita4 = "Comte, A. (1975). Cours de Philosophie positive. Paris, Hermann, Tomos 1 & 2, [1a. ed., 1832-1840, Paris. Librairie Positiviste]";

            LinkedList<String> listaDeCitas = new LinkedList<String>();
            //listaDeCitas.add(cita1);
            //listaDeCitas.add(cita2);
            //listaDeCitas.add(cita3);
            listaDeCitas.add(cita4);

            System.out.println("\n\n=====Prueba1=======");
            System.out.println("Para: " + cita4);
            LinkedList<TemporalReference> listaDeReferencias = dm.getCitations(listaDeCitas, "Chicago");
            System.out.println("Citas:");
            for (Citation c : listaDeReferencias) {
                System.out.println("====Cita====");
                System.out.println("Autores: ");
                for (Author a : c.getAutors()) {
                    System.out.println(a.getName());
                }

                System.out.println("Titulo:");
                System.out.println(c.getTitle());

                System.out.println("Editorial:");
                System.out.println(c.getPublisher());

                System.out.println("Fechas:");
                System.out.println(c.getDate());

                System.out.println("Lugar:");
                System.out.println(c.getLocation());

                System.out.println("Paginas:");
                System.out.println(c.getPages());

                System.out.println("Volume:");
                System.out.println(c.getVolume());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            control.Db4oConnectionManager.closeDB();
        }
    }//del main
}
