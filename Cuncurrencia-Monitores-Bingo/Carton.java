/*
 * Clase Carton
 */
package bingo3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Bartomeu Mascaró Arbona & Eduardo Erro Rodríguez
 */
public class Carton {

    private ArrayList<Integer> numeros = new ArrayList<>();  //Numeros que contiene el carton 

    /**
     * Constructor del carton
     */
    public Carton() {
        rellenarCarton();
    }

    /**
     * Metodo que rellena el carton con NUM_CARTON numeros aleatorios no
     * repetidos entre 1 y MAX_NUM
     */
    private void rellenarCarton() {
        for (int i = 0; i < Bingo3.NUM_CARTON; i++) {
            int num = ThreadLocalRandom.current().nextInt(1, Bingo3.MAX_NUM + 1);
            for (int j = 0; j < i; j++) { //Comprobamos si coincide con algun num. anterior
                while (numeros.get(j) == num) { //Mientras coincida con alguno, generamos otro num.
                    num = ThreadLocalRandom.current().nextInt(1, Bingo3.MAX_NUM);
                }
            }
            numeros.add(num); //Añadimos num. no repetido al carton
        }
        Collections.sort(numeros); //Ordenamos numeros carton
    }

    /**
     * Metodo que busca si esta un numero en el carton, si esta lo elimina
     *
     * @param numero numero que buscamos en el carton
     * @return true si el numero estaba en el carton
     */
    public boolean contieneNumero(int numero) {
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) == numero) {
                numeros.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que comprueba si el carton no tiene mas numeros
     *
     * @return true si esta vacio, es bingo
     */
    public boolean esBingo() {
        return numeros.isEmpty();
    }
    
    public int getNumsRestants() {
        return (Bingo3.NUM_CARTON - numeros.size());
    }

    /**
     * Metodo que imprime los numeros restantes del carton
     *
     * @return un String con los numeros del carton
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < numeros.size(); i++) {
            s += numeros.get(i) + " ";
        }
        return s;
    }

}
