/*
 * PRÀCTICA 2 - Programació Concurrent - Enginyeria Informàtica - UIB
 * Bingo monitors
 * Enllaç video explicatiu Youtube: https://www.youtube.com/watch?v=-5BppR6pBMI
 */
package bingo3;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Bartomeu Mascaró Arbona & Eduardo Erro Rodríguez
 */
public class Bingo3 {

    static int N_JUGADORES;
    static final int MIN_N_JUGADORES = 2;
    static final int MAX_N_JUGADORES = 4;
    static final int MAX_CARTONES = 4; //Num. maximo cartones del jugador
    static final int NUM_CARTON = 15; //Num. inicial de numeros que contiene cada carton. Tiene que ser menor a MAX_NUM 
    static final int MAX_NUM = 90; //Num. maximo que puede salir en el bingo
    static final int MIN_SLEEP = 200;
    static final int MAX_SLEEP = 400;

    public static void main(String[] args) throws InterruptedException {
        N_JUGADORES = ThreadLocalRandom.current().nextInt(MIN_N_JUGADORES, MAX_N_JUGADORES + 1);
        MonitorBingo monitor = new MonitorBingo(N_JUGADORES);
        Thread[] jugadores = new Thread[N_JUGADORES];
        Thread presentador = new Thread(new Presentador(monitor));

        for (int i = 0; i < N_JUGADORES; i++) {
            jugadores[i] = new Thread(new Jugador(monitor, i + 1));
            jugadores[i].start(); //Iniciamos jugadores
        }
        presentador.start(); //Iniciamos presentador

        for (int i = 0; i < N_JUGADORES; i++) {
            jugadores[i].join(); //Los jugadores esperan a que todos acaben
        }
        presentador.join(); //El presentador espera a que los jugadores acaben
        System.out.println("Se acaba el bingo");
    }
}
