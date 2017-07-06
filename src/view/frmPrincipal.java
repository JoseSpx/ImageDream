package view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.MyImage;

public class frmPrincipal extends javax.swing.JFrame {

    private int x;
    private int y;
    
    private String pathImage;
    private final MyImage originalImage;
    
    public frmPrincipal(String path){
        initComponents();  
        setLocationRelativeTo(null);
        this.pathImage = path;
        this.originalImage = new MyImage(pathImage);
        showImageOnlblOriginalImage();
        showImageOnlblImageActual();
        changePane(new PaneScale());
    }
    
    public void changePane(JPanel panelElegido){
        panelElegido.setSize(350,420);
        panelElegido.setLocation(0,0);
        this.paneContent.removeAll();
        this.paneContent.add(panelElegido,BorderLayout.CENTER);
        this.paneContent.revalidate();
        this.paneContent.repaint();
    }
    
    public void showImageOnlblOriginalImage(){
        int [] dimensions;
        dimensions = resizeOriginalImageToLabel(350,180);
        
        lblOriginalImage.setIcon(new ImageIcon(
                new ImageIcon(pathImage).getImage().getScaledInstance(dimensions[0],dimensions[1], Image.SCALE_DEFAULT)));
        lblOriginalImage.setHorizontalAlignment(SwingConstants.CENTER);
        lblOriginalImage.setVerticalAlignment(SwingConstants.CENTER);
    }
    
    public void showImageOnlblImageActual(){
        lblImageActual.setIcon(new ImageIcon(pathImage));
        /*int [] dimensions;
        dimensions = resizeOriginalImageToLabel(1820,640);
        
        lblImageActual.setIcon(new ImageIcon(
                new ImageIcon(pathImage).getImage().getScaledInstance(dimensions[0],dimensions[1], Image.SCALE_DEFAULT)));
        lblImageActual.setHorizontalAlignment(SwingConstants.CENTER);
        lblImageActual.setVerticalAlignment(SwingConstants.CENTER);
        */
    }
    
    public int [] resizeOriginalImageToLabel(int widthLabel, int heightLabel){
        final int lblOriginalWidth = widthLabel;
        final int lblOriginalHeight = heightLabel;
        int percentage = 1;
        int widthOriginalimage = this.originalImage.getColumnas();
        int heightOriginalImage = this.originalImage.getFilas();
        int width = getNewSizeByPorcentage(widthOriginalimage, percentage);
        int height = getNewSizeByPorcentage(heightOriginalImage, percentage);
        int [] dimensions = new int [2];
        
        while(width < lblOriginalWidth && height < lblOriginalHeight){
            dimensions[0] = width;
            dimensions[1] = height;
            percentage = percentage + 1;
            width = getNewSizeByPorcentage(widthOriginalimage, percentage);
            height = getNewSizeByPorcentage(heightOriginalImage, percentage);
        }
        
        return dimensions;
    }
    
    public int getNewSizeByPorcentage(int number, int porcentage){
        return (number * porcentage) / 100;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblOriginalImage = new javax.swing.JLabel();
        paneContent = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblImageActual = new javax.swing.JLabel();
        menuBarPrincipal = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        itemFileOpen = new javax.swing.JMenuItem();
        itemFileSaveAs = new javax.swing.JMenuItem();
        itemFileClose = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemEscalar = new javax.swing.JMenuItem();
        itemBrillo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(38, 50, 56));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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

        paneContent.setBackground(new java.awt.Color(38, 50, 56));
        paneContent.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        javax.swing.GroupLayout paneContentLayout = new javax.swing.GroupLayout(paneContent);
        paneContent.setLayout(paneContentLayout);
        paneContentLayout.setHorizontalGroup(
            paneContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );
        paneContentLayout.setVerticalGroup(
            paneContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        jPanel1.add(paneContent);
        paneContent.setBounds(920, 250, 350, 420);

        lblImageActual.setBackground(new java.awt.Color(55, 71, 79));
        lblImageActual.setOpaque(true);
        jScrollPane1.setViewportView(lblImageActual);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(40, 30, 820, 640);

        menuBarPrincipal.setBackground(new java.awt.Color(102, 102, 102));
        menuBarPrincipal.setBorder(null);
        menuBarPrincipal.setFocusable(false);
        menuBarPrincipal.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        menuBarPrincipal.setMaximumSize(new java.awt.Dimension(98, 300));
        menuBarPrincipal.setPreferredSize(new java.awt.Dimension(300, 19));
        menuBarPrincipal.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                menuBarPrincipalMouseDragged(evt);
            }
        });
        menuBarPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuBarPrincipalMousePressed(evt);
            }
        });

        menuFile.setBackground(new java.awt.Color(102, 102, 102));
        menuFile.setForeground(new java.awt.Color(255, 255, 255));
        menuFile.setText("Archivo");
        menuFile.setBorderPainted(true);
        menuFile.setFocusable(false);
        menuFile.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        menuFile.setOpaque(true);

        itemFileOpen.setBackground(new java.awt.Color(84, 110, 122));
        itemFileOpen.setForeground(new java.awt.Color(255, 255, 255));
        itemFileOpen.setText("Abrir");
        itemFileOpen.setBorderPainted(true);
        itemFileOpen.setOpaque(true);
        menuFile.add(itemFileOpen);

        itemFileSaveAs.setBackground(new java.awt.Color(84, 110, 122));
        itemFileSaveAs.setForeground(new java.awt.Color(255, 255, 255));
        itemFileSaveAs.setText("Guardar como");
        itemFileSaveAs.setBorderPainted(true);
        itemFileSaveAs.setOpaque(true);
        itemFileSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFileSaveAsActionPerformed(evt);
            }
        });
        menuFile.add(itemFileSaveAs);

        itemFileClose.setBackground(new java.awt.Color(84, 110, 122));
        itemFileClose.setForeground(new java.awt.Color(255, 255, 255));
        itemFileClose.setText("Cerrar");
        itemFileClose.setBorderPainted(true);
        itemFileClose.setOpaque(true);
        itemFileClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFileCloseActionPerformed(evt);
            }
        });
        menuFile.add(itemFileClose);

        menuBarPrincipal.add(menuFile);

        jMenu2.setBackground(new java.awt.Color(102, 102, 102));
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Imagen");
        jMenu2.setBorderPainted(true);
        jMenu2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jMenu2.setOpaque(true);

        itemEscalar.setBackground(new java.awt.Color(84, 110, 122));
        itemEscalar.setForeground(new java.awt.Color(255, 255, 255));
        itemEscalar.setText("Escalar");
        itemEscalar.setOpaque(true);
        jMenu2.add(itemEscalar);

        itemBrillo.setBackground(new java.awt.Color(84, 110, 122));
        itemBrillo.setForeground(new java.awt.Color(255, 255, 255));
        itemBrillo.setText("Brillo");
        itemBrillo.setOpaque(true);
        jMenu2.add(itemBrillo);

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

    private void itemFileCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFileCloseActionPerformed
        int option = JOptionPane.showConfirmDialog(null,
                "Se perdera todo lo aplicado en la imagen, esta seguro ?","Salir",JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION){
            new frmStart().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_itemFileCloseActionPerformed

    private void menuBarPrincipalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBarPrincipalMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_menuBarPrincipalMousePressed

    private void menuBarPrincipalMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBarPrincipalMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - this.x,this.getLocation().y + evt.getY() - this.y);

    }//GEN-LAST:event_menuBarPrincipalMouseDragged

    private void itemFileSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFileSaveAsActionPerformed
        int numberOfChannels = this.originalImage.getNumberOfchannels();
        if( numberOfChannels == 3){
            
        }else{
            
        }
    }//GEN-LAST:event_itemFileSaveAsActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemBrillo;
    private javax.swing.JMenuItem itemEscalar;
    private javax.swing.JMenuItem itemFileClose;
    private javax.swing.JMenuItem itemFileOpen;
    private javax.swing.JMenuItem itemFileSaveAs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImageActual;
    private javax.swing.JLabel lblOriginalImage;
    private javax.swing.JMenuBar menuBarPrincipal;
    private javax.swing.JMenu menuFile;
    private javax.swing.JPanel paneContent;
    // End of variables declaration//GEN-END:variables
}
