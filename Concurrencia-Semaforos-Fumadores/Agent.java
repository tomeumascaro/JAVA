/*
 * Classe Agent
 */
package fumadors;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author Bartomeu Mascaró Arbona & Eduardo Erro Rodríguez
 */
public class Agent implements Runnable {
    
    private final int T_FABRICAR = 500;

    Agent() {
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < Fumadors.MAX; i++) {
                Fumadors.semAgent.acquire(); //Esperam permis del semafor
                int ingr1 = new Random().nextInt(Fumadors.N_FUMADORS); //Posa 1r ingredient
                int ingr2 = new Random().nextInt(Fumadors.N_FUMADORS); //Posa 2n ingredient
                while (ingr1 == ingr2) {
                    ingr2 = new Random().nextInt(Fumadors.N_FUMADORS);
                }

                System.out.println("Ingredients servits: " + Ingredients.values()[ingr1] + " i " + Ingredients.values()[ingr2]);
                sleep(new Random().nextInt(T_FABRICAR));

                //En funcio dels ingredients servits, cridam al fumador pertinent
                if ((ingr1 == 0 && ingr2 == 1) || (ingr1 == 1 && ingr2 == 0)) {
                    Fumadors.semFumadors[2].release();
                } else if ((ingr1 == 0 && ingr2 == 2) || (ingr1 == 2 && ingr2 == 0)) {
                    Fumadors.semFumadors[1].release();
                } else if ((ingr1 == 1 && ingr2 == 2) || (ingr1 == 2 && ingr2 == 1)) {
                    Fumadors.semFumadors[0].release();
                }
            }
            
            Fumadors.semAgent.acquire(); //Quan s'ha fabricat el derrer xigarret, hem d'esperar que es fumi abans d'indicar que s'acaba
            Fumadors.fi = true;
            for (int i = 0; i < Fumadors.N_FUMADORS; i++) {
                Fumadors.semFumadors[i].release();
            }

        } catch (InterruptedException ex) {
            System.out.println("ERROR Agent: " + ex.toString());
        }

    }

}
