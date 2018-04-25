/*
 * Classe Tauler
 */
package generadorpictogrames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Bartomeu Mascaró Arbona
 */
public class Tauler extends JPanel {

    public static final int MIDA = 50; //Nº caselles per fila i columna
    public static final int MIDA_C_PANELL = 10; //Caselles 10x10 al panell
    private static final int MIDA_C_IMATGE = 2; //Caselles 2x2 a la imatge guardada
    public Casella[][] caselles = new Casella[MIDA][MIDA];
    BufferedImage bi = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB); //Imatge 100x100

    public Tauler() {
        crearCaselles();
    }

    /**
     * Mètode que crea un array 2D de caselles.
     */
    private void crearCaselles() {
        int y = 0;
        for (int i = 0; i < MIDA; i++) {
            int x = 0;
            for (int j = 0; j < MIDA; j++) {
                Rectangle2D.Float quadrat = new Rectangle2D.Float(x, y, MIDA_C_PANELL, MIDA_C_PANELL);
                caselles[i][j] = new Casella(x, y, quadrat, false);
                x += Casella.AMPLE;
            }
            y += Casella.ALT;
        }
    }

    /**
     * Mètode per despintar les caselles pintades.
     */
    public void borrarPintades() {
        for (int i = 0; i < MIDA; i++) {
            for (int j = 0; j < MIDA; j++) {
                caselles[i][j].setPerPintar(false); //False = la casella no s'ha de pintar
            }
        }
        repaint();
    }

    /**
     * Mètode per pintar les caselles del seu color pertinent. També pinta la
     * que serà la imatge que es guardarà. En el nostre cas, les caselles del
     * panell són de 10x10 i les caselles de la imatge són 2x2.
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D panell = (Graphics2D) g; //Per pintar al panell
        Graphics2D imatge = (Graphics2D) g; //Per pintar a la imatge
        imatge = bi.createGraphics();

        for (int i = 0; i < MIDA; i++) {
            for (int j = 0; j < MIDA; j++) {
                panell.draw(caselles[i][j].getQuadrat()); //Pintam la quadrícula
                imatge.setColor(Color.WHITE);
                imatge.fillRect(caselles[i][j].getX() / (MIDA_C_PANELL / MIDA_C_IMATGE),
                        caselles[i][j].getY() / (MIDA_C_PANELL / MIDA_C_IMATGE), MIDA_C_IMATGE, MIDA_C_IMATGE);

                if (caselles[i][j].isPintada()) { //Si s'ha de pintar la casella de negre
                    panell.fillRect(caselles[i][j].getX(), caselles[i][j].getY(), MIDA_C_PANELL, MIDA_C_PANELL);
                    imatge.setColor(Color.BLACK);
                    imatge.fillRect(caselles[i][j].getX() / (MIDA_C_PANELL / MIDA_C_IMATGE),
                            caselles[i][j].getY() / (MIDA_C_PANELL / MIDA_C_IMATGE), MIDA_C_IMATGE, MIDA_C_IMATGE);
                }
            }
        }
    }

    /**
     * Mètode per guardar el pictograma en una imatge, elegint el nom d'aquesta
     * i la carpeta de destí.
     */
    public void guardar() {
        String path = null;
        JFileChooser jfc = new JFileChooser();
        try {
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                path = jfc.getSelectedFile().getAbsolutePath();
            }
            ImageIO.write(bi, "jpg", new File(path + ".jpg")); //Guardam la imatge a la carpeta elegida
            
            JOptionPane pane = new JOptionPane("El pictograma s'ha guardat correctament.",
                    JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
            JDialog dialog = pane.createDialog(null, "GUARDAR IMATGE");
            dialog.setModal(false);
            dialog.setVisible(true);
            new Timer(1700, new ActionListener() { //El diàleg es tanca automàticament després d'un temps determinat
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.setVisible(false);
                }
            }).start();
        } catch (IOException ex) {
            System.err.println("ERROR: La imatge no s'ha pogut guardar correctament");
        }
    }
}
