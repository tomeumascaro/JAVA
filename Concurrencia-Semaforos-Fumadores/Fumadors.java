/*
 * PRÀCTICA 1 - Programació Concurrent - Enginyeria Informàtica - UIB
 * Fumadors semàfors
 * Enllaç video explicatiu Youtube: https://youtu.be/KK8IN7vMphk
 */
package fumadors;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Bartomeu Mascaró Arbona & Eduardo Erro Rodríguez
 */
public class Fumadors {
    static final int N_FUMADORS = 3;
    static final int MAX = 10;
    static volatile boolean fi = false;
    static Semaphore semAgent = new Semaphore(1); //Semafor agent
    static Semaphore[] semFumadors = new Semaphore[N_FUMADORS]; //Semafor per cada fumador

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Thread agent = new Thread(new Agent());
        Thread[] fumadors = new Thread[N_FUMADORS];
        
        agent.start();
        for (int i = 0; i < N_FUMADORS; i++) {
            semFumadors[i] = new Semaphore(0);
            String nomFumador = "Fumador " + (i+1);
            fumadors[i] = new Thread(new Fumador(nomFumador, i, semFumadors[i]));   
            fumadors[i].start();
        }

        agent.join();
        for (int i = 0; i < N_FUMADORS; i++) {
            fumadors[i].join();
        }
    }
}
