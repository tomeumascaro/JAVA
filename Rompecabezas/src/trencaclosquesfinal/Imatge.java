/*
 * BARTOMEU MASCARÓ ARBONA & TELM FRANCESC SERRA MALAGRAVA
 * Classe Imatge
 */
package trencaclosquesfinal;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Tomeu & Telm
 */
public class Imatge {

    private String nomImatge;
    private BufferedImage img = null;
    private static final int ALT = 200; //Altura imatge
    private static final int AMPLE = 200; //Amplària imatge

    public Imatge() {

    }

    /**
     * Llegeix la imatge passada per paràmetre.
     * @param nomImatge 
     */
    public Imatge(String nomImatge) {
        this.nomImatge = nomImatge;
        try {
            img = ImageIO.read(new File(nomImatge));
        } catch (IOException ex) {
            System.err.println("ERROR: No s'ha pogut carregar la imatge.");
        }
    }

    /**
     * Mètode per pintar una imatge.
     *
     * @param g
     * @param x
     * @param y
     */
    public void paintImatge(Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, null, x, y);
    }

    public String getNomImatge() {
        return nomImatge;
    }
    
    public static int getAlt() {
        return ALT;
    }
    
    public static int getAmple() {
        return AMPLE;
    }

}
