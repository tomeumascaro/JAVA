/*
 * Classe Casella
 */
package generadorpictogrames;

import java.awt.geom.Rectangle2D;

/**
 *
 * @author Bartomeu Mascaró Arbona
 */
public class Casella {

    public static final int ALT = 10;
    public static final int AMPLE = 10;
    private int x;
    private int y;
    private Rectangle2D.Float quadrat;
    private boolean perPintar;

    public Casella() {

    }

    public Casella(int x, int y, Rectangle2D.Float quadrat, boolean perPintar) {
        this.x = x;
        this.y = y;
        this.quadrat = quadrat;
        this.perPintar = perPintar;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Rectangle2D.Float getQuadrat() {
        return quadrat;
    }

    public boolean isPintada() {
        return perPintar;
    }

    public void setPerPintar(boolean perPintar) {
        this.perPintar = perPintar;
    }

}
