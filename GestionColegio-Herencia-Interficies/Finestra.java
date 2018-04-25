/*
ALGORÍSMIA - ENGINYERIA INFORMÀTICA (UIB 2016 - 2017)

PRÀCTICA: Gestió d'un col·legi.
 */
package gestiocolegi2;

import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author Bartomeu Mascaró Arbona & Toni Gomila Llompart & Manuel Peña Llull
 */

public class Finestra extends javax.swing.JFrame {

    //private LlistaAssignatures llistaAssignatures = new LlistaAssignatures();
    private LlistaCursos llistaCursos = new LlistaCursos();
    //private LlistaEstudiants llistaEstudiants = new LlistaEstudiants();
    private DefaultListModel model;

//MOSTRAR CURSOS
    private void llistarCursos() {
        model = new DefaultListModel();
        for (int i = 0; i < llistaCursos.getTamany(); i++) {
            model.addElement(llistaCursos.getElement(i).toString());
        }
        jlCursos.setModel(model);
    }

//MOSTRAR ASSIGNATURES
    private void llistarAssignatures(int idx) {
        model = new DefaultListModel();
        if (idx == -1) {
            model.clear();
        } else {
            if (!llistaCursos.llistaBuida()) {
                for (int i = 0; i < llistaCursos.getElement(idx).getLlistaAssign().getTamany(); i++) {
                    model.addElement(llistaCursos.getElement(idx).getLlistaAssign().getElement(i).toString());
                }
            }
        }
        jlAssignatures.setModel(model);

    }

//MOSTRAR ESTUDIANTS
    private void llistarEstudiants(int idx1, int idx2) {
        model = new DefaultListModel();
        if (idx1 == -1 || idx2 == -1) {
            model.clear();
        } else {
            for (int i = 0; i < llistaCursos.getElement(idx1).getLlistaAssign().getElement(idx2).getLlistaEstud().getTamany(); i++) {
                model.addElement(llistaCursos.getElement(idx1).getLlistaAssign().getElement(idx2).getLlistaEstud().getEstudiant(i).toString());
            }
        }
        jlEstudiants.setModel(model);
    }

//CERCAR ESTUDIANT    
    private Estudiant cercarEstudiant(String nom, String codi) {
        boolean estudiantTrobat = false;

        for (int i = 0; i < llistaCursos.getTamany() && !estudiantTrobat; i++) {
            for (int j = 0; j < llistaCursos.getElement(i).getLlistaAssign().getTamany() && !estudiantTrobat; j++) {
                for (int k = 0; k < llistaCursos.getElement(i).getLlistaAssign().getElement(j)
                        .getLlistaEstud().getTamany() && !estudiantTrobat; k++) {
                    if (llistaCursos.getElement(i).getLlistaAssign().getElement(j).getLlistaEstud()
                            .getEstudiant(k).getNomEstudiant().equals(nom)
                            && llistaCursos.getElement(i).getLlistaAssign().getElement(j).getLlistaEstud()
                                    .getEstudiant(k).getCodiEstud().equals(codi)) {
                        estudiantTrobat = true;
                        return llistaCursos.getElement(i).getLlistaAssign().getElement(j).getLlistaEstud()
                                .getEstudiant(k);
                    }
                }
            }
        }
        return null;
    }

//NETEJAR ASSIGNATURA    
    private void netejarAssignatura(Assignatura assignatura){

        for (int i = 0; i < llistaCursos.getTamany(); i++) {
            for (int j = 0; j < llistaCursos.getElement(i).getLlistaAssign().getTamany(); j++) {
                for (int k = 0; k < llistaCursos.getElement(i).getLlistaAssign().getElement(j)
                        .getLlistaEstud().getTamany(); k++) {
                    if (llistaCursos.getElement(i).getLlistaAssign().getElement(j).getLlistaEstud()
                            .getEstudiant(k).getAssignaturesMatriculat().contains(assignatura)) {
                        llistaCursos.getElement(i).getLlistaAssign().getElement(j).getLlistaEstud()
                                .getEstudiant(k).getAssignaturesMatriculat().remove(assignatura);
                    }
                }
            }
        }        
    }

//FINESTRA
    public Finestra() {
        setTitle("Gestió del col·legi");
        setResizable(false);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jlCursos = new javax.swing.JList();
        jbAfegirCurs = new javax.swing.JButton();
        jbEliminarCurs = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlAssignatures = new javax.swing.JList();
        jbAfegirAssign = new javax.swing.JButton();
        jbEliminarAssign = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlEstudiants = new javax.swing.JList();
        jbAfegirEstudiant = new javax.swing.JButton();
        jbEliminarEstudiant = new javax.swing.JButton();
        jbObrirCurs = new javax.swing.JButton();
        jbObrirAssign = new javax.swing.JButton();
        jbObrirEstudiant = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbAjuda = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jbAssignOblOpt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlCursos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jlCursos);

        jbAfegirCurs.setBackground(new java.awt.Color(102, 255, 102));
        jbAfegirCurs.setText("Afegir");
        jbAfegirCurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAfegirCursActionPerformed(evt);
            }
        });

        jbEliminarCurs.setBackground(new java.awt.Color(255, 71, 56));
        jbEliminarCurs.setText("Eliminar");
        jbEliminarCurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarCursActionPerformed(evt);
            }
        });

        jlAssignatures.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jlAssignatures);

        jbAfegirAssign.setBackground(new java.awt.Color(102, 255, 102));
        jbAfegirAssign.setText("Afegir");
        jbAfegirAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAfegirAssignActionPerformed(evt);
            }
        });

        jbEliminarAssign.setBackground(new java.awt.Color(255, 71, 56));
        jbEliminarAssign.setText("Eliminar");
        jbEliminarAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarAssignActionPerformed(evt);
            }
        });

        jlEstudiants.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jlEstudiants);

        jbAfegirEstudiant.setBackground(new java.awt.Color(102, 255, 102));
        jbAfegirEstudiant.setText("Afegir");
        jbAfegirEstudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAfegirEstudiantActionPerformed(evt);
            }
        });

        jbEliminarEstudiant.setBackground(new java.awt.Color(255, 71, 56));
        jbEliminarEstudiant.setText("Eliminar");
        jbEliminarEstudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarEstudiantActionPerformed(evt);
            }
        });

        jbObrirCurs.setBackground(new java.awt.Color(153, 204, 255));
        jbObrirCurs.setText("Mostra curs seleccionat");
        jbObrirCurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbObrirCursActionPerformed(evt);
            }
        });

        jbObrirAssign.setBackground(new java.awt.Color(153, 204, 255));
        jbObrirAssign.setText("<html>Mostra assignatura<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;seleccionada</html>");
        jbObrirAssign.setMaximumSize(new java.awt.Dimension(124, 38));
        jbObrirAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbObrirAssignActionPerformed(evt);
            }
        });

        jbObrirEstudiant.setBackground(new java.awt.Color(153, 204, 255));
        jbObrirEstudiant.setText("<html>Mostra estudiant<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;seleccionat</html>");
        jbObrirEstudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbObrirEstudiantActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Cursos:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 102));
        jLabel2.setText("Assignatures:");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 102));
        jLabel3.setText("Estudiants:");

        jbAjuda.setFont(new java.awt.Font("Ubuntu Mono", 1, 18)); // NOI18N
        jbAjuda.setText("?");
        jbAjuda.setActionCommand("jbtAjuda");
        jbAjuda.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jbAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAjudaActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Enginyeria Informàtica - UIB");

        jbAssignOblOpt.setBackground(new java.awt.Color(153, 204, 255));
        jbAssignOblOpt.setText("Assign. obligatories/optatives");
        jbAssignOblOpt.setActionCommand("Assign. obligatories/optatives");
        jbAssignOblOpt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAssignOblOptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jbAfegirCurs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jbEliminarCurs, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(jbObrirCurs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbAssignOblOpt, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbAfegirAssign, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(jbEliminarAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jbObrirAssign, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jbAfegirEstudiant, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jbEliminarEstudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                                    .addComponent(jbObrirEstudiant))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jbAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbObrirAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbObrirEstudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbObrirCurs, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminarCurs)
                    .addComponent(jbAfegirAssign)
                    .addComponent(jbEliminarAssign)
                    .addComponent(jbAfegirEstudiant)
                    .addComponent(jbEliminarEstudiant)
                    .addComponent(jbAfegirCurs))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbAjuda, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbAssignOblOpt)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//BOTO "MOSTRA ESTUDIANT SELECCIONAT"
    private void jbObrirEstudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbObrirEstudiantActionPerformed
        try {
            String res = "L'estudiant " + llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign()
                    .getElement(jlAssignatures.getSelectedIndex()).getLlistaEstud()
                    .getEstudiant(jlEstudiants.getSelectedIndex()).getNomEstudiant() + " està matriculat a : \n  ";

            for (int i = 0; i < llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign()
                    .getElement(jlAssignatures.getSelectedIndex()).getLlistaEstud()
                    .getEstudiant(jlEstudiants.getSelectedIndex()).getAssignaturesMatriculat().size(); i++) {

                res += llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign()
                        .getElement(jlAssignatures.getSelectedIndex()).getLlistaEstud()
                        .getEstudiant(jlEstudiants.getSelectedIndex()).getAssignaturesMatriculat().get(i)
                        .getNom() /*+ " (" + llistaCursos.getCurs(i).getLlistaAssign().getAssignatura(i).getTipusAssignatura() +
                        ")"*/ + ", que pertany al curs " + llistaCursos.getElement(jlCursos.getSelectedIndex())
                                .getLlistaAssign()
                                .getElement(jlAssignatures.getSelectedIndex()).getLlistaEstud()
                                .getEstudiant(jlEstudiants.getSelectedIndex()).getAssignaturesMatriculat().get(i)
                                .getCursPertenyent().getNom() + "\n  ";
            }

            JOptionPane.showMessageDialog(rootPane, res, "ESTUDIANT", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Selecciona un estudiant, assignatura i curs vàlid", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbObrirEstudiantActionPerformed

//BOTO "AFEGEIX" CURS
    private void jbAfegirCursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAfegirCursActionPerformed
        String nomTmp;
        String codiTmp;
        String tipoCursTmp;
        int anyBatxTmp;
        //String tipoFPTmp;
        String modalitat = "";
        Object[] opcions = {"Batxillerat", "FP"};
        Object[] batx = {"1r", "2n"};
        
        try {
            nomTmp = JOptionPane.showInputDialog(rootPane, "Introdueix el nom del curs:", "CURS", JOptionPane.QUESTION_MESSAGE);
            codiTmp = JOptionPane.showInputDialog(rootPane, "Introdueix el codi del curs:", "CURS", JOptionPane.QUESTION_MESSAGE);
            tipoCursTmp = (String) JOptionPane.showInputDialog(rootPane, "Selecciona el tipus de curs:", "CURS", JOptionPane.QUESTION_MESSAGE, null, opcions, opcions[0]);
            
            if (tipoCursTmp == opcions[0]) {
                anyBatxTmp = JOptionPane.showOptionDialog(rootPane, "Selecciona el curs de batxillerat", "BATXILLERAT", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, batx, batx[0]);
                modalitat = (String) batx[anyBatxTmp];
                
            } else if (tipoCursTmp == opcions[1]) {
                modalitat = (String) JOptionPane.showInputDialog(rootPane, "Selecciona el tipus de FP", "FP", JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Mecànica", "Electrònica", "Informàtica"}, "Mecànica");
            }
            
            if (nomTmp == null || codiTmp == null) {
                System.out.println("S'ha cancel·lat l'operació");
            } else {
                Curs nou = new Curs(nomTmp, codiTmp, tipoCursTmp, modalitat);
                llistaCursos.afegir(nou);
                llistaCursos.ordenar();
                llistarCursos();
                //ordenarLlistaCursos(jlCursos); A nes final no xD.
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbAfegirCursActionPerformed

//BOTO "ELIMINAR" CURS
    private void jbEliminarCursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarCursActionPerformed
        try {
            for (int i = 0; i < llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign().getTamany(); i++) {
                netejarAssignatura(llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign().getElement(i));
            }
            llistaCursos.eliminar(jlCursos.getSelectedIndex());
            llistaCursos.ordenar();
            llistarCursos();
            System.out.println("Selected curs: " + jlCursos.getSelectedIndex());
            llistarAssignatures(jlCursos.getSelectedIndex());
            llistarEstudiants(jlCursos.getSelectedIndex(), jlAssignatures.getSelectedIndex());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Selecciona un curs vàlid", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbEliminarCursActionPerformed

//BOTO "MOSTRA CURS SELECCIONAT"
    private void jbObrirCursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbObrirCursActionPerformed

        try {
            llistarAssignatures(jlCursos.getSelectedIndex());
            llistarEstudiants(-1, -1);   //d'aquesta manera es buida la llista d'estudiants sempre que s'obri un curs diferent
            ordenarLlistaCursos(jlCursos);
            ordenarLlistaAssignatures(jlAssignatures);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Selecciona un curs vàlid", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbObrirCursActionPerformed

//BOTO "AFEGIR" ASSIGNATURA
    private void jbAfegirAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAfegirAssignActionPerformed
        String nomTmp;
        String codiTmp;
        String tipusAssignatura = "";
        String caract = "";
        int tipusAssign;
        Object[] tipus = {"Obligatòria", "Optativa"};
        
        try {
            nomTmp = JOptionPane.showInputDialog(rootPane, "Introdueix el nom de la assignatura:", "ASSIGNATURA", JOptionPane.QUESTION_MESSAGE);
            codiTmp = JOptionPane.showInputDialog(rootPane, "Introdueix el codi de la assignatura:", "ASSIGNATURA", JOptionPane.QUESTION_MESSAGE);
            tipusAssign = JOptionPane.showOptionDialog(rootPane, "Selecciona el tipus d'assignatura", "ASSIGNATURA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipus, tipus[0]);
            tipusAssignatura = (String) tipus[tipusAssign];
            if (tipusAssignatura == tipus[0]) {
                caract = JOptionPane.showInputDialog(rootPane, "Introdueix el nº de crèdits", "ASSIGNATURA OBLIGATÒRIA", JOptionPane.QUESTION_MESSAGE) + " crèdits";
            
            } else if (tipusAssignatura == tipus[1]) {
                caract = (String) JOptionPane.showInputDialog(rootPane, "Selecciona el perfil de la optativa", "ASSIGNATURA OPTATIVA", JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Teòrica", "Pràctica"}, "Teòrica");
            }
            
            if (nomTmp == null || codiTmp == null) {
                System.out.println("S'ha cancel·lat l'operació");
            } else {
                Assignatura nova = new Assignatura(nomTmp, codiTmp, tipusAssignatura, caract);
                nova.setCursPertenyent(llistaCursos.getElement(jlCursos.getSelectedIndex())); //Assignam el cura al que pertany
                llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign().afegir(nova);
                //llistaAssignatures.afegirAssignatura(nova);
                llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign().ordenar();
                llistarAssignatures(jlCursos.getSelectedIndex());
                ordenarLlistaAssignatures(jlAssignatures);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Selecciona un curs vàlid", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jbAfegirAssignActionPerformed

//BOTO "ELIMINAR" ASSIGNATURA
    private void jbEliminarAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarAssignActionPerformed
        try {
            netejarAssignatura(llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign()
                    .getElement(jlAssignatures.getSelectedIndex()));
            llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign().eliminar(jlAssignatures.getSelectedIndex());
            llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign().ordenar();
            llistarAssignatures(jlCursos.getSelectedIndex());
            llistarEstudiants(jlCursos.getSelectedIndex(), jlAssignatures.getSelectedIndex());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Selecciona una assignatura vàlida", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbEliminarAssignActionPerformed

//BOTO "MOSTRA ASSIGNATURA SELECCIONADA"
    private void jbObrirAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbObrirAssignActionPerformed
        try {
            llistarEstudiants(jlCursos.getSelectedIndex(), jlAssignatures.getSelectedIndex());
            ordenarLlistaEstudiants(jlEstudiants);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Selecciona una assignatura vàlida", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbObrirAssignActionPerformed

//BOTO "AFEGEIX" ESTUDIANT
    private void jbAfegirEstudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAfegirEstudiantActionPerformed
        String nomTmp;
        String codiTmp;
        try {
            nomTmp = JOptionPane.showInputDialog(rootPane, "Introdueix el nom de l'estudiant:", "ESTUDIANT", JOptionPane.QUESTION_MESSAGE);
            codiTmp = JOptionPane.showInputDialog(rootPane, "Introdueix el DNI de l'estudiant:", "ESTUDIANT", JOptionPane.QUESTION_MESSAGE);

            if (nomTmp == null || codiTmp == null) {
                System.out.println("S'ha cancel·lat l'operació");
            } else {
                Estudiant aux = cercarEstudiant(nomTmp, codiTmp);
                if (aux == null) {
                    Estudiant nou = new Estudiant(nomTmp, codiTmp);
                    nou.afegirAssignaturaPertenyent(llistaCursos.getElement(jlCursos.getSelectedIndex())
                            .getLlistaAssign().getElement(jlAssignatures.getSelectedIndex()));
                    llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign().getElement(jlAssignatures.getSelectedIndex())
                            .getLlistaEstud().afegirEstudiant(nou);
                    llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign().getElement(jlAssignatures.getSelectedIndex())
                            .getLlistaEstud().ordenar();
                    llistarEstudiants(jlCursos.getSelectedIndex(), jlAssignatures.getSelectedIndex());
                    //ordenarLlistaEstudiants(jlEstudiants);
                } else {
                    llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign().getElement(jlAssignatures.getSelectedIndex())
                            .getLlistaEstud().afegirEstudiant(aux);
                    aux.afegirAssignaturaPertenyent(llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign()
                            .getElement(jlAssignatures.getSelectedIndex()));
                    llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign().getElement(jlAssignatures.getSelectedIndex())
                            .getLlistaEstud().ordenar();
                    llistarEstudiants(jlCursos.getSelectedIndex(), jlAssignatures.getSelectedIndex());
                    //ordenarLlistaEstudiants(jlEstudiants);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Selecciona una assignatura vàlida", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbAfegirEstudiantActionPerformed

//BOTO "ELIMINAR" ESTUDIANT
    private void jbEliminarEstudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarEstudiantActionPerformed
        try {
            netejarAssignatura(llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign()
                    .getElement(jlAssignatures.getSelectedIndex()));
            llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign().getElement(jlAssignatures.getSelectedIndex()).getLlistaEstud().eliminarEstudiant(jlEstudiants.getSelectedIndex());
            llistaCursos.getElement(jlCursos.getSelectedIndex()).getLlistaAssign().getElement(jlAssignatures.getSelectedIndex())
                            .getLlistaEstud().ordenar();
            llistarEstudiants(jlCursos.getSelectedIndex(), jlAssignatures.getSelectedIndex());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Selecciona un estudiant vàlid", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbEliminarEstudiantActionPerformed

//BOTO "?" AJUDA
    private void jbAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAjudaActionPerformed
        JOptionPane.showMessageDialog(rootPane, "-MOSTRAR CURS: Seleccionar curs i pitjar botó.\n"
                + "-MOSTRAR ASSIGNATURA: Seleccionar curs i assignatura i pitjar botó.\n"
                + "-MOSTRAR ESTUDIANT: Seleccionar curs, assignatura i estudiant i pitjar botó.", "AJUDA", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jbAjudaActionPerformed

//BOTO "ASSIGN. OBLIGATORIES/OPTATIVES"
    private void jbAssignOblOptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAssignOblOptActionPerformed
        Object[] tipus = {"Obligatòries", "Optatives"};
        int tipusAssign = JOptionPane.showOptionDialog(rootPane, "Selecciona les assignatures que vols veure:", "ASSIGNATURES OBLIGATÒRIES/OPTATIVES", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipus, tipus[0]);
        String tipusAssignatura = (String) tipus[tipusAssign];
        String obligatories = "";
        String optatives = "";
        
        if (tipusAssignatura == tipus[0]) { //Cercam totes les assignatures obligatòries
            
            for (int i = 0; i < llistaCursos.getTamany(); i++) {
                
                for (int j = 0; j < llistaCursos.getElement(i).getLlistaAssign().getTamany(); j++) {
                    
                    if("Obligatòria".equals(llistaCursos.getElement(i).getLlistaAssign().getElement(j).getTipo())){
                        obligatories += llistaCursos.getElement(i).getLlistaAssign().getElement(j).getInfo() + "\n";
                    }
                }
            }
            
            JOptionPane.showMessageDialog(rootPane, obligatories, "ASSIGNATURES OBLIGATÒRIES", JOptionPane.PLAIN_MESSAGE);
            
        } else if(tipusAssignatura == tipus[1]) { //Cercam totes les assignatures optatives
            
            for (int i = 0; i < llistaCursos.getTamany(); i++) {
                
                for (int j = 0; j < llistaCursos.getElement(i).getLlistaAssign().getTamany(); j++) {
                    
                    if("Optativa".equals(llistaCursos.getElement(i).getLlistaAssign().getElement(j).getTipo())){
                        optatives += llistaCursos.getElement(i).getLlistaAssign().getElement(j).getInfo() + "\n";
                    }
                }
            }
            
            JOptionPane.showMessageDialog(rootPane, optatives, "ASSIGNATURES OPTATIVES", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jbAssignOblOptActionPerformed

//ORDENAR CURSOS
    private void ordenarLlistaCursos(JList jlCursos) {
        ListModel modelLlista = jlCursos.getModel(); //Agafam jlCursos
        int n = modelLlista.getSize();
        String[] cursos = new String[n];
        
        for (int i = 0; i < n; i++) {
            cursos[i] = (String) modelLlista.getElementAt(i); //Posam jlCursos dins un array
        }
        
        Arrays.sort(cursos); //Ordenam array
        jlCursos.setListData(cursos); //Posam l'array ordenat a jlCursos
    }
    
//ORDENAR ESTUDIANTS
    private void ordenarLlistaEstudiants(JList jlEstudiants) {
        ListModel modelLlista = jlEstudiants.getModel(); //Agafam jlEstudiants
        int n = modelLlista.getSize();
        String[] estudiants = new String[n];
        
        for (int i = 0; i < n; i++) {
            estudiants[i] = (String) modelLlista.getElementAt(i); //Posam jlEstudiants dins un array
        }
        
        Arrays.sort(estudiants); //Ordenam array
        jlEstudiants.setListData(estudiants); //Posam l'array ordenat a jlEstudiants
    }
  
//ORDENAR ASSIGNATURES
    private void ordenarLlistaAssignatures(JList jlAssignatures) {
        ListModel modelLlista = jlAssignatures.getModel(); //Agafam jlAssignatures
        int n = modelLlista.getSize();
        String[] assignatures = new String[n];
        
        for (int i = 0; i < n; i++) {
            assignatures[i] = (String) modelLlista.getElementAt(i); //Posam jlAssignatures dins un array
        }
        
        Arrays.sort(assignatures); //Ordenam array
        jlAssignatures.setListData(assignatures); //Posam l'array ordenat a jlAssignatures
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Finestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Finestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Finestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Finestra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Finestra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbAfegirAssign;
    private javax.swing.JButton jbAfegirCurs;
    private javax.swing.JButton jbAfegirEstudiant;
    private javax.swing.JButton jbAjuda;
    private javax.swing.JButton jbAssignOblOpt;
    private javax.swing.JButton jbEliminarAssign;
    private javax.swing.JButton jbEliminarCurs;
    private javax.swing.JButton jbEliminarEstudiant;
    private javax.swing.JButton jbObrirAssign;
    private javax.swing.JButton jbObrirCurs;
    private javax.swing.JButton jbObrirEstudiant;
    private javax.swing.JList jlAssignatures;
    private javax.swing.JList jlCursos;
    private javax.swing.JList jlEstudiants;
    // End of variables declaration//GEN-END:variables
}
