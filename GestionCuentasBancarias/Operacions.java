/*
Mètodes de cada opció del menú.
 */

package gestiocomptesclients;

import static gestiocomptesclients.GestioComptesClients.jtaResults;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * @author Bartomeu Mascaró Arbona & Manuel Peña Llull
 */
public class Operacions extends JFrame{

    Client cl = new Client();

//OPCIÓ 1: Nou compte.
    public void nouCompte() {

        int numCompte = 0;//Variable auxiliar de numCompte que posteriorment afegirem a l'ArrayList nCompte
        double saldo = 0;//Variable que afegirem a l'ArrayList Saldo
        String nomClient = "";//Variable que afegirem a l'ArrayList nClient

        //Nº COMPTE
        numCompte = Integer.parseInt(JOptionPane.showInputDialog(null, "Nº compte:")); //Demanam el nº de compte
        //cl.nCompte.add(Integer.parseInt(numCompte)); //L'afegim a l'ArrayList de comptes
        boolean trobat = false; //Per determinar quan trobam el compte dins l'ArrayList
        for (int i = 0; i < cl.nCompte.size(); i++) { //Feim el recorregut dins l'ArrayList de comptes
            if (cl.nCompte.get(i) == numCompte) { //Si el nombre introduït coincideix amb algun de dins l'ArrayList
                trobat = true; //Hem trobat el compte
                break; //I aturam el recorregut
            }
        }
        if (trobat) { //Si hem trobat el compte dins l'ArrayList, no en podem crear un altre amb el mateix nº
            JOptionPane.showMessageDialog(null, "ERROR: Aquest compte ja existeix.", "Error", JOptionPane.ERROR_MESSAGE); //Indicam que ja existeix
        } else { //Si no hem trobat el compte dins l'ArrayList
            //Podem continuar rellenant les dades del compte
            //NOM CLIENT
            nomClient = JOptionPane.showInputDialog(null, "Nom client:"); //Demanam el nom del client
            //SALDO
            saldo = Double.parseDouble(JOptionPane.showInputDialog(null, "Saldo inicial (€):")); //Demanam el saldo inicial
            //Imprimim els resultats (dades introduïdes)
            JOptionPane.showMessageDialog(null, "Operació realitzada correctament.");
            jtaResults.setText(jtaResults.getText() + "\nNº compte: " + numCompte);
            jtaResults.setText(jtaResults.getText() + "\nNom client: " + nomClient);
            jtaResults.setText(jtaResults.getText() + "\nSaldo inicial: " + saldo + "€");
            jtaResults.setText(jtaResults.getText() + "\n\nNou compte creat correctament.");
        }
        //Afegim les dades als ArrayLists
        cl.nCompte.add(numCompte); //Afegim el compte a l'ArrayList de comptes
        cl.nomclient.add(nomClient); //Afegim el client a l'ArrayList de clients
        cl.Saldo.add((saldo)); //Afegim el saldo a l'ArrayList de saldos
    }


    //OPCIÓ 2: Veure un compte.
    public void veureCompte() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Introdueix el nº de compte que es vulgui veure:"));
        boolean trobat = false; //Per determinar quan trobem el compte dins l'ArrayList
        int i;
        
        for (i = 0; i < cl.nCompte.size(); i++) { //Feim el recorregut dins l'ArrayList de comptes
            if (cl.nCompte.get(i) == numero) { //Si el nº de compte introduït coincideix amb algun de l'ArrayList...
                trobat = true; //Hem trobat el compte
                break; //I aturam el recorregut
            }
        }
        if (trobat) { //Si hem trobat el nº de compte, mostram el seu client i saldo corresponent (els obtenim dels seus ArrayList)
            jtaResults.setText(jtaResults.getText() + "\n\nEl compte nº " + numero + " correspon a " + cl.nomclient.get(i) +
                    " i té un saldo de " + cl.Saldo.get(i) + "€");
        } else { //Si no hem trobat el nº de compte, notificam que no existeix
            JOptionPane.showMessageDialog(null, "ERROR: No existeix aquest nº de compte.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //OPCIÓ 3: Veure els comptes d'un client.
    public void veureClient() {
        String nom = JOptionPane.showInputDialog(null, "Introdueix el nom del client que es vulgui veure:");
        boolean trobat = false;
        int i;
        jtaResults.setText(jtaResults.getText() + "\n\nEl client  " + nom + "  té els comptes:");
        for (i = 0; i < cl.nomclient.size(); i++) { //Recorrem l'array de clients
            if (cl.nomclient.get(i).equals(nom)) { //Si el nom introduït coincideix amb un dels clients, mostram els seus comptes i saldos
                jtaResults.setText(jtaResults.getText() + "\n\nNº compte: " + cl.nCompte.get(i) + " amb saldo " + cl.Saldo.get(i) + "€");
                trobat = true; //Hem trobat el client
            }
        }
        if (!trobat) { //Si no hem trobat el client, notificam que no existeix
            jtaResults.setText(jtaResults.getText() + "\n\nERROR: No existeix aquest client.");
            JOptionPane.showMessageDialog(null, "ERROR: No existeix aquest client.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //OPCIÓ 4: Depositar diners a un compte.
    public void depositar() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Nº compte:"));
        boolean trobat = false;
        int i;
        for (i = 0; i < cl.nCompte.size(); i++) { //Recorrem l'ArrayList de comptes
            if (cl.nCompte.get(i) == numero) { //Si el nº de compte cercat coincideix amb un de l'ArrayList
                trobat = true; //Hem trobat el compte
                break; //I aturam el recorregut
            }
        }
        if (trobat) { //Si s'ha trobat el compte
            Double deposit = Double.parseDouble(JOptionPane.showInputDialog(null, "Quantitat a depositar (€):"));
            Double saldo = cl.Saldo.get(i); //Obtenim el saldo inicial del compte
            cl.Saldo.set(i, saldo+deposit); //Modificam el saldo inicial, afegint la quantitat que hem indicat
            Double nouSaldo = cl.Saldo.get(i); //Obtenim el nou saldo del compte
            JOptionPane.showMessageDialog(null, "Operació realitzada correctament.");
            jtaResults.setText(jtaResults.getText() + "\n\nS'han depositat " + deposit + "€ al compte nº " + numero +
                    " de "+ cl.nomclient.get(i) + ". \nSaldo actual: " + nouSaldo + "€.");

        } else { //Si no s'ha trobat el compte, notificam que no existeix
            JOptionPane.showMessageDialog(null, "ERROR: No existeix aquest compte.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //OPCIÓ 5: Retirar diners d'un compte.
    public void retirar() {
        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Nº compte:"));
        boolean trobat = false;
        int i;
        for (i = 0; i < cl.nCompte.size(); i++) { //Recorrem l'ArrayList de comptes
            if (cl.nCompte.get(i) == numero) { //Si el nº de compte cercat coincideix amb un de l'ArrayList
                trobat = true; //Hem trobat el compte
                break; //I aturam el recorregut
            }
        }
        if (trobat) { //Si s'ha trobat el compte
            Double retiro = Double.parseDouble(JOptionPane.showInputDialog(null, "Quantitat a retirar (€):"));
            Double saldo = cl.Saldo.get(i); //Obtenim el saldo inicial del compte
            if (retiro <= saldo) { //Si es vol retirar una quantitat igual o menor de la que es té
                cl.Saldo.set(i, saldo-retiro); //Modificam el saldo inicial, retirant la quantitat que hem indicat
                Double nouSaldo = cl.Saldo.get(i); //Obtenim el nou saldo del compte
                JOptionPane.showMessageDialog(null, "Operació realitzada correctament.");
                jtaResults.setText(jtaResults.getText() + "\n\nS'han retirat " + retiro + "€ del compte nº " + numero +
                            " de " + cl.nomclient.get(i) + ". \nSaldo actual: " + nouSaldo + "€.");
            } else { //Si es vol retirar una quantitat major de la que es té, no podem fer-ho
                jtaResults.setText(jtaResults.getText() + "\n\nNo es poden retirar més diners dels que hi ha al compte."
                        + "\nOPERACIÓ DENEGADA");
                JOptionPane.showMessageDialog(null, "ERROR: Es volen retirar més diners dels que hi ha al compte."
                        + "\n                            OPERACIÓ DENEGADA", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else { //Si no s'ha trobat el compte, notificam que no existeix
            JOptionPane.showMessageDialog(null, "ERROR: No existeix aquest compte.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //OPCIÓ 6: Eliminar un compte.
    public void eliminarCompte() {
        int eliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Nº compte que es vol eliminar:"));
        boolean trobat = false;
        int i;
        for (i = 0; i < cl.nCompte.size(); i++) { //Recorrem l'ArrayList de comptes
            if (cl.nCompte.get(i) == eliminar) { //Si el nº de compte cercat coincideix amb un de l'ArrayList
                trobat = true; //Hem trobat el compte
                break; //I aturam el recorregut
            }
        }
        if (trobat) { //Si s'ha trobat el compte
            int centinella = 000000; //Definim el compte nº 0, el qual no és mai utilitzat, com a sentinella
            String centinellaNom = "zzzzzz"; //Definim el nom "zzzzzz", el qual no és mai utilitzat, com a sentinella
            cl.nCompte.set(i, centinella); //Canviam el nº del compte pel sentinella (0)
            if (cl.nCompte.get(i) == centinella) { //Si el nº de compte és el sentinella (0), mostram que s'ha eliminat
                JOptionPane.showMessageDialog(null, "Operació realitzada correctament.");
                jtaResults.setText(jtaResults.getText() + "\n\nS'ha eliminat el compte nº " + eliminar + " de " +
                                        cl.nomclient.get(i) + " que tenia un saldo de " + cl.Saldo.get(i) + "€.");
                cl.nomclient.set(i, centinellaNom); //Després també canviam el nom del client (zzzzzz) perquè si cercam
                                                   // el nom del client no surti que té el compte nº sentinella (eliminat)
            }
        } else { //Si no s'ha trobat el compte, notificam que no existeix
            JOptionPane.showMessageDialog(null, "ERROR: No existeix aquest compte.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
