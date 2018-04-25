/*
 * Clase Presentador
 */
package bingo3;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Bartomeu Mascaró Arbona & Eduardo Erro Rodríguez
 */
public class Presentador implements Runnable {

    private ArrayList<Integer> numerosElegir = new ArrayList<>(); //Numeros que aun no han salido
    private final MonitorBingo monitor;

    /**
     * Constructor del presentador
     *
     * @param pmonitor monitor del bingo creado en el main
     */
    public Presentador(MonitorBingo pmonitor) {
        this.monitor = pmonitor;
        rellenarArrayList();

    }

    /**
     * Metodo que inicializa el arrayList con todos los numeros del bingo
     */
    private void rellenarArrayList() {
        for (int i = 1; i <= Bingo3.MAX_NUM; i++) {
            numerosElegir.add(i);
        }
    }

    @Override
    public void run() {
        //Mientras queden numeros y nadie cante bingo el presentador sigue sacando numeros
        for (int i = 0; i < Bingo3.MAX_NUM && !monitor.esBingo(); i++) {
            try {
                //Elige el siguiente numero de dentro del arrayList de numeros que no han salido
                int indiceNumero = ThreadLocalRandom.current().nextInt(0, numerosElegir.size());
                int numero = numerosElegir.get(indiceNumero);
                numerosElegir.remove(indiceNumero); //Eliminamos ese numero para no volerlo a sacar
                System.out.println("\nEl presentador saca el numero " + numero + " (Turno: " + (i + 1) + ")");
                Thread.sleep(ThreadLocalRandom.current().nextInt(Bingo3.MIN_SLEEP, Bingo3.MAX_SLEEP));
                monitor.elegirNumPresentador(numero);
            } catch (InterruptedException ex) {
                System.err.println("ERROR: " + ex.getMessage());
            }
        }
    }
}
