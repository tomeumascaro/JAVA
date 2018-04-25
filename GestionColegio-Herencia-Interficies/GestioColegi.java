/*
ALGORISMIA - ENGINYERIA INFORMÀTICA (UIB 2016 - 2017)

PRACTICA 1: Gestio d'un col·legi.
 */
package gestiocolegi2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author Bartomeu Mascaró Arbona & Toni Gomila Llompart & Manuel Peña Llull
 */

public class GestioColegi extends JFrame implements MouseListener {

    private JDesktopPane jdpPrincipal;
    private JPanel jpCursos;
    private JPanel jpAssign;
    private JPanel jpEstud;
    private JLabel jlabTitol;
    private JLabel jlabImage;
    private JButton jbtCursos;
    private JButton jbtAssign;
    private JButton jbtEstud;
    private JButton jbtOKcursos;
    private JButton jbtOKassign;
    private JButton jbtOKestud;
    private JButton jbNouCurs;
    private JButton jbEliminCurs;
    private JButton jbVeureCurs;
    private JInternalFrame jifCursos;
    private JInternalFrame jifAssign;
    private JInternalFrame jifEstud;
    private JList jlCursos;
    private JList jlAssign;
    private JList jlEstud;
    private JScrollPane scrollCursos;
    private JScrollPane scrollAssign;
    private JScrollPane scrollEstud;
    //private JRadioButton jrbNouCurs;
    //private JRadioButton jrbEliminCurs;
    //private JRadioButton jrbVeureCurs;
    private JButton jbNovaAssign;   //Modificat, antes eren radioButtons
    private JButton jbEliminAssign;
    private JButton jbVeureAssign;
    private JButton jbMatricEstud;
    private JButton jbVeureEstud;
    private ButtonGroup bgCursos;
    private ButtonGroup bgAssign;
    private ButtonGroup bgEstud;
    
    private DefaultListModel model;
    private LlistaCursos llistaCursos;
    private LlistaAssignatures llistaAssignatures;
    private LlistaEstudiants llistaEstudiants;
    

    public GestioColegi() {
        setSize(800, 700);
        setTitle("Gestió del col·legi");
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        
        //JDesktopPane Principal
        jdpPrincipal = new JDesktopPane();
        //inicialitzam les llistes
        llistaCursos = new LlistaCursos();
        
        //Botons principals
        jlabTitol = new JLabel(); //Etiqueta titol superior
        jlabImage = new JLabel(); //Etiqueta imatge
        jbtCursos = new JButton(); //Boto cursos
        jbtAssign = new JButton(); //Boto assignatures
        jbtEstud = new JButton(); //Boto estudiants

        //Finestres interiors
        jifCursos = new JInternalFrame(); //Finestra interior del boto cursos
        jifAssign = new JInternalFrame(); //Finestra interior del boto assignatures
        jifEstud = new JInternalFrame(); //Finestra interior del boto estudiants

        //Resultats dins finestres interiors
        jlCursos = new JList(); //Resultats dins la finestra interior cursos
        jlAssign = new JList(); //Resultats dins la finestra interior assignatures
        jlEstud = new JList(); //Resultats dins la finestra interior estudiants
        
        //propietats de les llistes:
        jlCursos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlAssign.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlEstud.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Scrolls dins resultats
        scrollCursos = new JScrollPane(jlCursos); //Unim scroll amb resultats de la finestra interior cursos
        scrollAssign = new JScrollPane(jlAssign); //Unim scroll amb resultats de la finestra interior assignatures
        scrollEstud = new JScrollPane(jlEstud); //Unim scroll amb resultats de la finestra interior estudiants

        //JButtons dins jifCursos
        jbNouCurs = new JButton("Nou curs                "); //RadioButton de "Nou curs"
        jbEliminCurs = new JButton("Eliminar curs        "); //RadioButton de "Eliminar curs"
        jbVeureCurs = new JButton("Veure curs            "); //RadioButton de "Veure curs"

        //JButtons dins jifAssign
        jbNovaAssign = new JButton("Nova assignatura"); //RadioButton de "Nova assignatura"
        jbEliminAssign = new JButton("Eliminar assignatura"); //RadioButton de "Eliminar assignatura"
        jbVeureAssign = new JButton("Veure assignatura"); //RadioButton de "Veure assignatura"
        
        //JButtons dins jifEstud
        jbMatricEstud = new JButton("Matricular estudiant"); //RadioButton de "Matricular estudiant"
        jbVeureEstud = new JButton("Veure estudiant"); //RadioButon de "Veure estudiant"

        //Grups botons
        bgCursos = new ButtonGroup(); //BottonGroup de RadioButtons dins jifCursos
        bgAssign = new ButtonGroup(); //ButtonGroup de RadioButtons dins jifAssign
        bgEstud = new ButtonGroup(); //ButtonGroup de RadioButtons dins jifEstud
//        Box verticalBoxCursos = Box.createVerticalBox(); //Per tenir els botons verticals
//        Box verticalBoxAssign = Box.createVerticalBox();
//        Box verticalBoxEstud = Box.createVerticalBox();
        
        //Botons "SELECCIONA" dins finestres interiors
        jbtOKcursos = new JButton();
        jbtOKassign = new JButton();
        jbtOKestud = new JButton();
        
        
        //Panels dins finestres interiors
        jpCursos = new JPanel();
        jpAssign = new JPanel();
        jpEstud = new JPanel();
        
        
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
        
        //JDESKTOPPANE PRINCIPAL
        getContentPane().add(jdpPrincipal);
        jdpPrincipal.setBounds(0, 0, 800, 700);
        jdpPrincipal.setBackground(Color.LIGHT_GRAY);
        
        //ETIQUETA TITOL SUPERIOR
        jdpPrincipal.add(jlabTitol);
        jlabTitol.setBounds(0, 0, 800, 60); //x, y, width, height
        jlabTitol.setText("                      GESTIÓ DEL COL·LEGI");
        jlabTitol.setFont(new java.awt.Font("Arial", 1, 28));
        jlabTitol.setForeground(Color.CYAN);
        jlabTitol.setOpaque(true);
        jlabTitol.setBackground(Color.GRAY);
        
        //ETIQUETA IMATGE
        jdpPrincipal.add(jlabImage);
        ImageIcon gif = new ImageIcon("16F.gif");
        jlabImage.setIcon(gif);
        gif.setImageObserver(jlabImage);
        jlabImage.setBounds(350, 220, 320, 320);
        
        //BOTO CURSOS
        jdpPrincipal.add(jbtCursos);
        jbtCursos.setBounds(20, 150, 195, 80);
        jbtCursos.setText("CURSOS");
        jbtCursos.setFont(new java.awt.Font("Arial", 1, 18));
        jbtCursos.setForeground(Color.BLACK);
        jbtCursos.setOpaque(true);
        jbtCursos.setBackground(Color.red);
        jbtCursos.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!jifCursos.isShowing()){
                    jifCursos();
                }
            }
        });
        
        //BOTO ASSIGNATURES
        jdpPrincipal.add(jbtAssign);
        jbtAssign.setBounds(20, 310, 195, 80);
        jbtAssign.setText("ASSIGNATURES");
        jbtAssign.setFont(new java.awt.Font("Arial", 1, 18));
        jbtAssign.setForeground(Color.BLACK);
        jbtAssign.setOpaque(true);
        jbtAssign.setBackground(Color.green);
        jbtAssign.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!jifAssign.isShowing()) {
                    jifAssign();
                }
            }
        });
        
        //BOTO ESTUDIANTS
        jdpPrincipal.add(jbtEstud);
        jbtEstud.setBounds(20, 470, 195, 80);
        jbtEstud.setText("ESTUDIANTS");
        jbtEstud.setFont(new java.awt.Font("Arial", 1, 18));
        jbtEstud.setForeground(Color.BLACK);
        jbtEstud.setOpaque(true);
        jbtEstud.setBackground(Color.yellow);
        jbtEstud.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!jifEstud.isShowing()) {
                    jifEstud();
                }
            }
        });

    }
    private void llistarCursos(){
        model = new DefaultListModel();
        for (int i = 0; i < llistaCursos.getTamany(); i++) {
            model.addElement(llistaCursos.getElement(i).getNom());
        }
        jlCursos.setModel(model);
    }
    private void llistarAssign(){
        model = new DefaultListModel();
        for (int i = 0; i < llistaAssignatures.getTamany(); i++) {
            model.addElement(llistaAssignatures.getElement(i).getNom());
        }
        jlAssign.setModel(model);
    }
    private String mostrarAssign(int idx){
        String res = "";
        
        for (int i = 0; i < llistaCursos.getElement(idx).getLlistaAssign().getTamany(); i++) {
            res += llistaCursos.getElement(idx).getLlistaAssign().getElement(i).toString();
        }
        return res;
    }
    
    //FINESTRA INTERIOR CURSOS
    private void jifCursos() {
        Box verticalBoxCursos = Box.createVerticalBox(); //Per tenir els botons verticals
        jdpPrincipal.add(jifCursos);
        jifCursos.add(jpCursos);
        jpCursos.add(verticalBoxCursos);
        jpCursos.add(scrollCursos);
        jpCursos.add(jbtOKcursos);
        bgCursos.add(jbNouCurs);       //MODIFICAT ANTES ERA (jrbNouCurs)
        bgCursos.add(jbEliminCurs);    //"     "       "       "       "  
        bgCursos.add(jbVeureCurs);
        verticalBoxCursos.add(jbNouCurs);
        verticalBoxCursos.add(jbEliminCurs);
        verticalBoxCursos.add(jbVeureCurs);
        jbtOKcursos.setText("Seleccionar");
//        jpCursos.add(jrbNouCurs); //per tenir les opcions horitzontalment
//        jpCursos.add(jrbEliminCurs);
//        jpCursos.add(jrbVeureCurs);
        jifCursos.setBounds(280, 200, 450, 350);
        jifCursos.setTitle("CURSOS");
        jifCursos.setClosable(true);
//        jifCursos.setVisible(true);
        jpCursos.setLayout(new FlowLayout());
        jpCursos.setBackground(Color.red);
        //jbNouCurs.setBackground(Color.red);       //color
        //jbEliminCurs.setBackground(Color.red);
        //jbVeureCurs.setBackground(Color.red);
        jbNouCurs.setFont(new java.awt.Font("Arial", 1, 15));
        jbEliminCurs.setFont(new java.awt.Font("Arial", 1, 15));
        jbVeureCurs.setFont(new java.awt.Font("Arial", 1, 15));
        jbNouCurs.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Es crea un nou curs");
                Curs nou = new Curs(JOptionPane.showInputDialog("Introdueix nom del curs"));
                llistaCursos.afegir(nou);
                llistarCursos();
            }
        });
        jbEliminCurs.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try{
                System.out.println("S'elimina el curs seleccionat");
                llistaCursos.eliminar(jlCursos.getSelectedIndex());
                llistarCursos();
                }catch(Exception error){
                    JOptionPane.showMessageDialog(rootPane, "Error, seleccioni un curs per eliminar");
                }
            }
        });
        jbVeureCurs.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try{
                JOptionPane.showMessageDialog(rootPane, "imrpimeix : " + mostrarAssign(jlCursos.getSelectedIndex()));
                }catch(Exception error){
                    JOptionPane.showMessageDialog(rootPane, error.toString());
                }
            }
        });
        scrollCursos.setBounds(20, 20, 100, 100); //no es situa
        jifCursos.setVisible(true);
    }
    
    //FINESTRA INTERIOR ASSIGNATURES
    private void jifAssign() {
        Box verticalBoxAssign = Box.createVerticalBox(); //Per tenir els botons verticals
        jdpPrincipal.add(jifAssign);
        jifAssign.add(jpAssign);
        jpAssign.add(verticalBoxAssign);
        jpAssign.add(scrollAssign);
        bgAssign.add(jbNovaAssign);
        bgAssign.add(jbEliminAssign);
        bgAssign.add(jbVeureAssign);
        verticalBoxAssign.add(jbNovaAssign);
        verticalBoxAssign.add(jbEliminAssign);
        verticalBoxAssign.add(jbVeureAssign);
        jifAssign.setBounds(310, 200, 450, 350);
        jifAssign.setTitle("ASSIGNATURES");
        jifAssign.setClosable(true);
        jifAssign.setVisible(true);
        jpAssign.setLayout(new FlowLayout());
        jpAssign.setBackground(Color.green);
        //jbNovaAssign.setBackground(Color.green);
        //jbEliminAssign.setBackground(Color.green);
        //jbVeureAssign.setBackground(Color.green);
        jbNovaAssign.setFont(new java.awt.Font("Arial", 1, 15));
        jbEliminAssign.setFont(new java.awt.Font("Arial", 1, 15));
        jbVeureAssign.setFont(new java.awt.Font("Arial", 1, 15));
        jbNovaAssign.addMouseListener(new MouseAdapter(){ 
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Es crea una nova assignatura.");
                try{
                Assignatura nova = new Assignatura(JOptionPane.showInputDialog("Introdueïx el nom de l'assignatura"));
                llistaAssignatures.afegir(nova);
                }catch(Exception error){
                    JOptionPane.showMessageDialog(rootPane, error.toString());
                }
            }
        });
    }
    
    //FINESTRA INTERIOR ESTUDIANTS
    private void jifEstud() {
        Box verticalBoxEstud = Box.createVerticalBox(); //Per tenir els botons verticals
        jdpPrincipal.add(jifEstud);
        jifEstud.add(jpEstud);
        jpEstud.add(verticalBoxEstud);
        jpEstud.add(scrollEstud);
        bgEstud.add(jbMatricEstud);
        bgEstud.add(jbVeureEstud);
        verticalBoxEstud.add(jbMatricEstud);
        verticalBoxEstud.add(jbVeureEstud);
        jifEstud.setBounds(340, 200, 450, 350);
        jifEstud.setTitle("ESTUDIANTS");
        jifEstud.setClosable(true);
        jifEstud.setVisible(true);
        jpEstud.setLayout(new FlowLayout());
        jpEstud.setBackground(Color.yellow);
        //jbMatricEstud.setBackground(Color.yellow);    // posam color predeterminat
        //jbVeureEstud.setBackground(Color.yellow);
        jbMatricEstud.setFont(new java.awt.Font("Arial", 1, 15));
        jbVeureEstud.setFont(new java.awt.Font("Arial", 1, 15));
    }
    
    
    private void formWindowOpened(WindowEvent evt) {
        jlabTitol.requestFocus();
    }
    
    private void exitForm(WindowEvent evt) {
        System.exit(0);
    }
    
    //Mètode per iniciar la finestra (la d'aquesta classe), la qual finalment no feim servir
    public void inici(){
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("ERROR: No s'ha pogut crear el disseny desitjat: " + e);
        }

        new GestioColegi().setVisible(true);
    }
    
    //Mètode per iniciar la finestra "Finestra.java" (de l'altra classe), que és la que feim servir
    public void inici2(){
        Finestra finestra = new Finestra();
        finestra.setVisible(true);
    }
    
    public static void main(String[] args) {
        GestioColegi programa = new GestioColegi();
        //programa.inici();
        programa.inici2(); //inicialitzam Finestra.java
    }

    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
