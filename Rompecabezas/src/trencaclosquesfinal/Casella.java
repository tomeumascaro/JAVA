/*
 * BARTOMEU MASCARÓ ARBONA & TELM FRANCESC SERRA MALAGRAVA
 * Classe Casella
 */
package trencaclosquesfinal;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Tomeu & Telm
 */
public class Casella {

    Imatge imatge;
    private String nomImatge; //Identificador de cada casella
    private boolean buida;
    private int x;
    private int y;
    private Rectangle2D.Float quadrat;

    public Casella() {

    }

    public Casella(String nomImatge) {
        this.nomImatge = nomImatge;
    }

    /**
     * Una casella conté una imatge i un quadrat. Es troba en unes cordenades
     * (x, y) i pot ser buida o no. Només hi haurà una casella buida.
     *
     * @param nomImatge
     * @param quadrat
     * @param x
     * @param y
     * @param buida
     */
    public Casella(String nomImatge, Rectangle2D.Float quadrat, int x, int y, boolean buida) {
        this.nomImatge = nomImatge;
        this.quadrat = quadrat;
        this.x = x;
        this.y = y;
        this.buida = buida;
    }

    /**
     * Mètode per pintar una casella. Es pinta el rectangle que delimitarà la
     * casella i es crida al mètode de la classe IMATGE que s'encarrega de
     * pintar una imatge dins la casella que es tracta.
     *
     * @param g
     * @param nomImatge
     * @param x
     * @param y
     * @param quadrat
     */
    public void paintCasella(Graphics g, String nomImatge, int x, int y, Rectangle2D.Float quadrat) {
        Graphics2D g2d = (Graphics2D) g;
        imatge = new Imatge(nomImatge);
        imatge.paintImatge(g, x, y);
        g2d.draw(quadrat);
    }

    /**
     * Posa la casella en estat "buida"
     */
    public void setBuida() {
        this.buida = true;
    }

    /**
     * Posa la casella en estat "ocupada"
     */
    public void setNoBuida() {
        buida = false;
    }

    /**
     * Retorna true si la casella està buida. Retorna false si la casella està
     * ocupada.
     *
     * @return
     */
    public boolean esCasellaBuida() {
        return buida;
    }

    public String getNomImatge() {
        return nomImatge;
    }

    public void setNomImatge(String nomImatge) {
        this.nomImatge = nomImatge;
    }

    public Rectangle2D.Float getQuadrat() {
        return quadrat;
    }

    public void setQuadrat(Rectangle2D.Float quadrat) {
        this.quadrat = quadrat;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
