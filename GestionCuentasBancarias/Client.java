/*
Classe que conté els ArrayList per guardar i gestionar totes les dades.
-ArrayList de clients
-ArrayList de comptes
-ArrayList de saldos
 */

package gestiocomptesclients;

import java.util.ArrayList;
import javax.swing.JFrame;

/*
 * @author Bartomeu Mascaró Arbona & Manuel Peña Llull
 */
public class Client extends JFrame {

    ArrayList<String> nomclient;
    ArrayList<Integer> nCompte;
    ArrayList<Double> Saldo;
      
    public Client() {
        nomclient = new ArrayList<>();
        nCompte = new ArrayList<>();
        Saldo = new ArrayList<>();
    }

//    public ArrayList<String> getNomclient() {
//        return nomclient;
//    }
//
//    public void setNomclient(ArrayList<String> nomclient) {
//        this.nomclient = nomclient;
//    }
//
//    public ArrayList<Integer> getnCompte() {
//        return nCompte;
//    }
//
//    public void setnCompte(ArrayList<Integer> nCompte) {
//        this.nCompte = nCompte;
//    }
//
//    public ArrayList<Double> getSaldo() {
//        return Saldo;
//    }
//
//    public void setSaldo(ArrayList<Double> Saldo) {
//        this.Saldo = Saldo;
//    }

}
