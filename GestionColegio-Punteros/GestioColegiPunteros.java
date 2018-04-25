/*
ALGORISMIA - ENGINYERIA INFORMÀTICA (UIB 2016 - 2017)

PRACTICA 1: Gestio d'un col·legi.
 */
package gestiocolegipunteros;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author Bartomeu Mascaró Arbona & Toni Gomila Llompart & Manuel Peña Llull
 */

public class GestioColegiPunteros extends JFrame {

    JTabbedPane MultiPanels;

    JPanel panel1;
    JPanel panel2;
    JPanel panel3;

    LlistaCursos listacursos = new LlistaCursos();
    LlistaAssignatures listaasignaturas = new LlistaAssignatures();
    
    JButton jbtAfegirCurs;
    JButton jbtEliminarCurs;
    JButton jbtVeureCurs;
    JButton jbtAfegirAssignatura;
    JButton jbtEliminarAssignatura;
    JButton jbtVeureAssignatura;
    JButton jbtAfegirEstudiant;
    JButton jbtVeureEstudiant;
    
    public static JTextArea jtaCursos;
    public static JTextArea jtaAssignatures;
    public static JTextArea jtaEstudiants;
    
    JScrollPane jsCursos;
    JScrollPane jsAssignatures;
    JScrollPane jsEstudiants;
    


    public GestioColegiPunteros() {

        this.setTitle("Gestió col·legi");
        this.setSize(630, 570);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(GestioColegiPunteros.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {

        MultiPanels = new JTabbedPane();
        this.getContentPane().add(MultiPanels);
        
        jbtAfegirCurs = new JButton("Afegir curs");
        jbtEliminarCurs = new JButton("Eliminar curs");
        jbtVeureCurs = new JButton("Veure curs");
        jbtAfegirAssignatura = new JButton("Afegir assignatura");
        jbtEliminarAssignatura = new JButton("Eliminar assignatura");
        jbtVeureAssignatura = new JButton("Veure assignatura");
        jbtAfegirEstudiant = new JButton("Afegir estudiant");
        jbtVeureEstudiant = new JButton("Veure estudiant");
        
        jtaCursos = new JTextArea();
        jtaAssignatures = new JTextArea();
        jtaEstudiants = new JTextArea();
        
        jsCursos = new JScrollPane(jtaCursos); //unim scroll amb jtaCursos
        jsAssignatures = new JScrollPane(jtaAssignatures);
        jsEstudiants = new JScrollPane(jtaEstudiants);

        

        //PANELL CURSOS
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.LIGHT_GRAY);
        MultiPanels.addTab("CURSOS", null, panel1, "Gestió dels cursos");

        jbtAfegirCurs.setBounds(20, 50, 180, 30);
        jbtEliminarCurs.setBounds(20, 100, 180, 30);
        jbtVeureCurs.setBounds(20, 150, 180, 30);
        jsCursos.setBounds(220, 50, 390, 450);
        jtaCursos.setEditable(false);
        jtaCursos.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jsCursos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel1.add(jbtAfegirCurs);
        panel1.add(jbtEliminarCurs);
        panel1.add(jbtVeureCurs);
        panel1.add(jsCursos);
        
        jbtAfegirCurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jbtAfegirCurs(evt);
            }
        });
        
        jbtEliminarCurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jbtEliminarCurs(evt);
            }
        });
        
        jbtVeureCurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jbtVeureCurs(evt);
            }
        });

        
        //PANELL ASSIGNATURES
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.LIGHT_GRAY);
        MultiPanels.addTab("ASSIGNATURES", null, panel2, "Gestió d'assignatures");
        
        jbtAfegirAssignatura.setBounds(20, 50, 180, 30);
        jbtEliminarAssignatura.setBounds(20, 100, 180, 30);
        jbtVeureAssignatura.setBounds(20, 150, 180, 30);
        jsAssignatures.setBounds(220, 50, 390, 450);
        jtaAssignatures.setEditable(false);
        jtaAssignatures.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jsAssignatures.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel2.add(jbtAfegirAssignatura);
        panel2.add(jbtEliminarAssignatura);
        panel2.add(jbtVeureAssignatura);
        panel2.add(jsAssignatures);

        jbtAfegirAssignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jbtAfegirAssignatura(evt);
            }
        });
        
        jbtEliminarAssignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jbtEliminarAssignatura(evt);
            }
        });
        
        jbtVeureAssignatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jbtVeureAssignatura(evt);
            }
        });

        
        //PANELL ESTUDIANTS
        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setBackground(Color.LIGHT_GRAY);
        MultiPanels.addTab("ESTUDIANTS", null, panel3, "Gestió dels estudiants");

        jbtAfegirEstudiant.setBounds(20, 50, 180, 30);
        jbtVeureEstudiant.setBounds(20, 100, 180, 30);
        jsEstudiants.setBounds(220, 50, 390, 450);
        jtaEstudiants.setEditable(false);
        jtaEstudiants.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jsEstudiants.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel3.add(jbtAfegirEstudiant);
        panel3.add(jbtVeureEstudiant);
        panel3.add(jsEstudiants);

        jbtAfegirEstudiant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jbtAfegirEstudiant(evt);
            }
        });
        
        jbtVeureEstudiant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jbtVeureEstudiant(evt);
            }
        });

    }

    
    
    
    //Afegir un curs
    private void jbtAfegirCurs(ActionEvent evt) {
        listacursos.incluir(JOptionPane.showInputDialog(rootPane, "Introdueix el nom del curs:", "AFEGIR CURS", 
                JOptionPane.QUESTION_MESSAGE), JOptionPane.showInputDialog(rootPane, "Introdueix el codi del curs:", 
                        "AFEGIR CURS", JOptionPane.QUESTION_MESSAGE),new LlistaAssignatures());
        JOptionPane.showMessageDialog(null, "S'ha afegit el curs", "AFEGIR CURS", JOptionPane.INFORMATION_MESSAGE);
        listacursos.imprimir();
        System.out.println("CURS AFEGIT");
    }

    //Afegir una assignatura
    private void jbtAfegirAssignatura(ActionEvent evt) {
        listacursos.afegirasignatura(JOptionPane.showInputDialog(rootPane, "Introdueix el nom del curs:", "AFEGIR ASSIGNATURA", 
                JOptionPane.QUESTION_MESSAGE), JOptionPane.showInputDialog(rootPane, "Introdueix el nom de l'assignatura:", 
                        "AFEGIR ASSIGNATURA", JOptionPane.QUESTION_MESSAGE), JOptionPane.showInputDialog(rootPane, "Introdueix el codi de l'assignatura:", 
                        "AFEGIR ASSIGNATURA", JOptionPane.QUESTION_MESSAGE));
        JOptionPane.showMessageDialog(null, "S'ha afegit l'assignatura", "AFEGIR ASSIGNATURA", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("ASSIGNATURA AFEGIDA");
    }
    
    //Afegir un estudiant
    private void jbtAfegirEstudiant(ActionEvent evt) {
       listacursos.matricular(JOptionPane.showInputDialog(rootPane, "Introdueix el nom de l'assignatura:", 
                        "AFEGIR ESTUDIANT", JOptionPane.QUESTION_MESSAGE), JOptionPane.showInputDialog(rootPane, "Introdueix el nom de l'estudiant:", 
                        "AFEGIR ESTUDIANT", JOptionPane.QUESTION_MESSAGE), JOptionPane.showInputDialog(rootPane, "Introdueix el DNI de l'estudiant:", 
                        "AFEGIR ESTUDIANT", JOptionPane.QUESTION_MESSAGE));
       JOptionPane.showMessageDialog(null, "S'ha afegit l'estudiant", "AFEGIR ESTUDIANT", JOptionPane.INFORMATION_MESSAGE);
       System.out.println("ESTUDIANT AFEGIT");
    }

    //Eliminar un curs per complet amb totes les seves asignatures
    private void jbtEliminarCurs(ActionEvent evt) {
        listacursos.eliminarcurso(JOptionPane.showInputDialog(rootPane, "Introdueix el nom del curs:", "ELIMINAR CURS", 
                JOptionPane.QUESTION_MESSAGE), JOptionPane.showInputDialog(rootPane, "Introdueix el codi del curs:", 
                        "ELIMINAR CURS", JOptionPane.QUESTION_MESSAGE));
        JOptionPane.showMessageDialog(null, "S'ha eliminat el curs", "ELIMINAR CURS", JOptionPane.INFORMATION_MESSAGE);
        listacursos.imprimir();
        System.out.println("CURS ELIMINAT");
    }

    //Eliminar una assignatura per complet amb tots els seus estudiants
    private void jbtEliminarAssignatura(ActionEvent evt) {
        listacursos.eliminarasginatura(JOptionPane.showInputDialog(rootPane, "Introdueix el nom de l'assignatura:", 
                        "ELIMINAR ASSIGNATURA", JOptionPane.QUESTION_MESSAGE));
        JOptionPane.showMessageDialog(null, "S'ha eliminat l'assignatura", "ELIMINAR ASSIGNATURA", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("ASSIGNATURA ELIMINADA");
    }
   
    //Veure les assignatures d'un curs
    private void jbtVeureCurs(ActionEvent evt) {
        jtaCursos.setText(jtaCursos.getText() + listacursos.listarasignaturas(JOptionPane.showInputDialog(rootPane, 
                "Introdueix el nom del curs:", "VEURE CURS", JOptionPane.QUESTION_MESSAGE), 
                JOptionPane.showInputDialog(rootPane, "Introdueix el codi del curs:", "VEURE CURS", JOptionPane.QUESTION_MESSAGE)));
    }

    //Veure el curs i estudiants d'una assignatura
    private void jbtVeureAssignatura(ActionEvent evt) {
        jtaAssignatures.setText(jtaAssignatures.getText() + listacursos.veureAssignatura(JOptionPane.showInputDialog(rootPane, 
                "Introdueix el nom de l'assignatura:", "VEURE ASSIGNATURA", JOptionPane.QUESTION_MESSAGE)));
    }
    
    //Veure les assignatures i cursos d'un estudiant
    private void jbtVeureEstudiant(ActionEvent evt) {
        jtaEstudiants.setText(jtaEstudiants.getText() + listacursos.recorrrerasignaturas(JOptionPane.showInputDialog(rootPane,
                "Introdueix el nom de l'estudiant: ", "VEURE ESTUDIANT", JOptionPane.QUESTION_MESSAGE)));
    }


    public static void main(String args[]) {
        GestioColegiPunteros colegi = new GestioColegiPunteros();
        colegi.setVisible(true);
        colegi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

    

