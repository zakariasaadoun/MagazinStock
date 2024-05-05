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
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author intel
 */
public final class UpdateClientE extends javax.swing.JFrame {

    java.sql.Connection con = ConnectionUtil.getConnection();
    ResultSet rs;
    int mouseX;
    int mouseY;

    /**
     * Creates new form Inscription
     */
    public UpdateClientE() {
        initComponents();
        
        affiche2();
        
        PromptSupport.setPrompt("Entrer le nom", txNom);
        PromptSupport.setPrompt("Entrer le prénom", txPrenom);
        PromptSupport.setPrompt("Entrer CIN ", txCin);
        PromptSupport.setPrompt("Entrer téléphonne", txTel);
        PromptSupport.setPrompt("Entrer l'email", txEmail);
        PromptSupport.setPrompt("Entrer l'adresse", txAdresse);
        ButtonGroup bg = new ButtonGroup();
        bg.add(RbHomme);
        bg.add(RbFemme);

    }

    public boolean verifierField() {
        String nom = txNom.getText();
        String prenom = txPrenom.getText();
        String Cin = txCin.getText();
        String tel = txTel.getText();
        String Email = txEmail.getText();
        String adresse = txAdresse.getText();

        if (nom.trim().equals("") || prenom.trim().equals("") || Cin.trim().equals("") || tel.trim().equals("")
                || Email.trim().equals("") || adresse.trim().equals("")) {

            JOptionPane.showMessageDialog(null, "Verifier les champs", "Champs vides", 2);
            return false;
        } else {

            return true;
        }
    }

    

    public void affiche2() {

        try {
            PreparedStatement pstmt = con.prepareStatement("select * from client where idCl=?");
            pstmt.setInt(1, MainEmployes.tabclid);
            rs = pstmt.executeQuery();

            if (rs.next()) {

                txNom.setText(rs.getString("nomcl"));
                txPrenom.setText(rs.getString("prenomcl"));
                txEmail.setText(rs.getString("emailcl"));
                txAdresse.setText(rs.getString("adressecl"));
                if (rs.getString("sexecl").equals("Homme")) {
                    RbHomme.setSelected(true);
                } else {
                    RbFemme.setSelected(true);
                }

                txCin.setText(rs.getString("cincl"));
                txTel.setText(rs.getString("telcl"));

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateClientE.class.getName()).log(Level.SEVERE, null, ex);
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
        txPrenom = new javax.swing.JTextField();
        txNom = new javax.swing.JTextField();
        txTel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txCin = new javax.swing.JTextField();
        RbHomme = new javax.swing.JRadioButton();
        RbFemme = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txAdresse = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnValider = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        btnAnn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);

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

        txPrenom.setBackground(new java.awt.Color(255, 255, 204));
        txPrenom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txPrenom.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txPrenom.setCaretColor(new java.awt.Color(0, 153, 0));
        txPrenom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txPrenomFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txPrenomFocusLost(evt);
            }
        });
        txPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txPrenomActionPerformed(evt);
            }
        });

        txNom.setBackground(new java.awt.Color(255, 255, 204));
        txNom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txNom.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txNom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txNomFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txNomFocusLost(evt);
            }
        });
        txNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNomActionPerformed(evt);
            }
        });

        txTel.setBackground(new java.awt.Color(255, 255, 204));
        txTel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txTel.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txTel.setCaretColor(new java.awt.Color(0, 153, 0));
        txTel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txTelFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txTelFocusLost(evt);
            }
        });
        txTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txTelActionPerformed(evt);
            }
        });
        txTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txTelKeyTyped(evt);
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

        txEmail.setBackground(new java.awt.Color(255, 255, 204));
        txEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txEmail.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txEmail.setCaretColor(new java.awt.Color(0, 153, 0));
        txEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txEmailFocusLost(evt);
            }
        });
        txEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txEmailActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Sexe:");

        txCin.setBackground(new java.awt.Color(255, 255, 204));
        txCin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txCin.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txCin.setCaretColor(new java.awt.Color(0, 153, 0));
        txCin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txCinFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txCinFocusLost(evt);
            }
        });
        txCin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCinActionPerformed(evt);
            }
        });

        RbHomme.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        RbHomme.setText("Homme");
        RbHomme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        RbFemme.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        RbFemme.setText("Femme");
        RbFemme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txAdresse.setBackground(new java.awt.Color(255, 255, 204));
        txAdresse.setColumns(20);
        txAdresse.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txAdresse.setRows(5);
        txAdresse.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txAdresse.setCaretColor(new java.awt.Color(0, 153, 0));
        jScrollPane1.setViewportView(txAdresse);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_phone_30px_2.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_email_30px.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_businesswoman_25px.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_25px.png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnValider.setBackground(new java.awt.Color(66, 160, 66));
        btnValider.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_checked_30px.png"))); // NOI18N
        btnValider.setText("Valider");
        btnValider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnValider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnValiderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnValiderMouseExited(evt);
            }
        });
        btnValider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValiderActionPerformed(evt);
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

        btnAnn.setBackground(new java.awt.Color(66, 160, 66));
        btnAnn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnAnn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_cancel_30px.png"))); // NOI18N
        btnAnn.setText("Annuler");
        btnAnn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAnnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAnnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAnnMouseExited(evt);
            }
        });
        btnAnn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RbHomme)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(RbFemme)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txCin, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txNom, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txTel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48)
                .addComponent(exit)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnValider, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAnn)
                .addGap(222, 222, 222))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txNom, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(25, 25, 25)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(txPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txCin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RbHomme)
                            .addComponent(jLabel19)
                            .addComponent(RbFemme, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txTel)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txEmail)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnValider)
                    .addComponent(btnAnn))
                .addGap(184, 184, 184))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        this.dispose();
    }//GEN-LAST:event_exitMouseClicked

    private void txEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txEmailActionPerformed

    private void txEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txEmailFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txEmailFocusLost

    private void txEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txEmailFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txEmailFocusGained

    private void txTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txTelActionPerformed

    private void txTelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txTelFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txTelFocusLost

    private void txTelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txTelFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txTelFocusGained

    private void txNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomActionPerformed

    private void txNomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txNomFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomFocusLost

    private void txNomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txNomFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txNomFocusGained

    private void txPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txPrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txPrenomActionPerformed

    private void txPrenomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txPrenomFocusLost

    }//GEN-LAST:event_txPrenomFocusLost

    private void txPrenomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txPrenomFocusGained

    }//GEN-LAST:event_txPrenomFocusGained

    private void txCinFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txCinFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txCinFocusGained

    private void txCinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txCinFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txCinFocusLost

    private void txCinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCinActionPerformed

    private void btnValiderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValiderMouseEntered
        btnValider.setBackground(new Color(37, 116, 169));
    }//GEN-LAST:event_btnValiderMouseEntered

    private void btnValiderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValiderMouseExited
        btnValider.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnValiderMouseExited

    private void btnValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValiderActionPerformed
        String nom = txNom.getText();
        String prenom = txPrenom.getText();
        String Cin = txCin.getText();
        String tel = txTel.getText();
        String Email = txEmail.getText();
        String adresse = txAdresse.getText();
        String sexe = "Homme";
        if (RbFemme.isSelected()) {
            sexe = "Femme";
        }

        if (verifierField()) {
            try {
                PreparedStatement pstmt = con.prepareStatement("update client set nomcl=?, prenomcl=?, cinCl=?, telcl=?, emailcl=?, adresseCl=?, sexeCl=? where idCl=?");
                pstmt.setString(1, nom);
                pstmt.setString(2, prenom);
                pstmt.setString(3, Cin);
                pstmt.setString(4, tel);
                pstmt.setString(5, Email);
                pstmt.setString(6, adresse);
                pstmt.setString(7, sexe);
                pstmt.setInt(8, MainEmployes.tabclid);

                if (pstmt.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, "les informations ont été mises à jours");
                    MainEmployes.RemplirTableauClient();
                    this.dispose();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Mise à jour a échoué");

                }

            } catch (SQLException ex) {
                Logger.getLogger(UpdateClientE.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_btnValiderActionPerformed

    private void txTelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txTelKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txTelKeyTyped

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        this.setLocation(this.getX() + evt.getX() - mouseX, this.getY() + evt.getY() - mouseY);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void btnAnnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnnMouseClicked

    }//GEN-LAST:event_btnAnnMouseClicked

    private void btnAnnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnnMouseEntered
        btnAnn.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnAnnMouseEntered

    private void btnAnnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnnMouseExited
        btnAnn.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnAnnMouseExited

    private void btnAnnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnActionPerformed
        txNom.setText("");
        txPrenom.setText("");
        txTel.setText("");
        txEmail.setText("");
        txCin.setText("");
        txAdresse.setText("");
    }//GEN-LAST:event_btnAnnActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateClientE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateClientE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateClientE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateClientE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new UpdateClientE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RbFemme;
    private javax.swing.JRadioButton RbHomme;
    private javax.swing.JButton btnAnn;
    private javax.swing.JButton btnValider;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea txAdresse;
    private javax.swing.JTextField txCin;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txNom;
    private javax.swing.JTextField txPrenom;
    private javax.swing.JTextField txTel;
    // End of variables declaration//GEN-END:variables
}
