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
import javax.swing.border.Border;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author intel
 */
public class NouveauClient extends javax.swing.JFrame {

    java.sql.Connection con = ConnectionUtil.getConnection();
    ResultSet rs;
    int mouseX;
    int mouseY;

    /**
     * Creates new form Inscription
     */
    public NouveauClient() {
        initComponents();

        ButtonGroup bg = new ButtonGroup();
        bg.add(jRadioHommeCl);
        bg.add(jRadioFemmeCl);

        PromptSupport.setPrompt("Entrer le nom", txtNomCl);
        PromptSupport.setPrompt("Entrer le prénom", txtPrenomCl);
        PromptSupport.setPrompt("Entrer CIN ", txtCinCl);
        PromptSupport.setPrompt("Entrer téléphonne", txtTelCl);
        PromptSupport.setPrompt("Entrer l'email", txtEmailCl);
        PromptSupport.setPrompt("Entrer l'adresse", txtAdresseCl);

    }

    public boolean verifierField() {
        String nom = txtNomCl.getText();
        String prenom = txtPrenomCl.getText();
        String Cin = txtCinCl.getText();
        String tel = txtTelCl.getText();
        String Email = txtEmailCl.getText();
        String adresse = txtAdresseCl.getText();

        if (nom.trim().equals("") || prenom.trim().equals("") || Cin.trim().equals("") || tel.trim().equals("")
                || Email.trim().equals("") || adresse.trim().equals("")) {

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
        txtPrenomCl = new javax.swing.JTextField();
        txtNomCl = new javax.swing.JTextField();
        txtTelCl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtEmailCl = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCinCl = new javax.swing.JTextField();
        jRadioHommeCl = new javax.swing.JRadioButton();
        jRadioFemmeCl = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAdresseCl = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnAjouterCll = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnAnnuler = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();

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

        txtPrenomCl.setBackground(new java.awt.Color(255, 255, 204));
        txtPrenomCl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPrenomCl.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtPrenomCl.setCaretColor(new java.awt.Color(0, 153, 0));
        txtPrenomCl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrenomClFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrenomClFocusLost(evt);
            }
        });
        txtPrenomCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrenomClActionPerformed(evt);
            }
        });

        txtNomCl.setBackground(new java.awt.Color(255, 255, 204));
        txtNomCl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNomCl.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtNomCl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomClFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomClFocusLost(evt);
            }
        });
        txtNomCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomClActionPerformed(evt);
            }
        });

        txtTelCl.setBackground(new java.awt.Color(255, 255, 204));
        txtTelCl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTelCl.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtTelCl.setCaretColor(new java.awt.Color(0, 153, 0));
        txtTelCl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelClFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelClFocusLost(evt);
            }
        });
        txtTelCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelClActionPerformed(evt);
            }
        });
        txtTelCl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelClKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Email:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("CIN:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Nom:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Prénom:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Télephone:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Adresse:");

        txtEmailCl.setBackground(new java.awt.Color(255, 255, 204));
        txtEmailCl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEmailCl.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtEmailCl.setCaretColor(new java.awt.Color(0, 153, 0));
        txtEmailCl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailClFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailClFocusLost(evt);
            }
        });
        txtEmailCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailClActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Sexe:");

        txtCinCl.setBackground(new java.awt.Color(255, 255, 204));
        txtCinCl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCinCl.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtCinCl.setCaretColor(new java.awt.Color(0, 153, 0));
        txtCinCl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCinClFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCinClFocusLost(evt);
            }
        });
        txtCinCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCinClActionPerformed(evt);
            }
        });

        jRadioHommeCl.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRadioHommeCl.setSelected(true);
        jRadioHommeCl.setText("Homme");

        jRadioFemmeCl.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRadioFemmeCl.setText("Femme");

        txtAdresseCl.setBackground(new java.awt.Color(255, 255, 204));
        txtAdresseCl.setColumns(20);
        txtAdresseCl.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtAdresseCl.setRows(5);
        txtAdresseCl.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtAdresseCl.setCaretColor(new java.awt.Color(0, 153, 0));
        jScrollPane1.setViewportView(txtAdresseCl);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_phone_30px_2.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_email_30px.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_businesswoman_25px.png"))); // NOI18N

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_25px.png"))); // NOI18N

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtEmailCl, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNomCl, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrenomCl, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCinCl, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exit))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelCl, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioHommeCl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jRadioFemmeCl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addContainerGap(29, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(btnAjouterCll, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAnnuler)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(txtNomCl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrenomCl, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCinCl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmailCl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28))))
                            .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelCl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioHommeCl)
                            .addComponent(jLabel19)
                            .addComponent(jRadioFemmeCl, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailClActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailClActionPerformed

    private void txtEmailClFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailClFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailClFocusLost

    private void txtEmailClFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailClFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailClFocusGained

    private void txtTelClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelClActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelClActionPerformed

    private void txtTelClFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelClFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelClFocusLost

    private void txtTelClFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelClFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelClFocusGained

    private void txtNomClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomClActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomClActionPerformed

    private void txtNomClFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomClFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomClFocusLost

    private void txtNomClFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomClFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomClFocusGained

    private void txtPrenomClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrenomClActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrenomClActionPerformed

    private void txtPrenomClFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrenomClFocusLost

    }//GEN-LAST:event_txtPrenomClFocusLost

    private void txtPrenomClFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrenomClFocusGained

    }//GEN-LAST:event_txtPrenomClFocusGained

    private void txtCinClFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCinClFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCinClFocusGained

    private void txtCinClFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCinClFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCinClFocusLost

    private void txtCinClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCinClActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCinClActionPerformed

    private void btnAjouterCllMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjouterCllMouseEntered
        btnAjouterCll.setBackground(new Color(37, 116, 169));
    }//GEN-LAST:event_btnAjouterCllMouseEntered

    private void btnAjouterCllMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjouterCllMouseExited
        btnAjouterCll.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnAjouterCllMouseExited

    private void btnAjouterCllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterCllActionPerformed
        String nom = txtNomCl.getText();
        String prenom = txtPrenomCl.getText();
        String Cin = txtCinCl.getText();
        String tel = txtTelCl.getText();
        String Email = txtEmailCl.getText();
        String adresse = txtAdresseCl.getText();
        String sexe = "Homme";
        if (jRadioFemmeCl.isSelected()) {
            sexe = "Femme";
        }

        if (verifierField()) {

            PreparedStatement pstmt;
            try {
                pstmt = con.prepareStatement("insert into client(nomCl, prenomCl, cinCl, telCl, adresseCl, emailCl, sexeCl) values (?,?,?,?,?,?,?)");
                pstmt.setString(1, nom);
                pstmt.setString(2, prenom);
                pstmt.setString(3, Cin);
                pstmt.setString(4, tel);
                pstmt.setString(5, adresse);
                pstmt.setString(6, Email);
                pstmt.setString(7, sexe);

                if (pstmt.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, " Client a été ajouter avec succès");
                      MainEmployes.RemplirTableauClient();
                      
                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Erreur!!: Vérifiez les informations");

                }

            } catch (SQLException ex) {
                Logger.getLogger(NouveauClient.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_btnAjouterCllActionPerformed

    private void txtTelClKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelClKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelClKeyTyped

    private void btnAnnulerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnnulerMouseClicked

    }//GEN-LAST:event_btnAnnulerMouseClicked

    private void btnAnnulerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnnulerMouseEntered
        btnAnnuler.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnAnnulerMouseEntered

    private void btnAnnulerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnnulerMouseExited
        btnAnnuler.setBackground(new Color(66, 160, 66));

    }//GEN-LAST:event_btnAnnulerMouseExited

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        txtNomCl.setText("");
        txtPrenomCl.setText("");
        txtTelCl.setText("");
        txtEmailCl.setText("");
        txtCinCl.setText("");
        txtAdresseCl.setText("");

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
            java.util.logging.Logger.getLogger(NouveauClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NouveauClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NouveauClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NouveauClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new NouveauClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouterCll;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioFemmeCl;
    private javax.swing.JRadioButton jRadioHommeCl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea txtAdresseCl;
    private javax.swing.JTextField txtCinCl;
    private javax.swing.JTextField txtEmailCl;
    private javax.swing.JTextField txtNomCl;
    private javax.swing.JTextField txtPrenomCl;
    private javax.swing.JTextField txtTelCl;
    // End of variables declaration//GEN-END:variables
}