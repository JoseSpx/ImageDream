package view;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import model.ScaleImage;

public class PaneScale extends javax.swing.JPanel {

    private BufferedImage image;
    private int heightPercentage;
    private int widthPercentage;
    
    private final int WIDTH_IMAGE = 0;
    private final int HEIGTH_IMAGE = 1;
    
    public PaneScale() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sliderHeight = new javax.swing.JSlider();
        SliderWidth = new javax.swing.JSlider();
        btnChangeHeight = new javax.swing.JButton();
        btnChangeWidth = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(350, 420));

        jPanel1.setBackground(new java.awt.Color(38, 50, 56));

        jLabel1.setBackground(new java.awt.Color(84, 110, 122));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ANCHO");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(84, 110, 122));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ALTURA");
        jLabel2.setOpaque(true);

        sliderHeight.setBackground(new java.awt.Color(38, 50, 56));
        sliderHeight.setForeground(new java.awt.Color(255, 255, 255));
        sliderHeight.setMajorTickSpacing(50);
        sliderHeight.setMaximum(200);
        sliderHeight.setMinorTickSpacing(5);
        sliderHeight.setPaintLabels(true);
        sliderHeight.setPaintTicks(true);
        sliderHeight.setToolTipText("");
        sliderHeight.setValue(100);
        sliderHeight.setFocusable(false);

        SliderWidth.setBackground(new java.awt.Color(38, 50, 56));
        SliderWidth.setForeground(new java.awt.Color(255, 255, 255));
        SliderWidth.setMajorTickSpacing(50);
        SliderWidth.setMaximum(200);
        SliderWidth.setMinorTickSpacing(5);
        SliderWidth.setPaintLabels(true);
        SliderWidth.setPaintTicks(true);
        SliderWidth.setToolTipText("");
        SliderWidth.setValue(100);
        SliderWidth.setFocusable(false);

        btnChangeHeight.setBackground(new java.awt.Color(207, 216, 220));
        btnChangeHeight.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnChangeHeight.setForeground(new java.awt.Color(84, 110, 122));
        btnChangeHeight.setText("APLICAR");
        btnChangeHeight.setFocusPainted(false);
        btnChangeHeight.setFocusable(false);
        btnChangeHeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeHeightActionPerformed(evt);
            }
        });

        btnChangeWidth.setBackground(new java.awt.Color(207, 216, 220));
        btnChangeWidth.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btnChangeWidth.setForeground(new java.awt.Color(84, 110, 122));
        btnChangeWidth.setText("APLICAR");
        btnChangeWidth.setFocusPainted(false);
        btnChangeWidth.setFocusable(false);
        btnChangeWidth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeWidthActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(sliderHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(SliderWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(btnChangeHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnChangeWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(sliderHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnChangeHeight, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SliderWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnChangeWidth, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangeHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeHeightActionPerformed
        scaleImageHeight();
    }//GEN-LAST:event_btnChangeHeightActionPerformed

    public void scaleImageWidth(){
        this.widthPercentage = this.SliderWidth.getValue();
        this.image = frmPrincipal.bufferedOriginalImage;
        if(widthPercentage == 100){
            widthPercentage = 101;
        }
        
        image = new ScaleImage().getScaleImage(image, widthPercentage, WIDTH_IMAGE);
        frmPrincipal.lblImageActual.setIcon(new ImageIcon(image));
        frmPrincipal.bufferedActualImage = image;
    }
    
    public void scaleImageHeight(){
        this.heightPercentage = this.sliderHeight.getValue();
        this.image = frmPrincipal.bufferedOriginalImage;
        if(heightPercentage == 100){
            heightPercentage++;
        }
        image = new ScaleImage().getScaleImage(image, heightPercentage, HEIGTH_IMAGE);
        frmPrincipal.lblImageActual.setIcon(new ImageIcon(image));
        frmPrincipal.bufferedActualImage = image;
    }
    
    private void btnChangeWidthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeWidthActionPerformed
        scaleImageWidth();
    }//GEN-LAST:event_btnChangeWidthActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider SliderWidth;
    private javax.swing.JButton btnChangeHeight;
    private javax.swing.JButton btnChangeWidth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider sliderHeight;
    // End of variables declaration//GEN-END:variables
}
