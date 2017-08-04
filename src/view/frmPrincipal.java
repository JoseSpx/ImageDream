package view;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.Binarizacion;
import model.CMYK;
import model.HSI;
import model.LocalBinarization;
import model.MyImage;
import model.PseudoColor;

public class frmPrincipal extends javax.swing.JFrame {

    private int x;
    private int y;
    
    private String pathImage;
    private MyImage originalImage = null;
    
    public static BufferedImage bufferedOriginalImage = null;
    public static BufferedImage bufferedActualImage = null;
    public static BufferedImage bufferedActualImageCopy = null;
    public static BufferedImage bufferedBeforeImage = null;
    public static BufferedImage bufferedAfterImage = null;
    
    public static boolean scaleAlgorithmAverage = false;
    public static boolean scaleAlgorithmLineBefore = true;
    
    public static boolean addImageExtremeLeft = true;
    public static boolean addImageCentered = false;
    
    public static boolean substractImageExtremeLeft = true;
    public static boolean substractImageCentered = false;
    
    public static boolean modeRGB = false;
    public static boolean modeGray = false;
    
    public static boolean modeRGBbefore = false;
    public static boolean modeGrayBefore = false;
    
    
    public frmPrincipal(String path){
        initComponents();  
        setLocationRelativeTo(null);
        initBufferedImage(path);
        changePane(new PaneScale());
        configurations();
        listeners();
    }
    
    public void initBufferedImage(String path){
        this.pathImage = path;
        this.originalImage = new MyImage(pathImage);
        bufferedOriginalImage = this.originalImage.getImg();
        bufferedActualImage = this.originalImage.getImg();
        bufferedActualImageCopy = bufferedActualImage;
        showImageOnlblOriginalImage();
        showImageOnlblImageActual();
        
        if(this.originalImage.getNumberOfchannels() == 3){
            modeRGB = true;
        }else{
            modeGray = true;
        }
 
    }
    
    public void listeners(){
        ListenerKey listenerKey = new ListenerKey();
        this.addKeyListener(listenerKey);
        lblImageActual.addKeyListener(listenerKey);
        lblOriginalImage.addKeyListener(listenerKey);
        menuBarPrincipal.addKeyListener(listenerKey);
        menuConfiguracion.addKeyListener(listenerKey);
        menuFile.addKeyListener(listenerKey);
        menuReset.addKeyListener(listenerKey);
        menuSubstractImage.addKeyListener(listenerKey);
    }
    
    public void configurations(){
        radioLineaAnterior.setSelected(true);
        radioPromedio.setSelected(false);
        radioGroupEscalar.add(radioPromedio);
        radioGroupEscalar.add(radioLineaAnterior);
        
        radioAddImageExtremeLeft.setSelected(true);
        radioGroupAddImage.add(radioAddImageCenter);
        radioGroupAddImage.add(radioAddImageExtremeLeft);
        
        radioSubstractImageExtremeLeft.setSelected(true);
        radioGroupSubstractImage.add(radioSubstractImageCentered);
        radioGroupSubstractImage.add(radioSubstractImageExtremeLeft);
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
    
    public void exit(){
        int option = JOptionPane.showConfirmDialog(null,
                "Se perdera todo lo aplicado en la imagen, esta seguro ?","Salir",JOptionPane.YES_NO_OPTION);
        
        if (option == JOptionPane.YES_OPTION){
            new frmStart().setVisible(true);
            this.dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroupEscalar = new javax.swing.ButtonGroup();
        radioGroupAddImage = new javax.swing.ButtonGroup();
        radioGroupSubstractImage = new javax.swing.ButtonGroup();
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
        menuSubstractImage = new javax.swing.JMenu();
        itemEscalar = new javax.swing.JMenuItem();
        itemBrillo = new javax.swing.JMenuItem();
        itemAdd = new javax.swing.JMenuItem();
        itemSubstract = new javax.swing.JMenuItem();
        itemBinar = new javax.swing.JMenuItem();
        btnLocalBinarization = new javax.swing.JMenuItem();
        itemPseudoColor = new javax.swing.JMenuItem();
        menuReset = new javax.swing.JMenuItem();
        menuModo = new javax.swing.JMenu();
        itemMenuCMYK = new javax.swing.JMenuItem();
        menuItemHSI = new javax.swing.JMenuItem();
        menuConfiguracion = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        radioPromedio = new javax.swing.JRadioButtonMenuItem();
        radioLineaAnterior = new javax.swing.JRadioButtonMenuItem();
        itemAddImage = new javax.swing.JMenu();
        radioAddImageExtremeLeft = new javax.swing.JRadioButtonMenuItem();
        radioAddImageCenter = new javax.swing.JRadioButtonMenuItem();
        jMenu3 = new javax.swing.JMenu();
        radioSubstractImageExtremeLeft = new javax.swing.JRadioButtonMenuItem();
        radioSubstractImageCentered = new javax.swing.JRadioButtonMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(38, 50, 56));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setFocusable(false);
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(895, 10, 1, 660);

        lblOriginalImage.setBackground(new java.awt.Color(55, 71, 79));
        lblOriginalImage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        lblOriginalImage.setFocusable(false);
        lblOriginalImage.setOpaque(true);
        jPanel1.add(lblOriginalImage);
        lblOriginalImage.setBounds(920, 30, 350, 180);

        paneContent.setBackground(new java.awt.Color(38, 50, 56));
        paneContent.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        paneContent.setFocusable(false);

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
        lblImageActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImageActual.setFocusable(false);
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
        itemFileOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFileOpenActionPerformed(evt);
            }
        });
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

        menuSubstractImage.setBackground(new java.awt.Color(102, 102, 102));
        menuSubstractImage.setBorder(null);
        menuSubstractImage.setForeground(new java.awt.Color(255, 255, 255));
        menuSubstractImage.setText("Editar");
        menuSubstractImage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuSubstractImage.setOpaque(true);

        itemEscalar.setBackground(new java.awt.Color(102, 102, 102));
        itemEscalar.setForeground(new java.awt.Color(255, 255, 255));
        itemEscalar.setText("Escalar");
        itemEscalar.setOpaque(true);
        itemEscalar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEscalarActionPerformed(evt);
            }
        });
        menuSubstractImage.add(itemEscalar);

        itemBrillo.setBackground(new java.awt.Color(102, 102, 102));
        itemBrillo.setForeground(new java.awt.Color(255, 255, 255));
        itemBrillo.setText("Brillo");
        itemBrillo.setOpaque(true);
        itemBrillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBrilloActionPerformed(evt);
            }
        });
        menuSubstractImage.add(itemBrillo);

        itemAdd.setBackground(new java.awt.Color(102, 102, 102));
        itemAdd.setForeground(new java.awt.Color(255, 255, 255));
        itemAdd.setText("Sumar Imagen");
        itemAdd.setOpaque(true);
        itemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAddActionPerformed(evt);
            }
        });
        menuSubstractImage.add(itemAdd);

        itemSubstract.setBackground(new java.awt.Color(102, 102, 102));
        itemSubstract.setForeground(new java.awt.Color(255, 255, 255));
        itemSubstract.setText("Restar Imagen");
        itemSubstract.setOpaque(true);
        itemSubstract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSubstractActionPerformed(evt);
            }
        });
        menuSubstractImage.add(itemSubstract);

        itemBinar.setBackground(new java.awt.Color(102, 102, 102));
        itemBinar.setForeground(new java.awt.Color(255, 255, 255));
        itemBinar.setText("Binarizacion");
        itemBinar.setOpaque(true);
        itemBinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBinarActionPerformed(evt);
            }
        });
        menuSubstractImage.add(itemBinar);

        btnLocalBinarization.setBackground(new java.awt.Color(102, 102, 102));
        btnLocalBinarization.setForeground(new java.awt.Color(255, 255, 255));
        btnLocalBinarization.setText("Binarizacion Local");
        btnLocalBinarization.setOpaque(true);
        btnLocalBinarization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalBinarizationActionPerformed(evt);
            }
        });
        menuSubstractImage.add(btnLocalBinarization);

        itemPseudoColor.setBackground(new java.awt.Color(102, 102, 102));
        itemPseudoColor.setForeground(new java.awt.Color(255, 255, 255));
        itemPseudoColor.setText("PseudoColor");
        itemPseudoColor.setOpaque(true);
        itemPseudoColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPseudoColorActionPerformed(evt);
            }
        });
        menuSubstractImage.add(itemPseudoColor);

        menuReset.setBackground(new java.awt.Color(102, 102, 102));
        menuReset.setForeground(new java.awt.Color(255, 255, 255));
        menuReset.setText("Reset");
        menuReset.setOpaque(true);
        menuReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuResetActionPerformed(evt);
            }
        });
        menuSubstractImage.add(menuReset);

        menuBarPrincipal.add(menuSubstractImage);

        menuModo.setBackground(new java.awt.Color(102, 102, 102));
        menuModo.setForeground(new java.awt.Color(255, 255, 255));
        menuModo.setText("Modo");
        menuModo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuModo.setOpaque(true);

        itemMenuCMYK.setBackground(new java.awt.Color(102, 102, 102));
        itemMenuCMYK.setForeground(new java.awt.Color(255, 255, 255));
        itemMenuCMYK.setText("CMYK");
        itemMenuCMYK.setOpaque(true);
        itemMenuCMYK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuCMYKActionPerformed(evt);
            }
        });
        menuModo.add(itemMenuCMYK);

        menuItemHSI.setBackground(new java.awt.Color(102, 102, 102));
        menuItemHSI.setForeground(new java.awt.Color(255, 255, 255));
        menuItemHSI.setText("HSI");
        menuItemHSI.setOpaque(true);
        menuItemHSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemHSIActionPerformed(evt);
            }
        });
        menuModo.add(menuItemHSI);

        menuBarPrincipal.add(menuModo);

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
        radioPromedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPromedioActionPerformed(evt);
            }
        });
        jMenu1.add(radioPromedio);

        radioLineaAnterior.setBackground(new java.awt.Color(102, 102, 102));
        radioLineaAnterior.setForeground(new java.awt.Color(255, 255, 255));
        radioLineaAnterior.setSelected(true);
        radioLineaAnterior.setText("Linea Anterior");
        radioLineaAnterior.setOpaque(true);
        radioLineaAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLineaAnteriorActionPerformed(evt);
            }
        });
        jMenu1.add(radioLineaAnterior);

        menuConfiguracion.add(jMenu1);

        itemAddImage.setBackground(new java.awt.Color(102, 102, 102));
        itemAddImage.setForeground(new java.awt.Color(255, 255, 255));
        itemAddImage.setText("Sumar Imagen Desde");
        itemAddImage.setOpaque(true);

        radioAddImageExtremeLeft.setBackground(new java.awt.Color(102, 102, 102));
        radioAddImageExtremeLeft.setForeground(new java.awt.Color(255, 255, 255));
        radioAddImageExtremeLeft.setText("Extremo Izquierdo");
        radioAddImageExtremeLeft.setOpaque(true);
        radioAddImageExtremeLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAddImageExtremeLeftActionPerformed(evt);
            }
        });
        itemAddImage.add(radioAddImageExtremeLeft);

        radioAddImageCenter.setBackground(new java.awt.Color(102, 102, 102));
        radioAddImageCenter.setForeground(new java.awt.Color(255, 255, 255));
        radioAddImageCenter.setText("Centro");
        radioAddImageCenter.setOpaque(true);
        radioAddImageCenter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioAddImageCenterActionPerformed(evt);
            }
        });
        itemAddImage.add(radioAddImageCenter);

        menuConfiguracion.add(itemAddImage);

        jMenu3.setBackground(new java.awt.Color(102, 102, 102));
        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setText("Restar Imagen Desde");
        jMenu3.setOpaque(true);

        radioSubstractImageExtremeLeft.setBackground(new java.awt.Color(102, 102, 102));
        radioSubstractImageExtremeLeft.setForeground(new java.awt.Color(255, 255, 255));
        radioSubstractImageExtremeLeft.setText("Extremo Izquierdo");
        radioSubstractImageExtremeLeft.setOpaque(true);
        radioSubstractImageExtremeLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSubstractImageExtremeLeftActionPerformed(evt);
            }
        });
        jMenu3.add(radioSubstractImageExtremeLeft);

        radioSubstractImageCentered.setBackground(new java.awt.Color(102, 102, 102));
        radioSubstractImageCentered.setForeground(new java.awt.Color(255, 255, 255));
        radioSubstractImageCentered.setText("Centro");
        radioSubstractImageCentered.setOpaque(true);
        radioSubstractImageCentered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSubstractImageCenteredActionPerformed(evt);
            }
        });
        jMenu3.add(radioSubstractImageCentered);

        menuConfiguracion.add(jMenu3);

        menuBarPrincipal.add(menuConfiguracion);

        jMenu2.setBackground(new java.awt.Color(102, 102, 102));
        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setText("Navegar");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenu2.setOpaque(true);

        jMenuItem1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuItem1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("Atras");
        jMenuItem1.setOpaque(true);
        jMenu2.add(jMenuItem1);

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
        exit();
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

    private void radioPromedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPromedioActionPerformed
        scaleAlgorithmAverage = true;
        scaleAlgorithmLineBefore = false;
    }//GEN-LAST:event_radioPromedioActionPerformed

    private void radioLineaAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLineaAnteriorActionPerformed
        scaleAlgorithmAverage = false;
        scaleAlgorithmLineBefore = true;
    }//GEN-LAST:event_radioLineaAnteriorActionPerformed

    private void menuResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuResetActionPerformed
        lblImageActual.setIcon(new ImageIcon(bufferedOriginalImage));
        frmPrincipal.bufferedActualImage = bufferedOriginalImage;
        bufferedActualImageCopy = bufferedOriginalImage;
        changePane(new PaneEmpty());
        
        if(modeGrayBefore){
            modeGray = true;
        }
        
    }//GEN-LAST:event_menuResetActionPerformed

    private void itemFileOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFileOpenActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("extensiones jpg","jpg"));
        int n = chooser.showOpenDialog(null);
        if(n == JFileChooser.APPROVE_OPTION){
            int accept = JOptionPane.showConfirmDialog
                            (null,"Se perdera todo, esta seguro ?","Cerrar Imagen",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
            if( accept == JOptionPane.YES_OPTION){
                File file = chooser.getSelectedFile();
                initBufferedImage(file.getAbsolutePath());
            
                MyImage imageOpened = new MyImage(file.getAbsolutePath());
                int numBands = imageOpened.getNumberOfchannels();
                
                if(numBands == 3){
                    modeRGB = true;
                    modeGray = false;
                }
                else{
                    modeRGB = false;
                    modeGray = true;
                }
                
                modeGrayBefore = false;
                modeRGBbefore = false;
                
                changePane(new PaneEmpty());
                
            }
            
        }
    }//GEN-LAST:event_itemFileOpenActionPerformed

    private void itemBrilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBrilloActionPerformed
        changePane(new PaneBright());
    }//GEN-LAST:event_itemBrilloActionPerformed

    private void itemAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAddActionPerformed
        changePane(new PaneAddImage());
    }//GEN-LAST:event_itemAddActionPerformed

    private void itemSubstractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSubstractActionPerformed
        changePane(new PaneSubstractImage());
    }//GEN-LAST:event_itemSubstractActionPerformed

    private void itemBinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBinarActionPerformed
        if(modeRGB){
            BufferedImage bufferedImage = new Binarizacion(frmPrincipal.bufferedActualImage).apply();
            frmPrincipal.bufferedActualImage = bufferedImage;
            bufferedActualImageCopy = bufferedImage;
            lblImageActual.setIcon(new ImageIcon(bufferedImage)); 
        }
        else{
            JOptionPane.showMessageDialog(null,"Solo es aplicable a imagenes en RGB");
        }
            
    }//GEN-LAST:event_itemBinarActionPerformed

    private void itemPseudoColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPseudoColorActionPerformed
        if(modeGray){
            BufferedImage bufferedImage = new PseudoColor(bufferedActualImage).apply();
            frmPrincipal.bufferedActualImage = bufferedImage;
            lblImageActual.setIcon(new ImageIcon(bufferedImage));
            modeRGB = true;
            modeGray = false;
            
            modeGrayBefore = true;
            modeRGBbefore = false;
            
            bufferedActualImageCopy = bufferedImage;
            
        }else{
            JOptionPane.showMessageDialog(null,"Solo es aplicable a imagenes en Escala de Grises");
        }
    }//GEN-LAST:event_itemPseudoColorActionPerformed

    private void radioAddImageExtremeLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAddImageExtremeLeftActionPerformed
        addImageCentered = false;
        addImageExtremeLeft = true;
    }//GEN-LAST:event_radioAddImageExtremeLeftActionPerformed

    private void radioAddImageCenterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioAddImageCenterActionPerformed
        addImageCentered = true;
        addImageExtremeLeft = false;
    }//GEN-LAST:event_radioAddImageCenterActionPerformed

    private void radioSubstractImageCenteredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSubstractImageCenteredActionPerformed
        substractImageCentered = true;
        substractImageExtremeLeft = false;
    }//GEN-LAST:event_radioSubstractImageCenteredActionPerformed

    private void radioSubstractImageExtremeLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSubstractImageExtremeLeftActionPerformed
        substractImageCentered = false;
        substractImageExtremeLeft = true;
    }//GEN-LAST:event_radioSubstractImageExtremeLeftActionPerformed

    private void itemMenuCMYKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuCMYKActionPerformed
        if(modeRGB){
            BufferedImage bufferedImage = new CMYK(bufferedActualImage).apply();
            lblImageActual.setIcon(new ImageIcon(bufferedImage));
            bufferedActualImage = bufferedImage;
            bufferedActualImageCopy = bufferedImage;
            
            JOptionPane.showMessageDialog(null,"Se aplico la imagen en modo CMYK ");
            
        }else{
            JOptionPane.showMessageDialog(null,"Solo es aplicable para imagenes RGB");
        }
    }//GEN-LAST:event_itemMenuCMYKActionPerformed

    private void menuItemHSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemHSIActionPerformed
        if(modeRGB){
            BufferedImage bufferedImage = new HSI(bufferedActualImage).apply();
            lblImageActual.setIcon(new ImageIcon(bufferedImage));
            bufferedActualImage = bufferedImage;
            bufferedActualImageCopy = bufferedImage;
            
            JOptionPane.showMessageDialog(null,"Se aplico la imagen en modo HSI ");
            
        }else{
            JOptionPane.showMessageDialog(null,"Solo es aplicable para imagenes RGB");
        }
    }//GEN-LAST:event_menuItemHSIActionPerformed

    private void itemEscalarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEscalarActionPerformed
        changePane(new PaneScale());
    }//GEN-LAST:event_itemEscalarActionPerformed

    private void btnLocalBinarizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalBinarizationActionPerformed
        if(modeRGB){
            BufferedImage bufferedImage = new LocalBinarization(frmPrincipal.bufferedActualImage).apply();
            frmPrincipal.bufferedActualImage = bufferedImage;
            bufferedActualImageCopy = bufferedImage;
            lblImageActual.setIcon(new ImageIcon(bufferedImage)); 
        }
        else{
            JOptionPane.showMessageDialog(null,"Solo es aplicable a imagenes en RGB");
        }
    }//GEN-LAST:event_btnLocalBinarizationActionPerformed

    class ListenerKey implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            if((int)e.getKeyChar() == KeyEvent.VK_ESCAPE){
                exit();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
        
    }
            
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnLocalBinarization;
    private javax.swing.JMenuItem itemAdd;
    private javax.swing.JMenu itemAddImage;
    private javax.swing.JMenuItem itemBinar;
    private javax.swing.JMenuItem itemBrillo;
    private javax.swing.JMenuItem itemEscalar;
    private javax.swing.JMenuItem itemFileClose;
    private javax.swing.JMenuItem itemFileOpen;
    private javax.swing.JMenuItem itemFileSaveAs;
    private javax.swing.JMenuItem itemMenuCMYK;
    private javax.swing.JMenuItem itemPseudoColor;
    private javax.swing.JMenuItem itemSubstract;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblImageActual;
    private javax.swing.JLabel lblOriginalImage;
    private javax.swing.JMenuBar menuBarPrincipal;
    private javax.swing.JMenu menuConfiguracion;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuItemHSI;
    private javax.swing.JMenu menuModo;
    private javax.swing.JMenuItem menuReset;
    private javax.swing.JMenu menuSubstractImage;
    private javax.swing.JPanel paneContent;
    private javax.swing.JRadioButtonMenuItem radioAddImageCenter;
    private javax.swing.JRadioButtonMenuItem radioAddImageExtremeLeft;
    private javax.swing.ButtonGroup radioGroupAddImage;
    private javax.swing.ButtonGroup radioGroupEscalar;
    private javax.swing.ButtonGroup radioGroupSubstractImage;
    public static javax.swing.JRadioButtonMenuItem radioLineaAnterior;
    public static javax.swing.JRadioButtonMenuItem radioPromedio;
    private javax.swing.JRadioButtonMenuItem radioSubstractImageCentered;
    private javax.swing.JRadioButtonMenuItem radioSubstractImageExtremeLeft;
    // End of variables declaration//GEN-END:variables
}
