/*
 * Clase Jugador
 */
package bingo3;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Bartomeu Mascaró Arbona & Eduardo Erro Rodríguez
 */
public class Jugador implements Runnable {

    private final int nCartones; //Num. cartones del jugador
    private final MonitorBingo monitor;
    private final int id; //ID jugador
    private Carton[] cartones; //Cartones del jugador    
    private int numerosBuscar;

    /**
     * Constructor del jugador
     *
     * @param jmonitor monitor del bingo creado en el main
     * @param jid identificador del jugador
     */
    public Jugador(MonitorBingo jmonitor, int jid) {
        this.monitor = jmonitor;
        this.id = jid;
        this.nCartones = ThreadLocalRandom.current().nextInt(1, Bingo3.MAX_CARTONES + 1);
        cartones = new Carton[nCartones];
        inicializarCartones(); //Inicializamos los cartones del jugador
        System.out.println(toString());
    }

    /**
     * Inicializamos los cartones del jugador
     */
    private void inicializarCartones() {
        for (int i = 0; i < cartones.length; i++) {
            cartones[i] = new Carton();
        }
    }

    @Override
    public void run() {
        while (!monitor.esBingo()) {
            try {
                numerosBuscar = monitor.llegirNumJugador();
                if (numerosBuscar != -1) { //Si es -1 significa que ya se ha cantado bingo y no hace falta que leea el ultimo numero que saca el presentador
                    System.out.println("   Jugador " + id + " lee el numero " + numerosBuscar);
                    Thread.sleep(ThreadLocalRandom.current().nextInt(Bingo3.MIN_SLEEP, Bingo3.MAX_SLEEP));
                }
                for (int i = 0; i < cartones.length; i++) { //Busca en todos sus cartones si tiene ese numero  
                    if (cartones[i].contieneNumero(numerosBuscar)) { //Si el carton contiene el numero
                        System.out.println("                                Jugador " + id + " ha encontrado el numero " + numerosBuscar + " en el carton " + (i + 1) + " (tiene " + cartones[i].getNumsRestants() + ")");
                        Thread.sleep(ThreadLocalRandom.current().nextInt(Bingo3.MIN_SLEEP, Bingo3.MAX_SLEEP));
                        if (cartones[i].esBingo() && !monitor.esBingo()) { //Miramos si es bingo y nadie mas lo ha cantado
                            monitor.cantarBingo(); //El jugador canta bingo
                            System.out.println("\n¡¡¡¡BINGOO!!!!\nEl jugador " + id + " ha cantado BINGO en el carton " + (i + 1));
                        }
                    }
                }
            } catch (InterruptedException ex) {
                System.err.println("ERROR: " + ex.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        String s = "Jugador " + id + "\nNumero cartones: " + nCartones + "\n";
        for (int i = 0; i < cartones.length; i++) {
            s += "  Carton " + (i + 1) + " : " + cartones[i].toString() + "\n";
        }
        return s;
    }

}
