/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magazinstock;

import db.ConnectionUtil;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static magazinstock.MainAdmin.RemplirTableauEmp;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.prompt.PromptSupport;

/**
 *
 * @author intel
 */
public class MainAdmin extends javax.swing.JFrame {

    static Connection con = ConnectionUtil.getConnection();
    public static String tabemp;

    int mouseX = 0;
    int mouseY = 0;

    /**
     * Creates new form MainAdmin
     */
    public MainAdmin() {
        initComponents();
        RemplirTableauEmp();
        HeaderJtable();
        promptEmp();

        jb1.setBackground(new Color(221, 255, 221));
        jLayeredPane2.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(0, 153, 0)));
        jPanelButton.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, new Color(0, 153, 0)));
        jPanelTitle.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 153, 0)));
    }

    public void promptEmp() {

        ButtonGroup bg = new ButtonGroup();
        bg.add(jRadioHommeEmp);
        bg.add(jRadioFemmeEmp);
        
        ButtonGroup bgg = new ButtonGroup();
        bgg.add(jRadioHommeEmp1);
        bgg.add(jRadioFemmeEmp1);

        PromptSupport.setPrompt("Entrer le nom", txtNomEmp);
        PromptSupport.setPrompt("Entrer le prénom", txtPrenomEmp);
        PromptSupport.setPrompt("Entrer CIN ", txtCinEmp);
        PromptSupport.setPrompt("Entrer téléphonne", txtTelEmp);
        PromptSupport.setPrompt("Entrer Email", txtEmailEmp);
        PromptSupport.setPrompt("Entrer  l'adresse", txtAdresseEmp);
        PromptSupport.setPrompt("Entrer le nom d'utilisateur", txtNUEmp);
        PromptSupport.setPrompt("Entrer le mot de passe", txtMpEmp);
        PromptSupport.setPrompt("Confirmer le mot de passe", txtCMpEmp);
    }
    
    
    public void viderEmp(){
         txtNomEmp.setText("");
        txtPrenomEmp.setText("");
        txtTelEmp.setText("");
        txtEmailEmp.setText("");
        txtNUEmp.setText("");
        txtMpEmp.setText("");
        txtCinEmp.setText("");
        txtCMpEmp.setText("");
        txtAdresseEmp.setText("");
    }

    public boolean verifierFieldEmp() {
        String nom = txtNomEmp.getText();
        String prenom = txtPrenomEmp.getText();
        String Cin = txtCinEmp.getText();
        String tel = txtTelEmp.getText();
        String Email = txtEmailEmp.getText();
        String adresse = txtAdresseEmp.getText();
        String NutilEmp = txtNUEmp.getText();
        String passe = String.valueOf(txtMpEmp.getPassword());
        String Cpasse = String.valueOf(txtCMpEmp.getPassword());

        if (nom.trim().equals("") || prenom.trim().equals("") || Cin.trim().equals("") || tel.trim().equals("")
                || Email.trim().equals("") || adresse.trim().equals("") || NutilEmp.trim().equals("")
                || passe.trim().equals("") || Cpasse.trim().equals("")) {

            JOptionPane.showMessageDialog(null, "Verifier les champs", "Champs vides", 2);
            return false;
        } else if (!passe.equals(Cpasse)) {
            JOptionPane.showMessageDialog(null, "les mots de passe ne sont pas identiques", "Confirmation du mot de passe", 2);
            return false;
        } else {
            return true;
        }
    }
public boolean verifierFieldEmp1() {
        String nom = txtNomEmp1.getText();
        String prenom = txtPrenomEmp1.getText();
        String Cin = txtCinEmp1.getText();
        String tel = txtTelEmp1.getText();
        String Email = txtEmailEmp1.getText();
        String adresse = txtAdresseEmp1.getText();
        String NutilEmp = txtNUEmp1.getText();
        String passe = String.valueOf(txtMpEmp1.getPassword());
        String Cpasse = String.valueOf(txtCMpEmp1.getPassword());

        if (nom.trim().equals("") || prenom.trim().equals("") || Cin.trim().equals("") || tel.trim().equals("")
                || Email.trim().equals("") || adresse.trim().equals("") || NutilEmp.trim().equals("")
                || passe.trim().equals("") || Cpasse.trim().equals("")) {

            JOptionPane.showMessageDialog(null, "Verifier les champs", "Champs vides", 2);
            return false;
        } else if (!passe.equals(Cpasse)) {
            JOptionPane.showMessageDialog(null, "les mots de passe ne sont pas identiques", "Confirmation du mot de passe", 2);
            return false;
        } else {
            return true;
        }
    }
    public boolean veifierUtilisateur(String NutilEmp) {
        Boolean utilisateur_existe = false;

        try {
            PreparedStatement pstmt = con.prepareStatement("select * from employe where NutilEmp=?");
            pstmt.setString(1, NutilEmp);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                utilisateur_existe = true;
                JOptionPane.showMessageDialog(null, "Employé existe", "Employé a echoué", 2);

            }

        } catch (SQLException ex) {
            Logger.getLogger(MainAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return utilisateur_existe;
    }

    public static void RemplirTableauEmp() {
        DefaultTableModel d = (DefaultTableModel) jTablemp.getModel();
        try {

            PreparedStatement pstmt = con.prepareStatement("select * from employe");

            ResultSet rs1 = pstmt.executeQuery();
            d.setRowCount(0);
            while (rs1.next()) {
                d.addRow(new Object[]{rs1.getString(2), rs1.getString(3), rs1.getString(4), rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9), rs1.getString(10)});
            }
            rs1.close();
            pstmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void afficheEmp() {

        try {
            PreparedStatement pstmt = con.prepareStatement("select * from employe where cinEmp=?");
            pstmt.setString(1, MainAdmin.tabemp);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                txtNUEmp1.setText(rs.getString("NutilEmp"));
                txtNomEmp1.setText(rs.getString("nomEmp"));
                txtPrenomEmp1.setText(rs.getString("prenomEmp"));
                txtEmailEmp1.setText(rs.getString("emailEmp"));
                txtAdresseEmp1.setText(rs.getString("adresseEmp"));
                if (rs.getString("sexeEmp").equals("Homme")) {
                    jRadioHommeEmp1.setSelected(true);
                } else {
                    jRadioFemmeEmp1.setSelected(true);
                }

                txtCinEmp1.setText(rs.getString("cinEmp"));
                txtTelEmp1.setText(rs.getString("telEmp"));
                txtMpEmp1.setText(rs.getString("MpEmp"));
                txtCMpEmp1.setText(rs.getString("MpEmp"));

            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MainAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
private void filteremp(String quer) {
    DefaultTableModel d = (DefaultTableModel) jTablemp.getModel();
    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(d);
    jTablemp.setRowSorter(tr);
    
    RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.orFilter(
            Arrays.asList(
            RowFilter.regexFilter("(?i)" + quer, 0), 
            RowFilter.regexFilter("(?i)" + quer, 1), 
            RowFilter.regexFilter("(?i)" + quer, 2),
            RowFilter.regexFilter("(?i)" + quer, 3),
            RowFilter.regexFilter("(?i)" + quer, 4),
            RowFilter.regexFilter("(?i)" + quer, 5),
            RowFilter.regexFilter("(?i)" + quer, 6),
            RowFilter.regexFilter("(?i)" + quer, 7)
        )
    );
    
    tr.setRowFilter(rowFilter);
}
    /*private void filteremp(String quer) {
        DefaultTableModel d = (DefaultTableModel) jTablemp.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(d);
        jTablemp.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(quer));

    }*/
public void HeaderJtable(){
    
        JTableHeader Theade = jTablemp.getTableHeader();
        Theade.setBackground(Color.red);
        Theade.setForeground(new Color(0,153,0));
        Theade.setFont(new Font("Tahome", Font.BOLD, 14));
        
           }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTitle = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanelButton = new javax.swing.JPanel();
        jb1 = new javax.swing.JButton();
        jb3 = new javax.swing.JButton();
        jb2 = new javax.swing.JButton();
        jb4 = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtSerchCll = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablemp = new javax.swing.JTable();
        btnSupprEmp = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        txtPrenomEmp = new javax.swing.JTextField();
        txtNomEmp = new javax.swing.JTextField();
        txtTelEmp = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNUEmp = new javax.swing.JTextField();
        txtEmailEmp = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCinEmp = new javax.swing.JTextField();
        jRadioHommeEmp = new javax.swing.JRadioButton();
        jRadioFemmeEmp = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAdresseEmp = new javax.swing.JTextArea();
        txtMpEmp = new javax.swing.JPasswordField();
        txtNU = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCMpEmp = new javax.swing.JPasswordField();
        jLabel18 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btnAjouterEmp = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        txtPrenomEmp1 = new javax.swing.JTextField();
        txtNomEmp1 = new javax.swing.JTextField();
        txtTelEmp1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtNUEmp1 = new javax.swing.JTextField();
        txtEmailEmp1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtCinEmp1 = new javax.swing.JTextField();
        jRadioHommeEmp1 = new javax.swing.JRadioButton();
        jRadioFemmeEmp1 = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAdresseEmp1 = new javax.swing.JTextArea();
        txtMpEmp1 = new javax.swing.JPasswordField();
        txtNU1 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtCMpEmp1 = new javax.swing.JPasswordField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        btnMiseàJourE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanelTitle.setBackground(new java.awt.Color(0, 153, 0));
        jPanelTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 0)));
        jPanelTitle.setFocusCycleRoot(true);
        jPanelTitle.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelTitleMouseDragged(evt);
            }
        });
        jPanelTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelTitleMousePressed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(255, 255, 255));
        exit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_20px_1.png"))); // NOI18N
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_minus_20px_1.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ESPACE ADMINISTRATIF");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo_transparent (8).png"))); // NOI18N

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitleLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGroup(jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelTitleLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelButton.setBackground(new java.awt.Color(221, 255, 221));
        jPanelButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));

        jb1.setBackground(new java.awt.Color(255, 255, 153));
        jb1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_employee_30px.png"))); // NOI18N
        jb1.setText("Employes");
        jb1.setBorder(null);
        jb1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb1.setFocusPainted(false);
        jb1.setFocusable(false);
        jb1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jb1MouseDragged(evt);
            }
        });
        jb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jb1MouseClicked(evt);
            }
        });
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1ActionPerformed(evt);
            }
        });

        jb3.setBackground(new java.awt.Color(255, 255, 153));
        jb3.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jb3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_update_30px.png"))); // NOI18N
        jb3.setText("Update Employe");
        jb3.setBorder(null);
        jb3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb3.setFocusPainted(false);
        jb3.setFocusable(false);
        jb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb3ActionPerformed(evt);
            }
        });

        jb2.setBackground(new java.awt.Color(255, 255, 153));
        jb2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_user_male_30px.png"))); // NOI18N
        jb2.setText("Add Employe");
        jb2.setBorder(null);
        jb2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb2.setFocusPainted(false);
        jb2.setFocusable(false);
        jb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb2ActionPerformed(evt);
            }
        });

        jb4.setBackground(new java.awt.Color(255, 255, 153));
        jb4.setFont(new java.awt.Font("Arial Black", 1, 21)); // NOI18N
        jb4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_exit_30px.png"))); // NOI18N
        jb4.setText("Déconnexion");
        jb4.setBorder(null);
        jb4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb4.setFocusPainted(false);
        jb4.setFocusable(false);
        jb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jb4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jb4MouseExited(evt);
            }
        });
        jb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelButtonLayout = new javax.swing.GroupLayout(jPanelButton);
        jPanelButton.setLayout(jPanelButtonLayout);
        jPanelButtonLayout.setHorizontalGroup(
            jPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonLayout.createSequentialGroup()
                .addComponent(jb1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jb2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jb3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jb4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelButtonLayout.setVerticalGroup(
            jPanelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jb4, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
            .addComponent(jb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jb3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLayeredPane2.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(221, 255, 221));
        jPanel2.setPreferredSize(new java.awt.Dimension(1178, 500));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Rechercher employé:");

        txtSerchCll.setBackground(new java.awt.Color(255, 255, 204));
        txtSerchCll.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSerchCll.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtSerchCll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerchCllActionPerformed(evt);
            }
        });
        txtSerchCll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSerchCllKeyReleased(evt);
            }
        });

        jTablemp.setBackground(new java.awt.Color(255, 255, 153));
        jTablemp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));
        jTablemp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTablemp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prénom", "Cin", "Tél", "Adresse", "Email", "Sexe"
            }
        ));
        jTablemp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTablemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablempMousePressed(evt);
            }
        });
        jTablemp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablempKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTablemp);

        btnSupprEmp.setBackground(new java.awt.Color(66, 160, 66));
        btnSupprEmp.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnSupprEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_user_male_30px_1.png"))); // NOI18N
        btnSupprEmp.setText("Supprimer");
        btnSupprEmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSupprEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSupprEmpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSupprEmpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSupprEmpMouseExited(evt);
            }
        });
        btnSupprEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprEmpActionPerformed(evt);
            }
        });

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_25px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5)
                        .addGap(50, 50, 50)
                        .addComponent(txtSerchCll, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel45)
                        .addGap(0, 631, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSupprEmp)
                .addGap(462, 462, 462))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtSerchCll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSupprEmp)
                .addContainerGap())
        );

        jLayeredPane2.add(jPanel2, "card2");

        jPanel4.setBackground(new java.awt.Color(221, 255, 221));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txtPrenomEmp.setBackground(new java.awt.Color(255, 255, 204));
        txtPrenomEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPrenomEmp.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtPrenomEmp.setCaretColor(new java.awt.Color(0, 153, 0));
        txtPrenomEmp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrenomEmpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrenomEmpFocusLost(evt);
            }
        });
        txtPrenomEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrenomEmpActionPerformed(evt);
            }
        });

        txtNomEmp.setBackground(new java.awt.Color(255, 255, 204));
        txtNomEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNomEmp.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtNomEmp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomEmpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomEmpFocusLost(evt);
            }
        });
        txtNomEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomEmpActionPerformed(evt);
            }
        });

        txtTelEmp.setBackground(new java.awt.Color(255, 255, 204));
        txtTelEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTelEmp.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtTelEmp.setCaretColor(new java.awt.Color(0, 153, 0));
        txtTelEmp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelEmpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelEmpFocusLost(evt);
            }
        });
        txtTelEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelEmpActionPerformed(evt);
            }
        });
        txtTelEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelEmpKeyTyped(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setText("Email:");

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

        txtNUEmp.setBackground(new java.awt.Color(255, 255, 204));
        txtNUEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNUEmp.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtNUEmp.setCaretColor(new java.awt.Color(0, 153, 0));
        txtNUEmp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNUEmpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNUEmpFocusLost(evt);
            }
        });
        txtNUEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNUEmpActionPerformed(evt);
            }
        });

        txtEmailEmp.setBackground(new java.awt.Color(255, 255, 204));
        txtEmailEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEmailEmp.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtEmailEmp.setCaretColor(new java.awt.Color(0, 153, 0));
        txtEmailEmp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailEmpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailEmpFocusLost(evt);
            }
        });
        txtEmailEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailEmpActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Sexe:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Mot de passe:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Confirmer mot de passe:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Nom d'utilisateur:");

        txtCinEmp.setBackground(new java.awt.Color(255, 255, 204));
        txtCinEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCinEmp.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtCinEmp.setCaretColor(new java.awt.Color(0, 153, 0));
        txtCinEmp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCinEmpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCinEmpFocusLost(evt);
            }
        });
        txtCinEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCinEmpActionPerformed(evt);
            }
        });

        jRadioHommeEmp.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRadioHommeEmp.setSelected(true);
        jRadioHommeEmp.setText("Homme");
        jRadioHommeEmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jRadioFemmeEmp.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRadioFemmeEmp.setText("Femme");
        jRadioFemmeEmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtAdresseEmp.setBackground(new java.awt.Color(255, 255, 204));
        txtAdresseEmp.setColumns(20);
        txtAdresseEmp.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtAdresseEmp.setRows(5);
        txtAdresseEmp.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtAdresseEmp.setCaretColor(new java.awt.Color(0, 153, 0));
        jScrollPane1.setViewportView(txtAdresseEmp);

        txtMpEmp.setBackground(new java.awt.Color(255, 255, 204));
        txtMpEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMpEmp.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtMpEmp.setCaretColor(new java.awt.Color(0, 153, 0));
        txtMpEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMpEmpActionPerformed(evt);
            }
        });

        txtNU.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_30px_1.png"))); // NOI18N

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_validation_30px.png"))); // NOI18N

        txtCMpEmp.setBackground(new java.awt.Color(255, 255, 204));
        txtCMpEmp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCMpEmp.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtCMpEmp.setCaretColor(new java.awt.Color(0, 153, 0));
        txtCMpEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCMpEmpActionPerformed(evt);
            }
        });

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_password_30px_1.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_phone_30px_2.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_email_30px.png"))); // NOI18N

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_businesswoman_25px.png"))); // NOI18N
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_25px.png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_home_address_30px.png"))); // NOI18N

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_identification_documents_30px.png"))); // NOI18N

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_30px.png"))); // NOI18N

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_30px.png"))); // NOI18N

        btnAjouterEmp.setBackground(new java.awt.Color(66, 160, 66));
        btnAjouterEmp.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnAjouterEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_30px_2.png"))); // NOI18N
        btnAjouterEmp.setText("Ajouter");
        btnAjouterEmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAjouterEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAjouterEmpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAjouterEmpMouseExited(evt);
            }
        });
        btnAjouterEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterEmpActionPerformed(evt);
            }
        });

        btnAnnuler.setBackground(new java.awt.Color(66, 160, 66));
        btnAnnuler.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_cancel_30px.png"))); // NOI18N
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(199, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmailEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioHommeEmp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jRadioFemmeEmp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrenomEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCinEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtMpEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCMpEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtNU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNUEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15))
                .addGap(158, 158, 158))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(btnAjouterEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnnuler))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)))
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNU, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNUEmp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMpEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCMpEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(txtNomEmp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(txtPrenomEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCinEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmailEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioHommeEmp)
                            .addComponent(jLabel19)
                            .addComponent(jRadioFemmeEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAjouterEmp)
                    .addComponent(btnAnnuler))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane2.add(jPanel4, "card5");

        jPanel5.setBackground(new java.awt.Color(221, 255, 221));
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel5MouseDragged(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txtPrenomEmp1.setBackground(new java.awt.Color(255, 255, 204));
        txtPrenomEmp1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPrenomEmp1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtPrenomEmp1.setCaretColor(new java.awt.Color(0, 153, 0));
        txtPrenomEmp1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrenomEmp1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrenomEmp1FocusLost(evt);
            }
        });
        txtPrenomEmp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrenomEmp1ActionPerformed(evt);
            }
        });

        txtNomEmp1.setBackground(new java.awt.Color(255, 255, 204));
        txtNomEmp1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNomEmp1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtNomEmp1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomEmp1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomEmp1FocusLost(evt);
            }
        });
        txtNomEmp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomEmp1ActionPerformed(evt);
            }
        });

        txtTelEmp1.setBackground(new java.awt.Color(255, 255, 204));
        txtTelEmp1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTelEmp1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtTelEmp1.setCaretColor(new java.awt.Color(0, 153, 0));
        txtTelEmp1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelEmp1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelEmp1FocusLost(evt);
            }
        });
        txtTelEmp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelEmp1ActionPerformed(evt);
            }
        });
        txtTelEmp1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelEmp1KeyTyped(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setText("Email:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("CIN:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("Nom:");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setText("Prénom:");

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setText("Télephone:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setText("Adresse:");

        txtNUEmp1.setBackground(new java.awt.Color(255, 255, 204));
        txtNUEmp1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNUEmp1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtNUEmp1.setCaretColor(new java.awt.Color(0, 153, 0));
        txtNUEmp1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNUEmp1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNUEmp1FocusLost(evt);
            }
        });
        txtNUEmp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNUEmp1ActionPerformed(evt);
            }
        });

        txtEmailEmp1.setBackground(new java.awt.Color(255, 255, 204));
        txtEmailEmp1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtEmailEmp1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtEmailEmp1.setCaretColor(new java.awt.Color(0, 153, 0));
        txtEmailEmp1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailEmp1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailEmp1FocusLost(evt);
            }
        });
        txtEmailEmp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailEmp1ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setText("Sexe:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setText("Mot de passe:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setText("Confirmer mot de passe:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setText("Nom d'utilisateur:");

        txtCinEmp1.setBackground(new java.awt.Color(255, 255, 204));
        txtCinEmp1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCinEmp1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtCinEmp1.setCaretColor(new java.awt.Color(0, 153, 0));
        txtCinEmp1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCinEmp1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCinEmp1FocusLost(evt);
            }
        });
        txtCinEmp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCinEmp1ActionPerformed(evt);
            }
        });

        jRadioHommeEmp1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRadioHommeEmp1.setSelected(true);
        jRadioHommeEmp1.setText("Homme");
        jRadioHommeEmp1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jRadioFemmeEmp1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jRadioFemmeEmp1.setText("Femme");
        jRadioFemmeEmp1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtAdresseEmp1.setBackground(new java.awt.Color(255, 255, 204));
        txtAdresseEmp1.setColumns(20);
        txtAdresseEmp1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        txtAdresseEmp1.setRows(5);
        txtAdresseEmp1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtAdresseEmp1.setCaretColor(new java.awt.Color(0, 153, 0));
        jScrollPane3.setViewportView(txtAdresseEmp1);

        txtMpEmp1.setBackground(new java.awt.Color(255, 255, 204));
        txtMpEmp1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMpEmp1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtMpEmp1.setCaretColor(new java.awt.Color(0, 153, 0));
        txtMpEmp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMpEmp1ActionPerformed(evt);
            }
        });

        txtNU1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtNU1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_30px_1.png"))); // NOI18N

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_validation_30px.png"))); // NOI18N

        txtCMpEmp1.setBackground(new java.awt.Color(255, 255, 204));
        txtCMpEmp1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCMpEmp1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtCMpEmp1.setCaretColor(new java.awt.Color(0, 153, 0));
        txtCMpEmp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCMpEmp1ActionPerformed(evt);
            }
        });

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_password_30px_1.png"))); // NOI18N

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_phone_30px_2.png"))); // NOI18N

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_email_30px.png"))); // NOI18N

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_businesswoman_25px.png"))); // NOI18N
        jLabel39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_25px.png"))); // NOI18N
        jLabel40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_home_address_30px.png"))); // NOI18N

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_identification_documents_30px.png"))); // NOI18N

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_30px.png"))); // NOI18N

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_name_30px.png"))); // NOI18N

        btnMiseàJourE.setBackground(new java.awt.Color(66, 160, 66));
        btnMiseàJourE.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnMiseàJourE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_update_30px_3.png"))); // NOI18N
        btnMiseàJourE.setText("Mettre à jour");
        btnMiseàJourE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMiseàJourE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMiseàJourEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMiseàJourEMouseExited(evt);
            }
        });
        btnMiseàJourE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMiseàJourEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(223, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrenomEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomEmp1))
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelEmp1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCinEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmailEmp1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioHommeEmp1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jRadioFemmeEmp1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel36)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtMpEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCMpEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtNU1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNUEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(200, 200, 200))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(btnMiseàJourE, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                                    .addComponent(txtNomEmp1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel43)
                                    .addComponent(txtPrenomEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCinEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEmailEmp1))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioHommeEmp1)
                                    .addComponent(jLabel40)
                                    .addComponent(jRadioFemmeEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)))
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNU1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNUEmp1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMpEmp1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCMpEmp1))))
                        .addGap(20, 20, 20))
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMiseàJourE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jLayeredPane2.add(jPanel5, "card5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1072, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setState(MainAdmin.ICONIFIED);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPanelTitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTitleMouseDragged
        this.setLocation(this.getX() + evt.getX() - mouseX, this.getY() + evt.getY() - mouseY);
    }//GEN-LAST:event_jPanelTitleMouseDragged

    private void jPanelTitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelTitleMousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_jPanelTitleMousePressed

    private void jb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb1ActionPerformed
        jb1.setBackground(new Color(221, 255, 221));
        jb2.setBackground(new Color(255, 255, 153));
        jb3.setBackground(new Color(255, 255, 153));
        jb4.setBackground(new Color(255, 255, 153));

        jLayeredPane2.removeAll();
        jLayeredPane2.add(jPanel2);
        jLayeredPane2.repaint();
        jLayeredPane2.revalidate();

    }//GEN-LAST:event_jb1ActionPerformed

    private void jb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb3ActionPerformed
        DefaultTableModel d = (DefaultTableModel) jTablemp.getModel();
        int row = -1;
        row = jTablemp.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner un employé");
            //this.setVisible(true);
        }else{
       
        
        jb3.setBackground(new Color(221, 255, 221));
        jb2.setBackground(new Color(255, 255, 153));
        jb1.setBackground(new Color(255, 255, 153));
        jb4.setBackground(new Color(255, 255, 153));
        
        
        jLayeredPane2.removeAll();
        jLayeredPane2.add(jPanel5);
        afficheEmp();
        jLayeredPane2.repaint();
        jLayeredPane2.revalidate();
        } 
        
        
        jLayeredPane2.revalidate();    }//GEN-LAST:event_jb3ActionPerformed

    private void jb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb2ActionPerformed
        jb2.setBackground(new Color(221, 255, 221));
        jb1.setBackground(new Color(255, 255, 153));
        jb3.setBackground(new Color(255, 255, 153));
        jb4.setBackground(new Color(255, 255, 153));

        jLayeredPane2.removeAll();
        jLayeredPane2.add(jPanel4);
        jLayeredPane2.repaint();
        jLayeredPane2.revalidate();
    }//GEN-LAST:event_jb2ActionPerformed

    private void jb4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb4MouseEntered
        jb4.setBackground(new Color(221, 255, 221));
    }//GEN-LAST:event_jb4MouseEntered

    private void jb4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb4MouseExited
        jb4.setBackground(new Color(255, 255, 153));
    }//GEN-LAST:event_jb4MouseExited

    private void jb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb4ActionPerformed
        Cnx cx = new Cnx();
        cx.setVisible(true);
        cx.pack();
        this.dispose();
    }//GEN-LAST:event_jb4ActionPerformed

    private void jb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jb1MouseClicked

    private void jb1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jb1MouseDragged

    private void txtSerchCllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerchCllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerchCllActionPerformed

    private void txtSerchCllKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerchCllKeyReleased
        String quer = txtSerchCll.getText().toLowerCase();

        filteremp(quer);
    }//GEN-LAST:event_txtSerchCllKeyReleased

    private void jTablempKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablempKeyReleased

    }//GEN-LAST:event_jTablempKeyReleased

    private void jTablempMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablempMousePressed
        DefaultTableModel d = (DefaultTableModel) jTablemp.getModel();
        int row = jTablemp.getSelectedRow();
        tabemp = (String) jTablemp.getModel().getValueAt(row, 2);
    }//GEN-LAST:event_jTablempMousePressed

    private void btnSupprEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupprEmpMouseClicked

    }//GEN-LAST:event_btnSupprEmpMouseClicked

    private void btnSupprEmpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupprEmpMouseEntered
        btnSupprEmp.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnSupprEmpMouseEntered

    private void btnSupprEmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupprEmpMouseExited
        btnSupprEmp.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnSupprEmpMouseExited

    private void btnSupprEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprEmpActionPerformed

        try {
            int row = -1;
            row = jTablemp.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner un employé");
            } else {
                int test = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer??");
                if (test == JOptionPane.YES_OPTION) {
                    PreparedStatement pstmt = con.prepareStatement("delete from employe where cinEmp=?");
                    pstmt.setString(1, tabemp);
                    pstmt.execute();
                    RemplirTableauEmp();
                } else {

                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(MainAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSupprEmpActionPerformed

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MousePressed

    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel5MouseDragged

    private void btnMiseàJourEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiseàJourEActionPerformed
        /* int row = -1;
        row = jTablemp.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un employé");
        } else {*/

            String nom = txtNomEmp1.getText();
            String prenom = txtPrenomEmp1.getText();
            String Cin = txtCinEmp1.getText();
            String tel = txtTelEmp1.getText();
            String Email = txtEmailEmp1.getText();
            String adresse = txtAdresseEmp1.getText();
            String Nutil = txtNUEmp1.getText();
            String passe = String.valueOf(txtMpEmp1.getPassword());
            String Cpasse = String.valueOf(txtCMpEmp1.getPassword());
            String sx = "Homme";
            if (jRadioFemmeEmp1.isSelected()) {
                sx = "Femme";
            }

            if (verifierFieldEmp1()) {
                try {
                    PreparedStatement pstmt = con.prepareStatement("update employe set nomEmp=?, prenomEmp=?, cinEmp=?, telEmp=?, emailEmp=?, adresseEmp=?, sexeEmp=?, NutilEmp=?, MpEmp=? where cinEmp=?");

                    pstmt.setString(1, nom);
                    pstmt.setString(2, prenom);
                    pstmt.setString(3, Cin);
                    pstmt.setString(4, tel);
                    pstmt.setString(5, Email);
                    pstmt.setString(6, adresse);
                    pstmt.setString(7, sx);
                    pstmt.setString(8, Nutil);
                    pstmt.setString(9, passe);
                    pstmt.setString(10, MainAdmin.tabemp);

                    if (pstmt.executeUpdate() != 0) {
                        JOptionPane.showMessageDialog(null, "Les informations ont été mises à jours");
                        /*MainAdmin ma = new MainAdmin();
                        ma.setVisible(true);
                        ma.pack();*/
                        MainAdmin.RemplirTableauEmp();
                        // this.dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Mise à jour a échoué");

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(MainAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            //this.dispose();
    }//GEN-LAST:event_btnMiseàJourEActionPerformed

    private void btnMiseàJourEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMiseàJourEMouseExited
        btnMiseàJourE.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnMiseàJourEMouseExited

    private void btnMiseàJourEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMiseàJourEMouseEntered
        btnMiseàJourE.setBackground(new Color(37, 116, 169));
    }//GEN-LAST:event_btnMiseàJourEMouseEntered

    private void txtCMpEmp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCMpEmp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCMpEmp1ActionPerformed

    private void txtMpEmp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMpEmp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMpEmp1ActionPerformed

    private void txtCinEmp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCinEmp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCinEmp1ActionPerformed

    private void txtCinEmp1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCinEmp1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCinEmp1FocusLost

    private void txtCinEmp1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCinEmp1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCinEmp1FocusGained

    private void txtEmailEmp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailEmp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailEmp1ActionPerformed

    private void txtEmailEmp1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailEmp1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailEmp1FocusLost

    private void txtEmailEmp1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailEmp1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailEmp1FocusGained

    private void txtNUEmp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNUEmp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNUEmp1ActionPerformed

    private void txtNUEmp1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNUEmp1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNUEmp1FocusLost

    private void txtNUEmp1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNUEmp1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNUEmp1FocusGained

    private void txtTelEmp1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelEmp1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelEmp1KeyTyped

    private void txtTelEmp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelEmp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelEmp1ActionPerformed

    private void txtTelEmp1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelEmp1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelEmp1FocusLost

    private void txtTelEmp1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelEmp1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelEmp1FocusGained

    private void txtNomEmp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomEmp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomEmp1ActionPerformed

    private void txtNomEmp1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomEmp1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomEmp1FocusLost

    private void txtNomEmp1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomEmp1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomEmp1FocusGained

    private void txtPrenomEmp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrenomEmp1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrenomEmp1ActionPerformed

    private void txtPrenomEmp1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrenomEmp1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrenomEmp1FocusLost

    private void txtPrenomEmp1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrenomEmp1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrenomEmp1FocusGained

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        mouseX = evt.getX();
        mouseY = evt.getY();
    }//GEN-LAST:event_jPanel4MousePressed

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        this.setLocation(this.getX() + evt.getX() - mouseX, this.getY() + evt.getY() - mouseY);
    }//GEN-LAST:event_jPanel4MouseDragged

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        txtNomEmp.setText("");
        txtPrenomEmp.setText("");
        txtTelEmp.setText("");
        txtEmailEmp.setText("");
        txtNUEmp.setText("");
        txtMpEmp.setText("");
        txtCinEmp.setText("");
        txtCMpEmp.setText("");
        txtAdresseEmp.setText("");
    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void btnAnnulerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnnulerMouseExited
        btnAnnuler.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnAnnulerMouseExited

    private void btnAnnulerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnnulerMouseEntered
        btnAnnuler.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnAnnulerMouseEntered

    private void btnAnnulerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnnulerMouseClicked

    }//GEN-LAST:event_btnAnnulerMouseClicked

    private void btnAjouterEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterEmpActionPerformed
        String nom = txtNomEmp.getText();
        String prenom = txtPrenomEmp.getText();
        String Cin = txtCinEmp.getText();
        String tel = txtTelEmp.getText();
        String Email = txtEmailEmp.getText();
        String adresse = txtAdresseEmp.getText();
        String NutilEmp = txtNUEmp.getText();
        String passe = String.valueOf(txtMpEmp.getPassword());
        String Cpasse = String.valueOf(txtCMpEmp.getPassword());
        String sexe = "Homme";
        if (jRadioFemmeEmp.isSelected()) {
            sexe = "Femme";
        }

        if (verifierFieldEmp()) {
            if (!veifierUtilisateur(NutilEmp)) {
                PreparedStatement pstmt;
                try {
                    pstmt = con.prepareStatement("insert into employe(nomEmp, prenomEmp, cinEmp, telEmp, emailEmp, adresseEmp, sexeEmp, NutilEmp, MpEmp) values (?,?,?,?,?,?,?,?,?)");
                    pstmt.setString(1, nom);
                    pstmt.setString(2, prenom);
                    pstmt.setString(3, Cin);
                    pstmt.setString(4, tel);
                    pstmt.setString(5, Email);
                    pstmt.setString(6, adresse);
                    pstmt.setString(7, sexe);
                    pstmt.setString(8, NutilEmp);
                    pstmt.setString(9, passe);

                    if (pstmt.executeUpdate() != 0) {
                        JOptionPane.showMessageDialog(null, "Employé a été ajouté avec succès");

                        MainAdmin.RemplirTableauEmp();
                        viderEmp();
                        promptEmp();

                    } else {
                        JOptionPane.showMessageDialog(null, "Erreur!!: Vérifiez vos informations");

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(MainAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }//GEN-LAST:event_btnAjouterEmpActionPerformed

    private void btnAjouterEmpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjouterEmpMouseExited
        btnAjouterEmp.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnAjouterEmpMouseExited

    private void btnAjouterEmpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjouterEmpMouseEntered
        btnAjouterEmp.setBackground(new Color(37, 116, 169));
    }//GEN-LAST:event_btnAjouterEmpMouseEntered

    private void txtCMpEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCMpEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCMpEmpActionPerformed

    private void txtMpEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMpEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMpEmpActionPerformed

    private void txtCinEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCinEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCinEmpActionPerformed

    private void txtCinEmpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCinEmpFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCinEmpFocusLost

    private void txtCinEmpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCinEmpFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCinEmpFocusGained

    private void txtEmailEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailEmpActionPerformed

    private void txtEmailEmpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailEmpFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailEmpFocusLost

    private void txtEmailEmpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailEmpFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailEmpFocusGained

    private void txtNUEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNUEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNUEmpActionPerformed

    private void txtNUEmpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNUEmpFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNUEmpFocusLost

    private void txtNUEmpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNUEmpFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNUEmpFocusGained

    private void txtTelEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelEmpKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelEmpKeyTyped

    private void txtTelEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelEmpActionPerformed

    private void txtTelEmpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelEmpFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelEmpFocusLost

    private void txtTelEmpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelEmpFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelEmpFocusGained

    private void txtNomEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomEmpActionPerformed

    private void txtNomEmpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomEmpFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomEmpFocusLost

    private void txtNomEmpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomEmpFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomEmpFocusGained

    private void txtPrenomEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrenomEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrenomEmpActionPerformed

    private void txtPrenomEmpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrenomEmpFocusLost

    }//GEN-LAST:event_txtPrenomEmpFocusLost

    private void txtPrenomEmpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrenomEmpFocusGained

    }//GEN-LAST:event_txtPrenomEmpFocusGained

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
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjouterEmp;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnMiseàJourE;
    private javax.swing.JButton btnSupprEmp;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelButton;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JRadioButton jRadioFemmeEmp;
    private javax.swing.JRadioButton jRadioFemmeEmp1;
    private javax.swing.JRadioButton jRadioHommeEmp;
    private javax.swing.JRadioButton jRadioHommeEmp1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    public static javax.swing.JTable jTablemp;
    private javax.swing.JButton jb1;
    private javax.swing.JButton jb2;
    private javax.swing.JButton jb3;
    private javax.swing.JButton jb4;
    private javax.swing.JTextArea txtAdresseEmp;
    private javax.swing.JTextArea txtAdresseEmp1;
    private javax.swing.JPasswordField txtCMpEmp;
    private javax.swing.JPasswordField txtCMpEmp1;
    private javax.swing.JTextField txtCinEmp;
    private javax.swing.JTextField txtCinEmp1;
    private javax.swing.JTextField txtEmailEmp;
    private javax.swing.JTextField txtEmailEmp1;
    private javax.swing.JPasswordField txtMpEmp;
    private javax.swing.JPasswordField txtMpEmp1;
    private javax.swing.JLabel txtNU;
    private javax.swing.JLabel txtNU1;
    private javax.swing.JTextField txtNUEmp;
    private javax.swing.JTextField txtNUEmp1;
    private javax.swing.JTextField txtNomEmp;
    private javax.swing.JTextField txtNomEmp1;
    private javax.swing.JTextField txtPrenomEmp;
    private javax.swing.JTextField txtPrenomEmp1;
    private javax.swing.JTextField txtSerchCll;
    private javax.swing.JTextField txtTelEmp;
    private javax.swing.JTextField txtTelEmp1;
    // End of variables declaration//GEN-END:variables

    private void affiche() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
