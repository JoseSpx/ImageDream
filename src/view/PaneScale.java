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
        btnReset = new javax.swing.JButton();

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
        sliderHeight.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderHeightStateChanged(evt);
            }
        });

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
        SliderWidth.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderWidthStateChanged(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(207, 216, 220));
        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnReset.setForeground(new java.awt.Color(84, 110, 122));
        btnReset.setText("RESETEAR");
        btnReset.setFocusPainted(false);
        btnReset.setFocusable(false);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
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
            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(sliderHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(SliderWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        this.sliderHeight.setValue(100);
        this.SliderWidth.setValue(100);
        frmPrincipal.lblImageActual.setIcon(new ImageIcon(frmPrincipal.bufferedOriginalImage));
    }//GEN-LAST:event_btnResetActionPerformed

    public void scaleImage(){
        this.heightPercentage = this.sliderHeight.getValue();
        this.widthPercentage = this.SliderWidth.getValue();
        this.image = frmPrincipal.bufferedOriginalImage;
       
        if(this.heightPercentage > 100){
            image = new ScaleImage().getScaleImage(image, heightPercentage, HEIGTH_IMAGE);
        }else if(this.heightPercentage < 100){
            image = new ScaleImage().getScaleImage(image, heightPercentage, HEIGTH_IMAGE);
        }

        if(this.widthPercentage > 100){System.out.println("widht + 100");
            image = new ScaleImage().getScaleImage(image, widthPercentage, WIDTH_IMAGE);
        }else if(this.widthPercentage < 100){
            image = new ScaleImage().getScaleImage(image, widthPercentage, WIDTH_IMAGE);
        }
        frmPrincipal.lblImageActual.setIcon(new ImageIcon(image));
        frmPrincipal.bufferedActualImage = image;
    }
    
    
    private void sliderHeightStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderHeightStateChanged
        scaleImage();
    }//GEN-LAST:event_sliderHeightStateChanged

    private void SliderWidthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderWidthStateChanged
        scaleImage();
    }//GEN-LAST:event_SliderWidthStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider SliderWidth;
    private javax.swing.JButton btnReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider sliderHeight;
    // End of variables declaration//GEN-END:variables
}
