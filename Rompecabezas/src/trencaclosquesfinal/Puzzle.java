/*
 * BARTOMEU MASCARÓ ARBONA & TELM FRANCESC SERRA MALAGRAVA
 * Classe Puzzle
 */
package trencaclosquesfinal;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Tomeu & Telm
 */
public class Puzzle extends JPanel {

    Casella casella;
    private static final int MIDA = 3; //Nombre de caselles que hi ha a cada costat del panell (panell 3x3)
    private static final int DAMPLE = (MIDA * Imatge.getAmple()) + 7; //Ample del puzzle
    private static final int DALT = (MIDA * Imatge.getAlt()) + 53; //Alt del puzzle
    private String puzzle; //Trencaclosques que es vol resoldre (Simpson o Ratolí)
    private int numMoviments; //Nº moviments fets per resoldre el trencaclosques
    private boolean inicialitzat = false; //Si s'inicialitza el puzzle i es resol, no es mostra el missatge final
    private Casella[][] caselles; //Array 2D de caselles que anirem modificant quan es realitzin els moviments
    private Casella[][] solucio; //Array 2D amb els noms de les imatges de la combinació de caselles correcta
    private Imatge[] img; //Array d'imatges que es desordenarà i servirà per afegir les imatges a les caselles
    private int iBuida; //Fila casella buida actual
    private int jBuida; //Columna casella buida actual

    public Puzzle() {

    }

    /**
     * Panell amb el puzzle passat per paràmetre, de dimensió MIDA*MIDA i amb
     * les caselles ja pintades i desordenades.
     *
     * @param puzzle
     */
    public Puzzle(String puzzle) {
        this.puzzle = puzzle;
        caselles = new Casella[MIDA][MIDA];
        solucio = new Casella[MIDA][MIDA];
        img = new Imatge[MIDA * MIDA];
        inicialitzar(); //Guardam imatges dins un array
        desordenar(); //Desordenam les imatges de l'array
        crearCaselles(); //Cream les caselles
    }

    /**
     * Mètode que crea un array d'objectes Imatge. Inicialitza l'array.
     */
    private void inicialitzar() {
        for (int i = 0; i < MIDA * MIDA; i++) {
            String nomIm = "PUZZLES/" + puzzle + i + ".jpg";
            img[i] = new Imatge(nomIm);
        }
    }

    /**
     * Mètode que crea les caselles del puzzle i les guarda dins l'array
     * bidimensional de caselles. També crea un array bidimensional amb la
     * combinació de caselles correctes.
     */
    private void crearCaselles() {
        numMoviments = 0;
        int numImatge = 0;

        int y = 0;
        for (int i = 0; i < MIDA; i++) {
            int x = 0;
            for (int j = 0; j < MIDA; j++) {
                String nomIm = "PUZZLES/" + puzzle + numImatge + ".jpg";
                Rectangle2D.Float quadrat = new Rectangle2D.Float(x, y, Imatge.getAmple(), Imatge.getAlt());

                caselles[i][j] = new Casella(img[numImatge].getNomImatge(), quadrat, x, y, false); //Array 2D de caselles desordenades
                solucio[i][j] = new Casella(nomIm); //Array 2D de caselles ordenades
                if (caselles[i][j].getNomImatge().equals("PUZZLES/" + puzzle + "0.jpg")) { //Detectam casella buida (acaba amb 0)
                    caselles[i][j].setBuida();
                    iBuida = i; //Guardam fila de la casella buida
                    jBuida = j; //Guardam columna de la casella buida
                }
                numImatge++;
                x += Imatge.getAmple();
            }
            y += Imatge.getAlt();
        }
    }

    /**
     * Mètode que pinta les caselles del puzzle, amb les seves corresponents
     * imatges, al panell. Per cada una de les caselles es crida al mètode de la
     * classe CASELLA que pinta una casella.
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        casella = new Casella();
        for (int i = 0; i < MIDA; i++) {
            for (int j = 0; j < MIDA; j++) {
                casella.paintCasella(g, caselles[i][j].getNomImatge(), caselles[i][j].getX(),
                        caselles[i][j].getY(), caselles[i][j].getQuadrat());
            }
        }
    }

    /**
     * Mètode que controla els moviments de les caselles en funció de la tecla
     * clicada. Intercanvia els paràmetres de dues caselles veïnes i repinta
     * únicament aquestes dues caselles. Per fer l'intercanvi utilitza una
     * casella auxiliar buida. 1.Agafam casella buida i la copiam a una casella
     * auxiliar. / 2.Copiam contingut casella inicialment no buida a la casella
     * inicialment buida. / 3.Copiam contingut casella buida auxiliar a la
     * casella inicialment no buida.
     *
     * @param tecla
     */
    public void moureCasella(char tecla) {
        Casella casellaAux;//Casella auxiliar buida
        String nomBuida; //Imatge de la casella buida
        int auxX, auxY; //Posició X,Y de la casella buida

        int x = iBuida; //Fila de la casella buida actual
        int y = jBuida; //Columna de la casella buida actual
        casellaAux = caselles[x][y];
        nomBuida = casellaAux.getNomImatge();
        auxX = casellaAux.getX();
        auxY = casellaAux.getY();

        switch (tecla) {
            case 'W': //Nord
                if (x != 2) {
                    caselles[x][y].setX(caselles[x + 1][y].getX());
                    caselles[x][y].setY(caselles[x + 1][y].getY());
                    caselles[x + 1][y].setX(auxX);
                    caselles[x + 1][y].setY(auxY);
                    caselles[x][y] = caselles[x + 1][y];
                    caselles[x + 1][y] = casellaAux;
                    caselles[x][y].setQuadrat(new Rectangle2D.Float(caselles[x][y].getX(), caselles[x][y].getY(), 200, 200));
                    caselles[x + 1][y].setQuadrat(new Rectangle2D.Float(caselles[x + 1][y].getX(), caselles[x + 1][y].getY(), 200, 200));
                    caselles[x + 1][y].setNomImatge(nomBuida);
                    casella.paintCasella(this.getGraphics(), caselles[x + 1][y].getNomImatge(), caselles[x + 1][y].getX(),
                            caselles[x + 1][y].getY(), caselles[x + 1][y].getQuadrat()); //Repintam únicament la casella buida que es mou
                    iBuida = x + 1; //Actualitzam fila de la casella buida actual
                }
                break;

            case 'S': //Sud
                if (x != 0) {
                    caselles[x][y].setX(caselles[x - 1][y].getX());
                    caselles[x][y].setY(caselles[x - 1][y].getY());
                    caselles[x - 1][y].setX(auxX);
                    caselles[x - 1][y].setY(auxY);
                    caselles[x][y] = caselles[x - 1][y];
                    caselles[x - 1][y] = casellaAux;
                    caselles[x][y].setQuadrat(new Rectangle2D.Float(caselles[x][y].getX(), caselles[x][y].getY(), 200, 200));
                    caselles[x - 1][y].setQuadrat(new Rectangle2D.Float(caselles[x - 1][y].getX(), caselles[x - 1][y].getY(), 200, 200));
                    caselles[x - 1][y].setNomImatge(nomBuida);
                    casella.paintCasella(this.getGraphics(), caselles[x - 1][y].getNomImatge(), caselles[x - 1][y].getX(),
                            caselles[x - 1][y].getY(), caselles[x - 1][y].getQuadrat());
                    iBuida = x - 1;  //Actualitzam fila de la casella buida actual
                }
                break;

            case 'A': //Esquerra
                if (y != 2) {
                    caselles[x][y].setX(caselles[x][y + 1].getX());
                    caselles[x][y].setY(caselles[x][y + 1].getY());
                    caselles[x][y + 1].setX(auxX);
                    caselles[x][y + 1].setY(auxY);
                    caselles[x][y] = caselles[x][y + 1];
                    caselles[x][y + 1] = casellaAux;
                    caselles[x][y].setQuadrat(new Rectangle2D.Float(caselles[x][y].getX(), caselles[x][y].getY(), 200, 200));
                    caselles[x][y + 1].setQuadrat(new Rectangle2D.Float(caselles[x][y + 1].getX(), caselles[x][y + 1].getY(), 200, 200));
                    caselles[x][y + 1].setNomImatge(nomBuida);
                    casella.paintCasella(this.getGraphics(), caselles[x][y + 1].getNomImatge(), caselles[x][y + 1].getX(),
                            caselles[x][y + 1].getY(), caselles[x][y + 1].getQuadrat());
                    jBuida = y + 1; //Actualitzam columna de la casella buida
                }
                break;

            case 'D': //Dreta
                if (y != 0) {
                    caselles[x][y].setX(caselles[x][y - 1].getX());
                    caselles[x][y].setY(caselles[x][y - 1].getY());
                    caselles[x][y - 1].setX(auxX);
                    caselles[x][y - 1].setY(auxY);
                    caselles[x][y] = caselles[x][y - 1];
                    caselles[x][y - 1] = casellaAux;
                    caselles[x][y].setQuadrat(new Rectangle2D.Float(caselles[x][y].getX(), caselles[x][y].getY(), 200, 200));
                    caselles[x][y - 1].setQuadrat(new Rectangle2D.Float(caselles[x][y - 1].getX(), caselles[x][y - 1].getY(), 200, 200));
                    caselles[x][y - 1].setNomImatge(nomBuida);
                    casella.paintCasella(this.getGraphics(), caselles[x][y - 1].getNomImatge(), caselles[x][y - 1].getX(),
                            caselles[x][y - 1].getY(), caselles[x][y - 1].getQuadrat());
                    jBuida = y - 1; //Actualitzam columna de la casella buida
                }
                break;
        }
        casella.paintCasella(this.getGraphics(), caselles[x][y].getNomImatge(), caselles[x][y].getX(), caselles[x][y].getY(),
                caselles[x][y].getQuadrat()); //Repintam únicament la casella no buida que es mou
        numMoviments++;    //Quan hem mogut una casella, incrementam el nº de moviments que ha fet l'usuari
        puzzleCorrecte(); //i comprovam si el trencaclosques és correcte
    }

    /**
     * Mètode per escapçar i reiniciar el puzzle. Es tornen inicialitzar i
     * desordenar les imatges, i després es creen les caselles desordenades.
     */
    public void reiniciarPuzzle() {
        inicialitzar();
        desordenar();
        crearCaselles();
        repaint();
    }

    /**
     * Mètode que soluciona el puzzle. S'inicialitzen les imatges però no es
     * desordenen, de manera que quan es creen les caselles aquestes estàn
     * ordenades. Si el puzzle es soluciona (s'inicialitza) ja no sortirà la
     * felicitació si l'usuari després el completa.
     */
    public void solucionarPuzzle() {
        inicialitzar();
        crearCaselles();
        repaint();
        inicialitzat = true;
    }

    /**
     * Mètode que mostra un missatge en pantalla quan el puzzle es completat
     * correctament per l'usuari. Compara per ordre els noms de les imatges de
     * l'array 2D de caselles amb les de l'array 2D que conté la combinació de
     * noms correcta, i si en troba una imatge que no concorda amb la solució es
     * surt del bucle i no es mostra el missatge final. En canvi, si totes les
     * caselles coincideixen i el trencaclosques no ha estat inicialitzat per
     * l'usuari (és a dir, resolt per la màquina) si que es mostra el missatge
     * de felicitació.
     */
    private void puzzleCorrecte() {
        boolean correcte = true;
        for (int i = 0; i < MIDA; i++) {
            for (int j = 0; j < MIDA; j++) {
                if (!(caselles[i][j].getNomImatge().equals(solucio[i][j].getNomImatge()))) { //Si una casella no coincideix amb la solució
                    correcte = false; //El trencaclosques no s'ha resolt
                    j = MIDA; //Forçam aturada bucle
                    i = MIDA;
                }
            }
        }
        if (correcte && !inicialitzat) { //Si totes les caselles coincideixen i no s'ha inicialitzat el trencaclosques
            JOptionPane.showMessageDialog(null, "Puzzle correcte!\nNº moviments: " + numMoviments, "TRENCACLOSQUES",
                    JOptionPane.OK_OPTION, new ImageIcon("IMATGES/claps.gif"));
            numMoviments = 0; //Quan es completa el puzzle es reseteja el comptador de moviments
        }
    }

    /**
     * Metode que desordena l'array d'imatges de les caselles. Així es poden
     * pintar les caselles desordenades. Quan es desordena el puzzle, ja no està
     * inicialitzat i pot sortir el missatge final.
     */
    private void desordenar() {
        mesclar(img);
        inicialitzat = false;
    }

    /**
     * Mètode que escapça aleatoriament l'array de les imatges de les caselles.
     *
     * @param array
     */
    private void mesclar(Imatge[] array) {
        for (int i = 0; i < array.length; i++) {
            int numAleatori = i + (int) (Math.random() * (array.length - i));
            Imatge aleatori = array[numAleatori];
            array[numAleatori] = array[i];
            array[i] = aleatori;
        }
    }

    /**
     * Mètode que retorna una casella de l'array 2D d'objectes Casella. Útil pel
     * mètode mousePressed de la classe TrencaclosquesFinal per a moure les
     * caselles mitjançant el ratolí.
     *
     * @param i
     * @param j
     * @return caselles[i][j]
     */
    public Casella getCasella(int i, int j) {
        return caselles[i][j];
    }

    /**
     * Mètode per poder canviar de trencaclosques.
     *
     * @param puzzle
     */
    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }

    /**
     * Retorna el nombre de caselles que hi ha a cada costat del panell.
     *
     * @return MIDA
     */
    public static int getMida() {
        return MIDA;
    }

    /**
     * Retorna les dimensions del panell del trencaclosques (ample x alt).
     *
     * @return Dimension
     */
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DAMPLE, DALT);
    }
}
