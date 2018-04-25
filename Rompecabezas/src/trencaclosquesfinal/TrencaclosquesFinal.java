/*
 * BARTOMEU MASCARÓ ARBONA & TELM FRANCESC SERRA MALAGRAVA
 *
 * PRÀCTICA FINAL - PROGRAMACIÓ II
 * ENGINYERIA INFORMÀTICA - UIB 2016/2017
 * 
 * JOC DEL TRENCACLOSQUES
 */
package trencaclosquesfinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 *
 * @author Tomeu & Telm
 */
public class TrencaclosquesFinal extends JFrame implements ActionListener, KeyListener, MouseListener {

    Puzzle puz;
    private JMenuBar jmBar;
    private JMenu jmOpcions;
    private JMenuItem jmiTriar;
    private JMenuItem jmiInicialitzar;
    private JMenuItem jmiReiniciar;
    private JMenuItem jmiPista;
    private JMenuItem jmiSortir;
    private static final Object[] OPCIONS = {"SIMPSON", "RATOLI"}; //(0=Simpson / 1=Ratoli)
    private static String tipusPuzzle; //Indica amb quin puzzle treballam (Simpson o Ratoli)
    private int numPistes; //Nº de pistes que ha mirat el jugador

    public TrencaclosquesFinal() {
        tipusPuzzle = (String) OPCIONS[0]; //S'inicia el programa amb el puzzle dels Simpson
        puz = new Puzzle(tipusPuzzle);
        this.getContentPane().add(puz);
        setTitle("TRENCACLOSQUES");
        setSize(puz.getPreferredSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(this);
        addMouseListener(this);
        initComponents();
        numPistes = 0;
    }

    /**
     * Components gràfics de la finestra
     */
    private void initComponents() {
        jmBar = new JMenuBar();
        jmOpcions = new JMenu("Joc ");
        jmiTriar = new JMenuItem("Nou trencaclosques");
        jmiInicialitzar = new JMenuItem("Inicialitzar");
        jmiReiniciar = new JMenuItem("Escapçar");
        jmiPista = new JMenuItem("Pista");
        jmiSortir = new JMenuItem("Sortir");

        setJMenuBar(jmBar);
        jmBar.add(jmOpcions);
        jmOpcions.add(jmiTriar);
        jmOpcions.add(jmiInicialitzar);
        jmOpcions.add(jmiReiniciar);
        jmOpcions.add(jmiPista);
        jmOpcions.add(jmiSortir);

        jmiTriar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jmiInicialitzar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jmiReiniciar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jmiPista.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jmiSortir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));

        jmiTriar.setToolTipText("Obrir un nou trencaclosques. (CTRL+N)");
        jmiInicialitzar.setToolTipText("Soluciona el puzzle. (CTRL+I)");
        jmiReiniciar.setToolTipText("Reinicia el puzzle. (CTRL+E)");
        jmiPista.setToolTipText("Mostra una imatge de la solució del puzzle. (CTRL+P)");
        jmiSortir.setToolTipText("Surt del programa. (ALT+F4)");

        jmiTriar.addActionListener(this);
        jmiInicialitzar.addActionListener(this);
        jmiReiniciar.addActionListener(this);
        jmiPista.addActionListener(this);
        jmiSortir.addActionListener(this);
    }

    /**
     * Control d'esdeveniments de teclat. Les caselles es poden moure amb les
     * lletres W,A,S,D i les fletxes.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W: //Nord
            case KeyEvent.VK_UP:
                puz.moureCasella('W');
                break;
            case KeyEvent.VK_S: //Sud
            case KeyEvent.VK_DOWN:
                puz.moureCasella('S');
                break;
            case KeyEvent.VK_A: //Esquerra
            case KeyEvent.VK_LEFT:
                puz.moureCasella('A');
                break;
            case KeyEvent.VK_D: //Dreta
            case KeyEvent.VK_RIGHT:
                puz.moureCasella('D');
                break;
            default:
                break;
        }
        //System.out.println("Tecla clicada: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    /**
     * Control d'esdeveniments de ratolí. Les caselles també es poden moure
     * clicant sobre elles. El mètode obté la casella sobre la qual s'ha clicat,
     * i si aquesta no és la casella buida va comprovant les del seu voltant, i
     * si alguna d'elles és la buida, crida al mètode que realitza el moviment i
     * intercanvia les dues caselles.
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getY() / (Imatge.getAlt() + 30); //Fila de la casella clicada
        int y = e.getX() / (Imatge.getAmple()); //Columna de la casella clicada
        if (x < Puzzle.getMida() && y < Puzzle.getMida() && x > -1 && y > -1 && !puz.getCasella(x, y).esCasellaBuida()) {
            if (x + 1 < 3 && puz.getCasella(x + 1, y).esCasellaBuida()) {
                puz.moureCasella('S'); //Sud
            } else if (x - 1 > -1 && puz.getCasella(x - 1, y).esCasellaBuida()) {
                puz.moureCasella('W'); //Nord
            } else if (y + 1 < 3 && puz.getCasella(x, y + 1).esCasellaBuida()) {
                puz.moureCasella('D'); //Dreta
            } else if (y - 1 > -1 && puz.getCasella(x, y - 1).esCasellaBuida()) {
                puz.moureCasella('A'); //Esquerra
            }
        }
    }

    /**
     * Opcions del menú: 1.Triar un nou trencaclosques. / 2.Inicialitzar /
     * 3.Reiniciar (escapçar) / 4.Pista / 5.Sortir
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jmiTriar)) { //Triar nou trencaclosques
            tipusPuzzle = (String) JOptionPane.showInputDialog(rootPane,
                    "Quin trencaclosques vols completar?", "TRENCACLOSQUES", JOptionPane.PLAIN_MESSAGE,
                    new ImageIcon("IMATGES/peca.png"), OPCIONS, OPCIONS[0]);
            if (tipusPuzzle != null) { //Si no s'ha clicat el botó de cancelar
                puz.setPuzzle(tipusPuzzle); //Indicam quin serà el puzzle que utilitzarem
                puz.reiniciarPuzzle(); //Reiniciam el joc amb el puzzle que s'ha elegit al JOptionPane
                numPistes = 0; //Quan es canvia de puzzle es pot tornar mirar la pista 3 cops
            }

        } else if (e.getSource().equals(jmiInicialitzar)) { //Solució
            puz.solucionarPuzzle();

        } else if (e.getSource().equals(jmiReiniciar)) { //Escapçar
            puz.reiniciarPuzzle();

        } else if (e.getSource().equals(jmiPista)) { //Pista
            if (numPistes < 3) { //Si s'ha vist la pista < 3 cops, es mostra la imatge del trencaclosques
                mostrarImatge(tipusPuzzle + ".png");
                numPistes++;
            } else { //Si ja s'ha vist la pista 3 vegades, no es podrà tornar a veure la imatge
                JOptionPane.showMessageDialog(rootPane, "Ja has vist la pista 3 vegades,\nno pots tornar-la mirar.",
                        "PISTA", JOptionPane.OK_OPTION);
            }

        } else if (e.getSource().equals(jmiSortir)) { //Sortir
            System.exit(0);
        }
    }

    /**
     * Mètode que mostra una imatge per pantalla i desapareix automàticament
     * després d'uns segons.
     *
     * @param nomImatge
     */
    private void mostrarImatge(String nomImatge) {
        JOptionPane pane = new JOptionPane(null, JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION, new ImageIcon("IMATGES/" + nomImatge), new Object[]{}, null);
        JDialog dialog = pane.createDialog(null, "PISTA");
        dialog.setModal(false);
        dialog.setVisible(true);
        new Timer(1100, new ActionListener() { //El diàleg es tanca automàticament després d'un temps determinat
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        }).start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        TrencaclosquesFinal joc = new TrencaclosquesFinal();
        joc.setVisible(true);
    }

}
