/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magazinstock;

import db.ConnectionUtil;
import java.awt.Color;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.border.Border;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author intel
 */
public class NouveauProduit extends javax.swing.JFrame {

    java.sql.Connection con = ConnectionUtil.getConnection();
    ResultSet rs;
    int mouseX;
    int mouseY;

    /**
     * Creates new form Inscription
     */
    public NouveauProduit() {
        initComponents();
       
        
      
 PromptSupport.setPrompt("Entrer la description", txtdescpd);
        PromptSupport.setPrompt("Entrer le nom", txtNompd);
        PromptSupport.setPrompt("Entrer la réference", txtrefpd);
        PromptSupport.setPrompt("Entrer catégorie ", txtcatpd);
       
        PromptSupport.setPrompt("Entrer le prix ", txtprixpd);

    }

    
    
    public boolean verifierField() {
        String nom = txtNompd.getText();
        String desc = txtdescpd.getText();
        String ref = txtrefpd.getText();
        String cat = txtcatpd.getText();
        String prix = txtprixpd.getText();
       // double prix = Double.parseDouble(txtprixpd.getText());
        int nbr = (int) spnqtPd.getValue();
        

     if (nom.trim().equals("") || desc.trim().equals("") || ref.trim().equals("") || cat.trim().equals("")
             || prix.trim().equals("") || nbr==0) {

            JOptionPane.showMessageDialog(null, "Verifier les champs", "Champs vides", 2);
            return false;

     } else {
            
            return true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        txtrefpd = new javax.swing.JTextField();
        txtNompd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtprixpd = new javax.swing.JTextField();
        txtcatpd = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdescpd = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        btnAjouterCll = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnAnnuler = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        spnqtPd = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(221, 255, 221));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txtrefpd.setBackground(new java.awt.Color(255, 255, 204));
        txtrefpd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtrefpd.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtrefpd.setCaretColor(new java.awt.Color(0, 153, 0));
        txtrefpd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtrefpdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtrefpdFocusLost(evt);
            }
        });
        txtrefpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrefpdActionPerformed(evt);
            }
        });

        txtNompd.setBackground(new java.awt.Color(255, 255, 204));
        txtNompd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNompd.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtNompd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNompdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNompdFocusLost(evt);
            }
        });
        txtNompd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNompdActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Prix(DH):");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Quantité:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Nom:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Réference:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Description:");

        txtprixpd.setBackground(new java.awt.Color(255, 255, 204));
        txtprixpd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtprixpd.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtprixpd.setCaretColor(new java.awt.Color(0, 153, 0));
        txtprixpd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtprixpdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtprixpdFocusLost(evt);
            }
        });
        txtprixpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprixpdActionPerformed(evt);
            }
        });
        txtprixpd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprixpdKeyTyped(evt);
            }
        });

        txtcatpd.setBackground(new java.awt.Color(255, 255, 204));
        txtcatpd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcatpd.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtcatpd.setCaretColor(new java.awt.Color(0, 153, 0));
        txtcatpd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtcatpdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcatpdFocusLost(evt);
            }
        });
        txtcatpd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcatpdActionPerformed(evt);
            }
        });

        txtdescpd.setBackground(new java.awt.Color(255, 255, 204));
        txtdescpd.setColumns(20);
        txtdescpd.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtdescpd.setRows(5);
        txtdescpd.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtdescpd.setCaretColor(new java.awt.Color(0, 153, 0));
        jScrollPane1.setViewportView(txtdescpd);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_price_tag_30px.png"))); // NOI18N

        btnAjouterCll.setBackground(new java.awt.Color(66, 160, 66));
        btnAjouterCll.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnAjouterCll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_30px_2.png"))); // NOI18N
        btnAjouterCll.setText("Ajouter");
        btnAjouterCll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAjouterCll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAjouterCllMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAjouterCllMouseExited(evt);
            }
        });
        btnAjouterCll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterCllActionPerformed(evt);
            }
        });

        btnAnnuler.setBackground(new java.awt.Color(66, 160, 66));
        btnAnnuler.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_cancel_30px_1.png"))); // NOI18N
        btnAnnuler.setText("Annuler");
        btnAnnuler.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnnuler.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnnulerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAnnulerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAnnulerMouseExited(evt);
            }
        });
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_home_address_30px.png"))); // NOI18N

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_identification_documents_30px.png"))); // NOI18N

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_30px.png"))); // NOI18N

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_30px.png"))); // NOI18N

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_20px_1.png"))); // NOI18N
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        spnqtPd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        spnqtPd.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnqtPd.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        spnqtPd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Catégorie:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel24)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtNompd, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txtrefpd, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel21)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtcatpd, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtprixpd, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addComponent(jLabel22)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(spnqtPd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAjouterCll, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnAnnuler)
                        .addGap(158, 158, 158)))
                .addComponent(exit)
                .addGap(65, 65, 65))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtprixpd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnqtPd)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(txtNompd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtrefpd, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(25, 25, 25)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcatpd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAjouterCll)
                    .addComponent(btnAnnuler))
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtprixpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprixpdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprixpdActionPerformed

    private void txtprixpdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtprixpdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprixpdFocusLost

    private void txtprixpdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtprixpdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprixpdFocusGained

    private void txtNompdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNompdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNompdActionPerformed

    private void txtNompdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNompdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNompdFocusLost

    private void txtNompdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNompdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNompdFocusGained

    private void txtrefpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrefpdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrefpdActionPerformed

    private void txtrefpdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrefpdFocusLost

    }//GEN-LAST:event_txtrefpdFocusLost

    private void txtrefpdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrefpdFocusGained

    }//GEN-LAST:event_txtrefpdFocusGained

    private void txtcatpdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcatpdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcatpdFocusGained

    private void txtcatpdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcatpdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcatpdFocusLost

    private void txtcatpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcatpdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcatpdActionPerformed

    private void btnAjouterCllMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjouterCllMouseEntered
        btnAjouterCll.setBackground(new Color(37, 116, 169));
    }//GEN-LAST:event_btnAjouterCllMouseEntered

    private void btnAjouterCllMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjouterCllMouseExited
        btnAjouterCll.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnAjouterCllMouseExited

    private void btnAjouterCllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterCllActionPerformed
       
        String nom = txtNompd.getText();
        String ref = txtrefpd.getText();
        String cat = txtcatpd.getText();
        int nbrqt = (int) spnqtPd.getValue(); 
        String desc = txtdescpd.getText();
        String prix = txtprixpd.getText();
       
        if (verifierField()) {

            PreparedStatement pstmt;
            try {
                pstmt = con.prepareStatement("insert into produit(nompd, refpd, prixU, categorie, description, quantite) values (?,?,?,?,?,?)");
                pstmt.setString(1, nom);                          
                pstmt.setString(2, ref);
                pstmt.setString(3, prix);
                pstmt.setString(4, cat);                                   
                pstmt.setString(5, desc);
                pstmt.setInt(6, nbrqt);  
                

                if (pstmt.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, " Produit a été ajouter avec succès");
                      MainEmployes.RemplirTableauProduit();
                      
                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Erreur!!: Vérifiez les informations");

                }

            } catch (SQLException ex) {
                Logger.getLogger(NouveauProduit.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_btnAjouterCllActionPerformed

    private void btnAnnulerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnnulerMouseClicked

    }//GEN-LAST:event_btnAnnulerMouseClicked

    private void btnAnnulerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnnulerMouseEntered
        btnAnnuler.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnAnnulerMouseEntered

    private void btnAnnulerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnnulerMouseExited
        btnAnnuler.setBackground(new Color(66, 160, 66));

    }//GEN-LAST:event_btnAnnulerMouseExited

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        txtNompd.setText("");
        txtrefpd.setText("");
        spnqtPd.setValue(0);
        txtprixpd.setText("");
        txtcatpd.setText("");
        txtdescpd.setText("");

    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        this.dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
this.setLocation(this.getX() + evt.getX() - mouseX, this.getY() + evt.getY() - mouseY);       
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
         mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
      

    }//GEN-LAST:event_formFocusLost

    private void txtprixpdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprixpdKeyTyped
    txtprixpd.addKeyListener(new KeyAdapter() {
    public void keyTyped(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
            evt.consume();
        }
    }
});        
    }//GEN-LAST:event_txtprixpdKeyTyped

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
            java.util.logging.Logger.getLogger(NouveauProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NouveauProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NouveauProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NouveauProduit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NouveauProduit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouterCll;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSpinner spnqtPd;
    private javax.swing.JTextField txtNompd;
    private javax.swing.JTextField txtcatpd;
    private javax.swing.JTextArea txtdescpd;
    private javax.swing.JTextField txtprixpd;
    private javax.swing.JTextField txtrefpd;
    // End of variables declaration//GEN-END:variables
}
