/*
 * Classe Fumador
 */
package fumadors;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Bartomeu Mascaró Arbona  & Eduardo Erro Rodríguez
 */
public class Fumador implements Runnable {

    private final String nomFumador;
    private final int ingredient;
    private final Semaphore sem;
    private final int T_FUMAR = 1000;
    private int counter = 0;

    Fumador(String nomFumador, int ingredient, Semaphore sem) {
        this.nomFumador = nomFumador;
        this.ingredient = ingredient;
        this.sem = sem;
    }

    @Override
    public void run() {
        try {
            while (!Fumadors.fi) {
                sem.acquire(); //Esperam permis del semafor
                if (!Fumadors.fi) {
                    System.out.println("Fuma el " + nomFumador + " (Ingredient: " + Ingredients.values()[ingredient] + ")\n");
                    sleep(T_FUMAR);
                    counter++;
                    Fumadors.semAgent.release(); //Activam semafor agent
                }
            }
            System.out.println("Fumador " + (ingredient+1) + " ha fumat " + counter + " xigarrets");
        } catch (InterruptedException ex) {
            System.err.println("ERROR Fumador: " + ex.toString());
        }
    }
}
