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
            String cita1 = "Smith, Jane. 1996. There is no resisting the Borg queen. Maclean's, December 2.";
            String cita2 = "Aron, R. (1961). Dimensions de la conscience historique. Paris: Plon";
            String cita3 = "Ayer, A.J. (1959). Logical Positivism. El amanecer sin sol. Nueva York, Free Press";
            String cita4 = "Comte, A. (1975). Cours de Philosophie positive. Caminando con las cosas. Paris, Hermann, Tomos 1 & 2, [1a. ed., 1832-1840, Paris. Librairie Positiviste]";

            LinkedList<String> listaDeCitas = new LinkedList<String>();
            listaDeCitas.add(cita1);
            listaDeCitas.add(cita2);
            listaDeCitas.add(cita3);
            listaDeCitas.add(cita4);

            
            
            LinkedList<TemporalReference> listaDeReferencias = dm.getCitations(listaDeCitas, "Chicago");
            int i = 1;
            for (Citation c : listaDeReferencias) {
                System.out.println("====Cita "+i+"====");

                System.out.println("Type: ");
                System.out.println(c.getType());

                System.out.println("Autores: ");
                for (Author a : c.getAutors()) {
                    System.out.println(a.getName());
                }

                System.out.println("Titulo:");
                System.out.println(c.getTitle());

                System.out.println("Revista:");
                System.out.println(c.getPeriodicalTitle());

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


                System.out.println("=Extras=");
                System.out.println(c.getExtra());
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            control.Db4oConnectionManager.closeDB();
        }
    }//del main
}
