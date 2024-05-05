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
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.table.TableColumnModel;
/**
 *
 * @author intel
 */
public class MainEmployes extends javax.swing.JFrame {
    
        static Connection con = ConnectionUtil.getConnection();
        
        
        public static int tabclid;
        public static int tabPd;
         public static int tabPdSt;
         public static int tabPdal;
        public static double tabPdPrix;
        public static int tabPdStock;
        int mouseX = 0;
        int mouseY = 0;
    /**
     * Creates new form MainEmploye
     */
    public MainEmployes() {
        initComponents();
        RemplirTableauClient();
        RemplirTableauProduit();
        RemplirTableauVente();
        RemplirTableauProduitAlert();
        HeaderJtable();
        
         jbt1.setBackground(new Color(221, 255, 221));
        jLayeredPane1.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, new Color(0, 153, 0)));
        jPanelBoutton.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, new Color(0, 153, 0)));
        jPanelTitle.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 153, 0)));
        
        
         TableColumnModel tcIDp = jTablePd.getColumnModel();
         tcIDp.removeColumn(tcIDp.getColumn(0));
        
         TableColumnModel tcIDcl = jTableClEmp.getColumnModel();
         tcIDcl.removeColumn(tcIDcl.getColumn(0));
         
         TableColumnModel tcIDv = jTableVente.getColumnModel();
         tcIDv.removeColumn(tcIDv.getColumn(0));
         
         TableColumnModel tcIDpa = jTablePdAl.getColumnModel();
         tcIDpa.removeColumn(tcIDpa.getColumn(0));
        
    }
      public static void RemplirTableauClient() {

        DefaultTableModel d = (DefaultTableModel) jTableClEmp.getModel();

        try {
            PreparedStatement pstmt = con.prepareStatement("select * from client");

            ResultSet rs2;

            rs2 = pstmt.executeQuery();

            d.setRowCount(0);
            while (rs2.next()) {
                d.addRow(new Object[]{rs2.getInt(1),rs2.getString(2), rs2.getString(3), rs2.getString(4), rs2.getString(5), rs2.getString(6), rs2.getString(7), rs2.getString(8)});
            }
            rs2.close();
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(MainEmployes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public static void RemplirTableauProduit() {

        DefaultTableModel d = (DefaultTableModel) jTablePd.getModel();

        try {
            PreparedStatement pstmt = con.prepareStatement("select * from Produit");

            ResultSet rs2;

            rs2 = pstmt.executeQuery();

            d.setRowCount(0);
            while (rs2.next()) {
                d.addRow(new Object[]{rs2.getInt("idpd"), rs2.getString("refpd"),rs2.getString("nompd"),rs2.getString("categorie") ,rs2.getString("description"),rs2.getDouble("prixu"),rs2.getInt("quantite")});
            }
            rs2.close();
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(MainEmployes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public static void RemplirTableauProduitAlert() {

        DefaultTableModel d = (DefaultTableModel) jTablePdAl.getModel();

        try {
            PreparedStatement pstmt = con.prepareStatement("select * from Produit where quantite<10");

            ResultSet rs2;

            rs2 = pstmt.executeQuery();

            d.setRowCount(0);
            while (rs2.next()) {
                d.addRow(new Object[]{rs2.getInt("idpd"), rs2.getString("refpd"),rs2.getString("nompd"),rs2.getString("categorie") ,rs2.getString("description"),rs2.getDouble("prixu"),rs2.getInt("quantite")});
            }
            rs2.close();
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(MainEmployes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
        public static void RemplirTableauVente() {

        DefaultTableModel d = (DefaultTableModel) jTableVente.getModel();

        try {
            PreparedStatement pstmt = con.prepareStatement("select * from Produit join vente using(idpd) join client using(idcl)");

            ResultSet rs2;

            rs2 = pstmt.executeQuery();

            d.setRowCount(0);
            while (rs2.next()) {
                d.addRow(new Object[]{rs2.getInt("idv"),rs2.getString("nomcl"), rs2.getString("prenomcl"),rs2.getString("cincl"),rs2.getString("refpd") ,rs2.getInt("qantitev"),rs2.getDouble("prixu"),rs2.getDouble("prixt")});
            }
            rs2.close();
            pstmt.close();

        } catch (SQLException ex) {
            Logger.getLogger(MainEmployes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      /* 
     private void filterClient(String query) {
        DefaultTableModel d = (DefaultTableModel) jTableClEmp.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(d);
        jTableClEmp.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
     private void filterVenteAl(String query) {
        DefaultTableModel d = (DefaultTableModel) jTablePdAl.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(d);
        jTablePdAl.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
      private void filterProduit(String query) {
        DefaultTableModel d = (DefaultTableModel) jTablePd.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(d);
        jTablePd.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
      private void filterVente(String query) {
        DefaultTableModel d = (DefaultTableModel) jTableVente.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(d);
        jTableVente.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }*/
       private void filterClient(String query) {
    DefaultTableModel d = (DefaultTableModel) jTableClEmp.getModel();
    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(d);
    jTableClEmp.setRowSorter(tr);
    
    RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.orFilter(
            Arrays.asList(
            RowFilter.regexFilter("(?i)" + query, 0), 
            RowFilter.regexFilter("(?i)" + query, 1), 
            RowFilter.regexFilter("(?i)" + query, 2),
            RowFilter.regexFilter("(?i)" + query, 3),
            RowFilter.regexFilter("(?i)" + query, 4),
            RowFilter.regexFilter("(?i)" + query, 5),
            RowFilter.regexFilter("(?i)" + query, 6),
            RowFilter.regexFilter("(?i)" + query, 7)
        )
    );
    
    tr.setRowFilter(rowFilter);
} 
 
   private void filterVenteAl(String query) {
    DefaultTableModel d = (DefaultTableModel) jTablePdAl.getModel();
    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(d);
    jTablePdAl.setRowSorter(tr);
    
    RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.orFilter(
            Arrays.asList(
            RowFilter.regexFilter("(?i)" + query, 0), 
            RowFilter.regexFilter("(?i)" + query, 1), 
            RowFilter.regexFilter("(?i)" + query, 2),
            RowFilter.regexFilter("(?i)" + query, 3),
            RowFilter.regexFilter("(?i)" + query, 4),
            RowFilter.regexFilter("(?i)" + query, 5),
            RowFilter.regexFilter("(?i)" + query, 6),
            RowFilter.regexFilter("(?i)" + query, 7)
        )
    );
    
    tr.setRowFilter(rowFilter);
} 
   
    private void filterProduit(String query) {
    DefaultTableModel d = (DefaultTableModel) jTablePd.getModel();
    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(d);
    jTablePd.setRowSorter(tr);
    
    RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.orFilter(
            Arrays.asList(
            RowFilter.regexFilter("(?i)" + query, 0), 
            RowFilter.regexFilter("(?i)" + query, 1), 
            RowFilter.regexFilter("(?i)" + query, 2),
            RowFilter.regexFilter("(?i)" + query, 3),
            RowFilter.regexFilter("(?i)" + query, 4),
            RowFilter.regexFilter("(?i)" + query, 5),
            RowFilter.regexFilter("(?i)" + query, 6),
            RowFilter.regexFilter("(?i)" + query, 7)
        )
    );
    
    tr.setRowFilter(rowFilter);
} 
    
     private void filterVente(String query) {
    DefaultTableModel d = (DefaultTableModel) jTableVente.getModel();
    TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(d);
    jTableVente.setRowSorter(tr);
    
    RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.orFilter(
            Arrays.asList(
            RowFilter.regexFilter("(?i)" + query, 0), 
            RowFilter.regexFilter("(?i)" + query, 1), 
            RowFilter.regexFilter("(?i)" + query, 2),
            RowFilter.regexFilter("(?i)" + query, 3),
            RowFilter.regexFilter("(?i)" + query, 4),
            RowFilter.regexFilter("(?i)" + query, 5),
            RowFilter.regexFilter("(?i)" + query, 6),
            RowFilter.regexFilter("(?i)" + query, 7)
        )
    );
    
    tr.setRowFilter(rowFilter);
} 
  
       
        
     public void HeaderJtable(){
        JTableHeader Theader = jTablePdAl.getTableHeader();
        Theader.setBackground(Color.red);
        Theader.setForeground(new Color(0,153,0));
        Theader.setFont(new Font("Tahome", Font.BOLD, 14));
        
        JTableHeader Theade = jTableClEmp.getTableHeader();
        Theade.setBackground(Color.red);
        Theade.setForeground(new Color(0,153,0));
        Theade.setFont(new Font("Tahome", Font.BOLD, 14));
        
         JTableHeader Thead = jTablePd.getTableHeader();
        Thead.setBackground(Color.red);
        Thead.setForeground(new Color(0,153,0));
        Thead.setFont(new Font("Tahome", Font.BOLD, 14));
        
        JTableHeader Theaders = jTableVente.getTableHeader();
        Theaders.setBackground(Color.red);
        Theaders.setForeground(new Color(0,153,0));
        Theaders.setFont(new Font("Tahome", Font.BOLD, 14));
        
                
        
           }
     public boolean verifierFieldVente() {
        String nom = txtclientV.getText();
        String ref = txtrefpd.getText();
        int nbr = (int) spnqtPd.getValue();
        

     if (nom.trim().equals("") && ref.trim().equals("") && nbr==0){
         JOptionPane.showMessageDialog(null, "Veuillez verifier les champs", "Champs vides", 2);
         
         
         
     }else if (ref.trim().equals("")){
         JOptionPane.showMessageDialog(null, "Veuillez choisir un produit", "Champs vides", 2);
         
         return false;
     }
     
          else if (nbr==0){
         JOptionPane.showMessageDialog(null, "Veuillez choisir la quantité", "Champs vides", 2);
         
         return false;
     }   
          else if (nom.trim().equals("")){
         JOptionPane.showMessageDialog(null, "Veuillez choisir un client", "Champs vides", 2);
         
         return false;
     }   
           else if (nbr>MainEmployes.tabPdStock){
         JOptionPane.showMessageDialog(null, "Stock insuffisant!", "Stock", 2);
         
         return false;
     }   

      else {
            return true;
            
        }
     return false;
    }
     
     
      public boolean verifierFieldStock() {
        int nbr = (int) spnqtPd1.getValue();
        

     
     
          if (nbr==0){
         JOptionPane.showMessageDialog(null, "Veuillez choisir le nouveau stock", "Stock", 2);
         
         return false;
     
          }
      else {
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

        jPanelTitle = new javax.swing.JPanel();
        exit = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanelBoutton = new javax.swing.JPanel();
        jbt2 = new javax.swing.JButton();
        jbt1 = new javax.swing.JButton();
        jbt4 = new javax.swing.JButton();
        jbt5 = new javax.swing.JButton();
        jbt3 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanelcl = new javax.swing.JPanel();
        pnl6 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnNouveauCl2 = new javax.swing.JButton();
        btnUpdateC = new javax.swing.JButton();
        btnSuppC = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClEmp = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jPanelpd = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePd = new javax.swing.JTable();
        btnNouveauCl3 = new javax.swing.JButton();
        btnUpdateC1 = new javax.swing.JButton();
        btnSuppC1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jRecherchePd = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jPanelavert = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePdAl = new javax.swing.JTable();
        btnMiseàJourE = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        spnqtPd1 = new javax.swing.JSpinner();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jRechercheVente1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanelVente = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableVente = new javax.swing.JTable();
        btnNouveauCl5 = new javax.swing.JButton();
        btnNouveauCl6 = new javax.swing.JButton();
        spnqtPd = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        btnNouveauVente = new javax.swing.JButton();
        txtrefpd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtclientV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jRechercheVente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnBillet1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanelTitle.setBackground(new java.awt.Color(0, 153, 0));
        jPanelTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));
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
        jLabel6.setText("ESPACE EMPLOYE");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo_transparent (8).png"))); // NOI18N

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitleLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exit))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGroup(jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGroup(jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelBoutton.setBackground(new java.awt.Color(221, 255, 221));
        jPanelBoutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));

        jbt2.setBackground(new java.awt.Color(255, 255, 153));
        jbt2.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jbt2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_product_30px.png"))); // NOI18N
        jbt2.setText("Produit");
        jbt2.setBorder(null);
        jbt2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbt2.setFocusPainted(false);
        jbt2.setFocusable(false);
        jbt2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jbt2MouseDragged(evt);
            }
        });
        jbt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbt2MouseClicked(evt);
            }
        });
        jbt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt2ActionPerformed(evt);
            }
        });

        jbt1.setBackground(new java.awt.Color(255, 255, 153));
        jbt1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jbt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_30px_1.png"))); // NOI18N
        jbt1.setText("Client");
        jbt1.setBorder(null);
        jbt1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbt1.setFocusPainted(false);
        jbt1.setFocusable(false);
        jbt1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jbt1MouseDragged(evt);
            }
        });
        jbt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbt1MouseClicked(evt);
            }
        });
        jbt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt1ActionPerformed(evt);
            }
        });

        jbt4.setBackground(new java.awt.Color(255, 255, 153));
        jbt4.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jbt4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_brake_warning_30px.png"))); // NOI18N
        jbt4.setText("Avertissement");
        jbt4.setBorder(null);
        jbt4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbt4.setFocusPainted(false);
        jbt4.setFocusable(false);
        jbt4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jbt4MouseDragged(evt);
            }
        });
        jbt4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbt4MouseClicked(evt);
            }
        });
        jbt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt4ActionPerformed(evt);
            }
        });

        jbt5.setBackground(new java.awt.Color(255, 255, 153));
        jbt5.setFont(new java.awt.Font("Arial Black", 1, 21)); // NOI18N
        jbt5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_exit_30px.png"))); // NOI18N
        jbt5.setText("Déconnexion");
        jbt5.setBorder(null);
        jbt5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbt5.setFocusPainted(false);
        jbt5.setFocusable(false);
        jbt5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbt5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbt5MouseExited(evt);
            }
        });
        jbt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt5ActionPerformed(evt);
            }
        });

        jbt3.setBackground(new java.awt.Color(255, 255, 153));
        jbt3.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jbt3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_sell_30px_1.png"))); // NOI18N
        jbt3.setText("Vente");
        jbt3.setBorder(null);
        jbt3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbt3.setFocusPainted(false);
        jbt3.setFocusable(false);
        jbt3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jbt3MouseDragged(evt);
            }
        });
        jbt3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbt3MouseClicked(evt);
            }
        });
        jbt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBouttonLayout = new javax.swing.GroupLayout(jPanelBoutton);
        jPanelBoutton.setLayout(jPanelBouttonLayout);
        jPanelBouttonLayout.setHorizontalGroup(
            jPanelBouttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBouttonLayout.createSequentialGroup()
                .addComponent(jbt1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jbt2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jbt3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jbt4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jbt5, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanelBouttonLayout.setVerticalGroup(
            jPanelBouttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbt5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBouttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jbt1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbt2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbt3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbt4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        jPanelcl.setBackground(new java.awt.Color(221, 255, 221));

        pnl6.setBackground(new java.awt.Color(221, 255, 221));

        btnNouveauCl2.setBackground(new java.awt.Color(66, 160, 66));
        btnNouveauCl2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnNouveauCl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_user_male_30px_1.png"))); // NOI18N
        btnNouveauCl2.setText("Nouveau client");
        btnNouveauCl2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNouveauCl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNouveauCl2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNouveauCl2MouseExited(evt);
            }
        });
        btnNouveauCl2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNouveauCl2ActionPerformed(evt);
            }
        });

        btnUpdateC.setBackground(new java.awt.Color(66, 160, 66));
        btnUpdateC.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnUpdateC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_update_30px_3.png"))); // NOI18N
        btnUpdateC.setText("Mise à jour");
        btnUpdateC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateCMouseExited(evt);
            }
        });
        btnUpdateC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCActionPerformed(evt);
            }
        });

        btnSuppC.setBackground(new java.awt.Color(66, 160, 66));
        btnSuppC.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnSuppC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_user_male_30px_1.png"))); // NOI18N
        btnSuppC.setText("Supprimer");
        btnSuppC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuppC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuppCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSuppCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSuppCMouseExited(evt);
            }
        });
        btnSuppC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl6Layout = new javax.swing.GroupLayout(pnl6);
        pnl6.setLayout(pnl6Layout);
        pnl6Layout.setHorizontalGroup(
            pnl6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl6Layout.createSequentialGroup()
                .addGroup(pnl6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl6Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(btnNouveauCl2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnUpdateC, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnSuppC))
                    .addGroup(pnl6Layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        pnl6Layout.setVerticalGroup(
            pnl6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnl6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNouveauCl2)
                    .addComponent(btnUpdateC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuppC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Rechercher Client:");

        jTextField1.setBackground(new java.awt.Color(255, 255, 204));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTableClEmp.setBackground(new java.awt.Color(255, 255, 153));
        jTableClEmp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));
        jTableClEmp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableClEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idcl", "Nom", "Prénom", "Cin", "Tél", "Adresse", "Email", "Sexe"
            }
        ));
        jTableClEmp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableClEmp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClEmpMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableClEmpMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClEmp);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_25px.png"))); // NOI18N

        javax.swing.GroupLayout jPanelclLayout = new javax.swing.GroupLayout(jPanelcl);
        jPanelcl.setLayout(jPanelclLayout);
        jPanelclLayout.setHorizontalGroup(
            jPanelclLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelclLayout.createSequentialGroup()
                .addGroup(jPanelclLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelclLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelclLayout.createSequentialGroup()
                        .addContainerGap(97, Short.MAX_VALUE)
                        .addComponent(pnl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanelclLayout.setVerticalGroup(
            jPanelclLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelclLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanelclLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelclLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.add(jPanelcl, "card2");

        jPanelpd.setBackground(new java.awt.Color(221, 255, 221));

        jTablePd.setBackground(new java.awt.Color(255, 255, 153));
        jTablePd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));
        jTablePd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTablePd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idP", "Réference", "Nom", "Catégorie", "Description", "Prix Unitaire (DH)", "Stock"
            }
        ));
        jTablePd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTablePd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePdMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablePdMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTablePd);

        btnNouveauCl3.setBackground(new java.awt.Color(66, 160, 66));
        btnNouveauCl3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnNouveauCl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_to_inbox_30px_1.png"))); // NOI18N
        btnNouveauCl3.setText("Nouveau Produit");
        btnNouveauCl3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNouveauCl3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNouveauCl3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNouveauCl3MouseExited(evt);
            }
        });
        btnNouveauCl3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNouveauCl3ActionPerformed(evt);
            }
        });

        btnUpdateC1.setBackground(new java.awt.Color(66, 160, 66));
        btnUpdateC1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnUpdateC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_product_30px_1.png"))); // NOI18N
        btnUpdateC1.setText("Mise à jour");
        btnUpdateC1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateC1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateC1MouseExited(evt);
            }
        });
        btnUpdateC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateC1ActionPerformed(evt);
            }
        });

        btnSuppC1.setBackground(new java.awt.Color(66, 160, 66));
        btnSuppC1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnSuppC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_used_product_30px.png"))); // NOI18N
        btnSuppC1.setText("Supprimer");
        btnSuppC1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuppC1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuppC1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSuppC1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSuppC1MouseExited(evt);
            }
        });
        btnSuppC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppC1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Rechercher Produit:");

        jRecherchePd.setBackground(new java.awt.Color(255, 255, 204));
        jRecherchePd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRecherchePd.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        jRecherchePd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRecherchePdActionPerformed(evt);
            }
        });
        jRecherchePd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jRecherchePdKeyReleased(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_25px.png"))); // NOI18N

        javax.swing.GroupLayout jPanelpdLayout = new javax.swing.GroupLayout(jPanelpd);
        jPanelpd.setLayout(jPanelpdLayout);
        jPanelpdLayout.setHorizontalGroup(
            jPanelpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelpdLayout.createSequentialGroup()
                .addGroup(jPanelpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelpdLayout.createSequentialGroup()
                        .addGroup(jPanelpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelpdLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jRecherchePd, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14))
                            .addGroup(jPanelpdLayout.createSequentialGroup()
                                .addGap(289, 289, 289)
                                .addComponent(btnNouveauCl3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnUpdateC1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnSuppC1)))
                        .addGap(0, 234, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelpdLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(286, 286, 286))
            .addGroup(jPanelpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelpdLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelpdLayout.setVerticalGroup(
            jPanelpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelpdLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanelpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jRecherchePd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanelpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNouveauCl3)
                    .addComponent(btnUpdateC1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuppC1))
                .addGap(172, 172, 172))
            .addGroup(jPanelpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelpdLayout.createSequentialGroup()
                    .addGap(0, 332, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 332, Short.MAX_VALUE)))
        );

        jLayeredPane1.add(jPanelpd, "card3");

        jPanelavert.setBackground(new java.awt.Color(221, 255, 221));

        jTablePdAl.setBackground(new java.awt.Color(255, 51, 51));
        jTablePdAl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));
        jTablePdAl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTablePdAl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idP", "Réference", "Nom", "Catégorie", "Description", "Prix Unitaire (DH)", "Stock"
            }
        ));
        jTablePdAl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTablePdAl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePdAlMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTablePdAlMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTablePdAl);

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

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Booster Stock:");

        spnqtPd1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        spnqtPd1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnqtPd1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        spnqtPd1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Recherche Vente:");

        jRechercheVente1.setBackground(new java.awt.Color(255, 255, 204));
        jRechercheVente1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRechercheVente1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        jRechercheVente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRechercheVente1ActionPerformed(evt);
            }
        });
        jRechercheVente1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jRechercheVente1KeyReleased(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_25px.png"))); // NOI18N

        javax.swing.GroupLayout jPanelavertLayout = new javax.swing.GroupLayout(jPanelavert);
        jPanelavert.setLayout(jPanelavertLayout);
        jPanelavertLayout.setHorizontalGroup(
            jPanelavertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelavertLayout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelavertLayout.createSequentialGroup()
                .addContainerGap(427, Short.MAX_VALUE)
                .addGroup(jPanelavertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelavertLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(spnqtPd1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(416, 416, 416))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelavertLayout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(445, 445, 445))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelavertLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMiseàJourE, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(480, 480, 480))
            .addGroup(jPanelavertLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel12)
                .addGap(65, 65, 65)
                .addComponent(jRechercheVente1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelavertLayout.setVerticalGroup(
            jPanelavertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelavertLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanelavertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelavertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRechercheVente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanelavertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnqtPd1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMiseàJourE, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(147, 147, 147))
        );

        jLayeredPane1.add(jPanelavert, "card5");

        jPanelVente.setBackground(new java.awt.Color(221, 255, 221));

        jTableVente.setBackground(new java.awt.Color(255, 255, 153));
        jTableVente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 51)));
        jTableVente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTableVente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idv", "Nom", "Prénom", "Cin", "Réference", "Quantité", "Prix Unitaire(DH)", "Montant(DH)"
            }
        ));
        jTableVente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableVente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVenteMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableVenteMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(jTableVente);

        btnNouveauCl5.setBackground(new java.awt.Color(66, 160, 66));
        btnNouveauCl5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnNouveauCl5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Package_Search_30px_2.png"))); // NOI18N
        btnNouveauCl5.setText("Choisir Produit");
        btnNouveauCl5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNouveauCl5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNouveauCl5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNouveauCl5MouseExited(evt);
            }
        });
        btnNouveauCl5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNouveauCl5ActionPerformed(evt);
            }
        });

        btnNouveauCl6.setBackground(new java.awt.Color(66, 160, 66));
        btnNouveauCl6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnNouveauCl6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Search_Client_30px_2.png"))); // NOI18N
        btnNouveauCl6.setText("Choisir Client");
        btnNouveauCl6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNouveauCl6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNouveauCl6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNouveauCl6MouseExited(evt);
            }
        });
        btnNouveauCl6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNouveauCl6ActionPerformed(evt);
            }
        });

        spnqtPd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        spnqtPd.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnqtPd.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        spnqtPd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Quantité:");

        btnNouveauVente.setBackground(new java.awt.Color(66, 160, 66));
        btnNouveauVente.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnNouveauVente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_sell_30px.png"))); // NOI18N
        btnNouveauVente.setText("Vendre");
        btnNouveauVente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNouveauVente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNouveauVenteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNouveauVenteMouseExited(evt);
            }
        });
        btnNouveauVente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNouveauVenteActionPerformed(evt);
            }
        });

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Client:");

        txtclientV.setBackground(new java.awt.Color(255, 255, 204));
        txtclientV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtclientV.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        txtclientV.setCaretColor(new java.awt.Color(0, 153, 0));
        txtclientV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtclientVFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtclientVFocusLost(evt);
            }
        });
        txtclientV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclientVActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Réference:");

        jRechercheVente.setBackground(new java.awt.Color(255, 255, 204));
        jRechercheVente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRechercheVente.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 230, 64), new java.awt.Color(0, 230, 64)));
        jRechercheVente.setCaretColor(new java.awt.Color(0, 204, 0));
        jRechercheVente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRechercheVenteActionPerformed(evt);
            }
        });
        jRechercheVente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jRechercheVenteKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Recherche Vente:");

        btnBillet1.setBackground(new java.awt.Color(66, 160, 66));
        btnBillet1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnBillet1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_file_30px_1.png"))); // NOI18N
        btnBillet1.setText("Fiche de vente");
        btnBillet1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBillet1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBillet1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBillet1MouseExited(evt);
            }
        });
        btnBillet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillet1ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_25px.png"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_refresh_30px_1.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelVenteLayout = new javax.swing.GroupLayout(jPanelVente);
        jPanelVente.setLayout(jPanelVenteLayout);
        jPanelVenteLayout.setHorizontalGroup(
            jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVenteLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelVenteLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(30, 30, 30)
                                .addComponent(txtclientV, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNouveauCl6, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelVenteLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(33, 33, 33)
                                .addComponent(txtrefpd, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNouveauCl5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(101, 101, 101)
                        .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelVenteLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(spnqtPd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 26, Short.MAX_VALUE))
                            .addGroup(jPanelVenteLayout.createSequentialGroup()
                                .addComponent(btnNouveauVente, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))))
                    .addComponent(jScrollPane4))
                .addContainerGap())
            .addGroup(jPanelVenteLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel10)
                .addGap(65, 65, 65)
                .addComponent(jRechercheVente, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVenteLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVenteLayout.createSequentialGroup()
                        .addComponent(btnBillet1)
                        .addGap(481, 481, 481))
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        jPanelVenteLayout.setVerticalGroup(
            jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelVenteLayout.createSequentialGroup()
                .addComponent(jLabel16)
                .addGap(21, 21, 21)
                .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnqtPd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNouveauCl6)
                    .addComponent(btnNouveauCl5))
                .addGap(26, 26, 26)
                .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtclientV, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtrefpd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNouveauVente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelVenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jRechercheVente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBillet1)
                .addGap(126, 126, 126))
        );

        jLayeredPane1.add(jPanelVente, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelBoutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelBoutton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane1))
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

    private void jbt2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbt2MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt2MouseDragged

    private void jbt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbt2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt2MouseClicked

    private void jbt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt2ActionPerformed
        jbt2.setBackground(new Color(221, 255, 221));
        jbt1.setBackground(new Color(255, 255, 153));
        jbt4.setBackground(new Color(255, 255, 153));
        jbt3.setBackground(new Color(255, 255, 153));
        jbt5.setBackground(new Color(255, 255, 153));
        
        jLayeredPane1.removeAll();
        jLayeredPane1.add(jPanelpd);
        jLayeredPane1.repaint();
        jLayeredPane1.revalidate();
        
        RemplirTableauProduit();
    }//GEN-LAST:event_jbt2ActionPerformed

    private void jbt1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbt1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt1MouseDragged

    private void jbt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbt1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt1MouseClicked

    private void jbt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt1ActionPerformed
        jbt1.setBackground(new Color(221, 255, 221));
        jbt2.setBackground(new Color(255, 255, 153));
        jbt3.setBackground(new Color(255, 255, 153));
        jbt4.setBackground(new Color(255, 255, 153));
        jbt5.setBackground(new Color(255, 255, 153));
        
        jLayeredPane1.removeAll();
        jLayeredPane1.add(jPanelcl);
        jLayeredPane1.repaint();
        jLayeredPane1.revalidate();
    }//GEN-LAST:event_jbt1ActionPerformed

    private void jbt4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbt4MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt4MouseDragged

    private void jbt4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbt4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt4MouseClicked

    private void jbt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt4ActionPerformed
        RemplirTableauProduitAlert();       
        jbt4.setBackground(new Color(221, 255, 221));
        jbt1.setBackground(new Color(255, 255, 153));
        jbt2.setBackground(new Color(255, 255, 153));
        jbt3.setBackground(new Color(255, 255, 153));
        jbt5.setBackground(new Color(255, 255, 153));
        
        jLayeredPane1.removeAll();
        jLayeredPane1.add(jPanelavert);
        jLayeredPane1.repaint();
        jLayeredPane1.revalidate();
    }//GEN-LAST:event_jbt4ActionPerformed

    private void jbt5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbt5MouseEntered
        jbt5.setBackground(new Color(221, 255, 221));
    }//GEN-LAST:event_jbt5MouseEntered

    private void jbt5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbt5MouseExited
        jbt5.setBackground(new Color(255, 255, 153));
    }//GEN-LAST:event_jbt5MouseExited

    private void jbt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt5ActionPerformed
        Cnx cx = new Cnx();
        cx.setVisible(true);
        cx.pack();
        this.dispose();
    }//GEN-LAST:event_jbt5ActionPerformed

    private void jbt3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbt3MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt3MouseDragged

    private void jbt3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbt3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt3MouseClicked

    private void jbt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt3ActionPerformed
          RemplirTableauVente();
        jbt3.setBackground(new Color(221, 255, 221));
        jbt1.setBackground(new Color(255, 255, 153));
        jbt4.setBackground(new Color(255, 255, 153));
        jbt2.setBackground(new Color(255, 255, 153));
        jbt5.setBackground(new Color(255, 255, 153));
        
        jLayeredPane1.removeAll();
        jLayeredPane1.add(jPanelVente);
        jLayeredPane1.repaint();
        jLayeredPane1.revalidate();
        
        
        try {

            PreparedStatement pstmt = con.prepareStatement("select * from client where idCl=?");
            pstmt.setInt(1, MainEmployes.tabclid);
            ResultSet rs5 = pstmt.executeQuery();
            while (rs5.next()) {
                txtclientV.setText(rs5.getString("nomCl").toUpperCase() +" "+ rs5.getString("prenomCl").toUpperCase());
               // txtCinCl1.setText(rs5.getString(4).toUpperCase());

            }
        } catch (SQLException ex) {
            Logger.getLogger(MainEmployes.class.getName()).log(Level.SEVERE, null, ex);
        }
try {

            PreparedStatement pstmt = con.prepareStatement("select * from produit where idpd=?");
            pstmt.setInt(1, MainEmployes.tabPd);
            ResultSet rs5 = pstmt.executeQuery();
            while (rs5.next()) {
                //jLabel11.setText(rs5.getString("nomCl").toUpperCase() +" "+ rs5.getString("prenomCl").toUpperCase());
                txtrefpd.setText(rs5.getString(2).toUpperCase());

            }
        } catch (SQLException ex) {
            Logger.getLogger(MainEmployes.class.getName()).log(Level.SEVERE, null, ex);
        }
       
                                      
    }//GEN-LAST:event_jbt3ActionPerformed

    private void jTableClEmpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClEmpMouseClicked

    }//GEN-LAST:event_jTableClEmpMouseClicked

    private void jTableClEmpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClEmpMousePressed
       
        DefaultTableModel d = (DefaultTableModel) jTableClEmp.getModel();
        int row = jTableClEmp.getSelectedRow();
        tabclid = (int) jTableClEmp.getModel().getValueAt(row, 0);
    }//GEN-LAST:event_jTableClEmpMousePressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        String query = jTextField1.getText().toLowerCase();

        filterClient(query);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void btnNouveauCl2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNouveauCl2MouseEntered
        btnNouveauCl2.setBackground(new Color(37, 116, 169));
    }//GEN-LAST:event_btnNouveauCl2MouseEntered

    private void btnNouveauCl2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNouveauCl2MouseExited
        btnNouveauCl2.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnNouveauCl2MouseExited

    private void btnNouveauCl2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNouveauCl2ActionPerformed

        NouveauClient nc = new NouveauClient();
        nc.setVisible(true);
        nc.pack();
    }//GEN-LAST:event_btnNouveauCl2ActionPerformed

    private void btnUpdateCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateCMouseEntered
        btnUpdateC.setBackground(new Color(37, 116, 169));
    }//GEN-LAST:event_btnUpdateCMouseEntered

    private void btnUpdateCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateCMouseExited
        btnUpdateC.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnUpdateCMouseExited

    private void btnUpdateCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCActionPerformed
        int row = -1;
        row = jTableClEmp.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un client");
        } else {

            UpdateClientE uc = new UpdateClientE();
            uc.setVisible(true);
            uc.pack();
        }
    }//GEN-LAST:event_btnUpdateCActionPerformed

    private void btnSuppCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuppCMouseClicked

    }//GEN-LAST:event_btnSuppCMouseClicked

    private void btnSuppCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuppCMouseEntered
        btnSuppC.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnSuppCMouseEntered

    private void btnSuppCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuppCMouseExited
        btnSuppC.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnSuppCMouseExited

    private void btnSuppCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppCActionPerformed
        try {
            DefaultTableModel d = (DefaultTableModel) jTableClEmp.getModel();

            int row = -1;
            row = jTableClEmp.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner un client");
            } else {

                int supp = (int) jTableClEmp.getModel().getValueAt(row, 0);

                int test = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer??");
                if (test == JOptionPane.YES_OPTION) {

                    PreparedStatement pstmt = con.prepareStatement("delete from client where idCl=?");
                    pstmt.setInt(1, supp);
                    pstmt.execute();
                    RemplirTableauClient();
                } else {

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainEmployes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuppCActionPerformed

    private void jTablePdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePdMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablePdMouseClicked

    private void jTablePdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePdMousePressed
        DefaultTableModel d = (DefaultTableModel) jTablePd.getModel();
        int row = jTablePd.getSelectedRow();
        tabPd = (int) jTablePd.getModel().getValueAt(row, 0);
        
         DefaultTableModel d1 = (DefaultTableModel) jTablePd.getModel();
        int row1 = jTablePd.getSelectedRow();
        tabPdPrix = (double) jTablePd.getModel().getValueAt(row1, 5);
        
         DefaultTableModel d2 = (DefaultTableModel) jTablePd.getModel();
        int row2 = jTablePd.getSelectedRow();
        tabPdStock = (int) jTablePd.getModel().getValueAt(row2, 6);
    }//GEN-LAST:event_jTablePdMousePressed

    private void btnNouveauCl3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNouveauCl3MouseEntered
        btnNouveauCl3.setBackground(new Color(37, 116, 169));
    }//GEN-LAST:event_btnNouveauCl3MouseEntered

    private void btnNouveauCl3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNouveauCl3MouseExited
       btnNouveauCl3.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnNouveauCl3MouseExited

    private void btnNouveauCl3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNouveauCl3ActionPerformed
          NouveauProduit np = new NouveauProduit();
        np.setVisible(true);
        np.pack();
    }//GEN-LAST:event_btnNouveauCl3ActionPerformed

    private void btnUpdateC1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateC1MouseEntered
         btnUpdateC1.setBackground(new Color(37, 116, 169));
    }//GEN-LAST:event_btnUpdateC1MouseEntered

    private void btnUpdateC1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateC1MouseExited
        btnUpdateC1.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnUpdateC1MouseExited

    private void btnUpdateC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateC1ActionPerformed
        int row = -1;
        row = jTablePd.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un produit");
        } else {

            UpdateProduit up = new UpdateProduit();
            up.setVisible(true);
            up.pack();
        }
                         
    }//GEN-LAST:event_btnUpdateC1ActionPerformed

    private void btnSuppC1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuppC1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSuppC1MouseClicked

    private void btnSuppC1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuppC1MouseEntered
        btnSuppC1.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_btnSuppC1MouseEntered

    private void btnSuppC1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuppC1MouseExited
        btnSuppC1.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnSuppC1MouseExited

    private void btnSuppC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppC1ActionPerformed
         try {
            DefaultTableModel d = (DefaultTableModel) jTablePd.getModel();

            int row = -1;
            row = jTablePd.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Veuillez sélectionner un produit");
            } else {

               
                int supp = (int) jTablePd.getModel().getValueAt(row, 0);
                int test = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer??");
                if (test == JOptionPane.YES_OPTION) {

                    PreparedStatement pstmt = con.prepareStatement("delete from produit where idpd=?");
                    pstmt.setInt(1, supp);
                    pstmt.execute();
                    RemplirTableauProduit();
                } else {

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainEmployes.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }//GEN-LAST:event_btnSuppC1ActionPerformed

    private void jRecherchePdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRecherchePdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRecherchePdActionPerformed

    private void jRecherchePdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRecherchePdKeyReleased
        String query = jRecherchePd.getText().toLowerCase();

        filterProduit(query);
    }//GEN-LAST:event_jRecherchePdKeyReleased

    private void jTableVenteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVenteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableVenteMouseClicked

    private void jTableVenteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVenteMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableVenteMousePressed

    private void btnNouveauCl5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNouveauCl5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNouveauCl5MouseEntered

    private void btnNouveauCl5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNouveauCl5MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNouveauCl5MouseExited

    private void btnNouveauCl5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNouveauCl5ActionPerformed
        jbt2.setBackground(new Color(221, 255, 221));
        jbt1.setBackground(new Color(255, 255, 153));
        jbt4.setBackground(new Color(255, 255, 153));
        jbt3.setBackground(new Color(255, 255, 153));
        jbt5.setBackground(new Color(255, 255, 153));
        
        jLayeredPane1.removeAll();
        jLayeredPane1.add(jPanelpd);
        jLayeredPane1.repaint();
        jLayeredPane1.revalidate();
    }//GEN-LAST:event_btnNouveauCl5ActionPerformed

    private void btnNouveauCl6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNouveauCl6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNouveauCl6MouseEntered

    private void btnNouveauCl6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNouveauCl6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNouveauCl6MouseExited

    private void btnNouveauCl6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNouveauCl6ActionPerformed
        jbt1.setBackground(new Color(221, 255, 221));
        jbt2.setBackground(new Color(255, 255, 153));
        jbt3.setBackground(new Color(255, 255, 153));
        jbt4.setBackground(new Color(255, 255, 153));
        jbt5.setBackground(new Color(255, 255, 153));
        
        jLayeredPane1.removeAll();
        jLayeredPane1.add(jPanelcl);
        jLayeredPane1.repaint();
        jLayeredPane1.revalidate();               

    }//GEN-LAST:event_btnNouveauCl6ActionPerformed

    private void btnNouveauVenteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNouveauVenteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNouveauVenteMouseEntered

    private void btnNouveauVenteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNouveauVenteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNouveauVenteMouseExited

    private void btnNouveauVenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNouveauVenteActionPerformed
      
        int nbr = (int) spnqtPd.getValue();
        double prixT = tabPdPrix;
        //Calendar calendar = Calendar.getInstance();
        //Date currentDate = new Date(calendar.getTime().getTime());
        
        if (verifierFieldVente()) {

            PreparedStatement pstmt;
            try {
                pstmt = con.prepareStatement("insert into vente(idcl, idpd, qantitev, prixT) values (?,?,?,?)");
                pstmt.setInt(1, MainEmployes.tabclid);
                pstmt.setInt(2, MainEmployes.tabPd);
                pstmt.setInt(3, nbr);
                pstmt.setDouble(4, prixT*nbr);
              //  pstmt.setDate(5, currentDate );
              

                if (pstmt.executeUpdate() != 0) {
                    JOptionPane.showMessageDialog(null, " Produit vendu avec succès");
                    
                      RemplirTableauVente();
                      
                    

                } else {
                    JOptionPane.showMessageDialog(null, "Erreur!!: Vérifiez les informations");

                }

            } catch (SQLException ex) {
                Logger.getLogger(NouveauClient.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnNouveauVenteActionPerformed

    private void txtrefpdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrefpdFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrefpdFocusGained

    private void txtrefpdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtrefpdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrefpdFocusLost

    private void txtrefpdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrefpdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrefpdActionPerformed

    private void txtclientVFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtclientVFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclientVFocusGained

    private void txtclientVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtclientVFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclientVFocusLost

    private void txtclientVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclientVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclientVActionPerformed

    private void jRechercheVenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRechercheVenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRechercheVenteActionPerformed

    private void jRechercheVenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRechercheVenteKeyReleased
        String query = jRechercheVente.getText().toLowerCase();

        filterVente(query);
    }//GEN-LAST:event_jRechercheVenteKeyReleased

    private void btnBillet1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBillet1MouseEntered
        btnBillet1.setBackground(new Color(37, 116, 169));
    }//GEN-LAST:event_btnBillet1MouseEntered

    private void btnBillet1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBillet1MouseExited
        btnBillet1.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnBillet1MouseExited

    private void btnBillet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillet1ActionPerformed
        DefaultTableModel d = (DefaultTableModel) jTableVente.getModel();
        int row = -1;
        row = jTableVente.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Veuillez sélectionner une vente");

        } else {

            int vt = (int) jTableVente.getModel().getValueAt(row, 0);

                          

                    Map parametre = new HashMap();

                    parametre.put("Vt", vt);
               

                    try {
                        JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\intel\\JaspersoftWorkspace\\Stage\\magazinstock.jrxml");
                        JasperPrint jp = JasperFillManager.fillReport(jr, parametre, con);
                        JasperViewer.viewReport(jp, false);
                    } catch (JRException ex) {
                        Logger.getLogger(MainEmployes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            
        
       
    }//GEN-LAST:event_btnBillet1ActionPerformed

    private void jTablePdAlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePdAlMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTablePdAlMouseClicked

    private void jTablePdAlMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePdAlMousePressed
        DefaultTableModel d = (DefaultTableModel) jTablePdAl.getModel();
        int row = jTablePdAl.getSelectedRow();
        tabPdSt = (int) jTablePdAl.getModel().getValueAt(row, 6);
        
        DefaultTableModel d1 = (DefaultTableModel) jTablePdAl.getModel();
        int row1 = jTablePdAl.getSelectedRow();
        tabPdal = (int) jTablePdAl.getModel().getValueAt(row, 0);
    }//GEN-LAST:event_jTablePdAlMousePressed

    private void btnMiseàJourEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMiseàJourEMouseEntered
        btnMiseàJourE.setBackground(new Color(37, 116, 169));
    }//GEN-LAST:event_btnMiseàJourEMouseEntered

    private void btnMiseàJourEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMiseàJourEMouseExited
        btnMiseàJourE.setBackground(new Color(66, 160, 66));
    }//GEN-LAST:event_btnMiseàJourEMouseExited

    private void btnMiseàJourEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMiseàJourEActionPerformed
         int row = -1;
        row = jTablePdAl.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner un produit");
        } else {

           
           int nbr = (int) spnqtPd1.getValue();

            if (verifierFieldStock()) {
                try {
                    PreparedStatement pstmt = con.prepareStatement("update produit set quantite=?+? where idpd=?");

                    pstmt.setInt(1, nbr);
                    pstmt.setInt(2,MainEmployes.tabPdSt );
                    pstmt.setInt(3, MainEmployes.tabPdal);

                    if (pstmt.executeUpdate() != 0) {
                        JOptionPane.showMessageDialog(null, "Le stock a été mis à jour");
                        
                        MainEmployes.RemplirTableauProduitAlert();
                        spnqtPd1.setValue(0);
                        // this.dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "Mise à jour a échoué");

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(MainEmployes.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }

            //this.dispose();
    }//GEN-LAST:event_btnMiseàJourEActionPerformed

    private void jRechercheVente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRechercheVente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRechercheVente1ActionPerformed

    private void jRechercheVente1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRechercheVente1KeyReleased
        String query = jRechercheVente1.getText().toLowerCase();

        filterVenteAl(query);
    }//GEN-LAST:event_jRechercheVente1KeyReleased

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        txtclientV.setText("");
        txtrefpd.setText("");
        jRechercheVente.setText("");
        spnqtPd.setValue(0);
        
    }//GEN-LAST:event_jLabel16MouseClicked

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
            java.util.logging.Logger.getLogger(MainEmployes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainEmployes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainEmployes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainEmployes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainEmployes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBillet1;
    private javax.swing.JButton btnMiseàJourE;
    private javax.swing.JButton btnNouveauCl2;
    private javax.swing.JButton btnNouveauCl3;
    private javax.swing.JButton btnNouveauCl5;
    private javax.swing.JButton btnNouveauCl6;
    private javax.swing.JButton btnNouveauVente;
    private javax.swing.JButton btnSuppC;
    private javax.swing.JButton btnSuppC1;
    private javax.swing.JButton btnUpdateC;
    private javax.swing.JButton btnUpdateC1;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanelBoutton;
    private javax.swing.JPanel jPanelTitle;
    private javax.swing.JPanel jPanelVente;
    private javax.swing.JPanel jPanelavert;
    private javax.swing.JPanel jPanelcl;
    private javax.swing.JPanel jPanelpd;
    private javax.swing.JTextField jRecherchePd;
    private javax.swing.JTextField jRechercheVente;
    private javax.swing.JTextField jRechercheVente1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    public static javax.swing.JTable jTableClEmp;
    public static javax.swing.JTable jTablePd;
    public static javax.swing.JTable jTablePdAl;
    public static javax.swing.JTable jTableVente;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbt1;
    private javax.swing.JButton jbt2;
    private javax.swing.JButton jbt3;
    private javax.swing.JButton jbt4;
    private javax.swing.JButton jbt5;
    private javax.swing.JPanel pnl6;
    private javax.swing.JSpinner spnqtPd;
    private javax.swing.JSpinner spnqtPd1;
    private javax.swing.JTextField txtclientV;
    private javax.swing.JTextField txtrefpd;
    // End of variables declaration//GEN-END:variables
}
