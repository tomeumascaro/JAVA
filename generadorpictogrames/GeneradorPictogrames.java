/*
 * TALLER 2 - GENERADOR DE PICTOGRAMES
 * Programació II - Enginyeria Informàtica
 * UIB 2016-2017
 */
package generadorpictogrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Bartomeu Mascaró Arbona
 */
public class GeneradorPictogrames extends JFrame implements ActionListener, MouseListener {

    Tauler tauler;
    private JMenuBar jmBar;
    private JMenu jmOpcions;
    private JMenuItem jmItemImatge;
    private JMenuItem jmItemBorrar;
    private JMenuItem jmItemSortir;

    public GeneradorPictogrames() {
        setTitle("GENERADOR DE PICTOGRAMES");
        setSize(Tauler.MIDA * Tauler.MIDA_C_PANELL + 7, Tauler.MIDA * Tauler.MIDA_C_PANELL + 53);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addMouseListener(this);
        initComponents();
        tauler = new Tauler();
        this.getContentPane().add(tauler);
    }

    private void initComponents() {
        jmBar = new JMenuBar();
        jmOpcions = new JMenu("Joc ");
        jmItemImatge = new JMenuItem("Generar imatge");
        jmItemBorrar = new JMenuItem("Borrar");
        jmItemSortir = new JMenuItem("Sortir");

        setJMenuBar(jmBar);
        jmBar.add(jmOpcions);
        jmOpcions.add(jmItemImatge);
        jmOpcions.add(jmItemBorrar);
        jmOpcions.add(jmItemSortir);

        jmItemImatge.setToolTipText("Guarda la imatge del pictograma.");
        jmItemBorrar.setToolTipText("Borra el pictograma.");
        jmItemSortir.setToolTipText("Surt del programa.");

        jmItemImatge.addActionListener(this);
        jmItemBorrar.addActionListener(this);
        jmItemSortir.addActionListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX() / Casella.ALT;
        int y = (e.getY() / Casella.AMPLE) - 5;
        if (x < Tauler.MIDA && y < Tauler.MIDA && x > -1 && y > -1) {
            //System.out.println("CASELLA " + x + " , " + y);
            if (!tauler.caselles[y][x].isPintada()) { //Si la casella no està pintada
                tauler.caselles[y][x].setPerPintar(true);
            } else {                                 //Si la casella està pintada
                tauler.caselles[y][x].setPerPintar(false);
            }
            repaint();
        }
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jmItemImatge)) {
            tauler.guardar();
        } else if (e.getSource().equals(jmItemBorrar)) {
            tauler.borrarPintades();
        } else if (e.getSource().equals(jmItemSortir)) {
            System.exit(0);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorPictogrames gp = new GeneradorPictogrames();
        gp.setVisible(true);
    }
}
