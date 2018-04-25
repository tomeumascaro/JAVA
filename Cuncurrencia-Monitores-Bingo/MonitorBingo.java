/*
 * Clase MonitorBingo
 */
package bingo3;

import static java.lang.Thread.sleep;

/**
 *
 * @author Bartomeu Mascaró Arbona & Eduardo Erro Rodríguez
 */
public class MonitorBingo {

    private static int N_JUGADORES;
    private static boolean darNumero; //True si el presentador tiene que dar otro numero
    public volatile static int numeroElegido; //Num. que elije el presentador
    private volatile static boolean bingo; //True si algun jugador canta bingo
    private volatile static int jugadoresRestantes = 0;

    /**
     * Constructor del monitor del bingo
     *
     * @param nJugadores numero de jugadores que participan en el bingo
     */
    public MonitorBingo(int nJugadores) {
        this.N_JUGADORES = nJugadores;
        darNumero = true;
        bingo = false;
    }

    /**
     * Metodo que indica si algun jugador ha cantado bingo
     *
     * @return true si hay bingo
     */
    public boolean esBingo() {
        return bingo;
    }

    /**
     * Metodo para idicar que un jugador ha cantado bingo
     *
     */
    public synchronized void cantarBingo() {
        bingo = true;
        jugadoresRestantes = 0;
        notifyAll();
    }

    public synchronized void elegirNumPresentador(int num) throws InterruptedException {
        jugadoresRestantes = N_JUGADORES;
        numeroElegido = num;
        notifyAll(); //Notifica als jugadors quan treu un nombre
        if (!esBingo()) {
            wait(); //Espera per tornar treure un nombre
            sleep(1000);
        }
    }

    public synchronized int llegirNumJugador() throws InterruptedException {
        int num;
        if (!esBingo()) {
            wait();
            num = numeroElegido;
            jugadoresRestantes--;
            if (jugadoresRestantes == 0) { //Quan tots els jugadors han sentit el nombre
                notifyAll();
            } else {
                wait();
            }
        } else {
            num = -1;
        }
        return num;
    }
}
