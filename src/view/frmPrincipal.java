package view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.MyImage;

public class frmPrincipal extends javax.swing.JFrame {

    private int x;
    private int y;
    
    private String pathImage;
    private final MyImage originalImage;
    private BufferedImage bufferedOriginalImage = null;
    
    public frmPrincipal(String path){
        initComponents();  
        setLocationRelativeTo(null);
        this.pathImage = path;
        this.originalImage = new MyImage(pathImage);
        this.bufferedOriginalImage = this.originalImage.getImg();
        showImageOnlblOriginalImage();
        showImageOnlblImageActual();
        changePane(new PaneScale());
        configurations();
    }
    
    public void configurations(){
        radioGroupEscalar.add(radioPromedio);
        radioGroupEscalar.add(radioLineaAnterior);
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
        lblImageActual.setIcon(new ImageIcon(bufferedOriginalImage));
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

        radioGroupEscalar = new javax.swing.ButtonGroup();
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
        menuImage = new javax.swing.JMenu();
        itemEscalar = new javax.swing.JMenuItem();
        itemBrillo = new javax.swing.JMenuItem();
        menuConfiguracion = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        radioPromedio = new javax.swing.JRadioButtonMenuItem();
        radioLineaAnterior = new javax.swing.JRadioButtonMenuItem();

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
        menuFile.setBorder(null);
        menuFile.setForeground(new java.awt.Color(255, 255, 255));
        menuFile.setText("Archivo");
        menuFile.setContentAreaFilled(false);
        menuFile.setFocusable(false);
        menuFile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuFile.setOpaque(true);

        itemFileOpen.setBackground(new java.awt.Color(102, 102, 102));
        itemFileOpen.setForeground(new java.awt.Color(255, 255, 255));
        itemFileOpen.setText("Abrir");
        itemFileOpen.setAlignmentX(0.0F);
        itemFileOpen.setAlignmentY(0.0F);
        itemFileOpen.setBorder(null);
        itemFileOpen.setOpaque(true);
        menuFile.add(itemFileOpen);

        itemFileSaveAs.setBackground(new java.awt.Color(102, 102, 102));
        itemFileSaveAs.setForeground(new java.awt.Color(255, 255, 255));
        itemFileSaveAs.setText("Guardar como");
        itemFileSaveAs.setBorder(null);
        itemFileSaveAs.setOpaque(true);
        itemFileSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFileSaveAsActionPerformed(evt);
            }
        });
        menuFile.add(itemFileSaveAs);

        itemFileClose.setBackground(new java.awt.Color(102, 102, 102));
        itemFileClose.setForeground(new java.awt.Color(255, 255, 255));
        itemFileClose.setText("Cerrar");
        itemFileClose.setBorder(null);
        itemFileClose.setOpaque(true);
        itemFileClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFileCloseActionPerformed(evt);
            }
        });
        menuFile.add(itemFileClose);

        menuBarPrincipal.add(menuFile);

        menuImage.setBackground(new java.awt.Color(102, 102, 102));
        menuImage.setBorder(null);
        menuImage.setForeground(new java.awt.Color(255, 255, 255));
        menuImage.setText("Imagen");
        menuImage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuImage.setOpaque(true);

        itemEscalar.setBackground(new java.awt.Color(102, 102, 102));
        itemEscalar.setForeground(new java.awt.Color(255, 255, 255));
        itemEscalar.setText("Escalar");
        itemEscalar.setOpaque(true);
        menuImage.add(itemEscalar);

        itemBrillo.setBackground(new java.awt.Color(102, 102, 102));
        itemBrillo.setForeground(new java.awt.Color(255, 255, 255));
        itemBrillo.setText("Brillo");
        itemBrillo.setOpaque(true);
        menuImage.add(itemBrillo);

        menuBarPrincipal.add(menuImage);

        menuConfiguracion.setBackground(new java.awt.Color(102, 102, 102));
        menuConfiguracion.setBorder(null);
        menuConfiguracion.setForeground(new java.awt.Color(255, 255, 255));
        menuConfiguracion.setText("Configuracion");
        menuConfiguracion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuConfiguracion.setOpaque(true);

        jMenu1.setBackground(new java.awt.Color(102, 102, 102));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Escalar");
        jMenu1.setOpaque(true);

        radioPromedio.setBackground(new java.awt.Color(102, 102, 102));
        radioPromedio.setForeground(new java.awt.Color(255, 255, 255));
        radioPromedio.setSelected(true);
        radioPromedio.setText("Promedio");
        radioPromedio.setOpaque(true);
        jMenu1.add(radioPromedio);

        radioLineaAnterior.setBackground(new java.awt.Color(102, 102, 102));
        radioLineaAnterior.setForeground(new java.awt.Color(255, 255, 255));
        radioLineaAnterior.setSelected(true);
        radioLineaAnterior.setText("Linea Anterior");
        radioLineaAnterior.setOpaque(true);
        jMenu1.add(radioLineaAnterior);

        menuConfiguracion.add(jMenu1);

        menuBarPrincipal.add(menuConfiguracion);

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
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int save = chooser.showSaveDialog(null);
        if(save == JFileChooser.APPROVE_OPTION){
            File file = chooser.getSelectedFile();
            int numberOfChannels = this.originalImage.getNumberOfchannels();
            if( numberOfChannels == 3){
                MyImage.guardarImagen(this.originalImage.getMatrizImg_R(),
                        this.originalImage.getMatrizImg_G(),this.originalImage.getMatrizImg_B(),
                        file.getAbsolutePath());
            }else{
                MyImage.guardarImagen(this.originalImage.getMatrizImg(),
                        file.getPath());
            }
        }
    }//GEN-LAST:event_itemFileSaveAsActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemBrillo;
    private javax.swing.JMenuItem itemEscalar;
    private javax.swing.JMenuItem itemFileClose;
    private javax.swing.JMenuItem itemFileOpen;
    private javax.swing.JMenuItem itemFileSaveAs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImageActual;
    private javax.swing.JLabel lblOriginalImage;
    private javax.swing.JMenuBar menuBarPrincipal;
    private javax.swing.JMenu menuConfiguracion;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuImage;
    private javax.swing.JPanel paneContent;
    private javax.swing.ButtonGroup radioGroupEscalar;
    private javax.swing.JRadioButtonMenuItem radioLineaAnterior;
    private javax.swing.JRadioButtonMenuItem radioPromedio;
    // End of variables declaration//GEN-END:variables
}
