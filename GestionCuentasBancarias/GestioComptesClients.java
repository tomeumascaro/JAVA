/*
ALGORÍSMIA - ACTIVITAT 1: GESTIÓ DELS COMPTES D'UN CLIENT

Programa que sigui capaç de gestionar varis comptes per un mateix client.
El programa ha de poder fer:

1. Crear un nou compte per un client, amb un saldo inicial. Un client pot tenir
tants comptes com es vulgui.
2. Donat un compte, respongui a quín client pertany i el saldo del compte.
3. Donat un client, llisti tots els seus comptes amb el saldo de cada un.
4. Depositar una certa quantitat de doblers en un compte ja creat.
5. Donat un compte, retiri una certa quantitat de doblers del mateix. El compte
no pot quedar amb un saldo negatiu.

• Recorda que el programa ha de ser capaç de gestionar els
comptes de tants de clients com es vulgui.
• El programa ha de dur a terme la gestió dels comptes a través
d’un menú d’entrada que permeti cada una de les anteriors
opcions i també l’opció de donar de baixa un compte. A més,
ha de tenir una cinquena opció que permeti finalitzar
l’execució del programa. S'ha de fer servir una interfície gràfica.
 */
package gestiocomptesclients;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Integer.parseInt;
import javax.swing.*;

/*
 * @author Bartomeu Mascaró Arbona & Manuel Peña Llull
 */

public class GestioComptesClients extends JFrame {

    public static JTextArea jtaMenu;
    public static JTextField jtfOpcio;
    public static JButton jbtOK;
    public static JScrollPane scroll;
    public static JTextArea jtaResults;
    public static JScrollPane scroll2;
    public static JLabel label;

    public GestioComptesClients() {
        setSize(580, 450);
        setTitle("Gestionar els comptes dels clients");
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        jtaMenu = new JTextArea();
        jtfOpcio = new JTextField();
        jbtOK = new JButton();
        scroll = new JScrollPane(jtaMenu); //unim scroll amb menu
        jtaResults = new JTextArea();
        scroll2 = new JScrollPane(jtaResults); //unim scroll amb results
        label = new JLabel();

        getContentPane().setLayout(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent evt) {
                formWindowOpened(evt);
            }

            @Override
            public void windowClosing(WindowEvent evt) {
                exitForm(evt);
            }
        });

        //BARRA ESCRIURE OPCIÓ
        getContentPane().add(jtfOpcio);
        jtfOpcio.setBounds(57, 172, 35, 24);
        //x = 150 és enmig

        //BOTÓ
        jbtOK.setText("OK");
        getRootPane().setDefaultButton(jbtOK);
        getContentPane().add(jbtOK);
        jbtOK.setBounds(35, 197, 80, 24);
        //(x, y, width, height)

        jbtOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jbtOKActionPerformed(evt);
                jtfOpcio.selectAll();
            }
        });

        //PANELL MENU
        jtaMenu.setText(menu());
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(scroll);
        scroll.setBounds(0, 0, 150, 170);
        jtaMenu.setBackground(Color.cyan);
        jtaMenu.setEditable(false); //No es pot escriure al menú

        //PANELL RESULTS
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(scroll2);
        scroll2.setBounds(168, 0, 405, 420);
        jtaResults.setEditable(false); //No es pot escriure al panell de resultats

        //LABEL
        label.setText("<html>&nbsp;&nbsp;Gestió<br>Comptes<br>Bancaris</html>");
        label.setFont(new java.awt.Font("Arial", 3, 20));
        label.setForeground(Color.BLUE);
        label.setBounds(35, 270, 85, 75);
        getContentPane().add(label);
    }

    private void formWindowOpened(WindowEvent evt) {
        jtfOpcio.requestFocus();
    }

    //OPCIONS DEL MENÚ
    Operacions operacio = new Operacions();
    private void jbtOKActionPerformed(ActionEvent evt) {
        try {
            int x = 1; //variable on guardam l'opció triada
            x = parseInt(jtfOpcio.getText());
            switch(x) {
                case 1: //Crear nou compte
                    operacio.nouCompte();
                    jtaResults.setText(jtaResults.getText() + "\n_______________________________________________________");
                    break;

                case 2: //Veure compte
                    operacio.veureCompte();
                    jtaResults.setText(jtaResults.getText() + "\n_______________________________________________________");
                    break;

                case 3: //Veure client
                    operacio.veureClient();
                    jtaResults.setText(jtaResults.getText() + "\n_______________________________________________________");
                    break;

                case 4: //Depositar diners
                    operacio.depositar();
                    jtaResults.setText(jtaResults.getText() + "\n_______________________________________________________");
                    break;

                case 5: //Retirar diners
                    operacio.retirar();
                    jtaResults.setText(jtaResults.getText() + "\n_______________________________________________________");
                    break;

                case 6: //Eliminar compte
                    operacio.eliminarCompte();
                    jtaResults.setText(jtaResults.getText() + "\n_______________________________________________________");
                    break;

                case 7: //Sortir
                    System.exit(0);
                    break;

                default: //Si s'introdueix un nº incorrecte
                    JOptionPane.showMessageDialog(null, "ERROR: No existeix l'opció.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR: El nº de compte i el saldo només poden estar format per nombres.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR: " + e);
        }
    }

    //CONTINGUT MENÚ
    public String menu() {
        String menu = "             ◄ MENÚ ►" + "\n\n  Introdueix una opció:"
                + "\n  1. Crear nou compte." + "\n  2. Veure compte." + "\n  3. Veure client." + "\n  4. Depositar diners."
                + "\n  5. Retirar diners." + "\n  6. Eliminar compte." + "\n  7. Sortir.";
        return menu;
    }

    private void exitForm(WindowEvent evt) {
        System.exit(0);
    }


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("ERROR: No s'ha pogut crear el diseny desitjat: " + e);
        }
        new GestioComptesClients().setVisible(true);
    }
}
