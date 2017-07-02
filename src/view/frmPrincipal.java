package view;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class frmPrincipal extends javax.swing.JFrame {

    private String pathImage;
    
    public frmPrincipal(String path) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        initComponents();
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //setSize(1300, 709);
        //setResizable(false);
        setLocationRelativeTo(null);
        this.pathImage = path;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblOriginalImage = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblImageActual = new javax.swing.JLabel();
        menuBarPrincipal = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        itemFileOpen = new javax.swing.JMenuItem();
        itemFileSaveAs = new javax.swing.JMenuItem();
        itemFileClose = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(38, 50, 56));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(895, 10, 1, 660);

        lblOriginalImage.setBackground(new java.awt.Color(55, 71, 79));
        lblOriginalImage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        lblOriginalImage.setOpaque(true);
        jPanel1.add(lblOriginalImage);
        lblOriginalImage.setBounds(920, 30, 350, 180);

        jPanel2.setBackground(new java.awt.Color(38, 50, 56));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(920, 250, 350, 420);

        jPanel3.setBackground(new java.awt.Color(69, 90, 100));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImageActual, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImageActual, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(40, 30, 820, 640);

        menuBarPrincipal.setBackground(new java.awt.Color(38, 50, 56));
        menuBarPrincipal.setBorder(null);
        menuBarPrincipal.setForeground(new java.awt.Color(51, 51, 255));
        menuBarPrincipal.setFocusCycleRoot(true);
        menuBarPrincipal.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        menuBarPrincipal.setMaximumSize(new java.awt.Dimension(98, 300));
        menuBarPrincipal.setPreferredSize(new java.awt.Dimension(300, 19));

        menuFile.setForeground(new java.awt.Color(255, 255, 255));
        menuFile.setText("Archivo");
        menuFile.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

        itemFileOpen.setBackground(new java.awt.Color(96, 125, 139));
        itemFileOpen.setForeground(new java.awt.Color(255, 255, 255));
        itemFileOpen.setText("Abrir");
        menuFile.add(itemFileOpen);

        itemFileSaveAs.setBackground(new java.awt.Color(96, 125, 139));
        itemFileSaveAs.setForeground(new java.awt.Color(255, 255, 255));
        itemFileSaveAs.setText("Guardar como");
        menuFile.add(itemFileSaveAs);

        itemFileClose.setBackground(new java.awt.Color(96, 125, 139));
        itemFileClose.setForeground(new java.awt.Color(255, 255, 255));
        itemFileClose.setText("Cerrar");
        menuFile.add(itemFileClose);

        menuBarPrincipal.add(menuFile);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Seleccion");
        jMenu2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        menuBarPrincipal.add(jMenu2);

        setJMenuBar(menuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemFileClose;
    private javax.swing.JMenuItem itemFileOpen;
    private javax.swing.JMenuItem itemFileSaveAs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblImageActual;
    private javax.swing.JLabel lblOriginalImage;
    private javax.swing.JMenuBar menuBarPrincipal;
    private javax.swing.JMenu menuFile;
    // End of variables declaration//GEN-END:variables
}
